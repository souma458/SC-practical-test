package pt.rigorcg.teste.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TipoFinanciamentoTest {
    
    @Test
    public void Should_ThrowIllegalArgumentException_DescriptionIsInvalid() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            TipoFinanciamento.fromString("NonExistent1234");
        });
    }

}
