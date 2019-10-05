package com.pkg.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class AdminSessionFilter implements Filter {

    private ServletContext context;

    public void init(FilterConfig fConfig) throws ServletException {
        this.context = fConfig.getServletContext();
        this.context.log("AdminSessionFilter initialized");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        HttpSession session = req.getSession(false);
       
        //set a header to cache control
        res.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
        
        if (session == null || session.getAttribute("user") == null || !session.getAttribute("user_role").equals("admin")) {   //checking whether the session exists
            this.context.log("Unauthorized access request");
            //System.out.println("Unauthorized");
            res.sendRedirect(req.getContextPath() + "/Home/login.jsp");
        } else {
            // pass the request along the filter chain
            //System.out.println("Pass the chain");
            
            if(session.getAttribute("user_role").equals("admin")){
                chain.doFilter(request, response);
            }else{
               res.sendRedirect(req.getContextPath() + "/Home/login.jsp"); 
            }
        }
    }

    public void destroy() {
        //close any resources here
    }
}