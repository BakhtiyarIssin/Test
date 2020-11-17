/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.test.command;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author User
 */
public class ActionFactory {
    
    public Command defineCommand(HttpServletRequest request)
    {
        Command current = new EmptyCommand();
        
        String action = request.getParameter("command");
        
        if(action == null || action.isEmpty())
        {
            return current;
        }
        
        try
        {
            Commands currentEnum = Commands.valueOf(action.toUpperCase());
            
            current = currentEnum.getCurrentCommand();           
            
        }
        catch(IllegalArgumentException e)
        {
            request.setAttribute("wrongAction", action);
        }
        
        return current;
    }
    
    
    
    
    
}
