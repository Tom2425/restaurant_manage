/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dao;

import com.mycompany.model.Admin;
import com.mycompany.model.Dish;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class AdminDAO {

    public static List<Admin> getAllAdmins() {
        List<Admin> admins = new ArrayList<Admin>();
        try {
            Connection connect = JDBCConnection.getJDBCConnection();
            String sql = "select * from admin;";
            Statement statment = connect.createStatement();
            ResultSet rs = statment.executeQuery(sql);
            while (rs.next()) {
                Admin admin = new Admin();
                admin.setId(rs.getInt("id"));
                admin.setName(rs.getString("name"));
                admin.setPhone(rs.getString("phone"));
                admin.setRole(rs.getString("role"));
                admins.add(admin);
            }
            return admins;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return admins;
    }
    public static Admin getByUsername(String username){
        Admin admin = null;
        try {
            Connection connect = JDBCConnection.getJDBCConnection();
            String sql = "select * from admin where username = ?";
            PreparedStatement preparedStatment = connect.prepareStatement(sql);

            preparedStatment.setString(1, username);
            ResultSet rs = preparedStatment.executeQuery();
            while (rs.next()) {
                admin = new Admin();
                admin.setId(rs.getInt("id"));
                admin.setName(rs.getString("name"));
                admin.setPhone(rs.getString("phone"));
                admin.setRole(rs.getString("role"));
                admin.setPassword(rs.getString("password"));
                System.out.println(admin.toString());
                return admin;
            }
            return admin;
                
        } catch (SQLException e) {
            
            e.printStackTrace();
            return admin;
        }
    }
    public static void createAdmin(Admin admin) {
        try {
            Connection connect = JDBCConnection.getJDBCConnection();
            String sql = "INSERT INTO admin (name, username, password, role, phone) VALUES(?, ?, ?, ?, ?)";
            System.out.print(admin.toString());
            PreparedStatement preparedStatment = connect.prepareStatement(sql);
            preparedStatment.setString(1, admin.getName());
            preparedStatment.setString(2, admin.getUsername());
            preparedStatment.setString(3, admin.getPassword());
            preparedStatment.setString(4, admin.getRole());
            preparedStatment.setString(5, admin.getPhone());
            int rs = preparedStatment.executeUpdate();
            System.out.print(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static Admin login(String username, String password) {
        Admin a = new Admin();
        try {
            Connection connect = JDBCConnection.getJDBCConnection();
            String sql = "select * from admin where username= ? and password = ?";
            PreparedStatement preparedStatment = connect.prepareStatement(sql);
            preparedStatment.setString(1, username);
            preparedStatment.setString(2, password);

            ResultSet rs = preparedStatment.executeQuery();
            while (rs.next()) {

                a.setId(rs.getInt("id"));
                a.setName(rs.getString("name"));
                a.setUsername(rs.getString("username"));
                a.setPassword(rs.getString("password"));
                a.setRole(rs.getString("role"));
                a.setIsAuth((true));
            }
            return a;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return a;
    }

}
