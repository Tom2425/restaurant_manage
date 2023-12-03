/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.model;

/**
 *
 * @author Admin
 */
public class User {
    private int id;
    private String name;
    private int age;
    private String email;
    private String _class;
    public User(String name, int age, String email, String _class) {
        this.name = name;
        this.age = age;
        this.email = email;
        this._class = _class;
    }
    public User() {
 
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String get_Class() {
        return _class;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void set_Class(String _class) {
        this._class = _class;
    }

    @Override
    public String toString() {
        return "User{" + "name=" + name + ", age=" + age + ", email=" + email + ", _class=" + _class + '}';
    }
    
            
}
