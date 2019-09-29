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
public class Pizza {
    
    private int id;
    private String name;
    private double price;
    private String status;
    private byte[] image;
    private String base64Image;
    
    //constructor
    public Pizza(int id,String name,double price,String status,byte[]image){
        this.id = id;
        this.name = name;
        this.price = price;
        this.status = status;
        this.image = image;
    }

    //starting of getters and setters
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
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
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
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }
    
    /**
     * @return the image
     */
    public byte[] getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(byte[] image) {
        this.image = image;
    }
    
    /**
     * @return the base64Image
     */
    public String getBase64Image() {
        return base64Image;
    }

    /**
     * @param base64Image the base64Image to set
     */
    public void setBase64Image(String base64Image) {
        this.base64Image = base64Image;
    }
    
    //end of setters and getters
    
}//class Pizza
