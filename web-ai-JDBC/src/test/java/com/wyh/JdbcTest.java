package com.wyh;

import com.wyh.pojo.User;
import org.junit.jupiter.api.Test;

import java.sql.*;

public class JdbcTest {
    @Test
    public void testUpdate() throws Exception {
        //1.注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2.获取数据库连接
        String url="jdbc:mysql://localhost:3306/web-01";
        String username="root";
        String password="123456";
        Connection connection = DriverManager.getConnection(url, username, password);
        //3.获取SQL语句执行对象
        Statement statement = connection.createStatement();
        //4.执行SQL
        int i = statement.executeUpdate("update user set age=25 where id=1");
        System.out.println("SQL执行完毕影响的记录叔为："+i);
        //5.释放资源
        statement.close();
        connection.close();
    }

    @Test
    public void testSelect() throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/web-01";
        String name="root";
        String password="123456";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(url, name, password);
            String sql="select id,username,password,name,age from user";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                User user = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getString("name"),
                        resultSet.getInt("age")
                );
                System.out.println(user.toString());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            resultSet.close();
            preparedStatement.close();
            connection.close();
        }

    }
}
