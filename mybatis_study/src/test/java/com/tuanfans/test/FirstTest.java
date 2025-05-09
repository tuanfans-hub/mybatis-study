package com.tuanfans.test;

import com.tuanfans.pojo.Dept;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author TuanFans
 * @date 2025/5/7
 * @description
 */
public class FirstTest {
    @Test
    public void testFirst(){
        // 1.创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();
        // 2.创建SqlSessionFactory对象
        InputStream sqlConfig = null;
        try {
            sqlConfig = Resources.getResourceAsStream("mybatis-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory factory = factoryBuilder.build(sqlConfig);
        // 3.创建SqlSession对象
        SqlSession sqlSession = factory.openSession();
        // 4.执行SQL语句
        List<Dept> depts = sqlSession.selectList("findAll");
        depts.forEach(System.out::println);
        // 5.关闭SqlSession对象
        sqlSession.close();
    }
}
