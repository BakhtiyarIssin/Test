/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.test.command;

/**
 *
 * @author User
 */
public enum Commands {
    
        LOGIN {
        {
            this.command = new Login();
        }
                
        },
        LOGOUT{
        {
            this.command = new ExitCommand();
        }
                
    },

    REGISTER{
        {
            this.command = new RegisterCommand();
        }

    }


    ;
    
    Command command;
    
    public  Command  getCurrentCommand()
    {
        return command;
    }
      
    
}
