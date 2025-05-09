package com.tuanfans.testEmp;

import com.tuanfans.pojo.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author TuanFans
 * @date 2025/5/7
 * @description
 */
public class TestSelectOfEmp {
    private static SqlSession sqlSession;
    @BeforeAll
    public static void init(){
        // 1.创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();
        // 2.创建SqlSessionFactory对象
        InputStream is = null;
        try{
            is = Resources.getResourceAsStream("mybatis-config.xml");
        }catch(IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory factory = factoryBuilder.build(is);
        // 3.创建SqlSession对象
        sqlSession = factory.openSession();
    }

    @AfterAll
    public static void destroy(){
        // 6.释放资源
        sqlSession.close();
    }

    @Test
    public void testFindEmpByEmpno(){
        // 4.执行sql语句
        Emp emp = sqlSession.selectOne("findEmpByEmpno", 10000);
        // 5.处理结果
        System.out.println(emp);
    }

    @Test
    public void testFindAllEmp(){
        List<Emp> emps = sqlSession.selectList("EmpMapper.findAll");
        emps.forEach(System.out::println);
    }

    @Test
    public void testFindEmpMap(){
        // selectMap(String statement, String mapKey): 根据指定的列名作为map的key，将查询结果封装为map集合
        // mapKey: 指定列名,类名与数据库字段名相同时，区分大小写
        Map<Integer, Emp> empMap = sqlSession.selectMap("findEmpMap", "EMPNO");
        empMap.entrySet().forEach(System.out::println);
    }

    @Test
    public void testFindEmpByDeptAndSal(){
        HashMap<String, Object> args = new HashMap<>();
        // 映射文件中使用#{deptno}和#{sal}，所以这里也要使用deptno和sal作为key
        // 要确保key与映射文件中的参数名相同，否则会报错或查询失败
        args.put("deptno", 20);
        args.put("sal", 1500);
        List<Emp> emps = sqlSession.selectList("findEmpByDeptAndSal", args);
        emps.forEach(System.out::println);
    }

    @Test
    public void testFindEmpByDeptAndSal2(){
        Emp emp = new Emp();
        emp.setDeptno(20);
        emp.setSal(1500.0);
        List<Emp> emps = sqlSession.selectList("findEmpByDeptAndSal2", emp);
        emps.forEach(System.out::println);
    }
}
