package com.tuanfans.testDept;

import com.tuanfans.pojo.Dept;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author TuanFans
 * @date 2025/5/7
 * @description
 */
public class TestSelectOfDept {
    private static SqlSession sqlSession = null;
    @BeforeAll
    public static void init(){
        // 1.创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();
        // 2.创建SqlSessionFactory对象
        InputStream is = null;
        try{
            is = Resources.getResourceAsStream("mybatis-config.xml");
        }catch(IOException e){
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
    public void testFindAll(){
        // 4.执行sql语句
        List<Dept> depts = sqlSession.selectList("DeptMapper.findAll");
        // 5.处理结果
        depts.forEach(System.out::println);
    }
}
