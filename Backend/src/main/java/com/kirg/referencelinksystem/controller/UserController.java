package com.kirg.referencelinksystem.controller;

import com.kirg.referencelinksystem.entity.ApplicationUser;
import com.kirg.referencelinksystem.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/applicationUser")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ApplicationUser save(@Valid @RequestBody ApplicationUser applicationUser) {
        return userService.save(applicationUser);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        userService.deleteById(id);
    }


}
