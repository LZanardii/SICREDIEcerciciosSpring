package br.sicredi.devdojosecurity.demo.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class Student {

    private String name;
    private int age;
    private String cpf;

}
