package pt.rigorcg.teste.model.dto;

import pt.rigorcg.teste.model.DadosUtilizador;

public class SavePrestacaoDataDTO {

    public String tipoFinanciamento;
    public int mensalidades;
    public double valorViatura;
    public double prestacaoMensal;
    public String nome;
    public String contacto;

    public SavePrestacaoDataDTO() {

    }

    public SavePrestacaoDataDTO(DadosUtilizador dU) {
        this.tipoFinanciamento = dU.mensalidades().tipoFinanciamento().getDescription();
        this.mensalidades = dU.mensalidades().nrMensalidades();
        this.valorViatura = dU.valor().valor();
        this.prestacaoMensal = dU.prestacao().prestacao().doubleValue();
        this.nome = dU.nome();
        this.contacto = dU.contacto();
    }

    public SavePrestacaoDataDTO(String tipoFinanciamento, int mensalidades, double valorViatura, double prestacaoMensal,
            String nome, String contacto) {
        this.tipoFinanciamento = tipoFinanciamento;
        this.mensalidades = mensalidades;
        this.valorViatura = valorViatura;
        this.prestacaoMensal = prestacaoMensal;
        this.nome = nome;
        this.contacto = contacto;
    }

    public boolean equals(Object anotherObject) {
        if (this == anotherObject) {
            return true;
        }
        if (anotherObject instanceof SavePrestacaoDataDTO) {
            SavePrestacaoDataDTO other = (SavePrestacaoDataDTO) anotherObject;
            return this.tipoFinanciamento.equals(other.tipoFinanciamento) && this.mensalidades == other.mensalidades
                    && this.prestacaoMensal == other.prestacaoMensal && this.valorViatura == other.valorViatura
                    && this.nome.equals(other.nome) && this.contacto.equals(other.contacto);
        }
        return false;
    }

}
