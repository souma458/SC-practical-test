package pt.rigorcg.teste.model.dto;

public class CalculoPrestacaoDTO {

    public String tipoFinanciamento;
    public int mensalidades;
    public double valorViatura;

    public CalculoPrestacaoDTO(String tipoFinanciamento, int mensalidades, double valorViatura) {
        this.tipoFinanciamento = tipoFinanciamento;
        this.mensalidades = mensalidades;
        this.valorViatura = valorViatura;
    }

}
