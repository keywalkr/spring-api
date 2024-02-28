package com.qburry.kubesspring.springapi.user.controller;

import com.qburry.kubesspring.springapi.user.dto.User;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        return ResponseEntity.ok("Successfully registered...");
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticate() {
        return ResponseEntity.ok("");
    }

    @GetMapping("/logout")
    public ResponseEntity<?> logout(){
        SecurityContextHolder.clearContext();
        return ResponseEntity.ok("Logout successful");
    }

    @GetMapping("/test")
    public ResponseEntity<?> test() {
        return ResponseEntity.ok("You have access now");
    }
}
