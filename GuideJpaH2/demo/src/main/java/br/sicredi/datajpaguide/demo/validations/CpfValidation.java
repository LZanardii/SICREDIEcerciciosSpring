package br.sicredi.datajpaguide.demo.validations;

public class CpfValidation {

    public static boolean cpdValidation(String cpf){

        int soma = 0;

        for (int i = 0; i < cpf.length(); i++) {
            soma += Integer.parseInt(String.valueOf(cpf.charAt(i)));
        }

        if ((soma == 33 || soma == 44 || soma == 55 || soma == 66 || soma == 77 || soma == 88 || soma == 99) && cpf.length() == 11)
            return true;
        else
            return false;
    }
}
