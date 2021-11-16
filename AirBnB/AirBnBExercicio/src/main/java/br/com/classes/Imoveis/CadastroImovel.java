package br.com.classes.Imoveis;

import br.com.classes.Usuario.CadastroUsuario;
import br.com.classes.Usuario.Usuario;

import java.util.ArrayList;

public class CadastroImovel {

    private ArrayList<Imovel> imoveisCadastrados;

    private static CadastroImovel ltRegistration = null;

    private CadastroImovel() {
        imoveisCadastrados = new ArrayList<Imovel>();
    }

    public static CadastroImovel getInstance() {
        if (ltRegistration == null) {
            ltRegistration = new CadastroImovel();
            return ltRegistration;
        } else {
            return ltRegistration;
        }
    }

    public String addImovel(Imovel im) {
        boolean locador = false;
        for (Usuario x : CadastroUsuario.getInstance().getUsuariosCadastrados()) {
            if (x.getUser().equals(im.getUserDono())) {
                if (x.getTipo().equals("locador") && x.getLogin() == true) {
                    locador = true;
                    System.out.println("Usuário |" + x.getUser() + "| foi confirmado como locador");
                    break;
                } else {
                    return "Você não pode cadastrar um imóvel pois não possui cadastro para isso.";
                }
            }
        }

        if (locador == true) {
            if (imoveisCadastrados.isEmpty()) {
                imoveisCadastrados.add(im);
                return "Imóvel cadastrado com sucesso";
            } else {
                boolean imovel = false;
                for (Imovel x : CadastroImovel.getInstance().getImoveisCadastrados()) {
                    if (x.getId().equals(im.getId())) {
                        return "Imóvel já cadastrado";
                    } else{
                        imovel = true;
                        break;
                    }
                }
                if (imovel == true) {
                    imoveisCadastrados.add(im);
                    return "Imóvel |" + im.getNome() + "| cadastrado com sucesso.";
                }
            }
        }
        return "erro";
    }

    public String deleteImovel(String id){
        for (Imovel x: imoveisCadastrados){
            if (x.getId().equals(id)){
                imoveisCadastrados.remove(x);
                return "Imóvel removido com sucesso";
            }else
                return "Imóvel não encontrado";
        }
        return "erro";
    }

    public String alugarImovel(String id) {
        for (Imovel x : imoveisCadastrados) {
            if (x.getId().equals(id)) {
                x.setDispopnivel(false);
                return "Imóvel alugado";
            }
        }
        return "Imóvel não encontrado, verifique o id inserido.";
    }

    public String liberarImovel(String id) {
        for (Imovel x : imoveisCadastrados) {
            if (x.getId().equals(id)) {
                x.setDispopnivel(true);
                return "Imóvel liberado";
            }
        }
        return "Imóvel não encontrado, verifique o id inserido.";
    }

    public ArrayList<Imovel> getImoveisCadastrados(){
        return imoveisCadastrados;
    }

    public ArrayList<Imovel> getDisponiveis(){
        ArrayList<Imovel> disponiveis = new ArrayList<>();
        for (Imovel x: imoveisCadastrados){
            if(x.getDisponibilidade()){
                disponiveis.add(x);
            }
        }
        return disponiveis;
    }

    public ArrayList<Imovel> getDisponiveisTipo(String tipo){
        ArrayList<Imovel> disponiveis = new ArrayList<>();
        for (Imovel x: imoveisCadastrados){
            if(x.getDisponibilidade() && x.getTipo().equals(tipo)){
                disponiveis.add(x);
            }
        }
        return disponiveis;
    }

    public ArrayList<Imovel> getReservados() {
        ArrayList<Imovel> disponiveis = new ArrayList<>();
        for (Imovel x: imoveisCadastrados){
            if(x.getDisponibilidade() == false){
                disponiveis.add(x);
            }
        }
        return disponiveis;
    }
}
