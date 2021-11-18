package com.example.DogService.Exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DogsException extends RuntimeException{

    public DogsException(String msg){
        super(msg);
    }


}
