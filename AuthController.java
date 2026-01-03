package io.jwtusetologin.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import io.jwtusetologin.login.model.User;
import io.jwtusetologin.login.security.JwtUtil;
import io.jwtusetologin.login.service.UserService;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    // ---------- REGISTER (HTML) ----------
    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    @PostMapping("/register")
    public String register(User user) {
        userService.registerUser(user);
        return "redirect:/login";
    }

    // ---------- REGISTER (API) ----------
    @PostMapping("/api/register")
    @ResponseBody
    public String registerApi(@RequestBody User user) {
        userService.registerUser(user);
        return "User Registered Successfully";
    }

    // ---------- LOGIN PAGE ----------
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    // ---------- LOGIN (HTML FORM) ----------
    @PostMapping("/login")
    public String loginHtml(@RequestParam String username,
                            @RequestParam String password,
                            org.springframework.ui.Model model) {

        User user = userService.findByUsername(username);

        if (user != null && userService.checkPassword(password, user.getPassword())) {
            String token = jwtUtil.generateToken(username);
            model.addAttribute("token", token);
            model.addAttribute("username", username);
            return "success";
        }

        model.addAttribute("error", "Invalid Credentials");
        return "login";
    }

    // ---------- LOGIN (API / POSTMAN) ----------
    @PostMapping("/api/login")
    @ResponseBody
    public String loginApi(@RequestBody User user) {

        User dbUser = userService.findByUsername(user.getUsername());

        if (dbUser == null) {
            return "User not found";
        }

        if (userService.checkPassword(user.getPassword(), dbUser.getPassword())) {
            return jwtUtil.generateToken(user.getUsername());
        }

        return "Invalid Credentials";
    }
}
