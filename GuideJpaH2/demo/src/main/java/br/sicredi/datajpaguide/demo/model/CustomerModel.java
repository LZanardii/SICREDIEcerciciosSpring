package br.sicredi.datajpaguide.demo.model;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
@Getter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
public class CustomerModel {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    private String cpf;

}