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
public class AirlineOffer {
    private MonetaryAmount price;
    private AirlineRoute route;

    public MonetaryAmount getPrice() {
        return price;
    }

    public void setPrice(MonetaryAmount price) {
        this.price = price;
    }

    public AirlineRoute getRoute() {
        return route;
    }

    public void setRoute(AirlineRoute route) {
        this.route = route;
    }
    
    
}
