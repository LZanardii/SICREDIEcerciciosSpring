package br.com.classes.Imoveis.model;

public class Imovel {

    public String id;
    private String userDono;
    private String nome;
    private String tipo;
    private String cidade;
    private double vlrDiaria;
    private boolean dispopnivel = true;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserDono() {
        return userDono;
    }

    public void setUserDono(String dono) {
        this.userDono = dono;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public double getVlrDiaria() {
        return vlrDiaria;
    }

    public void setVlrDiaria(double vlrDiaria) {
        this.vlrDiaria = vlrDiaria;
    }

    public boolean getDisponibilidade() {
        return dispopnivel;
    }

    public void setDispopnivel(boolean dispopnivel) {
        this.dispopnivel = dispopnivel;
    }
}
