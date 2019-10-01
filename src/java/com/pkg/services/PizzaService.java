/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pkg.services;

import com.pkg.dao.PizzaDao;
import com.pkg.daoImpl.PizzaDaoImpl;
import com.pkg.models.Pizza;
import java.util.List;

/**
 *
 * @author Ravindu Weerasnghe
 */
public class PizzaService {
    
    PizzaDao pd = new PizzaDaoImpl(); 
    
    public boolean addPizzaByAdmin(Pizza pizza){
        return pd.addPizza(pizza);
    }
    
    public List<Pizza> viewPizza(){
        return pd.getPizzaDetails();
    }
    
    public List<Pizza> viewPizzaItem(int id){
        return pd.findById(id);
    }
    
    public boolean updatePizzaByAdmin(int id,Pizza pizza){
        return pd.updatePizza(id, pizza);
    }
    
    public boolean deletePizzaByAdmin(int id){
        return pd.deletePizza(id);
    }
    
    public boolean updatePizzaImage(int id,Pizza pizza){
        return pd.updatePizzaImage(id,pizza);
    }
   
}
