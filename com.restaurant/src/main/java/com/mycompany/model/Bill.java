/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.model;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Admin
 */
public class Bill {

    private Map<Dish, Integer> list;
    private LocalTime time;

    public Bill() {
        this.list = new HashMap<>();
    }

    public Map<Dish, Integer> getList() {
        return list;
    }

    public LocalTime getTime() {
        return time;
    }

    public void add(Dish dish, int quantity) {
        list.put(dish, quantity);
    }

    public void remove(Dish dish) {
        list.remove(dish);
    }

    public void update(Dish dish, int quantity) {
        if (quantity > 0) {
            list.put(dish, quantity);

        } else {
            list.remove(dish);
        }
    }

    public BigDecimal calculateTotal() {
        BigDecimal total = BigDecimal.ZERO;
        for (Map.Entry<Dish, Integer> entry : list.entrySet()) {
            Dish dish = entry.getKey();
            int quantity = entry.getValue();
            total = total.add(dish.getPrice().multiply(BigDecimal.valueOf(quantity)));
        }
        return total;
    }

    public void printBill() {
        for (Map.Entry<Dish, Integer> entry : list.entrySet()) {
            Dish dish = entry.getKey();
            int quantity = entry.getValue();

            System.out.println(String.valueOf(dish.getName()) + "(" + quantity + "): " + String.valueOf(dish.getPrice().multiply(BigDecimal.valueOf(quantity))) + "$");
        }
        System.out.println("Total: " + String.valueOf(this.calculateTotal()) + "$");
    }
}
