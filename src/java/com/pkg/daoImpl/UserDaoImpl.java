/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pkg.daoImpl;

import com.pkg.dao.UserDao;
import com.pkg.models.User;
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
public class UserDaoImpl implements UserDao {

    //keep a single instance
    static Connection currentConnection = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String query = "";
    boolean success = false;
    
    @Override
    public String signUp(User user) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        String checkQuery = "SELECT * FROM users";
        query = "INSERT INTO users(firstName,lastName,email,username,address,contact_number,role) VALUES(?,?,?,?,?,?,?)";
        List<User> userList = new ArrayList<User>();
        String result = null;
        
        try{
        currentConnection = ConnectionManager.getConnection();
        rs = currentConnection.prepareStatement(checkQuery).executeQuery();
        
        while(rs.next()){
            User u = new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getInt(8),rs.getString(9));
            userList.add(u);
        }
        
        for(int i=0;i<userList.size();i++){
            if(user.getUsername().equals(userList.get(i).getUsername()) && (!user.getEmail().equals(userList.get(i).getEmail())) && (user.getContact_number() != (userList.get(i).getContact_number())) ){
                result = "Username already exists";
            }else if(user.getEmail().equals(userList.get(i).getEmail()) && (!user.getUsername().equals(userList.get(i).getUsername())) && (user.getContact_number() != (userList.get(i).getContact_number()))){
                result = "Email is already taken";
            }else if(user.getContact_number() == userList.get(i).getContact_number() && (!user.getUsername().equals(userList.get(i).getUsername())) && (!(user.getEmail().equals(userList.get(i).getEmail())))){
                result = "Contact Number is already taken";
            }else if(user.getUsername().equals(userList.get(i).getUsername()) && (user.getEmail().equals(userList.get(i).getEmail())) && (user.getContact_number() != (userList.get(i).getContact_number()))){
                result = "Username and Email already exists";
            }else if(user.getUsername().equals(userList.get(i).getUsername()) && (!user.getEmail().equals(userList.get(i).getEmail())) && (user.getContact_number() == (userList.get(i).getContact_number()))){
                result = "Username and Contact Number already taken";
            }else if(!user.getUsername().equals(userList.get(i).getUsername()) && (user.getEmail().equals(userList.get(i).getEmail())) && (user.getContact_number() == (userList.get(i).getContact_number()))){
                result = "Email and Contact Number already taken";
            }else if(user.getUsername().equals(userList.get(i).getUsername()) && (user.getEmail().equals(userList.get(i).getEmail())) && (user.getContact_number() == (userList.get(i).getContact_number()))){
                result = "Username,Email & Contact Number already taken";
            }
        }//end of for
        
        if(result != null){
            ps = currentConnection.prepareStatement(query);
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getUsername());
            ps.setString(5, user.getPassword());
            ps.setString(6, user.getAddress());
            ps.setInt(7, user.getContact_number());
            ps.setString(8, user.getRole());

            ps.executeUpdate();
            
            result = "Registration is successfully completed !";
        }
        
        }catch(Exception e){
            System.out.println(e);
            result = "Registration failed ! Please try again.";
            
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
    
        return result;   
    }//signUp method

    @Override
    public boolean login(String username, String password) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        query = "SELECT * FROM users WHERE username=? AND password=?";
        
        try{
            
            currentConnection = ConnectionManager.getConnection();
            ps = currentConnection.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            
            if(rs.next()){
                success = true;
            }else{
                success = false;
            }
            
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
            
            if(rs != null){
                try{
                    rs.close();
                }catch(Exception e){
                    System.out.println(e);
                }
            }
        }
        return success;
    }//lgin method

    @Override
    public List<User> userDetails(String username) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       List <User> userdetails = new ArrayList<>();
       query = "SELECT * FROM users WHERE username=?";
       
       try{
            
            currentConnection = ConnectionManager.getConnection();
            ps = currentConnection.prepareStatement(query);
            ps.setString(1, username);
            rs = ps.executeQuery();
            
            while(rs.next()){
               User u = new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getInt(8),rs.getString(9));
               userdetails.add(u); 
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
       return userdetails; 
    }//userDetails method

    @Override
    public List<User> getUserList() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        List <User> usersList = new ArrayList<>();
       query = "SELECT * FROM users";
       
       try{
            
            currentConnection = ConnectionManager.getConnection();
            ps = currentConnection.prepareStatement(query);
            rs = ps.executeQuery();
            
            while(rs.next()){
               User u = new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getInt(8),rs.getString(9));
               usersList.add(u); 
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
       return usersList; 
    }//getUserList method
       
}
