package br.sicredi.alura.model.dto;

import br.sicredi.alura.model.Resposta;

import java.time.LocalDateTime;

public class RespostasDto {

    private Long id;
    private String mensagem;
    private LocalDateTime localDateTime;
    private String nomeAutor;

    public RespostasDto(Resposta resposta) {
        this.id = resposta.getId();
        this.mensagem = resposta.getMensagem();
        this.localDateTime = resposta.getDataCriacao();
        this.nomeAutor = null;
    }
}
