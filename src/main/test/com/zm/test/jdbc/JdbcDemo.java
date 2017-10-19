package com.zm.test.jdbc;


import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by Administrator on 2017/10/18.
 */
public class JdbcDemo {
    /**
     *传统jdbc的编程
     */
    @Test
    public void testJdbc()throws Exception{
        //注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/zhangmin";
        String username = "root";
        String password = "root";
        Connection connection = DriverManager.getConnection(url, username,password);
        //获取preparedStatment对象
        String sql = "select * from user where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        //设置参数
        preparedStatement.setInt(1 , 1);
        //执行获取结果集
        ResultSet resultSet = preparedStatement.executeQuery();
        //遍历结果集
        while (resultSet.next()){
            String id = resultSet.getString(1);
            String sex = resultSet.getString(2);
            String name = resultSet.getString(3);
            System.out.println("id:"+id+"   name:"+name+"   sex:"+sex);
        }
        //关流
        connection.close();
        preparedStatement.close();
        resultSet.close();
    }

}
