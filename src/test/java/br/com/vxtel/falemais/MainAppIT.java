package br.com.vxtel.falemais;


import br.com.vxtel.falemais.adapters.controllers.SimulacaoController;
import br.com.vxtel.falemais.adapters.controllers.request.SimulacaoRequestModel;
import br.com.vxtel.falemais.adapters.controllers.response.SimulacaoResponseModel;
import br.com.vxtel.falemais.config.SwaggerConfiguration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


@SpringBootTest
public class MainAppIT {

    @Autowired
    private SimulacaoController simulacaoController;

    @Autowired
    private SwaggerConfiguration swaggerConfiguration;

    private String urlBase = "http://127.0.0.1:8080/falemais/simulacoes";

    @Test
    void contextLoads() {
        Assertions.assertFalse(simulacaoController == null);
        Assertions.assertFalse(swaggerConfiguration == null);
    }

    @Test
    void testCriarSimulacao011to016Plano30TempoDeChamadaMenor30() {
        RestTemplate restTemplate = new RestTemplate();
        SimulacaoRequestModel request = SimulacaoRequestModel.builder()
                .valorMinuto(1.90)
                .minutosPlano(30)
                .duracaoChamada(20)
                .codigoOrigem("011")
                .codigoDestino("016")
                .build();
        SimulacaoResponseModel response = restTemplate.postForObject(urlBase, request, SimulacaoResponseModel.class);
        Assertions.assertEquals(38.00, response.getValorSemPlano());
        Assertions.assertEquals(0, response.getValorComPlano());
        Assertions.assertEquals("011", response.getCodigoOrigem());
        Assertions.assertEquals("016", response.getCodigoDestino());
        Assertions.assertEquals(30, response.getMinutosPlano());
        Assertions.assertEquals(20, response.getDuracaoChamada());
    }

    @Test
    public void testCriarSimulacao011to016Plano30TempoDeChamadaIgual30() {
        RestTemplate restTemplate = new RestTemplate();
        SimulacaoRequestModel request = SimulacaoRequestModel.builder()
                .valorMinuto(1.90)
                .minutosPlano(30)
                .duracaoChamada(30)
                .codigoOrigem("011")
                .codigoDestino("016")
                .build();
        SimulacaoResponseModel response = restTemplate.postForObject(urlBase, request, SimulacaoResponseModel.class);

        Assertions.assertEquals(57.00, response.getValorSemPlano());
        Assertions.assertEquals(0, response.getValorComPlano());
        Assertions.assertEquals("011", response.getCodigoOrigem());
        Assertions.assertEquals("016", response.getCodigoDestino());
        Assertions.assertEquals(30, response.getMinutosPlano());
        Assertions.assertEquals(30, response.getDuracaoChamada());
    }

    @Test
    public void testCriarSimulacao011to016Plano30TempoDeChamadaMaior30() {

        RestTemplate restTemplate = new RestTemplate();
        SimulacaoRequestModel request = SimulacaoRequestModel.builder()
                .valorMinuto(1.90)
                .minutosPlano(30)
                .duracaoChamada(31)
                .codigoOrigem("011")
                .codigoDestino("016")
                .build();
        SimulacaoResponseModel response = restTemplate.postForObject(urlBase, request, SimulacaoResponseModel.class);

        Assertions.assertEquals(58.90, response.getValorSemPlano());
        Assertions.assertEquals(2.09, response.getValorComPlano());
        Assertions.assertEquals("011", response.getCodigoOrigem());
        Assertions.assertEquals("016", response.getCodigoDestino());
        Assertions.assertEquals(30, response.getMinutosPlano());
        Assertions.assertEquals(31, response.getDuracaoChamada());

    }

    @Test
    public void testCriarSimulacao011to017Plano60TempoDeChamadaMenor60() throws Exception {

        RestTemplate restTemplate = new RestTemplate();
        SimulacaoRequestModel request = SimulacaoRequestModel.builder()
                .valorMinuto(1.70)
                .minutosPlano(60)
                .duracaoChamada(59)
                .codigoOrigem("011")
                .codigoDestino("017")
                .build();
        SimulacaoResponseModel response = restTemplate.postForObject(urlBase, request, SimulacaoResponseModel.class);

        Assertions.assertEquals(100.3, response.getValorSemPlano());
        Assertions.assertEquals(0, response.getValorComPlano());
        Assertions.assertEquals("011", response.getCodigoOrigem());
        Assertions.assertEquals("017", response.getCodigoDestino());
        Assertions.assertEquals(60, response.getMinutosPlano());
        Assertions.assertEquals(59, response.getDuracaoChamada());
    }

    @Test
    public void testCriarSimulacao011to017Plano60TempoDeChamadaIgual60() throws Exception {

        RestTemplate restTemplate = new RestTemplate();
        SimulacaoRequestModel request = SimulacaoRequestModel.builder()
                .valorMinuto(1.70)
                .minutosPlano(60)
                .duracaoChamada(60)
                .codigoOrigem("011")
                .codigoDestino("017")
                .build();
        SimulacaoResponseModel response = restTemplate.postForObject(urlBase, request, SimulacaoResponseModel.class);

        Assertions.assertEquals(102.00, response.getValorSemPlano());
        Assertions.assertEquals(0, response.getValorComPlano());
        Assertions.assertEquals("011", response.getCodigoOrigem());
        Assertions.assertEquals("017", response.getCodigoDestino());
        Assertions.assertEquals(60, response.getMinutosPlano());
        Assertions.assertEquals(60, response.getDuracaoChamada());

    }

    @Test
    public void testCriarSimulacao011to017Plano60TempoDeChamadaMaior60() throws Exception {

        RestTemplate restTemplate = new RestTemplate();
        SimulacaoRequestModel request = SimulacaoRequestModel.builder()
                .valorMinuto(1.70)
                .minutosPlano(60)
                .duracaoChamada(80)
                .codigoOrigem("011")
                .codigoDestino("017")
                .build();
        SimulacaoResponseModel response = restTemplate.postForObject(urlBase, request, SimulacaoResponseModel.class);

        Assertions.assertEquals(136.0, response.getValorSemPlano());
        Assertions.assertEquals(37.40, response.getValorComPlano());
        Assertions.assertEquals("011", response.getCodigoOrigem());
        Assertions.assertEquals("017", response.getCodigoDestino());
        Assertions.assertEquals(60, response.getMinutosPlano());
        Assertions.assertEquals(80, response.getDuracaoChamada());
    }

    @Test
    public void testCriarSimulacao018to011Plano120TempoDeChamadaMenor120() throws Exception {

        RestTemplate restTemplate = new RestTemplate();
        SimulacaoRequestModel request = SimulacaoRequestModel.builder()
                .valorMinuto(1.90)
                .minutosPlano(120)
                .duracaoChamada(119)
                .codigoOrigem("018")
                .codigoDestino("011")
                .build();
        SimulacaoResponseModel response = restTemplate.postForObject(urlBase, request, SimulacaoResponseModel.class);

        Assertions.assertEquals(226.10, response.getValorSemPlano());
        Assertions.assertEquals(0, response.getValorComPlano());
        Assertions.assertEquals("018", response.getCodigoOrigem());
        Assertions.assertEquals("011", response.getCodigoDestino());
        Assertions.assertEquals(120, response.getMinutosPlano());
        Assertions.assertEquals(119, response.getDuracaoChamada());


    }


    @Test
    public void testCriarSimulacao018to011Plano120TempoDeChamadaIgual120() throws Exception {

        RestTemplate restTemplate = new RestTemplate();
        SimulacaoRequestModel request = SimulacaoRequestModel.builder()
                .valorMinuto(1.90)
                .minutosPlano(120)
                .duracaoChamada(120)
                .codigoOrigem("018")
                .codigoDestino("011")
                .build();
        SimulacaoResponseModel response = restTemplate.postForObject(urlBase, request, SimulacaoResponseModel.class);

        Assertions.assertEquals(228.0, response.getValorSemPlano());
        Assertions.assertEquals(0, response.getValorComPlano());
        Assertions.assertEquals("018", response.getCodigoOrigem());
        Assertions.assertEquals("011", response.getCodigoDestino());
        Assertions.assertEquals(120, response.getMinutosPlano());
        Assertions.assertEquals(120, response.getDuracaoChamada());

    }



    @Test
    public void testCriarSimulacao018to011Plano120TempoDeChamadaMaior120() throws Exception {

        RestTemplate restTemplate = new RestTemplate();
        SimulacaoRequestModel request = SimulacaoRequestModel.builder()
                .valorMinuto(1.90)
                .minutosPlano(120)
                .duracaoChamada(200)
                .codigoOrigem("018")
                .codigoDestino("011")
                .build();
        SimulacaoResponseModel response = restTemplate.postForObject(urlBase, request, SimulacaoResponseModel.class);

        Assertions.assertEquals(380.0, response.getValorSemPlano());
        Assertions.assertEquals(167.20, response.getValorComPlano());
        Assertions.assertEquals("018", response.getCodigoOrigem());
        Assertions.assertEquals("011", response.getCodigoDestino());
        Assertions.assertEquals(120, response.getMinutosPlano());
        Assertions.assertEquals(200, response.getDuracaoChamada());

    }

}