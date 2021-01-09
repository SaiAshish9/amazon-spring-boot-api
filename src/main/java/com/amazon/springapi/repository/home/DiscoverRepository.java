package com.amazon.springapi.repository.home;

import com.amazon.springapi.entity.home.Discover;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DiscoverRepository extends MongoRepository<Discover, Integer> {

}
