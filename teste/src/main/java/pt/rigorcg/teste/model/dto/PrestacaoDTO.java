package pt.rigorcg.teste.model.dto;

import java.math.BigDecimal;

import pt.rigorcg.teste.model.PrestacaoMensal;

public class PrestacaoDTO {
    
    public BigDecimal prestacao;

    public PrestacaoDTO(final PrestacaoMensal prestacao) {
        this.prestacao = prestacao.prestacao();
    }

}
