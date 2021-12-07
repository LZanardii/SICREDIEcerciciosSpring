package br.sicredi.livraria.model;


import lombok.*;
import javax.persistence.*;
import java.io.Serializable;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Editoras")
public class Editora implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codigo;

    @Column(nullable=false)
    private String nome;

    public Editora(String nome) {
        this.nome = nome;
    }

    //    @OneToMany(targetEntity = Livro.class)
//    @JoinTable(name = "editora_livros")
//    private Optional<Collection<Livro>> livros;







}
