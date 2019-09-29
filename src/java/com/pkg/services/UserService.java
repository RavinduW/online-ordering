/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pkg.services;

import com.pkg.dao.UserDao;
import com.pkg.daoImpl.UserDaoImpl;
import com.pkg.models.User;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.List;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/**
 *
 * @author Ravindu Weerasnghe
 */
public class UserService {

    UserDao ud = new UserDaoImpl(); //UserDAO interface referencing
    
    //password hashing begins
    private static String generateStrongPasswordHash(String password) throws NoSuchAlgorithmException, InvalidKeySpecException
    {
        int iterations = 1000; //number of iterations
        char[] chars = password.toCharArray(); //convert the password in to a character array
        
        //salt is random data
        //for each pw,generate new salt
        byte[] salt = getSalt(); //get the salt
         
        PBEKeySpec spec = new PBEKeySpec(chars, salt, iterations, 64 * 8);
        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        
        byte[] hash = skf.generateSecret(spec).getEncoded(); //hash value
        
        return iterations + ":" + toHex(salt) + ":" + toHex(hash); //return the hash value
    }
     
    private static byte[] getSalt() throws NoSuchAlgorithmException
    {
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG"); //PRNG=Pseudo Random Number Generator
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return salt;
    }
    
    private static String toHex(byte[] array) throws NoSuchAlgorithmException
    {
        BigInteger bi = new BigInteger(1, array);
        String hex = bi.toString(16);
        int paddingLength = (array.length * 2) - hex.length();
        if(paddingLength > 0)
        {
            return String.format("%0"  +paddingLength + "d", 0) + hex;
        }else{
            return hex;
        }
    }
    
    private static boolean validatePassword(String originalPassword, String storedPassword) throws NoSuchAlgorithmException, InvalidKeySpecException
    {
        String[] parts = storedPassword.split(":");
        int iterations = Integer.parseInt(parts[0]);
        byte[] salt = fromHex(parts[1]);
        byte[] hash = fromHex(parts[2]);
         
        PBEKeySpec spec = new PBEKeySpec(originalPassword.toCharArray(), salt, iterations, hash.length * 8);
        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] testHash = skf.generateSecret(spec).getEncoded();
         
        int diff = hash.length ^ testHash.length;
        for(int i = 0; i < hash.length && i < testHash.length; i++)
        {
            diff |= hash[i] ^ testHash[i];
        }
        return diff == 0;
    }
    private static byte[] fromHex(String hex) throws NoSuchAlgorithmException
    {
        byte[] bytes = new byte[hex.length() / 2];
        for(int i = 0; i<bytes.length ;i++)
        {
            bytes[i] = (byte)Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);
        }
        return bytes;
    }
    
    //end of password hashing
    
    public String userRegistration(User user) throws NoSuchAlgorithmException, InvalidKeySpecException{
        user.setPassword(generateStrongPasswordHash(user.getPassword()));
        return ud.signUp(user);       
    }//userRegistration method
    
    public boolean UserLogin(String username,String password) throws NoSuchAlgorithmException, InvalidKeySpecException{
        
        boolean authentication = false;
        List<User> userData = ud.userDetails(username);
        
        if(!userData.isEmpty()){
            int id = ud.userDetails(username).get(0).getId();
            //System.out.println("not empty");
            if(validatePassword(password,userData.get(0).getPassword()) && (username.equals(userData.get(0).getUsername()))){
                authentication = true;
            }else{
                authentication = false;
            }
        }
        
        return authentication;
        
    }//userLogin mwthod
    
    public List<User> getUserDetails(String username){
        return ud.userDetails(username);
    }//getUserDetails method
    
    //public List<User> getUsers(){
        
    //}
}    

