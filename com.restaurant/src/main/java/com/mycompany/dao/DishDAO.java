/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dao;

import com.mycompany.model.Dish;
import com.mycompany.model.User;
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
public class DishDAO {
     public static List<Dish> getAllDishes() {
        List<Dish> dishs = new ArrayList<Dish>();
        try {

            Connection connect = JDBCConnection.getJDBCConnection();
            String sql = "select * from dish";
            Statement statment = connect.createStatement();
            ResultSet rs = statment.executeQuery(sql);
            while (rs.next()) {
                Dish dish = new Dish();
                dish.setId(rs.getInt("id"));
                dish.setName(rs.getString("name"));
                dish.setPrice(rs.getBigDecimal("price"));
                dish.setType(rs.getString("type"));
                dishs.add(dish);
            }
            return dishs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dishs;
    }
     public static void createUser(Dish dish) {
        try {
            Connection connect = JDBCConnection.getJDBCConnection();
            String sql = "INSERT INTO dish (name, price, type) VALUES (?, ?, ?);";
            PreparedStatement preparedStatment = connect.prepareStatement(sql);
            preparedStatment.setString(1,dish.getName());
            preparedStatment.setBigDecimal(2, dish.getPrice());
            preparedStatment.setString(3, dish.getType());

            int rs = preparedStatment.executeUpdate();
            System.out.print(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
