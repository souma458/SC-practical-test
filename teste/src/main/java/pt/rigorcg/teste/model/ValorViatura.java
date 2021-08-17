package pt.rigorcg.teste.model;

public class ValorViatura {
    
    private double valor;

    public ValorViatura(final double valor) {
        if(valor <= 0) {
            throw new IllegalArgumentException("Valor da viatura inválido - deve ser superior a 0");
        }
        this.valor = valor;
    }

    public final double valor() {
        return this.valor;
    }

}
