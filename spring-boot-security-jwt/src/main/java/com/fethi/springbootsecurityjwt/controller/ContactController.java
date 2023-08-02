package com.fethi.springbootsecurityjwt.controller;

import com.fethi.springbootsecurityjwt.payload.request.ContactDTO;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ContactController {


    @PostMapping("/contact")
    // @PreFilter("filterObject.contactName != 'Test'")
    @PostFilter("filterObject.contactName != 'Test'")
    public String saveContactInquiryDetails(@RequestBody List<ContactDTO> contactDTOS) {
        return "contact service was called";

    }
}