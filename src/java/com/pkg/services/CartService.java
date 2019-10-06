/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pkg.services;

import com.pkg.dao.CartDao;
import com.pkg.daoImpl.CartDaoImpl;
import com.pkg.models.Cart;
import java.util.List;

/**
 *
 * @author Ravindu Weerasnghe
 */
public class CartService {
    
    CartDao cd = new CartDaoImpl();
    
    public boolean addPizzaToCart(Cart cart){
        return cd.addItemToCart(cart);
    }
    
    public List<Cart> viewCart(int user_id){
        return cd.viewCartItems(user_id);
    }
    
    public boolean makeOrder(int user_id){
        return cd.makeOrder(user_id);
    }
    
}
