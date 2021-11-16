package br.com.classes.Imoveis.Controllers;


import br.com.classes.Imoveis.CadastroImovel;
import br.com.classes.Imoveis.Imovel;
import org.springframework.web.bind.annotation.*;

@RestController
public class CadastrarImovelController {

    @PostMapping("/imovel/registrar")
    public String adicionarImovel(@RequestBody Imovel im) {
        return CadastroImovel.getInstance().addImovel(im);
    }

    @PostMapping("/imovel/deletar")
    public String deleteImovel(@RequestParam String id){
        System.out.println("Deletando usuario");
        return CadastroImovel.getInstance().deleteImovel(id);
    }

    @PutMapping("/imovel/alugar")
    public String alugarImovel(@RequestParam String id){
        System.out.println("alugando imóvel");
        return CadastroImovel.getInstance().alugarImovel(id);
    }

    @PutMapping("/imovel/liberar")
    public String liberarImovel(@RequestParam String id){
        System.out.println("Liberando imóvel");
        return CadastroImovel.getInstance().liberarImovel(id);
    }
}
