/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pkg.daoImpl;

import com.pkg.dao.CartDao;
import static com.pkg.daoImpl.PizzaDaoImpl.currentConnection;
import com.pkg.models.Cart;
import com.pkg.models.Pizza;
import com.pkg.utils.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ravindu Weerasnghe
 */
public class CartDaoImpl implements CartDao{

    PreparedStatement ps = null;
    ResultSet rs = null;
    static Connection currentConnection = null;
    String query = null;
    boolean success = false;
    
    @Override
    public boolean addItemToCart(Cart cart) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        query = "INSERT INTO cart(id,user_id,pizza_id,quantity,delivery_status) VALUES(?,?,?,?,?)";
        
        try{
          currentConnection = ConnectionManager.getConnection();
          
          ps = currentConnection.prepareStatement(query);
          
          ps.setInt(1, cart.getId());
          ps.setInt(2, cart.getUser_id());
          ps.setInt(3, cart.getPizza_id());
          ps.setInt(4, cart.getQuantity());
          ps.setBoolean(5, cart.isDelivery_status());
          
          ps.executeUpdate();
          
          success = true;
          
        }catch(Exception e){
            System.out.println(e);
            success = false;
        }finally{
            if(currentConnection != null){
                try{
                    currentConnection.close();
                }catch(Exception e){
                    System.out.println(e);
                }
            }
            
            if(ps != null){
                try{
                    ps.close();
                }catch(Exception e){
                    System.out.println(e);
                }
            }           
        }
        return success;
    }//addItemToCart
    
    @Override
    public List<Cart> viewCartItems(int user_id){
        
        List<Cart> cartItems = new ArrayList<>();
        query = "SELECT * FROM cart INNER JOIN pizzaitems ON cart.pizza_id = pizzaitems.id WHERE user_id = ? AND delivery_status=?";
        
        try{
          currentConnection = ConnectionManager.getConnection();
          
          ps = currentConnection.prepareStatement(query);         
          
          ps.setInt(1, user_id);
          ps.setBoolean(2, false);
          
          rs = ps.executeQuery();
          
          while(rs.next()){
              Pizza pizza = new Pizza(rs.getInt("id"),rs.getString("name"),rs.getDouble("price"),rs.getString("status"),rs.getBytes("image"));
              Cart cart = new Cart(rs.getInt("id"),rs.getInt("user_id"),rs.getInt("pizza_id"),rs.getInt("quantity"),rs.getBoolean("delivery_status"),pizza);
              cartItems.add(cart);
          }
          
        }catch(Exception e){
            System.out.println(e);
        }finally{
            if(currentConnection != null){
                try{
                    currentConnection.close();
                }catch(Exception e){
                    System.out.println(e);
                }
            }
            
            if(ps != null){
                try{
                    ps.close();
                }catch(Exception e){
                    System.out.println(e);
                }
            }
            
            if(rs != null){
                try{
                    rs.close();
                }catch(Exception e){
                    System.out.println(e);
                }
            }                          
        }
       return cartItems; 
    }
    
    public boolean makeOrder(int user_id){
        
        query = "UPDATE cart set delivery_status = ? WHERE user_id =? AND delivery_status = ?";
        
        try{
         currentConnection = ConnectionManager.getConnection();   
         ps = currentConnection.prepareStatement(query);  
         
         ps.setBoolean(1,true);
         ps.setInt(2,user_id);
         ps.setBoolean(3,false);
         
         ps.executeUpdate();
         
         success = true;
        }catch(Exception e){
            System.out.println(e);
            success = false;
        }finally{
            if(currentConnection != null){
                try{
                    currentConnection.close();
                }catch(Exception e){
                    System.out.println(e);
                }
            }
            
            if(ps != null){
                try{
                    ps.close();
                }catch(Exception e){
                    System.out.println(e);
                }
            }
             
        }
        
        return success;
    }
}
