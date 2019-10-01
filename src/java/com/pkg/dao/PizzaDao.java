/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pkg.dao;

import com.pkg.models.Pizza;
import java.util.List;

/**
 *
 * @author Ravindu Weerasnghe
 */

public interface PizzaDao {
    
    public boolean addPizza(Pizza pizza);
    
    public List<Pizza> getPizzaDetails();
    
    public boolean updatePizza(int id,Pizza pizza);
    
    public boolean deletePizza(int id);
    
    public List<Pizza> findById(int id);
    
    public boolean updatePizzaImage(int id,Pizza pizza);
    
    
    
}
