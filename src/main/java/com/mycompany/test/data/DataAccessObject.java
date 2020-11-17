/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.test.data;

/**
 *
 * @author User
 */
public interface DataAccessObject<T> {
    
    public void create(T object);
    
    public T read(T object);
    
    public void update(T object);
    
    public void delete(T object);    
    
}
