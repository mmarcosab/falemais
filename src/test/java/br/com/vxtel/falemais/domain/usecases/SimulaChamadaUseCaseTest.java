package br.com.vxtel.falemais.domain.usecases;

import br.com.vxtel.falemais.adapters.controllers.request.SimulacaoRequestModel;
import br.com.vxtel.falemais.adapters.controllers.response.SimulacaoResponseModel;
import br.com.vxtel.falemais.adapters.presenters.SimulacaoPresenter;
import br.com.vxtel.falemais.domain.entities.Simulacao;
import br.com.vxtel.falemais.domain.factories.SimulacaoFactory;
import br.com.vxtel.falemais.domain.usecases.impl.SimulaChamadaUseCaseImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;


public class SimulaChamadaUseCaseTest {

    private SimulaChamadaUseCaseImpl simulaChamadaUseCase;
    private SimulacaoFactory simulacaoFactory;
    private SimulacaoPresenter simulacaoPresenter;

    @BeforeEach
    public void init(){
        simulacaoFactory = mock(SimulacaoFactory.class);
        simulacaoPresenter = mock(SimulacaoPresenter.class);
        simulaChamadaUseCase = new SimulaChamadaUseCaseImpl(simulacaoFactory, simulacaoPresenter);
    }

    @Test
    public void testSuccess() throws Exception {
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

        Simulacao simulacao = new Simulacao("011", "016", 20, 30, 1.90);

        when(simulacaoFactory.create("011", "016", 20, 30, 1.90)).thenReturn(simulacao);
        when(simulacaoPresenter.prepareSuccessView(any())).thenReturn(responseModel);
        SimulacaoResponseModel response = simulaChamadaUseCase.execute(request);

        Assertions.assertEquals(38.00, response.getValorSemPlano());
        Assertions.assertEquals(0, response.getValorComPlano());
        Assertions.assertEquals("011", response.getCodigoOrigem());
        Assertions.assertEquals("016", response.getCodigoDestino());
        Assertions.assertEquals(30, response.getMinutosPlano());

    }

    @Test
    public void testFail() throws Exception {
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

        Simulacao simulacao = new Simulacao("011", "016", 20, 30, 1.90);

        doThrow(Exception.class).when(simulacaoFactory).create("011", "016", 20, 30, 1.90);

        SimulacaoResponseModel response = simulaChamadaUseCase.execute(request);

        Assertions.assertEquals(null, response);


    }



}
