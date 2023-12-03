/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.service;

import com.mycompany.dao.AdminDAO;
import com.mycompany.model.Admin;
import java.util.List;

/**
 *
 * @author Admin
 */
public class AdminService {
    static public Admin login(String username, String password){
        Admin a = AdminDAO.login(username, password);
        return a;
    }
    static public List<Admin> getAllAdmins(){
        List<Admin> admins = AdminDAO.getAllAdmins();
        return admins;
    }
    static public void createAdmin(Admin admin){
        AdminDAO.createAdmin(admin);
    }
    static public Admin getByUsername(String username){
        Admin a = AdminDAO.getByUsername( username);
        return a;
    }
}
