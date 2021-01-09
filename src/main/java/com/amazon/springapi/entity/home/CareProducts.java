package com.amazon.springapi.entity.home;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@AllArgsConstructor
public class CareProducts {

    @Id
    private Integer id;

    private String url;

}
