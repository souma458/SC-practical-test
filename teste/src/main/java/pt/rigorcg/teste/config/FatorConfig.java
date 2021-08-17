package pt.rigorcg.teste.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("fator")
public class FatorConfig implements IFatorConfig {
    
    private double fatorInterno;
    private double fatorExterno;

    public double fatorInterno() {
        return this.fatorInterno;
    }

    public void setFatorInterno(double fatorInterno) {
        this.fatorInterno = fatorInterno;
    }

    public double fatorExterno() {
        return this.fatorExterno;
    }

    public void setFatorExterno(double fatorExterno) {
        this.fatorExterno = fatorExterno;
    }
    
}
