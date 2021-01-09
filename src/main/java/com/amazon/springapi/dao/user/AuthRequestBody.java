package com.amazon.springapi.dao.user;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthRequestBody implements Serializable {

    private String username;

    private String password;

    private String email;

}
