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
import java.time.LocalDate;

/**
 * @author TuanFans
 * @date 2025/5/7
 * @description
 */
public class TestUpdateOfEmp {
    private static SqlSession sqlSession;
    @BeforeAll
    public static void init(){
        SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();
        InputStream is = null;
        try{
            is = Resources.getResourceAsStream("mybatis-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory factory = factoryBuilder.build(is);
        sqlSession = factory.openSession();
        //sqlSession = factory.openSession(true);//设置自动提交事务
    }

    @AfterAll
    public static void destroy(){
        sqlSession.close();
    }

    @Test
    public void testInsertEmp(){
        Emp emp = new Emp(10001, "小黑", "MANAGER", 10000,
                LocalDate.of(1980, 2, 2), 8000.0, 2000.0, 20);
        int count = sqlSession.insert("insertEmp", emp);
        // 提交事务，否则数据不会保存到数据库中
        // mybatis默认是回滚事务，所以要手动提交事务
        sqlSession.commit();
        System.out.println("成功插入"+count+"条数据！");
    }

    @Test
    public void testUpdateEmp(){
        Emp emp = new Emp(10001, "小夏", "CLERK", 10000,
                LocalDate.of(2004, 5, 2), 6000.0, 1000.0, 10);
        int count = sqlSession.update("updateEmp", emp);
        sqlSession.commit();
        System.out.println("成功更新"+count+"条数据！");
    }

    @Test
    public void testDeleteEmp(){
        int count = sqlSession.delete("deleteEmp", 10000);
        sqlSession.commit();
        System.out.println("成功删除"+count+"条数据！");
    }
}
