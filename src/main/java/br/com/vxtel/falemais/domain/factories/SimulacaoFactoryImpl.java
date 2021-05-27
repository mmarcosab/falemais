package br.com.vxtel.falemais.domain.factories;

import br.com.vxtel.falemais.domain.entities.Simulacao;

public class SimulacaoFactoryImpl implements SimulacaoFactory {

    @Override
    public Simulacao create(String codigoOrigem, String codigoDestino, int duracaoChamada, int minutosPlano, double valorMinuto) throws Exception {
        return new Simulacao(codigoOrigem, codigoDestino, duracaoChamada, minutosPlano, valorMinuto);
    }

}
