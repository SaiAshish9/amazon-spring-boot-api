package com.amazon.springapi.repository.home;

import com.amazon.springapi.entity.home.Sellers;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SellersRepository extends MongoRepository<Sellers,Integer> {
}
