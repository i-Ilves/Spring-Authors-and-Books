package com.example.demo.Services;

import com.example.demo.Configs.MyUserDetailsService;
import com.example.demo.Enteties.User;
import com.example.demo.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    MyUserDetailsService myUserDetailsService;

    @Autowired
    UserRepository userRepository;

    public User register(User user) {
        return myUserDetailsService.addUser(user);
    }

    public User whoAmI() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findByUsername(username);
    }
}
