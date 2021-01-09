package com.amazon.springapi.controllers.home;

import com.amazon.springapi.repository.home.CareProductsRepository;
import com.amazon.springapi.repository.home.ProductsRepository;
import com.amazon.springapi.repository.home.SellersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import static java.lang.Long.decode;

@RestController
@RequestMapping("/api/public/home/")
public class HomeController {

    @Autowired
    private SellersRepository sellersRepository;

    @Autowired
    private CareProductsRepository careProductsRepository;

    @Autowired
    private ProductsRepository productsRepository;

    @GetMapping("sellers")
    public ResponseEntity<?> fetchSellers() {
        return ResponseEntity.ok(sellersRepository.findAll());
    }

    @GetMapping("careProducts")
    public ResponseEntity<?> fetchCPS() {
        return ResponseEntity.ok(careProductsRepository.findAll());
    }

    @GetMapping("products")
    public ResponseEntity<?> getProducts(@RequestParam(name="title",required = false) String name) throws UnsupportedEncodingException {
        if (name != null) {
            System.out.println(URLDecoder.decode(name,"UTF-8"));
            System.out.println(name);
            return ResponseEntity.ok(productsRepository.findByName(URLDecoder.decode(name,"UTF-8")));
        }
        return ResponseEntity.ok(productsRepository.findAll());

    }

    @DeleteMapping("products")
    public ResponseEntity<?> deleteProduct(@RequestParam(name="title") String name) {
        productsRepository.deleteByName(name);
        return ResponseEntity.ok(productsRepository.findAll());
    }

}
