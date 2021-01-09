package com.amazon.springapi.controllers.home;

import com.amazon.springapi.repository.home.DiscoverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/public/home/discoverItems")
public class DiscoverController {

    @Autowired
    private DiscoverRepository discoverRepository;

    @GetMapping
    public ResponseEntity<?> getDiscoverItems(){
      return ResponseEntity.ok(discoverRepository.findAll());
    }


}
