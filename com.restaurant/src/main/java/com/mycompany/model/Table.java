/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.model;

/**
 *
 * @author Admin
 */
public class Table {
     private int id;
     private String name;
     private String status;

    public Table(int id, String name, String status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public Table() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Table{" + "id=" + id + ", name=" + name + ", status=" + status + '}';
    }
     
    
}
