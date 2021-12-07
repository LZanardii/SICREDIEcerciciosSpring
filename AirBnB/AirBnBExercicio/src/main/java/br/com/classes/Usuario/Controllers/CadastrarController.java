package br.com.classes.Usuario.Controllers;

import br.com.classes.Usuario.service.CadastroUsuario;
import br.com.classes.Usuario.model.Usuario;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**Responsável por cadastrar e deletar usuários*/


@RestController
public class CadastrarController {

    //registrando os dois usuários no mesmo post
    @PostMapping("/usuario/registrar")
    public String cadastrarUsuario(@RequestBody Usuario user){
        System.out.println("Registrando...");
        return CadastroUsuario.getInstance().addUsuario(user);

    }

    @PostMapping("/usuario/deletar")
    public  String deletarUsuario(@RequestParam String cpf){
        System.out.println("Deletando usuário");
        return CadastroUsuario.getInstance().deleteUsuario(cpf);
    }

}
