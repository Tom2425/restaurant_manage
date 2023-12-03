/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dao;

import com.mycompany.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class UserDAO {

    /**
     *
     * @return
     */
    public static List<User> getAllUsers() {
        List<User> users = new ArrayList<User>();
        try {

            Connection connect = JDBCConnection.getJDBCConnection();
            String sql = "select * from user";
            Statement statment = connect.createStatement();
            ResultSet rs = statment.executeQuery(sql);
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setAge(rs.getInt("age"));
                user.set_Class(rs.getString("_class"));
                user.setEmail(rs.getString("email"));
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    ;
    public static void createUser(User user) {
        try {
            Connection connect = JDBCConnection.getJDBCConnection();
            String sql = "INSERT INTO user (name, age, email, _class) VALUES(?, ?, ?, ?)";
            PreparedStatement preparedStatment = connect.prepareStatement(sql);
            preparedStatment.setString(1, user.getName());
            preparedStatment.setInt(2, user.getAge());
            preparedStatment.setString(3, user.getEmail());
            preparedStatment.setString(4, user.get_Class());

            int rs = preparedStatment.executeUpdate();
            System.out.print(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
