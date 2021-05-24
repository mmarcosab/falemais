package br.com.vxtel.falemais.domain.entities.factories;

import br.com.vxtel.falemais.domain.entities.Simulacao;

public class SimulacaoFactoryImpl implements SimulacaoFactory {

    @Override
    public Simulacao create(String codigoOrigem, String codigoDestino, int tempoChamada, int codigoPlano, Double valorComPlano, Double valorSemPlano) {
        return new Simulacao(codigoOrigem, codigoDestino, tempoChamada, codigoPlano, valorComPlano, valorSemPlano);
    }

}
