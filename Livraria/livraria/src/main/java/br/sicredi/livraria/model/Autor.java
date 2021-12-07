package br.sicredi.livraria.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Autor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codigo;

    @Column(nullable=false)
    private String primerioNome;

    @Column(nullable=false)
    private String ultimoNome;

    public Autor(String primerioNome, String ultimoNome) {
        this.primerioNome = primerioNome;
        this.ultimoNome = ultimoNome;
    }


}
