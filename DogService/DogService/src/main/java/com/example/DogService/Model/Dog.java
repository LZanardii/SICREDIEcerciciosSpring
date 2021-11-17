package com.example.DogService.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Dog {

    private int id;
    private String nome;
    private int age;


}
