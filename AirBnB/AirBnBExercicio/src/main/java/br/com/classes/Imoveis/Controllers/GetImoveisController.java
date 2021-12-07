package br.com.classes.Imoveis.Controllers;


import br.com.classes.Imoveis.service.CadastroImovel;
import br.com.classes.Imoveis.model.Imovel;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class GetImoveisController {

    @GetMapping("/get/imoveis")
    @PreAuthorize("hasRole('USER')")
    public ArrayList<Imovel> getImoveis(){
        return CadastroImovel.getInstance().getImoveisCadastrados();

    }

    @GetMapping("/get/imoveis/disponiveis")
    public ArrayList<Imovel> getImoveisDisponiveis(){
        return CadastroImovel.getInstance().getDisponiveis();
    }

    @GetMapping("/get/imoveis/disponiveis/{tipo}")
    public ArrayList<Imovel> getImoveisDisponiveiss(@PathVariable String tipo){
        return CadastroImovel.getInstance().getDisponiveisTipo(tipo);
    }

    @GetMapping("/get/imoveis/alugados")
    public ArrayList<Imovel> getImoveisReservados(){
        return CadastroImovel.getInstance().getReservados();
    }


}
