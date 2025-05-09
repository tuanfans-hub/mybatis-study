package com.tuanfans.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author TuanFans
 * @date 2025/5/8
 * @description
 */
public abstract class MyBatisUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyBatisUtil.class);

    public static SqlSession getSqlSession(){
        SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();
        InputStream is = null;
        try{
            is = Resources.getResourceAsStream("mybatis-config.xml");
        } catch (IOException e) {
            LOGGER.error("加载mybatis-config.xml配置文件失败！",e);
            throw new RuntimeException("加载mybatis-config.xml配置文件失败！");
        }
        SqlSessionFactory factory = factoryBuilder.build(is);
        return factory.openSession();
    }

}
