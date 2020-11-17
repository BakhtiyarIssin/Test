/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.test.connectionPool;

/**
 *
 * @author User
 */
public class ConnectionException extends Exception{
    
    private static final long serialVersionUID = 1L;
    
    public ConnectionException(String message, Exception e)
    {
        super(message, e);
    }
    
}
