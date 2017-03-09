/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crossover.project.dao;

import com.crossover.project.entities.User;
import com.crossover.project.jsonpojo.Account;
import com.crossover.project.entities.UserRequest;
import java.util.List;
import javax.sql.DataSource;

/**
 *
 * @author waqas.ali2
 */
public interface UserDAO{ 
   /** 
    * This is the method to be used to initialize
    * database resources ie. connection.
     * @param ds
    */
   public void setDataSource(DataSource ds);
   /** 
    * This is the method to be used to create
    * a record in the User table.
     * @param user
     * @param account
    */
   public void create(UserRequest user,Account account);
   /** 
    * This is the method to be used to list down
    * a record from the User table corresponding
    * to a passed student id.
     * @param id
     * @return 
    */
   public User getUser(Integer id);
   /** 
    * This is the method to be used to list down
    * a record from the User table corresponding
    * to a passed student id.
     * @param email
     * @return 
    */
   public User getUser(String email);
   /** 
    * This is the method to be used to list down
    * all the records from the User table.
     * @return 
    */
   public List<User> listUsers();

}
