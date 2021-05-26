package br.com.vxtel.falemais.domain.entities;

import br.com.vxtel.falemais.domain.entities.factories.SimulacaoFactoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class SimulacaoTest {

    private SimulacaoFactoryImpl simulacaoFactory = new SimulacaoFactoryImpl();

    @Test
    public void testCriarSimulacao011to016Plano30TempoDeChamadaMenor30() throws Exception {
        int tempoChamada = 20;
        double valorMinuto = 1.90;
        int minutosPlano = 30;
        Double valorComplano = Simulacao.calculaValorComPlano(valorMinuto, 20, minutosPlano);
        Double valorSemplano = Simulacao.calculaValorSemPlano(valorMinuto, 20);
        Simulacao simulacao = simulacaoFactory.create("011", "016", tempoChamada, minutosPlano, valorComplano, valorSemplano);
        Assertions.assertFalse(simulacao.getValorComPlano() > 0);
        Assertions.assertEquals(38.00, simulacao.getValorSemPlano());;
    }

    @Test
    public void testCriarSimulacao011to016Plano30TempoDeChamadaIgual30() throws Exception {
        int tempoChamada = 30;
        double valorMinuto = 1.90;
        int minutosPlano = 30;
        Double valorComplano = Simulacao.calculaValorComPlano(valorMinuto, tempoChamada, minutosPlano);
        Double valorSemplano = Simulacao.calculaValorSemPlano(valorMinuto, tempoChamada);
        Simulacao simulacao = simulacaoFactory.create("011", "016", tempoChamada, minutosPlano, valorComplano, valorSemplano);
        Assertions.assertFalse(simulacao.getValorComPlano() > 0);
        Assertions.assertEquals(57.00, simulacao.getValorSemPlano());;
    }

    @Test
    public void testCriarSimulacao011to016Plano30TempoDeChamadaMaior30() throws Exception {
        int tempoChamada = 31;
        double valorMinuto = 1.90;
        int minutosPlano = 30;
        Double valorComplano = Simulacao.calculaValorComPlano(valorMinuto, tempoChamada, minutosPlano);
        Double valorSemplano = Simulacao.calculaValorSemPlano(valorMinuto, tempoChamada);
        Simulacao simulacao = simulacaoFactory.create("011", "016", tempoChamada, minutosPlano, valorComplano, valorSemplano);
        Assertions.assertEquals(2.09, simulacao.getValorComPlano());
        Assertions.assertEquals(58.90, simulacao.getValorSemPlano());
    }

    @Test
    public void testCriarSimulacao011to017Plano60TempoDeChamadaMenor60() throws Exception {
        int tempoChamada = 59;
        double valorMinuto = 1.70;
        int minutosPlano = 60;
        Double valorComplano = Simulacao.calculaValorComPlano(valorMinuto, tempoChamada, minutosPlano);
        Double valorSemplano = Simulacao.calculaValorSemPlano(valorMinuto, tempoChamada);
        Simulacao simulacao = simulacaoFactory.create("011", "017", tempoChamada,minutosPlano, valorComplano, valorSemplano);
        Assertions.assertEquals(0.0, simulacao.getValorComPlano());
        Assertions.assertEquals(100.3, simulacao.getValorSemPlano());
    }

    @Test
    public void testCriarSimulacao011to017Plano60TempoDeChamadaIgual60() throws Exception {
        int tempoChamada = 60;
        double valorMinuto = 1.70;
        int minutosPlano = 60;
        Double valorComplano = Simulacao.calculaValorComPlano(valorMinuto, tempoChamada, minutosPlano);
        Double valorSemplano = Simulacao.calculaValorSemPlano(valorMinuto, tempoChamada);
        Simulacao simulacao = simulacaoFactory.create("011", "017", tempoChamada, minutosPlano, valorComplano, valorSemplano);
        Assertions.assertEquals(0.0, simulacao.getValorComPlano());
        Assertions.assertEquals(102.0, simulacao.getValorSemPlano());
    }

    @Test
    public void testCriarSimulacao011to017Plano60TempoDeChamadaMaior60() throws Exception {
        int tempoChamada = 80;
        double valorMinuto = 1.70;
        int minutosPlano = 60;
        Double valorComplano = Simulacao.calculaValorComPlano(valorMinuto, tempoChamada, minutosPlano);
        Double valorSemplano = Simulacao.calculaValorSemPlano(valorMinuto, tempoChamada);
        Simulacao simulacao = simulacaoFactory.create("011", "017", tempoChamada, minutosPlano, valorComplano, valorSemplano);
        Assertions.assertEquals(37.40, simulacao.getValorComPlano());
        Assertions.assertEquals(136.0, simulacao.getValorSemPlano());
    }

    @Test
    public void testCriarSimulacao018to011Plano120TempoDeChamadaMenor120() throws Exception {
        int tempoChamada = 119;
        double valorMinuto = 1.90;
        int minutosPlano = 120;
        Double valorComplano = Simulacao.calculaValorComPlano(valorMinuto, tempoChamada, minutosPlano);
        Double valorSemplano = Simulacao.calculaValorSemPlano(valorMinuto, tempoChamada);
        Simulacao simulacao = simulacaoFactory.create("018", "011", tempoChamada, minutosPlano, valorComplano, valorSemplano);
        Assertions.assertEquals(0.0, simulacao.getValorComPlano());
        Assertions.assertEquals(226.10, simulacao.getValorSemPlano());
    }


    @Test
    public void testCriarSimulacao018to011Plano120TempoDeChamadaIgual120() throws Exception {
        int tempoChamada = 120;
        double valorMinuto = 1.90;
        int minutosPlano = 120;
        Double valorComplano = Simulacao.calculaValorComPlano(valorMinuto, tempoChamada, minutosPlano);
        Double valorSemplano = Simulacao.calculaValorSemPlano(valorMinuto, tempoChamada);
        Simulacao simulacao = simulacaoFactory.create("018", "011", tempoChamada, minutosPlano, valorComplano, valorSemplano);
        Assertions.assertEquals(0.0, simulacao.getValorComPlano());
        Assertions.assertEquals(228.00, simulacao.getValorSemPlano());
    }



    @Test
    public void testCriarSimulacao018to011Plano120TempoDeChamadaMaior120() throws Exception {
        int tempoChamada = 200;
        double valorMinuto = 1.90;
        int minutosPlano = 120;
        Double valorComplano = Simulacao.calculaValorComPlano(valorMinuto, tempoChamada, minutosPlano);
        Double valorSemplano = Simulacao.calculaValorSemPlano(valorMinuto, tempoChamada);
        Simulacao simulacao = simulacaoFactory.create("018", "011", tempoChamada, minutosPlano, valorComplano, valorSemplano);
        Assertions.assertEquals(167.20, simulacao.getValorComPlano());
        Assertions.assertEquals(380.0, simulacao.getValorSemPlano());
        Assertions.assertEquals("018", simulacao.getCodigoOrigem());
        Assertions.assertEquals("011", simulacao.getCodigoDestino());
        Assertions.assertEquals(200, simulacao.getTempoDeChamada());
        Assertions.assertEquals(120, simulacao.getMinutosPlano());
    }

}
