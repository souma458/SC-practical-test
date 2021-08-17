package pt.rigorcg.teste.services;

import pt.rigorcg.teste.model.dto.CalculoPrestacaoDTO;
import pt.rigorcg.teste.model.dto.PrestacaoDTO;
import pt.rigorcg.teste.model.dto.SavePrestacaoDataDTO;
import pt.rigorcg.teste.util.ServiceResponse;

public interface IPrestacaoService {

    ServiceResponse<PrestacaoDTO> calculoPrestacao(CalculoPrestacaoDTO data);

	ServiceResponse<SavePrestacaoDataDTO> savePrestacaoData(SavePrestacaoDataDTO data);

}
