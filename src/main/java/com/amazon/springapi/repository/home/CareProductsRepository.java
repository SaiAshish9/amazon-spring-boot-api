package com.amazon.springapi.repository.home;

import com.amazon.springapi.entity.home.CareProducts;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CareProductsRepository extends MongoRepository<CareProducts,Integer> {
}
