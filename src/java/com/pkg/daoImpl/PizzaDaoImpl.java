/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pkg.daoImpl;

import com.pkg.dao.PizzaDao;
import static com.pkg.daoImpl.UserDaoImpl.currentConnection;
import com.pkg.models.Pizza;
import com.pkg.models.User;
import com.pkg.utils.ConnectionManager;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.output.*;

/**
 *
 * @author Ravindu Weerasnghe
 */
public class PizzaDaoImpl implements PizzaDao{

    //keep a single instance
    static Connection currentConnection = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String query = "";
    boolean success = false;
    
    @Override
    public boolean addPizza(Pizza pizza) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        query = "INSERT INTO pizzaitems(name,price,status,image) VALUES(?,?,?,?) ";
        
        try{
        currentConnection = ConnectionManager.getConnection();

        String querySetLimit = "SET GLOBAL max_allowed_packet=16177215";  // 10 MB
        Statement stSetLimit = currentConnection.createStatement();
        stSetLimit.execute(querySetLimit);
         
        ps = currentConnection.prepareStatement(query);
        
        ps.setString(1, pizza.getName());
        ps.setDouble(2, pizza.getPrice());
        ps.setString(3, pizza.getStatus());
        
        if(pizza.getImage()!= null){
            ps.setBlob(4, new ByteArrayInputStream(pizza.getImage()));
        }
        // sends the statement to the database server
        int row = ps.executeUpdate();
        if (row > 0) {
             System.out.println("File uploaded and saved into database");
             success = true;
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
    }//addPizza
    
    public List<Pizza> getPizzaDetails(){
       
       List <Pizza> pizzadetails = new ArrayList<>();
       query = "SELECT * FROM pizzaitems";
        
       try{
            currentConnection = ConnectionManager.getConnection();
            ps = currentConnection.prepareStatement(query);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Blob blob = rs.getBlob("image");
                 
                InputStream inputStream = blob.getBinaryStream();
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[4096];
                int bytesRead = -1;
                 
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);                  
                }
                 
                byte[] imageBytes = outputStream.toByteArray();
                String base64Image = Base64.getEncoder().encodeToString(imageBytes);
                

                Pizza pizza = new Pizza(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getString(4),imageBytes);
                pizza.setBase64Image(base64Image);
                pizzadetails.add(pizza);
                inputStream.close();
                outputStream.close();
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
       return pizzadetails;
    }//getPizzaDetails
    
    public boolean updatePizza(int id,Pizza pizza){
    
        query = "UPDATE pizzaitems SET name=?,price=?,status=? WHERE id=?";
                
        try{
            
            currentConnection = ConnectionManager.getConnection();
            ps = currentConnection.prepareStatement(query);
            ps.setString(1, pizza.getName());
            ps.setDouble(2, pizza.getPrice());
            ps.setString(3, pizza.getStatus());
            ps.setInt(4, id);
            
            // sends the statement to the database server
            int row = ps.executeUpdate();
            if (row > 0) {
             System.out.println("Updated database");
             success = true;
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
    }//updatePizza
    
    public boolean deletePizza(int id){
        
        query = "DELETE FROM pizzaitems WHERE id=?";
        
        try{
            currentConnection = ConnectionManager.getConnection();
            ps = currentConnection.prepareStatement(query);
            ps.setInt(1, id);
            
           int row = ps.executeUpdate();
            if (row > 0) {
             System.out.println("File uploaded and updated database");
             success = true;
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
    }//deletePizza
    
    public List<Pizza> findById(int id){
        
        query = "SELECT * FROM pizzaitems WHERE id=?";
        List<Pizza> pizzadetails = new ArrayList<>();
        
        try{
            currentConnection = ConnectionManager.getConnection();
            ps = currentConnection.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while(rs.next()){
                Blob blob = rs.getBlob("image");
                 
                InputStream inputStream = blob.getBinaryStream();
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[4096];
                int bytesRead = -1;
                 
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);                  
                }
                 
                byte[] imageBytes = outputStream.toByteArray();
                String base64Image = Base64.getEncoder().encodeToString(imageBytes);
                

                Pizza pizza = new Pizza(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getString(4),imageBytes);
                pizza.setBase64Image(base64Image);
                pizzadetails.add(pizza);
                inputStream.close();
                outputStream.close();
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
        return pizzadetails;
    }//findById
    
    @Override
    public boolean updatePizzaImage(int id,Pizza pizza){
        
        query = "UPDATE pizzaitems SET name=?,price=?,status=?,image=? WHERE id=?";
        
        try{
            currentConnection = ConnectionManager.getConnection();

            String querySetLimit = "SET GLOBAL max_allowed_packet=16177215";  // 16 MB
            Statement stSetLimit = currentConnection.createStatement();
            stSetLimit.execute(querySetLimit);

            ps = currentConnection.prepareStatement(query);

            ps.setString(1, pizza.getName());
            ps.setDouble(2, pizza.getPrice());
            ps.setString(3, pizza.getStatus());
            ps.setInt(5, id);

            if(pizza.getImage()!= null){
                ps.setBlob(4, new ByteArrayInputStream(pizza.getImage()));
            }
            // sends the statement to the database server
            int row = ps.executeUpdate();
            if (row > 0) {
                 System.out.println("File uploaded and saved into database");
                 success = true;
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
    }//updatePizzaImage
    
    //view avilable pizzas for customer
    public List<Pizza> getAvailablePizza(){
       
       List <Pizza> pizzadetails = new ArrayList<>();
       query = "SELECT * FROM pizzaitems WHERE status=?";
        
       try{
            currentConnection = ConnectionManager.getConnection();
            ps = currentConnection.prepareStatement(query);
            ps.setString(1, "Available");
            rs = ps.executeQuery();
            
            while(rs.next()){
                Blob blob = rs.getBlob("image");
                 
                InputStream inputStream = blob.getBinaryStream();
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[4096];
                int bytesRead = -1;
                 
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);                  
                }
                 
                byte[] imageBytes = outputStream.toByteArray();
                String base64Image = Base64.getEncoder().encodeToString(imageBytes);
                

                Pizza pizza = new Pizza(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getString(4),imageBytes);
                pizza.setBase64Image(base64Image);
                pizzadetails.add(pizza);
                inputStream.close();
                outputStream.close();
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
       return pizzadetails;
    }//getAvailablePizza
    
}//PizzaDaoImpl class
