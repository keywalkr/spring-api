package com.qburry.kubesspring.springapi.user.controller;

import com.qburry.kubesspring.springapi.user.dto.User;
import com.qburry.kubesspring.springapi.user.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping(value = "/users", produces = APPLICATION_JSON_VALUE)
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<User> getAll() {
        return userService.findAll();
    }

    @PostMapping("/add")
    public Long addOne(@RequestBody User user) {
        log.info("add one person called {}", user);
        return userService.save(user);
    }
}
