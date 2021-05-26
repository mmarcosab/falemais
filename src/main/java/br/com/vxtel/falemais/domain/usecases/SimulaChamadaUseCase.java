package br.com.vxtel.falemais.domain.usecases;

import br.com.vxtel.falemais.adapters.controllers.request.SimulacaoRequestModel;
import br.com.vxtel.falemais.adapters.controllers.response.SimulacaoResponseModel;

public interface SimulaChamadaUseCase {
    SimulacaoResponseModel execute(SimulacaoRequestModel simulacaoRequestModel);
}
