package br.com.vxtel.falemais.adapters.presenters.formatters;

import br.com.vxtel.falemais.adapters.controllers.response.SimulacaoResponseModel;
import br.com.vxtel.falemais.adapters.presenters.SimulacaoPresenter;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;


public class SimulacaoResponseFormatter implements SimulacaoPresenter {

    @Override
    public SimulacaoResponseModel prepareSuccessView(SimulacaoResponseModel response) {
        return response;
    }

    @Override
    public SimulacaoResponseModel prepareFailView(String error) {
        throw new ResponseStatusException(HttpStatus.CONFLICT, error);
    }
}
