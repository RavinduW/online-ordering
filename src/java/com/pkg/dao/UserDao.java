/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pkg.dao;

import com.pkg.models.User;
import java.util.List;

/**
 *
 * @author Ravindu Weerasnghe
 */
public interface UserDao {
    
    //signup
    public String signUp(User user);
    
    //login
    public boolean login(String username,String password);
    
    //retrieve user details
    public List<User> userDetails(String username);
    
    //retireve all users
    public List<User> getUserList();
    
}
