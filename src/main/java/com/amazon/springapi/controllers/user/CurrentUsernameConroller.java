package com.amazon.springapi.controllers.user;

import com.amazon.springapi.repository.user.UserRepository;
import com.amazon.springapi.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class CurrentUsernameConroller {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/api/get-username")
    public ResponseEntity<?> getUsername(@RequestParam("token") String token){
        Map username=new HashMap();
        username.put("username",userRepository.findByEmail(jwtUtil.extractUsername(token)).getUsername());
        return ResponseEntity.ok(username);

    }

}
