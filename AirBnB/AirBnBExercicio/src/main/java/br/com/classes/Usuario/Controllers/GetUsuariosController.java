package br.com.classes.Usuario.Controllers;


import br.com.classes.Usuario.service.CadastroUsuario;
import br.com.classes.Usuario.model.Usuario;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**Responsável por retornar uma lista com os usuários cadastrados*/

@RestController
public class GetUsuariosController {

    @GetMapping("/get/usuarios")
    public ArrayList<Usuario> getUsuarios() {
        return CadastroUsuario.getInstance().getUsuariosCadastrados();
    }



}
