/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pkg.dao;

import com.pkg.models.Order;

/**
 *
 * @author Ravindu Weerasnghe
 */
public interface OrderDao {
    
    public boolean placeOrder(Order order);
    
    public boolean doPayments(Order order);
}
