package br.sicredi.datajpaguide.demo.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CustomerNotFoundException extends RuntimeException{

    public CustomerNotFoundException (String msg){
        super(msg);
    }
}
