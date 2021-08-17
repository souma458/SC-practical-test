package pt.rigorcg.teste.model;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;

import pt.rigorcg.teste.exceptions.InvalidFatorException;

public class FatorTest {
    
    @Test
    public void Should_ThrowInvalidFatorException_IfFatorInternoLessThan0() {
        Assertions.assertThrows(InvalidFatorException.class, () -> {
            new Fator(-1, 1);
        });
    }

    @Test
    public void Should_ThrowInvalidFatorException_IfFatorExternoLessThan0() {
        Assertions.assertThrows(InvalidFatorException.class, () -> {
             new Fator(1, -1);
        });
    }

}
