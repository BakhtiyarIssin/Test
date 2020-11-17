/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.test.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.mycompany.test.connectionPool.ConnectionException;
import com.mycompany.test.connectionPool.ConnectionPool;
import com.mycompany.test.model.User;
import com.mycompany.test.data.DataAccessObject;
import java.sql.ResultSet;

/**
 *
 * @author User
 */
public class UserDAO implements DataAccessObject<User>{
    
    private ConnectionPool connectionPool = null;
    
    public UserDAO()
    {
        connectionPool = ConnectionPool.getInstance();         
    }    
    
    @Override
    public void create(User user)
    {
        
        final String createUser =  "INSERT INTO users (login, password, role) VALUES (?, ?, ?)"; //"INSERT INTO 'new'.'users' ('',''login', 'password', 'role') VALUES ( ?,?,?,?)";
            
                        
        PreparedStatement preparedStatement = null;
            
        try(Connection connection  = connectionPool.takeConnection();)
        { 
            
            preparedStatement = connection.prepareStatement(createUser);
            
            preparedStatement.setString(1, user.getLogin());  
            
            preparedStatement.setString(2, user.getPassword());
            
            preparedStatement.setString(3, user.getRole().toString());
            
            preparedStatement.executeUpdate();
            
        } 
        catch (ConnectionException ex) {      
                
                System.out.println("can not take connection");
            }
        catch (SQLException ex) {
            
            System.out.println("problem with sql");
            
        }
        
    }
    
    @Override
    public User read(User user)
    {
        final String readUser = "SELECT * FROM users WHERE login = ? ";
                        
        PreparedStatement preparedStatement = null;
            
        ResultSet set = null;

        User userOne = null;
        
        try(Connection connection  = connectionPool.takeConnection();)
        {
            preparedStatement = connection.prepareStatement(readUser);
            
            preparedStatement.setString(1, user.getLogin());  
            
            set = preparedStatement.executeQuery();       
            
            while(set.next()) 
            {
                userOne = new User();

                userOne.setLogin(set.getString(2)).setPassword(set.getString(3)).setRole( User.ROLE.valueOf(set.getString(4)));
            }
        } 
        catch (ConnectionException ex) {      
                
                System.out.println("can not take connection");
            }
        catch (SQLException ex) {
            
            System.out.println("problem with sql");
            
        }
        
        return userOne;
        
        
    }
    
    @Override
    public void update(User user)
    {
        final String updateUser =  "UPDATE users SET password = ?  WHERE  ( login = ? )"; //"INSERT INTO 'new'.'users' ('',''login', 'password', 'role') VALUES ( ?,?,?,?)";

        PreparedStatement preparedStatement = null;

        try(Connection connection  = connectionPool.takeConnection();)
        {
            preparedStatement = connection.prepareStatement(updateUser);

            preparedStatement.setString(1, user.getPassword());

            preparedStatement.setString(2, user.getLogin());

            preparedStatement.executeUpdate();
        }
        catch (ConnectionException ex) {

            System.out.println("can not take connection");
        }
        catch (SQLException ex) {

            System.out.println("problem with sql");

        }
    }
    
    @Override
    public void delete(User user) {

        final String delete = "DELETE FROM users WHERE (login = ?)";

        PreparedStatement preparedStatement = null;

        try (Connection connection = connectionPool.takeConnection();) {

            preparedStatement = connection.prepareStatement(delete);

            preparedStatement.setString(1, user.getLogin());

            preparedStatement.executeUpdate();

        } catch (ConnectionException ex) {

            System.out.println("can not take connection");
        } catch (SQLException ex) {

            System.out.println("problem with sql");

        }

    }
    
}
