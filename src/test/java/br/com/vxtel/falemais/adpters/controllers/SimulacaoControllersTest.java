package br.com.vxtel.falemais.adpters.controllers;

import br.com.vxtel.falemais.adapters.controllers.SimulacaoController;
import br.com.vxtel.falemais.adapters.controllers.request.SimulacaoRequestModel;
import br.com.vxtel.falemais.adapters.controllers.response.SimulacaoResponseModel;
import br.com.vxtel.falemais.domain.usecases.SimulaChamadaUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;

import static org.mockito.Mockito.*;


public class SimulacaoControllersTest {

    private SimulacaoController simulacaoController;
    private SimulaChamadaUseCase simulaChamadaUseCase;

    @BeforeEach
    public void init(){
        simulaChamadaUseCase = mock(SimulaChamadaUseCase.class);
        simulacaoController = new SimulacaoController(simulaChamadaUseCase);
    }

    @Test
    public void testCriarSimulacao011to016Plano30TempoDeChamadaMenor30() throws Exception {
        SimulacaoRequestModel request = SimulacaoRequestModel.builder()
                .codigoOrigem("011")
                .codigoDestino("016")
                .duracaoChamada(20)
                .minutosPlano(30)
                .valorMinuto(1.90)
                .build();

        SimulacaoResponseModel responseModel = SimulacaoResponseModel.builder()
                .codigoOrigem("011")
                .codigoDestino("016")
                .duracaoChamada(20)
                .minutosPlano(30)
                .valorComPlano(0.0)
                .valorSemPlano(38.0)
                .build();

        when(simulaChamadaUseCase.execute(request)).thenReturn(responseModel);

        SimulacaoResponseModel response = (SimulacaoResponseModel) simulacaoController.create(request).getBody();

        Assertions.assertEquals(38.00, response.getValorSemPlano());
        Assertions.assertEquals(0, response.getValorComPlano());
        Assertions.assertEquals("011", response.getCodigoOrigem());
        Assertions.assertEquals("016", response.getCodigoDestino());
        Assertions.assertEquals(30, response.getMinutosPlano());
    }

    @Test
    public void testCriarSimulacao011to016Plano30TempoDeChamadaIgual30() throws Exception {

        SimulacaoRequestModel request = SimulacaoRequestModel.builder()
                .codigoOrigem("011")
                .codigoDestino("016")
                .duracaoChamada(20)
                .minutosPlano(30)
                .valorMinuto(1.90)
                .build();

        SimulacaoResponseModel responseModel = SimulacaoResponseModel.builder()
                .codigoOrigem("011")
                .codigoDestino("016")
                .duracaoChamada(20)
                .minutosPlano(30)
                .valorComPlano(0.0)
                .valorSemPlano(38.0)
                .build();

//        when(simulaChamadaUseCase.execute(request)).thenReturn(responseModel);

        doThrow(new ResponseStatusException(HttpStatus.CONFLICT, "Codigo de destino esta em formato invalido")).when(simulaChamadaUseCase).execute(request);

        ResponseEntity response = simulacaoController.create(request);

        Assertions.assertEquals(409, response.getStatusCodeValue());
        Assertions.assertEquals(HttpStatus.CONFLICT, response.getStatusCode());
    }

}
