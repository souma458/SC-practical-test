package pt.rigorcg.teste.model;

import pt.rigorcg.teste.exceptions.InvalidFatorException;

public class Fator {
    
    private double fatorInterno;
    private double fatorExterno;

    public Fator(final double fatorInterno, final double fatorExterno) {
        if(fatorInterno < 0 || fatorExterno < 0) {
            throw new InvalidFatorException("Configuração de fator inválida - fator interno e externo devem ser pelo menos 0");
        }
        this.fatorInterno = fatorInterno;
        this.fatorExterno = fatorExterno;
    }

    public final double fatorInterno() {
        return this.fatorInterno;
    }

    public final double fatorExterno() {
        return this.fatorExterno;
    }
}
