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
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author waqas.ali2
 */
public class OrderJDBCTemplate implements OrderDAO {
   private DataSource dataSource;
   private JdbcTemplate jdbcTemplateObject;
   
   @Override
   public void setDataSource(DataSource dataSource) {
      this.dataSource = dataSource;
      this.jdbcTemplateObject = new JdbcTemplate(dataSource);
   }

   @Override
   public void create(Order order) {
      String SQL = "insert into orders(accountid, fromcity,tocity,tickets,totalprice) values (?, ?, ?,?,?)";
      int i = jdbcTemplateObject.update( SQL, order.getAccountId(),order.getFrom(),order.getTo(),order.getTickets(),order.getTotalPrice());
      
   }

   @Override
   public Order getOrder(Integer id) {
      String SQL = "select * from orders where id = ?";
      Order order = jdbcTemplateObject.queryForObject(SQL, 
                        new Object[]{id}, new OrderMapper());
      return order;
   }

   @Override
   public List<Order> getOrders(String accountId) {
      String SQL = "select * from orders where accountid = ?";
      List <Order> orders= jdbcTemplateObject.query(SQL, 
                        new Object[]{accountId}, new OrderMapper());
      return orders;
   }
   
   @Override
   public List<Order> listOrders() {
      String SQL = "select * from orders";
      List <Order> orders = jdbcTemplateObject.query(SQL, 
                                new OrderMapper());
      return orders;
   }

}
