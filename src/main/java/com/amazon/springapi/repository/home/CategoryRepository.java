package com.amazon.springapi.repository.home;

import com.amazon.springapi.entity.home.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepository extends MongoRepository<Category,Integer> {

}
