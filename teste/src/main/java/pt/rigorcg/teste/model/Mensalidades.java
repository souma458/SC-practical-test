package pt.rigorcg.teste.model;

public class Mensalidades {

    private static final int INTERVALO = 12;
    private static final int MIN_FIN = 12;
    private static final int MAX_FIN_INTERNO = 48;
    private static final int MAX_FIN_EXTERNO = 60;

    private int nrMensalidades;
    private TipoFinanciamento tipoFinanciamento;

    public Mensalidades(final int nrMensalidades, final TipoFinanciamento tipoFinanciamento) {
        
        if (tipoFinanciamento == TipoFinanciamento.INTERNO) {
            if (nrMensalidades % INTERVALO != 0 || nrMensalidades > MAX_FIN_INTERNO || nrMensalidades < MIN_FIN) {
                throw new IllegalArgumentException("Nº de mensalidades do tipo de financiamento " + TipoFinanciamento.INTERNO.toString() + " inválido");
            }
        } else if (tipoFinanciamento == TipoFinanciamento.EXTERNO) {
            if (nrMensalidades % INTERVALO != 0 || nrMensalidades > MAX_FIN_EXTERNO || nrMensalidades < MIN_FIN) {
                throw new IllegalArgumentException("Nº de mensalidades do tipo de financiamento " + TipoFinanciamento.EXTERNO.toString() + " inválido");
            }
        } else {
            throw new IllegalArgumentException("Tipo de financiamento inválido");
        }

        this.nrMensalidades = nrMensalidades;
        this.tipoFinanciamento = tipoFinanciamento;

    }

    public final int nrMensalidades() {
        return this.nrMensalidades;
    }

    public final TipoFinanciamento tipoFinanciamento() {
        return this.tipoFinanciamento;
    }

}
