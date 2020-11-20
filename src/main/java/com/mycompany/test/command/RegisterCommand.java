/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.test.command;

import com.mycompany.test.data.UserDAO;
import com.mycompany.test.hash.HashPassword;
import com.mycompany.test.model.User;
import com.mycompany.test.manager.ConfigurationManager;
import com.mycompany.test.manager.MessageManager;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author User
 */
public class RegisterCommand implements Command {
    
    private static final String PARAMETER_NAME_LOGIN = "login";
    
    private static final String PARAMETER_NAME_PASSWORD = "password";
    
    @Override
    public String execute(HttpServletRequest request)
    {
        String page = null;
        
        String login = request.getParameter(PARAMETER_NAME_LOGIN);
        
        String password = request.getParameter(PARAMETER_NAME_PASSWORD);
        
        UserDAO dataAccessObject = new UserDAO();
        
        User newUser = new User().setLogin(login);


        if(dataAccessObject.read(newUser) == null)
        {
            dataAccessObject.create(newUser.setPassword(HashPassword.getHashPassword(password)).setRole(User.ROLE.user));

            page = ConfigurationManager.getProperty("path.page.registered");

        }
        else
        {
            page = ConfigurationManager.getProperty("path.page.register");
            
            request.getSession().setAttribute("userIsExist", MessageManager.getProperty("message.userIsExist"));
        }       
        
        return page;
    }
    
    
}
