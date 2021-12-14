package br.sicredi.alura.service;

import br.sicredi.alura.model.Curso;
import br.sicredi.alura.model.StatusTopico;
import br.sicredi.alura.model.Topico;
import br.sicredi.alura.model.Usuario;
import br.sicredi.alura.repository.CursoRepository;
import br.sicredi.alura.repository.TopicoRepository;
import br.sicredi.alura.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class Inicializa {

    @Autowired
    TopicoRepository topicoRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    CursoRepository cursoRepository;

    public void populaBanco() {

        Curso c1 = new Curso("Spring Boot", "Programação");
        Curso c2 = new Curso("HTML 5", "Front-end");

        cursoRepository.save(c1);
        cursoRepository.save(c2);

        Usuario user1 = new Usuario("Aluno", "aluno@gmail.com", "123456");
        Usuario user2 = new Usuario("Aluno2", "aluno2@gmail.com", "123456");

        usuarioRepository.save(user1);
        usuarioRepository.save(user2);


        topicoRepository.save(new Topico("Duvida", "Erro ao criar projeto",
                LocalDateTime.now(), StatusTopico.NAO_RESPONDIDO,
                user1, c1 ));

        topicoRepository.save(new Topico("Duvida", "Erro ao usar h2",
                LocalDateTime.now(), StatusTopico.NAO_RESPONDIDO,
                user2, c2 ));
    }

//    http://localhost:8080/topicos?nomeCurso=Spring+Boot
}
