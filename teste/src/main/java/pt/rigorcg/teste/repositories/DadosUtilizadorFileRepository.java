package pt.rigorcg.teste.repositories;

import java.io.FileWriter;
import java.io.IOException;

import org.springframework.stereotype.Repository;

import pt.rigorcg.teste.model.DadosUtilizador;

@Repository
public class DadosUtilizadorFileRepository implements IDadosUtilizadorRepository {

    @Override
    public DadosUtilizador save(DadosUtilizador dU) {
        try {
            FileWriter writer = new FileWriter("dados_utilizador.txt", true);
            String toSave = dU.nome() + ";" + dU.contacto() + ";" + dU.valor().valor() + ";"
                    + dU.mensalidades().tipoFinanciamento().getDescription() + ";" + dU.mensalidades().nrMensalidades()
                    + ";" + dU.prestacao().prestacao();

            writer.write(System.getProperty("line.separator"));
            writer.write(toSave);
            writer.close();
            return dU;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
