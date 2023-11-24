package com.mycompany.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Admin
 */
public class JDBCConnection {

    public static Connection getJDBCConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/JavaConnectTest", "root", "password");
            return con;

        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
        return null;
    }
    public static void a(){
        
        System.out.print("test texet");
    }

}
