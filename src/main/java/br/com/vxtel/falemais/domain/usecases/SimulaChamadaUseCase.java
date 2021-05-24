package br.com.vxtel.falemais.domain.usecases;

import br.com.vxtel.falemais.adapters.controllers.model.SimulacaoRequestModel;
import br.com.vxtel.falemais.adapters.controllers.model.SimulacaoResponseModel;

public interface SimulaChamadaUseCase {
    SimulacaoResponseModel execute(SimulacaoRequestModel simulacaoRequestModel);
}
