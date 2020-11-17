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

import java.util.Locale;
import java.util.ResourceBundle;



public class DBResourceManager {

	private final static DBResourceManager instance = new DBResourceManager();
        
	private ResourceBundle bundle = ResourceBundle.getBundle("db");
	
	public static DBResourceManager getInstance() {
		return instance;
	}
	
	public String getValue(String key){
		return bundle.getString(key);
	}
}
