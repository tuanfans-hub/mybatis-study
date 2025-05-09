package com.tuanfans.test;

import com.tuanfans.mapper.DeptMapper;
import com.tuanfans.mapper.EmpMapper;
import com.tuanfans.mapper.ProjectMapper;
import com.tuanfans.pojo.Dept;
import com.tuanfans.pojo.Emp;
import com.tuanfans.pojo.Project;
import com.tuanfans.util.MyBatisUtil;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author TuanFans
 * @date 2025/5/8
 * @description
 */
public class TestOfMoreTable {
    private static SqlSession sqlSession;

    @BeforeAll
    public static void init() {
        sqlSession = MyBatisUtil.getSqlSession();
    }

    @AfterAll
    public static void release() {
        sqlSession.close();
    }

    @Test
    public void testFindAll(){
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> emps = empMapper.findAll();
        emps.forEach(System.out::println);
    }

    @Test
    public void testFindEmpByDeptnos(){
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        List<Integer> deptnos  = List.of(10, 20);
        List<Emp> emps = empMapper.findEmpByDeptnos(deptnos);
        emps.forEach(System.out::println);
    }

    @Test
    public void testFindEmpJoinDeptByEmpno(){
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = empMapper.findEmpJoinDeptByEmpno(10000);
        System.out.println(emp);
    }

    @Test
    public void testFindEmpJoinDeptByEmpno2(){
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = empMapper.findEmpJoinDeptByEmpno2(10000);
        System.out.println(emp);
    }

    @Test
    public void testFindDeptJoinEmpByDeptno(){
        DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);
        List<Integer> deptnos  = List.of(10, 20);
        List<Dept> depts = deptMapper.findDeptJoinEmpByDeptno(deptnos);
        depts.forEach(System.out::println);
    }

    @Test
    public void testFindDeptJoinEmpByDeptno2(){
        DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);
        List<Integer> deptnos = List.of(10,20);
        List<Dept> depts = deptMapper.findDeptJoinEmpByDeptno2(deptnos);
        System.out.println(depts.get(0).getDeptno());
        depts.forEach(System.out::println);
        System.out.println("-------------------------");
        depts.get(0).getEmps().forEach(System.out::println);
        System.out.println("-------------------------");
        depts.get(1).getEmps().forEach(System.out::println);
    }


    @Test
    public void testFindProJoinEmpsByPid(){
        ProjectMapper proMapper = sqlSession.getMapper(ProjectMapper.class);
        List<Integer> pids = List.of(1, 2);
        List<Project> pros = proMapper.findProJoinEmpsByPid(pids);
        pros.forEach(System.out::println);
        System.out.println("-------------------------");
        pros.get(0).getProAndEmp().forEach(System.out::println);
        System.out.println("-------------------------");
        pros.get(1).getProAndEmp().forEach(System.out::println);
    }

    @Test
    public void testCache(){
        EmpMapper empMapper1 = sqlSession.getMapper(EmpMapper.class);
        List<Emp> emps1 = empMapper1.findAll();
        emps1.forEach(System.out::println);
        System.out.println("-------------------------");
        EmpMapper empMapper2 = sqlSession.getMapper(EmpMapper.class);
        List<Emp> emps2 = empMapper1.findAll();
        emps2.forEach(System.out::println);
        System.out.println("-------------------------");
        System.out.println(empMapper1==empMapper2);//false
        System.out.println(emps1 == emps2);//true

    }
}
