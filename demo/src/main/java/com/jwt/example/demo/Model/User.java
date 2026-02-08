package com.jwt.example.demo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class User{
    private String userId;
    private String name ;
    private String email;
}
