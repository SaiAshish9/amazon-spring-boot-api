package com.amazon.springapi.entity.home;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@AllArgsConstructor
@Data
public class Category {

    @Id
    private Integer id;

    private String title;

    private String imageUrl;

    private Boolean descAvailable;

}
