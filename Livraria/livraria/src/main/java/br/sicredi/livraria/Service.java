package br.sicredi.livraria;

import br.sicredi.livraria.model.Autor;
import br.sicredi.livraria.model.Editora;
import br.sicredi.livraria.model.Livro;
import br.sicredi.livraria.repository.AutorRepository;
import br.sicredi.livraria.repository.EditoraRepository;
import br.sicredi.livraria.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class Service {


    @Autowired
    AutorRepository autorRepository;
    @Autowired
    LivroRepository livroRepository;
    @Autowired
    EditoraRepository editoraRepository;

    public void inicial(){

        Autor a1 = new Autor("Leo", "Zanardi");
        autorRepository.save(a1);
        Autor a2 = new Autor("Van", "Rodrigues");
        autorRepository.save(a2);

        List<Autor> lA1 = new ArrayList<>();
        lA1.add(a1);
        lA1.add(a2);

        Editora e1 = new Editora("EditoraDoLeo");
        editoraRepository.save(e1);

        Livro l1 = new Livro("LivroDoLeo", "1999", e1 , lA1 );
        livroRepository.save(l1);

    }
}
