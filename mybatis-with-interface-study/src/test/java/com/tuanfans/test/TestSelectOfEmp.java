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
    public static void init() {
        SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();
        InputStream is = null;
        try{
            is = Resources.getResourceAsStream("mybatis-config.xml");
        }catch(IOException e){
            e.printStackTrace();
        }
        SqlSessionFactory factory = factoryBuilder.build(is);
        sqlSession = factory.openSession();
    }

    @AfterAll
    public static void close() {
        sqlSession.close();
    }

    @Test
    public void testFindAll(){
        // getMapper方法底层是通过反射机制来获取接口的实现类
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> emps = empMapper.findAll();
        emps.forEach(System.out::println);
    }

    @Test
    public void testFindEmpById(){
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = empMapper.findEmpById(10000);
        System.out.println(emp);
    }

    @Test
    public void testFindEmpByDeptAndSal(){
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> emps = empMapper.findEmpByDeptAndSal(10, 1500.0);
        emps.forEach(System.out::println);
    }

    @Test
    public void testFindEmpByDeptAndSal2(){
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        Map<String,Object> map = new HashMap<>();
        map.put("deptno",10);
        map.put("sal",1500.0);
        List<Emp> emps = empMapper.findEmpByDeptAndSal2(map);
        emps.forEach(System.out::println);
    }

    @Test
    public void testFindEmpByDeptAndSal3(){
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = new Emp();
        emp.setDeptno(10);
        emp.setSal(1500.0);
        List<Emp> emps = empMapper.findEmpByDeptAndSal3(emp);
        emps.forEach(System.out::println);
    }

    @Test
    public void testFindEmpByDeptAndSal4(){
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp1 = new Emp();
        emp1.setDeptno(10);
        Emp emp2 = new Emp();
        emp2.setSal(1500.0);
        List<Emp> emps = empMapper.findEmpByDeptAndSal4(emp1, emp2);
        emps.forEach(System.out::println);
    }

    @Test
    public void testFindEmpByName(){
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> emps = empMapper.findEmpByName("s");
        emps.forEach(System.out::println);
    }
}
