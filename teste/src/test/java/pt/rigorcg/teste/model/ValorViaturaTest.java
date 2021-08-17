package pt.rigorcg.teste.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValorViaturaTest {
 
    @Test
    public void Should_ThrowIllegalArgumentException_IfValorLessThan0() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new ValorViatura(-1);
        });
    }

}
