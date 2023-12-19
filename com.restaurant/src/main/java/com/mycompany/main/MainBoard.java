/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

import com.mycompany.dao.JDBCConnection;
import com.mycompany.model.Admin;
import com.mycompany.model.Bill;
import com.mycompany.model.Dish;
import com.mycompany.service.BillService;
import com.mycompany.service.DishService;
import com.mycompany.util.DateUtil;
import com.mycompany.view.AddDishForm;
import com.mycompany.view.AddStaffForm;
import com.mycompany.view.AddTableForm;
import com.mycompany.view.BillForm;
import com.mycompany.view.DashBoardForm;
import com.mycompany.view.LoginForm;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.List;

/**
 *
 * @author Admin
 */
public class MainBoard {

    public static void main(String args[]) {
//        LoginForm loginForm = new LoginForm();
//        loginForm.setLocationRelativeTo(null);
//        loginForm.setVisible(true);
//        loginForm.setResizable(false);
          List<String> list = DishService.getCategory();
          for(String cate : list){
              System.out.println(cate);
          }
          List<Dish> dishes = DishService.getByCategory("Main Course");
          for(Dish dish : dishes){
              System.out.println(dish.toString());
          }
        
//        AddTableForm addTableForm = new AddTableForm();
//        addTableForm.setLocationRelativeTo(null);
//        addTableForm.setVisible(true);  
//        List<Dish> listDish = DishService.getAll();
//        Bill bill = new Bill();
//        bill.setTime(LocalDateTime.now());
//        bill.add(listDish.get(1), 2);
//        bill.add(listDish.get(2), 4);
//        bill.add(listDish.get(3), 6);
//        BillService.create(bill);
    }
}
