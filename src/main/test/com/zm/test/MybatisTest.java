package com.zm.test;

import com.zm.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;

/**
 * Created by Administrator on 2017/9/17.
 */
public class MybatisTest {

    @Test
    public void testMybatis() throws Exception {
        //创建sqlSessionbuild对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //加载配置文件
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        //读取配置文件,获取sessionFactory
        SqlSessionFactory sessionFactory = builder.build(inputStream);
        //获取sqlsession
        SqlSession session = sessionFactory.openSession();
        User user = session.selectOne("selectUserById" , new Integer(1) );
        System.out.println(user);
        //关闭session
        session.close();
    }
}
