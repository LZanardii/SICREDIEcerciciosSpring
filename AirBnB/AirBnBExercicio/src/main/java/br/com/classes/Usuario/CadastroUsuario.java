package br.com.classes.Usuario;

import br.com.classes.Imoveis.Imovel;

import java.util.ArrayList;

public class CadastroUsuario {

    //array que irá conter todos os usuários locatátios
    private ArrayList<Usuario> usuariosCadastrados;

    private static CadastroUsuario ltRegistration = null;

    private CadastroUsuario() {
        usuariosCadastrados = new ArrayList<Usuario>();
    }

    public static CadastroUsuario getInstance() {
        if (ltRegistration == null) {
            ltRegistration = new CadastroUsuario();
            return ltRegistration;
        } else {
            return ltRegistration;
        }
    }

    public String addUsuario(Usuario lt) {
        boolean cadastrado = false;
        for (Usuario locatario : usuariosCadastrados) {
            if (locatario.getCpf().equals(lt.getCpf()) || locatario.getUser().equals(lt.getUser())) {
                cadastrado = true;
                System.out.println("Usuário já cadastrado anteriormente");
                return "Usuário já cadastrado anteriormente";
            }
        }
        if (cadastrado == false) {
            usuariosCadastrados.add(lt);
        }
        System.out.println("Usuário |" + lt.getUser() + "| do tipo |" + lt.getTipo() + "| cadastrado com sucesso.");
        return "Usuário |" + lt.getUser() + "| do tipo |" + lt.getTipo() + "| cadastrado com sucesso.";
    }

    public String deleteUsuario(String cpf) {

        for (Usuario x: usuariosCadastrados){
            if (x.getCpf().equals(cpf)){
                usuariosCadastrados.remove(x);
                return "Usuário removido com sucesso";
            }else
                return "Usuário não encontrado";
        }
        return "erro";

    }

    public ArrayList<Usuario> getUsuariosCadastrados(){
        return usuariosCadastrados;
    }


}
