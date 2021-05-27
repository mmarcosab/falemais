package br.com.vxtel.falemais.adpters;

import br.com.vxtel.falemais.adapters.controllers.SimulacaoController;
import br.com.vxtel.falemais.adapters.controllers.request.SimulacaoRequestModel;
import br.com.vxtel.falemais.adapters.controllers.response.SimulacaoResponseModel;
import br.com.vxtel.falemais.domain.usecases.SimulaChamadaUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

        SimulacaoResponseModel response = (SimulacaoResponseModel) simulacaoController.create(request).getBody();



//        Assertions.assertEquals(38.00, response.getValorSemPlano());;
//        Assertions.assertEquals(0, response.getValorComPlano());;
//        Assertions.assertEquals("011", response.getCodigoOrigem());;
//        Assertions.assertEquals("016", response.getCodigoDestino());;
//        Assertions.assertEquals(30, response.getMinutosPlano());;
    }

//    @Test
//    public void testCriarSimulacao011to016Plano30TempoDeChamadaIgual30() throws Exception {
//        int tempoChamada = 30;
//        double valorMinuto = 1.90;
//        int minutosPlano = 30;
//        Double valorComplano = Simulacao.calculaValorComPlano(valorMinuto, tempoChamada, minutosPlano);
//        Double valorSemplano = Simulacao.calculaValorSemPlano(valorMinuto, tempoChamada);
//        Simulacao simulacao = simulacaoFactory.create("011", "016", tempoChamada, minutosPlano, valorComplano, valorSemplano);
//        Assertions.assertFalse(simulacao.getValorComPlano() > 0);
//        Assertions.assertEquals(57.00, simulacao.getValorSemPlano());;
//    }
//
//    @Test
//    public void testCriarSimulacao011to016Plano30TempoDeChamadaMaior30() throws Exception {
//        int tempoChamada = 31;
//        double valorMinuto = 1.90;
//        int minutosPlano = 30;
//        Double valorComplano = Simulacao.calculaValorComPlano(valorMinuto, tempoChamada, minutosPlano);
//        Double valorSemplano = Simulacao.calculaValorSemPlano(valorMinuto, tempoChamada);
//        Simulacao simulacao = simulacaoFactory.create("011", "016", tempoChamada, minutosPlano, valorComplano, valorSemplano);
//        Assertions.assertEquals(2.09, simulacao.getValorComPlano());
//        Assertions.assertEquals(58.90, simulacao.getValorSemPlano());
//    }
//
//    @Test
//    public void testCriarSimulacao011to017Plano60TempoDeChamadaMenor60() throws Exception {
//        int tempoChamada = 59;
//        double valorMinuto = 1.70;
//        int minutosPlano = 60;
//        Double valorComplano = Simulacao.calculaValorComPlano(valorMinuto, tempoChamada, minutosPlano);
//        Double valorSemplano = Simulacao.calculaValorSemPlano(valorMinuto, tempoChamada);
//        Simulacao simulacao = simulacaoFactory.create("011", "017", tempoChamada,minutosPlano, valorComplano, valorSemplano);
//        Assertions.assertEquals(0.0, simulacao.getValorComPlano());
//        Assertions.assertEquals(100.3, simulacao.getValorSemPlano());
//    }
//
//    @Test
//    public void testCriarSimulacao011to017Plano60TempoDeChamadaIgual60() throws Exception {
//        int tempoChamada = 60;
//        double valorMinuto = 1.70;
//        int minutosPlano = 60;
//        Double valorComplano = Simulacao.calculaValorComPlano(valorMinuto, tempoChamada, minutosPlano);
//        Double valorSemplano = Simulacao.calculaValorSemPlano(valorMinuto, tempoChamada);
//        Simulacao simulacao = simulacaoFactory.create("011", "017", tempoChamada, minutosPlano, valorComplano, valorSemplano);
//        Assertions.assertEquals(0.0, simulacao.getValorComPlano());
//        Assertions.assertEquals(102.0, simulacao.getValorSemPlano());
//    }
//
//    @Test
//    public void testCriarSimulacao011to017Plano60TempoDeChamadaMaior60() throws Exception {
//        int tempoChamada = 80;
//        double valorMinuto = 1.70;
//        int minutosPlano = 60;
//        Double valorComplano = Simulacao.calculaValorComPlano(valorMinuto, tempoChamada, minutosPlano);
//        Double valorSemplano = Simulacao.calculaValorSemPlano(valorMinuto, tempoChamada);
//        Simulacao simulacao = simulacaoFactory.create("011", "017", tempoChamada, minutosPlano, valorComplano, valorSemplano);
//        Assertions.assertEquals(37.40, simulacao.getValorComPlano());
//        Assertions.assertEquals(136.0, simulacao.getValorSemPlano());
//    }
//
//    @Test
//    public void testCriarSimulacao018to011Plano120TempoDeChamadaMenor120() throws Exception {
//        int tempoChamada = 119;
//        double valorMinuto = 1.90;
//        int minutosPlano = 120;
//        Double valorComplano = Simulacao.calculaValorComPlano(valorMinuto, tempoChamada, minutosPlano);
//        Double valorSemplano = Simulacao.calculaValorSemPlano(valorMinuto, tempoChamada);
//        Simulacao simulacao = simulacaoFactory.create("018", "011", tempoChamada, minutosPlano, valorComplano, valorSemplano);
//        Assertions.assertEquals(0.0, simulacao.getValorComPlano());
//        Assertions.assertEquals(226.10, simulacao.getValorSemPlano());
//    }
//
//
//    @Test
//    public void testCriarSimulacao018to011Plano120TempoDeChamadaIgual120() throws Exception {
//        int tempoChamada = 120;
//        double valorMinuto = 1.90;
//        int minutosPlano = 120;
//        Double valorComplano = Simulacao.calculaValorComPlano(valorMinuto, tempoChamada, minutosPlano);
//        Double valorSemplano = Simulacao.calculaValorSemPlano(valorMinuto, tempoChamada);
//        Simulacao simulacao = simulacaoFactory.create("018", "011", tempoChamada, minutosPlano, valorComplano, valorSemplano);
//        Assertions.assertEquals(0.0, simulacao.getValorComPlano());
//        Assertions.assertEquals(228.00, simulacao.getValorSemPlano());
//    }
//
//
//
//    @Test
//    public void testCriarSimulacao018to011Plano120TempoDeChamadaMaior120() throws Exception {
//        int tempoChamada = 200;
//        double valorMinuto = 1.90;
//        int minutosPlano = 120;
//        Double valorComplano = Simulacao.calculaValorComPlano(valorMinuto, tempoChamada, minutosPlano);
//        Double valorSemplano = Simulacao.calculaValorSemPlano(valorMinuto, tempoChamada);
//        Simulacao simulacao = simulacaoFactory.create("018", "011", tempoChamada, minutosPlano, valorComplano, valorSemplano);
//        Assertions.assertEquals(167.20, simulacao.getValorComPlano());
//        Assertions.assertEquals(380.0, simulacao.getValorSemPlano());
//        Assertions.assertEquals("018", simulacao.getCodigoOrigem());
//        Assertions.assertEquals("011", simulacao.getCodigoDestino());
//        Assertions.assertEquals(200, simulacao.getTempoDeChamada());
//        Assertions.assertEquals(120, simulacao.getMinutosPlano());
//    }



}
