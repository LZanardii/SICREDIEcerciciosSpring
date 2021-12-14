package br.sicredi.alura.model.dto;

import br.sicredi.alura.model.StatusTopico;
import br.sicredi.alura.model.Topico;
import lombok.Getter;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class TopicoDto {

    private Long id;
    private String titulo;
    private String mensagem;
    private LocalDateTime dataCriacao;
    private String nomeAutor;
    private String nomeCurso;
    private StatusTopico statusTopico;
    private List<RespostasDto> respostas;


    public TopicoDto (Topico topico){
        this.id = topico.getId();
        this.titulo = topico.getTitulo();
        this.mensagem = topico.getMensagem();
        this.dataCriacao = topico.getDataCriacao();
        this.nomeAutor = null;
        this.nomeCurso = null;
        this.statusTopico = topico.getStatus();
        this.respostas = new ArrayList<>();
        respostas.addAll(topico.getRespostas().stream().map(RespostasDto::new).collect(Collectors.toList()));
    }


}
