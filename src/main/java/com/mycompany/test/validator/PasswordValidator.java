package com.mycompany.test.validator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class PasswordValidator {
    
    public static boolean validate(final String password)
    {
       String rule = "[0-9]+[a-z]+[A-Z]+[\\.,!]+";         
       
       return password.matches(rule);       
    }     
        
    
}
