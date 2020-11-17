/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.test.command;

import javax.servlet.http.HttpServletRequest;
import com.mycompany.test.manager.ConfigurationManager;

/**
 *
 * @author User
 */
public class EmptyCommand implements Command
{
    @Override
    public String execute(HttpServletRequest request)
    {
        String page = ConfigurationManager.getProperty("path.page.index");
        
        return page;
    }
    
    
    
    
}
