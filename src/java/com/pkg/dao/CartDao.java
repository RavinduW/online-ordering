/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pkg.dao;

import com.pkg.models.Cart;
import java.util.List;

/**
 *
 * @author Ravindu Weerasnghe
 */
public interface CartDao {  
    public boolean addItemToCart(Cart cart);
    
    public List<Cart> viewCartItems(int user_id);
    
    public boolean makeOrder(int user_id);
}
