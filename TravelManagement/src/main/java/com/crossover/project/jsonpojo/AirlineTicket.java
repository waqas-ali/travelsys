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
public class AirlineTicket {
    private long amount;
    private AirlineOffer details;

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }    

    public AirlineOffer getDetails() {
        return details;
    }

    public void setDetails(AirlineOffer details) {
        this.details = details;
    }
    
    
}
