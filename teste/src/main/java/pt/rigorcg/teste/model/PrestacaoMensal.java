package pt.rigorcg.teste.model;

import java.math.BigDecimal;

public class PrestacaoMensal {

    private BigDecimal prestacao;

    public PrestacaoMensal(final double prestacao) {
        if(prestacao >= 0) {
            this.prestacao = BigDecimal.valueOf(prestacao).setScale(2, BigDecimal.ROUND_HALF_EVEN);
        } else {
            throw new IllegalArgumentException("Prestacao inválida");
        }
    }

    public PrestacaoMensal(final Mensalidades mensalidades, final ValorViatura valorViatura, final Fator fator) {
        if(mensalidades.tipoFinanciamento() == TipoFinanciamento.EXTERNO) {
            this.prestacao = BigDecimal.valueOf(valorViatura.valor() * fator.fatorExterno() / mensalidades.nrMensalidades()).setScale(2, BigDecimal.ROUND_HALF_EVEN);
        } else if (mensalidades.tipoFinanciamento() == TipoFinanciamento.INTERNO) {
            this.prestacao = BigDecimal.valueOf(valorViatura.valor() * fator.fatorInterno() / mensalidades.nrMensalidades()).setScale(2, BigDecimal.ROUND_HALF_EVEN);
        } else {
            throw new IllegalArgumentException("Tipo de financiamento inválido");
        }
    }

    public BigDecimal prestacao() {
        return this.prestacao;
    }

}
