package pt.rigorcg.teste.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MensalidadesTest {
    
    @Test
    public void Should_ThrowIllegalArgumentException_TipoFinanciamentoDoesNotExist() {
        IllegalArgumentException ex = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Mensalidades m = new Mensalidades(12, null);
        });

        assertEquals(ex.getMessage(), "Tipo de financiamento inválido");
    }

    @Test
    public void Should_ThrowIllegalArgumentException_NrMensalidadesFinanciamentoInternoIsInvalid() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Mensalidades m = new Mensalidades(60, TipoFinanciamento.INTERNO);
        });
    }

    @Test
    public void Should_ThrowIllegalArgumentException_NrMensalidadesFinanciamentoExternoIsInvalid() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Mensalidades m = new Mensalidades(72, TipoFinanciamento.EXTERNO);
        });
    }

}
