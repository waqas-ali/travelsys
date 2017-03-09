/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crossover.project.entities;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author waqas.ali2
 */
public class UserRequest {
    @NotNull
    @Email(message = "Please enter valid email.")
    @NotEmpty(message = "Please enter your email addresss.")
    private String email;
    @NotNull
    @Size(min = 3, max = 20, message = "Password length should be between 3 and 20")
    @Pattern(regexp = "[a-zA-Z0-9_-@]+", message = "Allowed values are a-z, A-Z, 0-9, @, _ and -")
    private String password;
    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
