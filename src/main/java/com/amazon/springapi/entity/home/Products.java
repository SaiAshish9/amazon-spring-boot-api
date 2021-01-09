package com.amazon.springapi.entity.home;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
@AllArgsConstructor
public class Products {


    @Id
    private String name;

    private List<String> images;

}
