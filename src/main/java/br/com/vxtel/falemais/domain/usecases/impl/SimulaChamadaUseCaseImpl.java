package br.com.vxtel.falemais.domain.usecases.impl;

import br.com.vxtel.falemais.adapters.controllers.request.SimulacaoRequestModel;
import br.com.vxtel.falemais.adapters.controllers.response.SimulacaoResponseModel;
import br.com.vxtel.falemais.adapters.presenters.SimulacaoPresenter;
import br.com.vxtel.falemais.domain.entities.Simulacao;
import br.com.vxtel.falemais.domain.factories.SimulacaoFactory;
import br.com.vxtel.falemais.domain.usecases.SimulaChamadaUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


@Slf4j
@Component
@RequiredArgsConstructor
public class SimulaChamadaUseCaseImpl implements SimulaChamadaUseCase {

    private final SimulacaoFactory simulacaoFactory;
    private final SimulacaoPresenter simulacaoPresenter;

    @Override
    public SimulacaoResponseModel execute(SimulacaoRequestModel simulacaoRequestModel) {
        try {
            Simulacao simulacao = simulacaoFactory.create(simulacaoRequestModel.getCodigoOrigem(),
                    simulacaoRequestModel.getCodigoDestino(),
                    simulacaoRequestModel.getDuracaoChamada(),
                    simulacaoRequestModel.getMinutosPlano(),
                    simulacaoRequestModel.getValorMinuto());

            SimulacaoResponseModel response = SimulacaoResponseModel.builder()
                    .codigoOrigem(simulacao.getCodigoOrigem())
                    .codigoDestino(simulacao.getCodigoDestino())
                    .minutosPlano(simulacao.getMinutosPlano())
                    .duracaoChamada(simulacao.getDuracaoChamada())
                    .valorComPlano(simulacao.getValorComPlano())
                    .valorSemPlano(simulacao.getValorSemPlano())
                    .build();

            return simulacaoPresenter.prepareSuccessView(response);
        } catch (Exception e){
            log.error("Um erro ocorreu ao processar a requisicao", simulacaoRequestModel);
            return simulacaoPresenter.prepareFailView(e.getMessage());
        }
    }

}
