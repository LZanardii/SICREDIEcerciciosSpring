package br.com.classes.Usuario.model;

public class Usuario {

    private String user;
    private String senha;
    private String cpf;
    private String tipo;

    //verifica se o usuário está logado
    private boolean login = false;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean getLogin(){
        return login;
    }

    public void setLogin(boolean log){login = log;}

}
