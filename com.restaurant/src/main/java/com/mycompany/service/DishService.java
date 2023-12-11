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
public class DishService extends Service{

    public DishService() {
         super();
    }
    
    public static List<Dish> getAll() {
        List<Dish> menu = DishDAO.getAll();
        return menu;
    }
    public static void create(Dish dish){
        DishDAO.create(dish);
    }

    /**
     *
     */
    public static void update(){
        System.out.println("Dish update");
    }
    public static void delete(){
        System.out.println("Dish delete");
    }

}
