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
    private String time; //need to refer pizza table
    //private String time_stamp;
    private double price;
    private boolean payment_status;
    
    //constructor
    public Order(int id,int user_id,String time,double price,boolean payment_status){
        this.id = id;
        this.user_id = user_id;
        this.time = time;
        this.price = price;
        this.payment_status = payment_status;
    }

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
     * @return the time
     */
    public String getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(String time) {
        this.time = time;
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
     * @return the payment_status
     */
    public boolean isPayment_status() {
        return payment_status;
    }

    /**
     * @param payment_status the payment_status to set
     */
    public void setPayment_status(boolean payment_status) {
        this.payment_status = payment_status;
    }

    
    
}//class Order
