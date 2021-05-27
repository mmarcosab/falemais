package br.com.vxtel.falemais.adapters.presenters;

import br.com.vxtel.falemais.adapters.controllers.response.SimulacaoResponseModel;

public interface SimulacaoPresenter {
    SimulacaoResponseModel prepareSuccessView(SimulacaoResponseModel simulacaoResponseModel);
    SimulacaoResponseModel prepareFailView(String error);
}
