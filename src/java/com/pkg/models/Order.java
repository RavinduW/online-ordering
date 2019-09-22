/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pkg.models;

/**
 *
 * @author Ravindu Weerasnghe
 */
public class Order {
    
    private int id;
    private int user_id; //need to refer users table
    private String order_name;
    private double price;
    private String requested_time;
    
    //constructor
    public Order(int id,int user_id,String order_name,double price, String requested_time){
        this.id = id;
        this.user_id = user_id;
        this.order_name = order_name;
        this.price = price;
        this.requested_time = requested_time;
    }

    //started getters and setters
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the user_id
     */
    public int getUser_id() {
        return user_id;
    }

    /**
     * @param user_id the user_id to set
     */
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    /**
     * @return the order_name
     */
    public String getOrder_name() {
        return order_name;
    }

    /**
     * @param order_name the order_name to set
     */
    public void setOrder_name(String order_name) {
        this.order_name = order_name;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return the requested_time
     */
    public String getRequested_time() {
        return requested_time;
    }

    /**
     * @param requested_time the requested_time to set
     */
    public void setRequested_time(String requested_time) {
        this.requested_time = requested_time;
    }
    //end of getters and setters
    
    
}//class Order
