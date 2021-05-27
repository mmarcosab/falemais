package br.com.vxtel.falemais.domain.entities;

import br.com.vxtel.falemais.adapters.controllers.request.SimulacaoRequestModel;
import br.com.vxtel.falemais.domain.factories.SimulacaoFactoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class SimulacaoTest {

    private SimulacaoFactoryImpl simulacaoFactory = new SimulacaoFactoryImpl();

    @Test
    public void testCriarSimulacao011to016Plano30TempoDeChamadaMenor30() throws Exception {
        int tempoChamada = 20;
        double valorMinuto = 1.90;
        int minutosPlano = 30;
        Simulacao simulacao = simulacaoFactory.create("011", "016", tempoChamada, minutosPlano, valorMinuto);
        Assertions.assertFalse(simulacao.getValorComPlano() > 0);
        Assertions.assertEquals(38.00, simulacao.getValorSemPlano());;
    }

    @Test
    public void testCriarSimulacao011to016Plano30TempoDeChamadaIgual30() throws Exception {
        int tempoChamada = 30;
        double valorMinuto = 1.90;
        int minutosPlano = 30;
        Simulacao simulacao = simulacaoFactory.create("011", "016", tempoChamada, minutosPlano, valorMinuto);
        Assertions.assertFalse(simulacao.getValorComPlano() > 0);
        Assertions.assertEquals(57.00, simulacao.getValorSemPlano());;
    }

    @Test
    public void testCriarSimulacao011to016Plano30TempoDeChamadaMaior30() throws Exception {
        int tempoChamada = 31;
        double valorMinuto = 1.90;
        int minutosPlano = 30;
        Simulacao simulacao = simulacaoFactory.create("011", "016", tempoChamada, minutosPlano, valorMinuto);
        Assertions.assertEquals(2.09, simulacao.getValorComPlano());
        Assertions.assertEquals(58.90, simulacao.getValorSemPlano());
    }

    @Test
    public void testCriarSimulacao011to017Plano60TempoDeChamadaMenor60() throws Exception {
        int tempoChamada = 59;
        double valorMinuto = 1.70;
        int minutosPlano = 60;
        Simulacao simulacao = simulacaoFactory.create("011", "017", tempoChamada,minutosPlano, valorMinuto);
        Assertions.assertEquals(0.0, simulacao.getValorComPlano());
        Assertions.assertEquals(100.3, simulacao.getValorSemPlano());
    }

    @Test
    public void testCriarSimulacao011to017Plano60TempoDeChamadaIgual60() throws Exception {
        int tempoChamada = 60;
        double valorMinuto = 1.70;
        int minutosPlano = 60;
        Simulacao simulacao = simulacaoFactory.create("011", "017", tempoChamada, minutosPlano, valorMinuto);
        Assertions.assertEquals(0.0, simulacao.getValorComPlano());
        Assertions.assertEquals(102.0, simulacao.getValorSemPlano());
    }

    @Test
    public void testCriarSimulacao011to017Plano60TempoDeChamadaMaior60() throws Exception {
        int tempoChamada = 80;
        double valorMinuto = 1.70;
        int minutosPlano = 60;
        Simulacao simulacao = simulacaoFactory.create("011", "017", tempoChamada, minutosPlano, valorMinuto);
        Assertions.assertEquals(37.40, simulacao.getValorComPlano());
        Assertions.assertEquals(136.0, simulacao.getValorSemPlano());
    }

    @Test
    public void testCriarSimulacao018to011Plano120TempoDeChamadaMenor120() throws Exception {
        int tempoChamada = 119;
        double valorMinuto = 1.90;
        int minutosPlano = 120;
        Simulacao simulacao = simulacaoFactory.create("018", "011", tempoChamada, minutosPlano, valorMinuto);
        Assertions.assertEquals(0.0, simulacao.getValorComPlano());
        Assertions.assertEquals(226.10, simulacao.getValorSemPlano());
    }


    @Test
    public void testCriarSimulacao018to011Plano120TempoDeChamadaIgual120() throws Exception {
        int tempoChamada = 120;
        double valorMinuto = 1.90;
        int minutosPlano = 120;
        Simulacao simulacao = simulacaoFactory.create("018", "011", tempoChamada, minutosPlano, valorMinuto);
        Assertions.assertEquals(0.0, simulacao.getValorComPlano());
        Assertions.assertEquals(228.00, simulacao.getValorSemPlano());
    }



    @Test
    public void testCriarSimulacao018to011Plano120TempoDeChamadaMaior120() throws Exception {
        int tempoChamada = 200;
        double valorMinuto = 1.90;
        int minutosPlano = 120;
        Simulacao simulacao = simulacaoFactory.create("018", "011", tempoChamada, minutosPlano, valorMinuto);
        Assertions.assertEquals(167.20, simulacao.getValorComPlano());
        Assertions.assertEquals(380.0, simulacao.getValorSemPlano());
        Assertions.assertEquals("018", simulacao.getCodigoOrigem());
        Assertions.assertEquals("011", simulacao.getCodigoDestino());
        Assertions.assertEquals(200, simulacao.getDuracaoChamada());
        Assertions.assertEquals(120, simulacao.getMinutosPlano());
    }

    @Test
    public void validarCodigoOrigemNulo(){

        SimulacaoRequestModel requestModel = SimulacaoRequestModel.builder()
                .codigoDestino("017")
                .duracaoChamada(31)
                .minutosPlano(30)
                .valorMinuto(1.70)
                .build();

        try {
            simulacaoFactory.create(requestModel.getCodigoOrigem(), requestModel.getCodigoDestino(), requestModel.getDuracaoChamada(), requestModel.getMinutosPlano(), requestModel.getValorMinuto());
        } catch (Exception e){
            Assertions.assertEquals("Codigo de origem nulo ou vazio" ,e.getMessage());
        }

    }

    @Test
    public void validarCodigoOrigemVazio(){

        SimulacaoRequestModel requestModel = SimulacaoRequestModel.builder()
                .codigoDestino("017")
                .duracaoChamada(31)
                .minutosPlano(30)
                .valorMinuto(1.70)
                .build();

        try {
            simulacaoFactory.create(requestModel.getCodigoOrigem(), requestModel.getCodigoDestino(), requestModel.getDuracaoChamada(), requestModel.getMinutosPlano(), requestModel.getValorMinuto());
        } catch (Exception e){
            Assertions.assertEquals("Codigo de origem nulo ou vazio" ,e.getMessage());
        }

    }

    @Test
    public void validarCodigoDestinoNulo(){

        SimulacaoRequestModel requestModel = SimulacaoRequestModel.builder()
                .codigoOrigem("017")
                .duracaoChamada(31)
                .minutosPlano(30)
                .valorMinuto(1.70)
                .build();

        try {
            simulacaoFactory.create(requestModel.getCodigoOrigem(), requestModel.getCodigoDestino(), requestModel.getDuracaoChamada(), requestModel.getMinutosPlano(), requestModel.getValorMinuto());
        } catch (Exception e){
            Assertions.assertEquals("Codigo de destino nulo ou vazio" ,e.getMessage());
        }

    }

    @Test
    public void validarCodigoDestinoVazio(){

        SimulacaoRequestModel requestModel = SimulacaoRequestModel.builder()
                .codigoDestino("")
                .codigoOrigem("017")
                .duracaoChamada(31)
                .minutosPlano(30)
                .valorMinuto(1.70)
                .build();

        try {
            simulacaoFactory.create(requestModel.getCodigoOrigem(), requestModel.getCodigoDestino(), requestModel.getDuracaoChamada(), requestModel.getMinutosPlano(), requestModel.getValorMinuto());
        } catch (Exception e){
            Assertions.assertEquals("Codigo de destino nulo ou vazio" ,e.getMessage());
        }

    }

    @Test
    public void validarDuracaoChamadaZerada(){

        SimulacaoRequestModel requestModel = SimulacaoRequestModel.builder()
                .codigoDestino("11")
                .codigoOrigem("017")
                .duracaoChamada(0)
                .minutosPlano(30)
                .valorMinuto(1.70)
                .build();

        try {
            simulacaoFactory.create(requestModel.getCodigoOrigem(), requestModel.getCodigoDestino(), requestModel.getDuracaoChamada(), requestModel.getMinutosPlano(), requestModel.getValorMinuto());
        } catch (Exception e){
            Assertions.assertEquals("Duracao da chamada invalida" ,e.getMessage());
        }

    }

    @Test
    public void validarMinutosPlanoZerado(){

        SimulacaoRequestModel requestModel = SimulacaoRequestModel.builder()
                .codigoDestino("11")
                .codigoOrigem("017")
                .duracaoChamada(31)
                .minutosPlano(0)
                .valorMinuto(1.70)
                .build();

        try {
            simulacaoFactory.create(requestModel.getCodigoOrigem(), requestModel.getCodigoDestino(), requestModel.getDuracaoChamada(), requestModel.getMinutosPlano(), requestModel.getValorMinuto());
        } catch (Exception e){
            Assertions.assertEquals("O campo minutos do plano esta invalido" ,e.getMessage());
        }

    }

}
