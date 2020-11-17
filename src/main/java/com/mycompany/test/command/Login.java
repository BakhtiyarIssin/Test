/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.test.command;

import com.mycompany.test.data.UserDAO;
import com.mycompany.test.hash.HashPassword;
import com.mycompany.test.model.User;
import javax.servlet.http.HttpServletRequest;
import com.mycompany.test.manager.ConfigurationManager;

/**
 *
 * @author User
 */
public class Login  implements Command {
    
    private static final String PARAMETER_NAME_LOGIN = "login";
    
    private static final String PARAMETER_NAME_PASSWORD = "password";
    
    @Override
    public String execute(HttpServletRequest request)
    {
        String page = null;
        
        String login = request.getParameter(PARAMETER_NAME_LOGIN);
        
        String password = request.getParameter(PARAMETER_NAME_PASSWORD);
        
        UserDAO dataAccessObject = new UserDAO();
        
        User currentUser = dataAccessObject.read(new User().setLogin(login));
        
        if(currentUser == null || !currentUser.getLogin().equals(login) || !currentUser.getPassword().equals(HashPassword.getHashPassword(password)))
        {
            page = ConfigurationManager.getProperty("path.page.index");            
        }
        else
        {
            page = ConfigurationManager.getProperty("path.page.main");            
        }       
        
        return page;
    }
    
    
}
