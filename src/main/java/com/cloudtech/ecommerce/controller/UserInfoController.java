package com.cloudtech.ecommerce.controller;

import com.cloudtech.ecommerce.entity.UserInfo;
import com.cloudtech.ecommerce.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;
    @PostMapping("/users")
    public ResponseEntity<String> createUser(@Validated @RequestBody UserInfo userInfo) {
        String message = userInfoService.addUser(userInfo);
        return ResponseEntity.ok(message);
    }
}
