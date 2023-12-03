/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.service;

import com.mycompany.dao.UserDAO;
import com.mycompany.model.User;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Admin
 */
public class UserService {
    public static List<User> getAllUsers() {
        List<User> users = UserDAO.getAllUsers();
        return users;
    }
    public static void createUser(User user){
        UserDAO.createUser(user);
    }
    
}
