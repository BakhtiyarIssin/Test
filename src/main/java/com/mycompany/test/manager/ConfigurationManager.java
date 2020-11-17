/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.test.manager;

import java.util.ResourceBundle;

/**
 *
 * @author User
 */
public class ConfigurationManager {
    
    private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("config");
    
    private ConfigurationManager()
    {
        
    }
    
    public static String getProperty(String key)
    {
            return resourceBundle.getString(key);
    }
    
    
    
}
