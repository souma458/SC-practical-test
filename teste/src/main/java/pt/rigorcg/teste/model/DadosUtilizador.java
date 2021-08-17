package pt.rigorcg.teste.model;

public class DadosUtilizador {

    private String nome;
    private String contacto;
    private Mensalidades mensalidades;
    private ValorViatura valor;
    private PrestacaoMensal prestacao;

    public DadosUtilizador(final String nome, final String contacto, final Mensalidades mensalidades,
            final ValorViatura valor, final PrestacaoMensal prestacao) {
        if(!nome.isEmpty()) {
            this.nome = nome;
        } else {
            throw new IllegalArgumentException("Nome não pode ser vazio");
        }
        if(!contacto.isEmpty()) {
            this.contacto = contacto;
        } else {
            throw new IllegalArgumentException("Contacto não pode ser vazio");
        }
        this.contacto = contacto;
        this.mensalidades = mensalidades;
        this.valor = valor;
        this.prestacao = prestacao;
    }

    public String nome() {
        return this.nome;
    }

    public String contacto() {
        return this.contacto;
    }

    public Mensalidades mensalidades() {
        return this.mensalidades;
    }

    public ValorViatura valor() {
        return this.valor;
    }

    public PrestacaoMensal prestacao() {
        return this.prestacao;
    }

}
