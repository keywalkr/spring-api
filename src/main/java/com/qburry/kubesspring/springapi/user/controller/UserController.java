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
@RequestMapping(value = "/user", produces = APPLICATION_JSON_VALUE)
public class UserController {

    private final UserService userService;

    @GetMapping("/list")
    public List<User> getAll() {
        return userService.findAll();
    }

    @GetMapping("/info/{id}")
    public User getUserById(@PathVariable("id") Long id) {
        return userService.findById(id).orElseThrow(IllegalStateException::new);
    }

    @PostMapping("/add")
    public Long addOne(@RequestBody User user) {
        log.info("add one person called {}", user);
        return userService.save(user);
    }
}
