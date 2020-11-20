/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.test.filter;

import com.mycompany.test.manager.ConfigurationManager;
import com.mycompany.test.manager.MessageManager;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mycompany.test.validator.PasswordValidator;

/**
 *
 * @author User
 */
public class SimpleFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
       System.out.println("init of filter");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        
        final HttpServletRequest req = (HttpServletRequest) request;
        
        final HttpServletResponse res = (HttpServletResponse) response;
        
        final String login = req.getParameter("login");
        
        final String password = req.getParameter("password");
        
        req.getSession().setAttribute("error", "");
        
        req.getSession().setAttribute("password", "");
        
        if(login.isEmpty() || password.isEmpty())
        {
            String page = ConfigurationManager.getProperty("path.page.register");
            
            req.getSession().setAttribute("error", MessageManager.getProperty("message.error"));
            
            res.sendRedirect(req.getContextPath() + page);     
            
        }         
        else if(!PasswordValidator.validate(password))
        {
            String page = ConfigurationManager.getProperty("path.page.register");
            
            req.getSession().setAttribute("password", MessageManager.getProperty("message.password"));
            
            res.sendRedirect(req.getContextPath() + page);   
           
        }
        else
        {
            chain.doFilter(request, response);
        }    
    }

    @Override
    public void destroy() {
       System.out.println("destroy");
    }    
                
    
}
