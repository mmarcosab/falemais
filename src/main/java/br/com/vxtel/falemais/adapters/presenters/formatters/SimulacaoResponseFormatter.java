package br.com.vxtel.falemais.adapters.presenters.formatters;

import br.com.vxtel.falemais.adapters.controllers.response.SimulacaoResponseModel;
import br.com.vxtel.falemais.adapters.presenters.SimulacaoPresenter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@Component
public class SimulacaoResponseFormatter implements SimulacaoPresenter {

    @Override
    public SimulacaoResponseModel prepareSuccessView(SimulacaoResponseModel response) {
        log.info("Preparando a view de sucesso com a mensagem: {}", response);
        return response;
    }

    @Override
    public SimulacaoResponseModel prepareFailView(String error) {
        log.error("Preparando a view de falha com a mensagem: {}", error);
        throw new ResponseStatusException(HttpStatus.CONFLICT, error);
    }

}
