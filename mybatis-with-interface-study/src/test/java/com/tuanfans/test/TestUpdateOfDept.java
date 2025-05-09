package com.tuanfans.test;

import com.tuanfans.mapper.DeptMapper;
import com.tuanfans.pojo.Dept;
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

/**
 * @author TuanFans
 * @date 2025/5/8
 * @description
 */
public class TestUpdateOfDept {
    private static final Logger logger = LoggerFactory.getLogger(TestUpdateOfDept.class);
    private static SqlSession sqlSession;
    @BeforeAll
    public static void init(){
        SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();
        InputStream is = null;
        try{
            is = Resources.getResourceAsStream("mybatis-config.xml");
        }catch(IOException e){
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
    public void testAddDept(){
        DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = new Dept(null, "市场部", "北京");
        System.out.println("添加操作前："+dept);
        int row = deptMapper.addDept(dept);
        sqlSession.commit();
        if(row > 0){
            System.out.println("添加成功！"+dept);
        }else{
            System.out.println("添加失败！");
        }
    }

    @Test
    public void testUpdateDept(){
        DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = new Dept(49, "市场部", "河北");
        int row = deptMapper.updateDept(dept);
        sqlSession.commit();
        if(row > 0){
            System.out.println("修改成功！");
        }else{
            System.out.println("修改失败！");
        }
    }

    @Test
    public void testDeleteDept(){
        DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);
        int row = deptMapper.deleteDept(49);
        sqlSession.commit();
        if(row > 0){
            System.out.println("删除成功！");
        }else{
            System.out.println("删除失败！");
        }
    }

}
