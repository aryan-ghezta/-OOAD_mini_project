package com.example.moviebooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.moviebooking.model.User;
import com.example.moviebooking.service.UserService;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    // Home page (loads login page)
    @GetMapping("/")
    public String home() {
        return "login";
    }

    // Also allow direct /login access (GET)
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    // Register user (POST)
    @PostMapping("/register")
    public String register(@RequestParam String username,
                           @RequestParam String password) {

        User user = new User(username, password);
        userService.register(user);

        return "login";
    }

    // Login user (POST)
    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        Model model) {

        User user = userService.login(username, password);

        if (user != null) {
            return "redirect:/movies";
        } else {
            model.addAttribute("error", "Invalid credentials");
            return "login";
        }
    }
}