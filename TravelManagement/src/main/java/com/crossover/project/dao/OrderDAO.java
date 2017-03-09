/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crossover.project.dao;

import com.crossover.project.entities.User;
import com.crossover.project.jsonpojo.Account;
import com.crossover.project.entities.Order;
import com.crossover.project.entities.UserRequest;
import java.util.List;
import javax.sql.DataSource;

/**
 *
 * @author waqas.ali2
 */
public interface OrderDAO{ 
   /** 
    * This is the method to be used to initialize
    * database resources ie. connection.
     * @param ds
    */
   public void setDataSource(DataSource ds);
   /** 
    * This is the method to be used to create
    * a record in the Order table.
     * @param order
    */
   public void create(Order order);
   /** 
    * This is the method to be used to list down
    * a record from the Order table corresponding
    * to a passed order id.
     * @param id
     * @return 
    */
   public Order getOrder(Integer id);
   /** 
    * This is the method to be used to list down
    * a record from the Order table corresponding
    * to a passed order id.
     * @param accountId
     * @return 
    */
   public List<Order> getOrders(String accountId);
   /** 
    * This is the method to be used to list down
    * all the records from the Order table.
     * @return 
    */
   public List<Order> listOrders();
   
   
   
}
