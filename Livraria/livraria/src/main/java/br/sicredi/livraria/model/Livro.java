package br.sicredi.livraria.model;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Livro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codigo;

    @Column(nullable=false)
    private String titulo;

    @Column(nullable=false)
    private String ano;

    @ManyToOne(targetEntity = Editora.class)
    private Editora editora;

    @ManyToMany(targetEntity = Autor.class)
    private List<Autor> autores;

    public Livro(String titulo, String ano, Editora editora, List<Autor> autores) {
        this.titulo = titulo;
        this.ano = ano;
        this.editora = editora;
        this.autores = autores;
    }
}
