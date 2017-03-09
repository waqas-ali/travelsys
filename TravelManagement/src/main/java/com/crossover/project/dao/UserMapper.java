/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crossover.project.dao;

import com.crossover.project.entities.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author waqas.ali2
 */
public class UserMapper implements RowMapper<User> {
   @Override
   public User mapRow(ResultSet rs, int rowNum) throws SQLException {
      User user = new User();
      user.setEmail(rs.getString("email"));
      user.setRole(rs.getString("role"));
      user.setCurrency(rs.getString("currency"));
      user.setAccountId(rs.getString("account"));
      user.setPassword(rs.getString("password"));
      return user;
   }
}
