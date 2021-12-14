package br.sicredi.alura.controller;


import br.sicredi.alura.service.Inicializa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inicializa")
public class InicializaServiceController {

    @Autowired
    Inicializa inicializa;

    @GetMapping("/inicializa")
    public String inicializa(){
        inicializa.populaBanco();
        return "<h1> DB populado com sucesso</h1>";
    }
}
