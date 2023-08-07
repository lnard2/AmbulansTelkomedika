package com.ambulans.AmbulansKlinikTelkomedika.controller;

import com.ambulans.AmbulansKlinikTelkomedika.DTO.AmbulansDTO;
import com.ambulans.AmbulansKlinikTelkomedika.entity.AmbulansEntity;
import com.ambulans.AmbulansKlinikTelkomedika.model.AccountRequest;
import com.ambulans.AmbulansKlinikTelkomedika.service.AmbulansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/account")
public class AccountController {
    URI uri = new URI("http://desktop-vld0s2c:8080/account");

    RestTemplate restTemplate = new RestTemplate();

    public AccountController() throws URISyntaxException {
        this.restTemplate = new RestTemplate();
    }
    @GetMapping
    public AccountRequest[] getAccountAll(){
        AccountRequest[] Accountlist = restTemplate.getForObject(uri, AccountRequest[].class);
        return Accountlist;
    }
    @GetMapping("{id}")
    public AccountRequest getAccountById(@PathVariable("id") Long id) throws URISyntaxException {
        AccountRequest account = restTemplate.getForObject(uri+"/"+id, AccountRequest.class);
        return account;
    }
    @PostMapping
    public AccountRequest addAccount(@RequestBody AccountRequest account) throws URISyntaxException{
        AccountRequest newaccount =  restTemplate.postForObject(uri, account, AccountRequest.class);
        return newaccount;
    }
    @DeleteMapping("{id}")
    public void deteleAccount(@PathVariable Long id) throws URISyntaxException{
        restTemplate.delete(uri+"/"+id);
    }

}


