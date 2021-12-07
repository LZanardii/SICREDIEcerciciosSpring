package br.sicredi.datajpaguide.demo.exception;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class CustomerErrorAdviceException {

    @ExceptionHandler({CustomerBadRequestException.class})
    public ResponseEntity<String> customerBadResquestException(CustomerBadRequestException customerAlreadyExistsException){
        return error(HttpStatus.BAD_REQUEST, customerAlreadyExistsException);
    }

    @ExceptionHandler({CustomerNotFoundException.class})
    public ResponseEntity<String> customerNotFoundException(CustomerNotFoundException customerNotFoundException){
        return error(HttpStatus.NOT_FOUND, customerNotFoundException);
    }

    private ResponseEntity<String> error(HttpStatus status, Exception e){
        log.error("Exception:", e);
        return new ResponseEntity<>(e.getMessage(), status);
    }


}
