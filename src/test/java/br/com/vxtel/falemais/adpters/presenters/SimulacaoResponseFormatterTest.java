package br.com.vxtel.falemais.adpters.presenters;

import br.com.vxtel.falemais.adapters.controllers.response.SimulacaoResponseModel;
import br.com.vxtel.falemais.adapters.presenters.formatters.SimulacaoResponseFormatter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.server.ResponseStatusException;

public class SimulacaoResponseFormatterTest {

    private SimulacaoResponseFormatter formatter;

    @BeforeEach
    public void init(){
        formatter = new SimulacaoResponseFormatter();
    }

    @Test
    public void testSuccessView(){
        SimulacaoResponseModel responseModel = SimulacaoResponseModel.builder()
                .codigoOrigem("011")
                .codigoDestino("017")
                .duracaoChamada(20)
                .minutosPlano(30)
                .valorComPlano(0.0)
                .valorSemPlano(38.0)
                .build();

        formatter.prepareSuccessView(responseModel);
        Assertions.assertEquals("011", responseModel.getCodigoOrigem());
        Assertions.assertEquals("017", responseModel.getCodigoDestino());
        Assertions.assertEquals(20, responseModel.getDuracaoChamada());
        Assertions.assertEquals(30, responseModel.getMinutosPlano());
        Assertions.assertEquals(0.0, responseModel.getValorComPlano());
        Assertions.assertEquals(38.0, responseModel.getValorSemPlano());

    }

    @Test
    public void testFailView(){
        try {
            formatter.prepareFailView("Erro");
        } catch(ResponseStatusException e) {
            Assertions.assertEquals("Erro", e.getReason());
        }

    }

}
