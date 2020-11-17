/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.test.model;

/**
 *
 * @author User
 */
public class User {
    
    private int id;
    
    private String login;
    
    private String password;
    
    private ROLE role;
    
    public User()
    {
        
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public User setId(int id) {
        this.id = id;
        
        return this;
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public User setLogin(String login) {
        this.login = login;
        
        return this;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public User setPassword(String password) {
        this.password = password;
        
        return this;
    }
    
    public enum ROLE 
    {
        admin, user, unknown        
    }

    /**
     * @return the role
     */
    public ROLE getRole() {
        return role;
    }

    /**
     * @param role the role to set
     */
    public User setRole(ROLE role) {
        this.role = role;
        
        return this;
    }
    
    
    
    
    
    
}
