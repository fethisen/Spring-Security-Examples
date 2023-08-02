package com.fethi.springbootsecurityjwt.controller;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoansController {

    @GetMapping("/myLoans")
    @PostAuthorize("hasRole('USER')")
    public String getLoanDetails(@RequestParam int id) {
        return "myLoans service was called";
    }

    @PostMapping("/postLoans")
    public String getLoanDetails2() {
        return "Example for CSRF ";
    }

}