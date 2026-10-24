package com.wyh.pojo;

import lombok.*;

import javax.management.ConstructorParameters;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private Integer age;
}
