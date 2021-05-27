package br.com.vxtel.falemais.adapters.controllers;

import br.com.vxtel.falemais.adapters.controllers.request.SimulacaoRequestModel;
import br.com.vxtel.falemais.adapters.controllers.response.SimulacaoResponseModel;
import br.com.vxtel.falemais.domain.usecases.SimulaChamadaUseCase;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
            return ResponseEntity.ok().body(simulaChamadaUseCase.execute(requestModel));
        } catch (ResponseStatusException e){
            return ResponseEntity.status(e.getStatus()).body(e.getMessage());
        }
    }

}
