package br.com.vxtel.falemais.adapters.controllers;

import br.com.vxtel.falemais.adapters.controllers.request.SimulacaoRequestModel;
import br.com.vxtel.falemais.domain.usecases.SimulaChamadaUseCase;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@Api
@Slf4j
@RestController
@RequestMapping("/simulacoes")
@RequiredArgsConstructor
public class SimulacaoController {

    private final SimulaChamadaUseCase simulaChamadaUseCase;

    @ApiOperation("Cria uma simulacao de uma chamada com uso de um plano e sem o uso de um plano")
    @PostMapping
    public ResponseEntity create(@RequestBody SimulacaoRequestModel requestModel){
        try {
            log.info("Requisicao recebida: {}", requestModel);
            return ResponseEntity.ok().body(simulaChamadaUseCase.execute(requestModel));
        } catch (ResponseStatusException e){
            log.error("Houve um erro ao processar a requisicao: {}", e.getMessage());
            return ResponseEntity.status(e.getRawStatusCode()).body(e.getMessage());
        } catch (Exception e){
            log.error("Houve um erro ao processar a requisicao: {}", e.getMessage());
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
