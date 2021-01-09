package com.amazon.springapi.repository.user;

import com.amazon.springapi.entity.user.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,Long> {

    User findByEmail(String email);

}
