package com.cloudtech.ecommerce.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EcommerceController {

    @GetMapping("/hello")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String sayHello() {
        return "Hello";
    }

}
