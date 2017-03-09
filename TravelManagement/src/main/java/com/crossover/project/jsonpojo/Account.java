/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crossover.project.jsonpojo;

/**
 *
 * @author waqas.ali2
 */
public class Account {
    private String id;
    private MonetaryAmount balance;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public MonetaryAmount getBalance() {
        return balance;
    }

    public void setBalance(MonetaryAmount balance) {
        this.balance = balance;
    }
    
    
    
}
