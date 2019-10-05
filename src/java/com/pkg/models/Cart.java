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
public class Cart {
    
    private int user_id; //need to refer users table
    private int pizza_id; //need to refer pizza table
    private int quantity;
    private boolean delivery_status;
    
    public Cart(int user_id,int pizza_id,int quantity,boolean delivery_status ){
        this.user_id = user_id;
        this.pizza_id = pizza_id;
        this.quantity = quantity;
        this.delivery_status = delivery_status;
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
     * @return the pizza_id
     */
    public int getPizza_id() {
        return pizza_id;
    }

    /**
     * @param pizza_id the pizza_id to set
     */
    public void setPizza_id(int pizza_id) {
        this.pizza_id = pizza_id;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the delivery_status
     */
    public boolean isDelivery_status() {
        return delivery_status;
    }

    /**
     * @param delivery_status the delivery_status to set
     */
    public void setDelivery_status(boolean delivery_status) {
        this.delivery_status = delivery_status;
    }
    
    

}
