/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pkg.controllers;

import com.pkg.models.User;
import com.pkg.services.UserService;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ravindu Weerasnghe
 */
public class SignUpController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SignUpController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SignUpController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        UserService u_service = new UserService();

        String username = request.getParameter("username");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String contact_number = request.getParameter("contact_number");
        String password1 = request.getParameter("password1");
        String password2 = request.getParameter("password2");

        RequestDispatcher rd;
        HttpSession session = request.getSession();
        request.setAttribute("firstName",firstName); 
        request.setAttribute("lastName",lastName);
        request.setAttribute("email", email);
        request.setAttribute("address", address);
        request.setAttribute("contact_number", contact_number);
        request.setAttribute("username", username);
        
        try {

           User user = new User(0,firstName,lastName,email,username,password1,address,contact_number,"customer");
           //call the user service
           if(password1.equals(password2)){
               if(password1.length()>=6){
                if(u_service.userRegistration(user).equals("Success")){
                    
                    session.setAttribute("success", "Your Registration is successfully completed !");
                    response.sendRedirect("/OnlinePizza/Home/signup.jsp");
                    return;
                    
                }else if(u_service.userRegistration(user).equals("Username is already taken")){
                    
                    session.setAttribute("error", "Username is already taken");
                    rd = request.getRequestDispatcher("Home/signup.jsp"); //return the jsp
                    rd.forward(request, response);

                    return;
                    
                }else if(u_service.userRegistration(user).equals("Email is already taken")){
                    
                    session.setAttribute("error", "Email is already taken");
                    rd = request.getRequestDispatcher("Home/signup.jsp"); //return the jsp
                    rd.forward(request, response);
                    
                    return;
                    
                }else if(u_service.userRegistration(user).equals("Contact Number is already taken")){
                    
                    session.setAttribute("error", "Contact Number is already taken");
                    rd = request.getRequestDispatcher("Home/signup.jsp"); //return the jsp
                    rd.forward(request, response);
                    
                    return;
                    
                }else if(u_service.userRegistration(user).equals("Username and Contact Number already exists")){
                    
                    session.setAttribute("error", "Username and Contact Number already taken");
                    rd = request.getRequestDispatcher("Home/signup.jsp"); //return the jsp
                    rd.forward(request, response);
                    
                    return;
                    
                }
                else if(u_service.userRegistration(user).equals("Username and Email already exists")){
                    
                    session.setAttribute("error", "Username and Email already taken");
                    rd = request.getRequestDispatcher("Home/signup.jsp"); //return the jsp
                    rd.forward(request, response);
                    
                    return;
                    
                }else if(u_service.userRegistration(user).equals("Email and Contact Number already taken")){
                    
                    session.setAttribute("error", "Email and Contact Number already taken");
                    rd = request.getRequestDispatcher("Home/signup.jsp"); //return the jsp
                    rd.forward(request, response);
                    
                    return;
                    
                }else if(u_service.userRegistration(user).equals("Username,Email & Contact Number already taken")){
                    
                    session.setAttribute("error","Username,Email & Contact Number already taken");
                    rd = request.getRequestDispatcher("Home/signup.jsp"); //return the jsp
                    rd.forward(request, response);
                    
                    return;
                    
                }else{
                    session.setAttribute("error", "SignUp failed !");
                    rd = request.getRequestDispatcher("Home/signup.jsp"); //return the jsp
                    rd.forward(request, response);
                    
                    return;
                }
               }else{
                   //length must be grater or equal to 6
                   session.setAttribute("error", "Password length should be equal or greater than 6");
                   rd = request.getRequestDispatcher("Home/signup.jsp"); //return the jsp
                   rd.forward(request, response);
                   
                   return;
               }
           }else{
               //pw mismatched
               session.setAttribute("error", "Passwords mismatched");
               rd = request.getRequestDispatcher("Home/signup.jsp"); //return the jsp
               rd.forward(request, response);
               
               return;
           }
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeySpecException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
