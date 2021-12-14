package br.sicredi.alura.config.validation;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErroFormDto {

    private String campo;
    private String erro;

}
