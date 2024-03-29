/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pkg.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ravindu Weerasnghe
 */
public class ConnectionManager {
    //variables declared as private, to controll the access
    private static Connection con;
    private static String connectionUrl;
    private static String username;
    private static String password;
    
    //this method is static
    public static Connection getConnection() throws SQLException{
        
        try {
            connectionUrl = "jdbc:mysql://localhost:3306/pizza?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            username = "root";
            password = "";
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            con = DriverManager.getConnection(connectionUrl,username,password);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //print out a success and error msgs regarding the db connection
        if(con != null){
            String query = "SET GLOBAL max_allowed_packet=16177215";
            PreparedStatement ps = con.prepareStatement(query);
            ps.executeUpdate();
            System.out.println("Connected to database");
        }else{
            System.out.println("Connection is failed");
        }
        
        return con; //return the db connection
    }
}
