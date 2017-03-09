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
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author waqas.ali2
 */
public class UserJDBCTemplate implements UserDAO {
   private DataSource dataSource;
   private JdbcTemplate jdbcTemplateObject;
   
   @Override
   public void setDataSource(DataSource dataSource) {
      this.dataSource = dataSource;
      this.jdbcTemplateObject = new JdbcTemplate(dataSource);
   }

   @Override
   public void create(UserRequest user,Account account) {
      String SQL = "insert into User (email, password,role,account,amount,currency) values (?, ?, ?,?,?,?)";
      int i = jdbcTemplateObject.update( SQL, user.getEmail(), user.getPassword(),user.getRole(),account.getId(),account.getBalance().getAmount(),account.getBalance().getCurrency().toString());
      
   }

   @Override
   public User getUser(Integer id) {
      String SQL = "select * from User where id = ?";
      User student = jdbcTemplateObject.queryForObject(SQL, 
                        new Object[]{id}, new UserMapper());
      return student;
   }

   @Override
   public User getUser(String email) {
      String SQL = "select * from User where email = ?";
      User student = jdbcTemplateObject.queryForObject(SQL, 
                        new Object[]{email}, new UserMapper());
      return student;
   }
   
   @Override
   public List<User> listUsers() {
      String SQL = "select * from User";
      List <User> students = jdbcTemplateObject.query(SQL, 
                                new UserMapper());
      return students;
   }

}
