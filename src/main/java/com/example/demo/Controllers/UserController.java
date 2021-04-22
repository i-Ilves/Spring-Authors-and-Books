package com.example.demo.Controllers;

import com.example.demo.Enteties.User;
import com.example.demo.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/auth/register")
    public User register(@RequestBody User user) {
        return userService.register(user);
    }

    @GetMapping("/auth/whoami")
    public User whoAmI() {
        return userService.whoAmI();
    }
}
