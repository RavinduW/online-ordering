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
public class LoginController extends HttpServlet {

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
            out.println("<title>Servlet LoginController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginController at " + request.getContextPath() + "</h1>");
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
        //processRequest(request, response);
        HttpSession session = request.getSession();
        session.invalidate();
        response.sendRedirect("/OnlinePizza/Home/login.jsp");
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
        
        UserService us = new UserService();
        RequestDispatcher rd;
        HttpSession session = request.getSession();
        String username,password;
        
        username = request.getParameter("username");
        password = request.getParameter("password");
        
        try {
            if(us.UserLogin(username, password) && us.getUserDetails(username).get(0).getRole().equals("customer")){
                session.setAttribute("user_id",us.getUserDetails(username).get(0).getId());
                session.setAttribute("user",us.getUserDetails(username).get(0).getUsername());
                session.setAttribute("user_role",us.getUserDetails(username).get(0).getRole());
                session.setMaxInactiveInterval(3600);
                response.sendRedirect("/OnlinePizza/CustomerPanelController");
                
            }else if(us.UserLogin(username, password) && us.getUserDetails(username).get(0).getRole().equals("admin")){
                session.setAttribute("user_id",us.getUserDetails(username).get(0).getId());
                session.setAttribute("user",us.getUserDetails(username).get(0).getUsername());
                session.setAttribute("user_role", us.getUserDetails(username).get(0).getRole());
                session.setMaxInactiveInterval(3600);
                
                response.sendRedirect("/OnlinePizza/ViewAdminPanelController");
                
            }else{
                request.setAttribute("Message", "Authentication failed !");
                request.setAttribute("username", username);
                rd = request.getRequestDispatcher("Home/login.jsp"); //return the jsp
                rd.forward(request, response);
                //response.sendRedirect("/OnlinePizza/login.jsp");
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
