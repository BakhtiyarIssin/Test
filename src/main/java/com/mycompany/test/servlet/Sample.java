/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.test.servlet;

import com.mycompany.test.command.ActionFactory;
import com.mycompany.test.command.Command;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mycompany.test.manager.ConfigurationManager;
import com.mycompany.test.manager.MessageManager;

/**
 *
 * @author User
 */
public class Sample extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        processRequest(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        processRequest(request, response);
    }
    
        
    private void  processRequest(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException
    {

        String page = null;
        
        ActionFactory client = new ActionFactory();
        
        Command command = client.defineCommand(request);
        
        page = command.execute(request);
        
        if(page != null)
        {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
            
            dispatcher.forward(request, response);           
            
        }
        else
        {
            page = ConfigurationManager.getProperty("path.page.index");
            
            request.getSession().setAttribute("nullPage", MessageManager.getProperty("message.nullpage"));
            
            response.sendRedirect(request.getContextPath() + page);       
                   
            
        }
        
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
        


        
    
    
    
}
