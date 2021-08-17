package pt.rigorcg.teste.model;

public enum TipoFinanciamento {
    
    INTERNO("INTERNO"),
    EXTERNO("EXTERNO");

    private String description;

    TipoFinanciamento(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public static TipoFinanciamento fromString(String description) {
        for (TipoFinanciamento tf : TipoFinanciamento.values()) {
            if (tf.description.equalsIgnoreCase(description)) {
                return tf;
            }
        }
        throw new IllegalArgumentException("Não foi encontrado nenhum tipo de financiamento '" + description + "'");
    }
}
