/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

import com.mycompany.dao.JDBCConnection;
import com.mycompany.model.Admin;
import com.mycompany.model.Bill;
import com.mycompany.model.Dish;
import com.mycompany.view.AddDishForm;
import com.mycompany.view.AddStaffForm;
import com.mycompany.view.DashBoardForm;
import com.mycompany.view.LoginForm;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Admin
 */
public class MainBoard {

    public static void main(String args[]) {
        LoginForm loginForm = new LoginForm();
        loginForm.setLocationRelativeTo(null);
        loginForm.setVisible(true);

      
    }
}
