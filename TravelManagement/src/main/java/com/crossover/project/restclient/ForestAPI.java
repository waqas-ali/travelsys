/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crossover.project.restclient;

import com.crossover.project.entities.Currency;
import com.crossover.project.jsonpojo.Account;
import com.crossover.project.jsonpojo.AirlineOffer;
import com.crossover.project.jsonpojo.AirlineTicket;
import com.crossover.project.jsonpojo.BuyTicketRequest;
import com.crossover.project.jsonpojo.DepositWithdrawRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author waqas.ali2
 */
public class ForestAPI {

    private static final String URL = "https://api-forest.crossover.com/ZlAyVlQ/";
    private static final Gson gson = new GsonBuilder().create();
    
    public Account createAccount() {
        String url = URL + "paypallets/account";
        Account account = new Account();
        RestTemplate restTemplate = new RestTemplate();
        JsonObject request = new JsonObject();
        request.addProperty("currency", Currency.USD.toString());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<String>(new Gson().toJson(request), headers);

        ResponseEntity<String> response = restTemplate
                .exchange(url, HttpMethod.POST, entity, String.class);

        String jsonString = response.getBody();
        account = gson.fromJson(jsonString, Account.class);

        return account;
    }
    
    public Account deposit(DepositWithdrawRequest request) {
        String url = URL + "paypallets/account/deposit";

        RestTemplate restTemplate = new RestTemplate();        
        
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(new Gson().toJson(request), headers);

        ResponseEntity<String> response = restTemplate
                .exchange(url, HttpMethod.POST, entity, String.class);

        String jsonString = response.getBody();
        return gson.fromJson(jsonString, Account.class);

    }
    
    public List<AirlineOffer> getOffers() {
        String url = URL + "gammaairlines/offers";
        
        RestTemplate restTemplate = new RestTemplate();
       
        ResponseEntity<String> response = restTemplate
                .exchange(url, HttpMethod.GET, null, String.class);

        String jsonString = response.getBody();
        
        Type listType = new TypeToken<ArrayList<AirlineOffer>>(){}.getType(); 
        return gson.fromJson(jsonString, listType);

    }
    
    public void resetAccount() {
        String url = URL + "reset";
        
        RestTemplate restTemplate = new RestTemplate();
       
        ResponseEntity<String> response = restTemplate
                .exchange(url, HttpMethod.GET, null, String.class);

        //String jsonString = response.getBody();

    }
    
    public AirlineTicket buyTicket(BuyTicketRequest request) {
        String url = URL + "gammaairlines/tickets/buy";
        RestTemplate restTemplate = new RestTemplate();
        
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(new Gson().toJson(request), headers);

        ResponseEntity<String> response = restTemplate
                .exchange(url, HttpMethod.POST, entity, String.class);

        String jsonString = response.getBody();
        return gson.fromJson(jsonString, AirlineTicket.class);

    }
    
   
    
   
}
