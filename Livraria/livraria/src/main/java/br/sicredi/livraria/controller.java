package br.sicredi.livraria;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class controller {

    @Autowired
    Service service;


    @GetMapping("/teste")
    public void teste(){
        service.inicial();
    }

}
