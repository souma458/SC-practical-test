package pt.rigorcg.teste.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import pt.rigorcg.teste.config.IFatorConfig;
import pt.rigorcg.teste.model.DadosUtilizador;
import pt.rigorcg.teste.model.Mensalidades;
import pt.rigorcg.teste.model.PrestacaoMensal;
import pt.rigorcg.teste.model.TipoFinanciamento;
import pt.rigorcg.teste.model.ValorViatura;
import pt.rigorcg.teste.model.dto.CalculoPrestacaoDTO;
import pt.rigorcg.teste.model.dto.PrestacaoDTO;
import pt.rigorcg.teste.model.dto.SavePrestacaoDataDTO;
import pt.rigorcg.teste.repositories.IDadosUtilizadorRepository;
import pt.rigorcg.teste.util.ServiceResponse;

@SpringBootTest
public class PrestacaoServiceTest {

    @Mock
    IFatorConfig fatorConfig;

    @Mock
    IDadosUtilizadorRepository repository;

    @InjectMocks
    PrestacaoService service;

    private static final double DEFAULT_FATOR_INTERNO = 0.4;
    private static final double DEFAULT_FATOR_EXTERNO = 0.65;

    @Test
    public void Should_ReturnServiceErrorWithBadRequest_IfInvalidTipoFinanciamento() {

        String invalidTipoFinanciamento = "NonExistent1234";
        int nrMensalidades = 12;
        double valor = 10000;

        CalculoPrestacaoDTO data = new CalculoPrestacaoDTO(invalidTipoFinanciamento, nrMensalidades, valor);

        Mockito.when(fatorConfig.fatorExterno()).thenReturn(DEFAULT_FATOR_EXTERNO);

        ServiceResponse<PrestacaoDTO> result = service.calculoPrestacao(data);

        HttpStatus expected = HttpStatus.BAD_REQUEST;
        HttpStatus actual = result.error().getStatus();
        assertEquals(expected, actual);

    }

    @Test
    public void Should_ReturnServiceErrorWithBadRequest_IfInvalidMensalidades() {

        String tipoFinanciamento = TipoFinanciamento.EXTERNO.getDescription();
        int invalidNrMensalidades = 0;
        double valor = 10000;

        CalculoPrestacaoDTO data = new CalculoPrestacaoDTO(tipoFinanciamento, invalidNrMensalidades, valor);

        Mockito.when(fatorConfig.fatorExterno()).thenReturn(DEFAULT_FATOR_EXTERNO);

        ServiceResponse<PrestacaoDTO> result = service.calculoPrestacao(data);

        HttpStatus expected = HttpStatus.BAD_REQUEST;
        HttpStatus actual = result.error().getStatus();
        assertEquals(expected, actual);

    }

    @Test
    public void Should_ReturnServiceErrorWithBadRequest_IfInvalidValorViatura() {

        String tipoFinanciamento = TipoFinanciamento.EXTERNO.getDescription();
        int nrMensalidades = 12;
        double invalidValor = -1;

        CalculoPrestacaoDTO data = new CalculoPrestacaoDTO(tipoFinanciamento, nrMensalidades, invalidValor);

        Mockito.when(fatorConfig.fatorExterno()).thenReturn(DEFAULT_FATOR_EXTERNO);

        ServiceResponse<PrestacaoDTO> result = service.calculoPrestacao(data);

        HttpStatus expected = HttpStatus.BAD_REQUEST;
        HttpStatus actual = result.error().getStatus();
        assertEquals(expected, actual);

    }

    @Test
    public void Should_ReturnServiceErrorWithServerError_IfInvalidFator() {

        String tipoFinanciamento = TipoFinanciamento.EXTERNO.getDescription();
        int nrMensalidades = 12;
        double valor = 10000;

        CalculoPrestacaoDTO data = new CalculoPrestacaoDTO(tipoFinanciamento, nrMensalidades, valor);

        Mockito.when(fatorConfig.fatorExterno()).thenReturn(-0.1);

        ServiceResponse<PrestacaoDTO> result = service.calculoPrestacao(data);

        HttpStatus expected = HttpStatus.INTERNAL_SERVER_ERROR;
        HttpStatus actual = result.error().getStatus();
        assertEquals(expected, actual);

    }

    @Test
    public void Should_ReturnExpectedValue_IfValidDataWithInterno() {

        String tipoFinanciamento = TipoFinanciamento.INTERNO.getDescription();
        int nrMensalidades = 12;
        double valor = 10000;

        CalculoPrestacaoDTO data = new CalculoPrestacaoDTO(tipoFinanciamento, nrMensalidades, valor);

        Mockito.when(fatorConfig.fatorInterno()).thenReturn(DEFAULT_FATOR_INTERNO);

        ServiceResponse<PrestacaoDTO> result = service.calculoPrestacao(data);

        BigDecimal expected = BigDecimal.valueOf(valor * fatorConfig.fatorInterno() / nrMensalidades).setScale(2,
                BigDecimal.ROUND_HALF_EVEN);
        BigDecimal actual = result.data().prestacao;
        assertEquals(expected, actual);

    }

    @Test
    public void Should_ReturnExpectedValue_IfValidDataWithExterno() {

        String tipoFinanciamento = TipoFinanciamento.EXTERNO.getDescription();
        int nrMensalidades = 12;
        double valor = 10000;

        CalculoPrestacaoDTO data = new CalculoPrestacaoDTO(tipoFinanciamento, nrMensalidades, valor);

        Mockito.when(fatorConfig.fatorExterno()).thenReturn(DEFAULT_FATOR_EXTERNO);

        ServiceResponse<PrestacaoDTO> result = service.calculoPrestacao(data);

        BigDecimal expected = BigDecimal.valueOf(valor * fatorConfig.fatorExterno() / nrMensalidades).setScale(2,
                BigDecimal.ROUND_HALF_EVEN);
        BigDecimal actual = result.data().prestacao;
        assertEquals(expected, actual);

    }

    @Test
    public void Should_ReturnServiceErrorWithBadRequest_IfInvalidNome() {

        String tipoFinanciamento = TipoFinanciamento.EXTERNO.getDescription();
        int nrMensalidades = 12;
        double valor = 10000;
        double prestacao = 100;
        String invalidNome = "";
        String contacto = "111111111";

        SavePrestacaoDataDTO data = new SavePrestacaoDataDTO(tipoFinanciamento, nrMensalidades, valor, prestacao,
                invalidNome, contacto);

        Mockito.when(fatorConfig.fatorExterno()).thenReturn(DEFAULT_FATOR_EXTERNO);

        ServiceResponse<SavePrestacaoDataDTO> result = service.savePrestacaoData(data);

        HttpStatus expected = HttpStatus.BAD_REQUEST;
        HttpStatus actual = result.error().getStatus();
        assertEquals(expected, actual);

    }

    @Test
    public void Should_ReturnServiceErrorWithBadRequest_IfInvalidContacto() {

        String tipoFinanciamento = TipoFinanciamento.EXTERNO.getDescription();
        int nrMensalidades = 12;
        double valor = 10000;
        double prestacao = 100;
        String invalidNome = "nome";
        String contacto = "";

        SavePrestacaoDataDTO data = new SavePrestacaoDataDTO(tipoFinanciamento, nrMensalidades, valor, prestacao,
                invalidNome, contacto);

        Mockito.when(fatorConfig.fatorExterno()).thenReturn(DEFAULT_FATOR_EXTERNO);

        ServiceResponse<SavePrestacaoDataDTO> result = service.savePrestacaoData(data);

        HttpStatus expected = HttpStatus.BAD_REQUEST;
        HttpStatus actual = result.error().getStatus();
        assertEquals(expected, actual);

    }

    @Test
    public void Should_ReturnServiceErrorWithServerError_IfRepositoryReturnsNull() {

        String tipoFinanciamento = TipoFinanciamento.EXTERNO.getDescription();
        int nrMensalidades = 12;
        double valor = 10000;
        double prestacao = 100;
        String invalidNome = "nome";
        String contacto = "111111111";

        SavePrestacaoDataDTO data = new SavePrestacaoDataDTO(tipoFinanciamento, nrMensalidades, valor, prestacao,
                invalidNome, contacto);

        Mockito.when(fatorConfig.fatorExterno()).thenReturn(DEFAULT_FATOR_EXTERNO);
        Mockito.when(repository.save(Mockito.any(DadosUtilizador.class))).thenReturn(null);

        ServiceResponse<SavePrestacaoDataDTO> result = service.savePrestacaoData(data);

        HttpStatus expected = HttpStatus.INTERNAL_SERVER_ERROR;
        HttpStatus actual = result.error().getStatus();
        assertEquals(expected, actual);

    }

    @Test
    public void Should_ReturnExpectedDadosUtilizador_IfValidData() {
        
        String tipoFinanciamento = TipoFinanciamento.EXTERNO.getDescription();
        int nrMensalidades = 12;
        double valor = 10000;
        double prestacao = 100;
        String invalidNome = "nome";
        String contacto = "111111111";

        SavePrestacaoDataDTO data = new SavePrestacaoDataDTO(tipoFinanciamento, nrMensalidades, valor, prestacao, invalidNome, contacto);

        Mockito.when(fatorConfig.fatorExterno()).thenReturn(DEFAULT_FATOR_EXTERNO);
        Mockito.when(repository.save(Mockito.any(DadosUtilizador.class))).thenReturn(
            new DadosUtilizador(data.nome, data.contacto,
            new Mensalidades(data.mensalidades, TipoFinanciamento.fromString(data.tipoFinanciamento)),
            new ValorViatura(data.valorViatura), new PrestacaoMensal(data.prestacaoMensal)
        ));

        ServiceResponse<SavePrestacaoDataDTO> actual = service.savePrestacaoData(data);
        
        assertEquals(data, actual.data());

    }

}
