package com.fethi.springbootsecurityjwt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BalanceController {


    @GetMapping("/myBalance")
    public String getBalanceDetails(@RequestParam int id) {
        return "myBalance service was called";
    }
}
