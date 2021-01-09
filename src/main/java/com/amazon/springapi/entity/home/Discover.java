package com.amazon.springapi.entity.home;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@AllArgsConstructor
@Data
public class Discover {


    @Id
    private Integer id;

    private String url;

}
