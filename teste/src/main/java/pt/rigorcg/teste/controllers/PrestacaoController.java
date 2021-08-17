package pt.rigorcg.teste.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pt.rigorcg.teste.model.dto.CalculoPrestacaoDTO;
import pt.rigorcg.teste.model.dto.PrestacaoDTO;
import pt.rigorcg.teste.model.dto.SavePrestacaoDataDTO;
import pt.rigorcg.teste.services.IPrestacaoService;
import pt.rigorcg.teste.util.ServiceResponse;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "/prestacao", produces = MediaType.APPLICATION_JSON_VALUE)
public class PrestacaoController {

    @Autowired
    IPrestacaoService service;

    @GetMapping
    public ResponseEntity<Object> calculatePrestacao(@RequestParam String financiamento, @RequestParam int mensalidades, @RequestParam double valor) {
        ServiceResponse<PrestacaoDTO> sResponse = service.calculoPrestacao(new CalculoPrestacaoDTO(financiamento, mensalidades, valor));

        if (sResponse.hasError()) {
            return ResponseEntity.status(sResponse.error().getStatus()).body(sResponse.error());
        }

        return ResponseEntity.status(HttpStatus.OK).body(sResponse.data());
    }

    @PostMapping
    public ResponseEntity<Object> savePrestacaoData(@RequestBody SavePrestacaoDataDTO data) {
        ServiceResponse<SavePrestacaoDataDTO> sResponse = service.savePrestacaoData(data);

        if (sResponse.hasError()) {
            return ResponseEntity.status(sResponse.error().getStatus()).body(sResponse.error());
        }

        return ResponseEntity.status(HttpStatus.OK).body(sResponse.data());
    }

}
