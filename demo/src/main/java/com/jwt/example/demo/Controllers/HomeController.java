package com.jwt.example.demo.Controllers;


import com.jwt.example.demo.Model.User;
import com.jwt.example.demo.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public List<User> getUser(){
        System.out.println("Getting users data");
        return userService.getUsers();
    }

    @GetMapping("/current-user")
    public String getLoggedInUser(Principal principal){
        System.out.println("Getting current logged in User");
        return principal.getName();
    }
}
