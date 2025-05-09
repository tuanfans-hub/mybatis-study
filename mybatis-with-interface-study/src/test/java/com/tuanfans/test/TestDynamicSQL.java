package com.tuanfans.test;

import com.tuanfans.mapper.EmpMapper;
import com.tuanfans.pojo.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author TuanFans
 * @date 2025/5/8
 * @description
 */
public class TestDynamicSQL {
    private static SqlSession sqlSession;
    private static final Logger logger = LoggerFactory.getLogger(TestDynamicSQL.class);

    @BeforeAll
    public static void init(){
        SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();
        InputStream is = null;
        try{
            is = Resources.getResourceAsStream("mybatis-config.xml");
        } catch (IOException e) {
            logger.error("加载mybatis-config.xml配置文件失败！",e);
            throw new RuntimeException("加载mybatis-config.xml配置文件失败！");
        }
        SqlSessionFactory factory = factoryBuilder.build(is);
        sqlSession = factory.openSession();
    }

    @AfterAll
    public static void release(){
        sqlSession.close();
    }

    @Test
    public void testFindEmpByCondition(){
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        //根据emp中不为null值的属性查询员工
        Emp emp = new Emp();
        emp.setDeptno(10);
        emp.setSal(5000.0);
        List<Emp> emps = empMapper.findEmpByCondition(emp);
        emps.forEach(System.out::println);
    }

    @Test
    public void testUpdateEmpByCondition(){
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = new Emp();
        emp.setEmpno(10000);
        emp.setJob("BOSS");
        emp.setMgr(0);
        emp.setComm(5000.0);
        int count = empMapper.updateEmpByCondition(emp);
        sqlSession.commit();
        if (count > 0) {
            System.out.println("成功更新" + count + "条数据！");
        } else {
            System.out.println("更新失败！");
        }
    }

    @Test
    public void testFindEmpByMoreDept(){
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        //查询10号和20号部门的员工信息
        List<Integer> deptnos = List.of(10,20);
//        Integer[] deptnos = new Integer[]{10,20};
        List<Emp> emps = empMapper.findEmpByMoreDept(deptnos);
        emps.forEach(System.out::println);
    }
}
