package br.sicredi.alura.config.validation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ErroDeValidacaoHandler {

    @Autowired
    private MessageSource messageSource;


    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ErroFormDto> bodyInvalidoExecao(MethodArgumentNotValidException exception){
        List<ErroFormDto> dto = new ArrayList<>();
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        fieldErrors.forEach(fieldError -> {
            String mensagem = messageSource.getMessage(fieldError, LocaleContextHolder.getLocale()) ;
            ErroFormDto erro = new ErroFormDto(fieldError.getField(), mensagem);
            dto.add(erro);
        });
        return dto;
    }

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NumberFormatException.class)
    public String inputInvalidoId(NumberFormatException exception){
        return "Erro no input de ID";
    }


}
