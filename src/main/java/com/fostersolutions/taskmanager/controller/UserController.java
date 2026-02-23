package com.fostersolutions.taskmanager.controller;

import com.fostersolutions.taskmanager.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("/me")
    public ResponseEntity<Map<String,String>> me(
            @AuthenticationPrincipal UserDetails userDetails
            ){
        return ResponseEntity.ok(Map.of(
                "name", userRepository.findByUsername(userDetails.getUsername()).get().getName(),
                "username", userDetails.getUsername()
        ));
    }
}
