package com.qburry.kapi.web.auth;

import com.qburry.kapi.model.RegistrationRequest;
import com.qburry.kapi.service.AuthenticationService;
import com.qburry.kapi.model.AuthRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    //private final UserService userService;
    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegistrationRequest request) {
        log.info("Registration resource called...");
        Long id = authenticationService.signup(request);
        return ResponseEntity.ok("Successfully registered..." + id);
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticate(@RequestBody AuthRequest authRequest) {
        log.info("Authentication resource called...");
        return ResponseEntity.ok(authenticationService.authenticate(authRequest));
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
