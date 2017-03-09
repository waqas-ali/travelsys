/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crossover.project.dao;


import com.crossover.project.entities.Order;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author waqas.ali2
 */
public class OrderMapper implements RowMapper<Order> {
   @Override
   public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
      Order order = new Order();
      order.setAccountId(rs.getString("accountid"));
      order.setFrom(rs.getString("fromcity"));
      order.setTo(rs.getString("tocity"));
      order.setId(rs.getInt("id"));
      order.setTickets(rs.getLong("tickets"));
      order.setTotalPrice(rs.getDouble("totalprice"));
      return order;
   }
}
