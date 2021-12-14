package br.sicredi.alura.service;


import br.sicredi.alura.model.Topico;
import br.sicredi.alura.model.dto.TopicoDto;
import br.sicredi.alura.repository.CursoRepository;
import br.sicredi.alura.repository.TopicoRepository;
import lombok.Getter;
import org.aspectj.weaver.tools.StandardPointcutExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Getter
@Component
public class TopicoService {

    @Autowired
    TopicoRepository topicoRepository;

    @Autowired
    CursoRepository cursoRepository;


    public static List<TopicoDto> converterListaParaDto(List<Topico> topicos){
        return topicos.stream().map(TopicoDto::new).collect(Collectors.toList());
    }

    public static TopicoDto converterParaDto(Topico topico){
        return new TopicoDto(topico);
    }

    public Topico atualizaTopico(Long id, String titulo, String mensagem){

        Topico topico = topicoRepository.getById(id);
        topico.setTitulo(titulo);
        topico.setMensagem(mensagem);
        topicoRepository.save(topico);

        return topico;
    }


}
