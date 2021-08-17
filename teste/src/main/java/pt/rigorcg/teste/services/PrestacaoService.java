package pt.rigorcg.teste.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import pt.rigorcg.teste.config.IFatorConfig;
import pt.rigorcg.teste.exceptions.InvalidFatorException;
import pt.rigorcg.teste.model.DadosUtilizador;
import pt.rigorcg.teste.model.Fator;
import pt.rigorcg.teste.model.Mensalidades;
import pt.rigorcg.teste.model.PrestacaoMensal;
import pt.rigorcg.teste.model.TipoFinanciamento;
import pt.rigorcg.teste.model.ValorViatura;
import pt.rigorcg.teste.model.dto.CalculoPrestacaoDTO;
import pt.rigorcg.teste.model.dto.PrestacaoDTO;
import pt.rigorcg.teste.model.dto.SavePrestacaoDataDTO;
import pt.rigorcg.teste.repositories.IDadosUtilizadorRepository;
import pt.rigorcg.teste.util.ServiceError;
import pt.rigorcg.teste.util.ServiceResponse;

@Service
public class PrestacaoService implements IPrestacaoService {

    @Autowired
    IFatorConfig fatorConfig;

    @Autowired
    IDadosUtilizadorRepository repository;

    public ServiceResponse<PrestacaoDTO> calculoPrestacao(CalculoPrestacaoDTO data) {
        try {
            PrestacaoMensal p = new PrestacaoMensal(
                    new Mensalidades(data.mensalidades, TipoFinanciamento.fromString(data.tipoFinanciamento)),
                    new ValorViatura(data.valorViatura),
                    new Fator(fatorConfig.fatorInterno(), fatorConfig.fatorExterno()));
            return new ServiceResponse<PrestacaoDTO>(new PrestacaoDTO(p));
        } catch (IllegalArgumentException ex) {
            return new ServiceResponse<PrestacaoDTO>(new ServiceError(ex.getMessage(), HttpStatus.BAD_REQUEST));
        } catch (InvalidFatorException ex) {
            return new ServiceResponse<PrestacaoDTO>(
                    new ServiceError(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR));
        }
    }

    @Override
    public ServiceResponse<SavePrestacaoDataDTO> savePrestacaoData(SavePrestacaoDataDTO data) {
        try {
            DadosUtilizador dU = new DadosUtilizador(data.nome, data.contacto,
                    new Mensalidades(data.mensalidades, TipoFinanciamento.fromString(data.tipoFinanciamento)),
                    new ValorViatura(data.valorViatura), new PrestacaoMensal(data.prestacaoMensal));
            dU = repository.save(dU);
            if (dU != null) {
                return new ServiceResponse<SavePrestacaoDataDTO>(new SavePrestacaoDataDTO(dU));
            } else {
                return new ServiceResponse<SavePrestacaoDataDTO>(
                        new ServiceError("Erro ao gravar dados", HttpStatus.INTERNAL_SERVER_ERROR));
            }
        } catch (IllegalArgumentException ex) {
            return new ServiceResponse<SavePrestacaoDataDTO>(new ServiceError(ex.getMessage(), HttpStatus.BAD_REQUEST));
        } catch (InvalidFatorException ex) {
            return new ServiceResponse<SavePrestacaoDataDTO>(
                    new ServiceError(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR));
        }
    }

}
