package br.com.classes.Usuario.Controllers;

import br.com.classes.Usuario.CadastroUsuario;
import br.com.classes.Usuario.Usuario;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.PartialResultException;


/**Responsável por login e logoff dos usuários*/

@RestController
public class LoginController {


    @PostMapping("/login")
    public String login(@RequestParam String user, @RequestParam String senha) {
        for (Usuario x: CadastroUsuario.getInstance().getUsuariosCadastrados()){
            if(x.getUser().equals(user) && x.getSenha().equals(senha) && !x.getLogin()){
                x.setLogin(true);
                return "Usuário portador do cpf |" + x.getCpf() + "| logado com sucesso.";
            }
        }
        System.out.println("Usuário não encontrado ou já logado.");
        return "Usuário não encontrado ou já logado.";
    }

    @PostMapping("/logoff")
    public String logoff(@RequestParam String user, @RequestParam String senha) {
        for (Usuario x : CadastroUsuario.getInstance().getUsuariosCadastrados()) {
            if (x.getUser().equals(user) && x.getSenha().equals(senha) && x.getLogin()) {
                x.setLogin(false);
                return "Usuário portador do cpf |" + x.getCpf() + "| vazou!!!";
            }
        }
        System.out.println("Usuário não encontrado para realizar logoff.");
        return "Usuário não encontrado ou já desconectado.";
    }
}