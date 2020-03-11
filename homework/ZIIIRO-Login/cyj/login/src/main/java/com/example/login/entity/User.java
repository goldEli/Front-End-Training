package com.example.login.entity;

import lombok.*;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Integer id;

    @NonNull
    private String name;

    @NonNull
    private String password;



}
