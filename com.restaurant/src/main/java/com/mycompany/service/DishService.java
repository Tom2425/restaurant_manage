/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.service;

import com.mycompany.dao.DishDAO;
import com.mycompany.model.Dish;
import com.mycompany.model.User;
import java.util.List;

/**
 *
 * @author Admin
 */
public class DishService {
    public static List<Dish> getAllDishes() {
        List<Dish> menu = DishDAO.getAllDishes();
        return menu;
    }
    public static void createDish(Dish dish){
        DishDAO.createDish(dish);
    }
}
