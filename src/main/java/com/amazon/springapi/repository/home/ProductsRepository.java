package com.amazon.springapi.repository.home;

import com.amazon.springapi.entity.home.Products;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductsRepository extends MongoRepository<Products,String> {

    List<Products> findByName(String name);

    void deleteByName(String name);

}
