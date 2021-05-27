package br.com.vxtel.falemais;


import br.com.vxtel.falemais.adapters.controllers.SimulacaoController;
import br.com.vxtel.falemais.config.SwaggerConfiguration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MainAppTest {

    @Autowired
    private SimulacaoController simulacaoController;

    @Autowired
    private SwaggerConfiguration swaggerConfiguration;

    @Test
    void contextLoads() {
        Assertions.assertFalse(simulacaoController == null);
        Assertions.assertFalse(swaggerConfiguration == null);
    }
}