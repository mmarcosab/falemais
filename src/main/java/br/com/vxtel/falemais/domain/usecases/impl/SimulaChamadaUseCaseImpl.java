package br.com.vxtel.falemais.domain.usecases.impl;

import br.com.vxtel.falemais.adapters.controllers.request.SimulacaoRequestModel;
import br.com.vxtel.falemais.adapters.controllers.response.SimulacaoResponseModel;
import br.com.vxtel.falemais.domain.entities.Simulacao;
import br.com.vxtel.falemais.domain.entities.factories.SimulacaoFactory;
import br.com.vxtel.falemais.domain.usecases.SimulaChamadaUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SimulaChamadaUseCaseImpl implements SimulaChamadaUseCase {

    private final SimulacaoFactory simulacaoFactory;

    @Override
    public SimulacaoResponseModel execute(SimulacaoRequestModel simulacaoRequestModel) {

        // Passo 1: Calcular valor da chamada com plano
        double valorComPlano = Simulacao.calculaValorComPlano(simulacaoRequestModel.getValorMinuto(),
                                                              simulacaoRequestModel.getDuracaoChamada(),
                                                              simulacaoRequestModel.getMinutosPlano());

        // Passo 2: Calcular valor da chamada sem plano
        double valorSemPlano = Simulacao.calculaValorSemPlano(simulacaoRequestModel.getValorMinuto(), simulacaoRequestModel.getDuracaoChamada());


        // Passo 3: Converter em uma entidade de negocio
        Simulacao simulacao =simulacaoFactory.create(simulacaoRequestModel.getCodigoOrigem(),
                                                     simulacaoRequestModel.getCodigoDestino(),
                                                     simulacaoRequestModel.getDuracaoChamada(),
                                                     simulacaoRequestModel.getMinutosPlano(),
                                                     valorComPlano,
                                                     valorSemPlano);

        // Passo 4: Montar resposta
        return SimulacaoResponseModel.builder()
                .codigoOrigem(simulacao.getCodigoOrigem())
                .codigoDestino(simulacao.getCodigoDestino())
                .minutosPlano(simulacao.getMinutosPlano())
                .duracaoChamada(simulacao.getTempoDeChamada())
                .valorComPlano(simulacao.getValorComPlano())
                .valorSemplano(simulacao.getValorSemPlano())
                .build();
    }

}
