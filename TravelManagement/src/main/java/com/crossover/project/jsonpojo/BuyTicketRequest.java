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
public class BuyTicketRequest {
    private String accountId;
    private long amount;
    private AirlineRoute route;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public AirlineRoute getRoute() {
        return route;
    }

    public void setRoute(AirlineRoute route) {
        this.route = route;
    }

    
    
}
