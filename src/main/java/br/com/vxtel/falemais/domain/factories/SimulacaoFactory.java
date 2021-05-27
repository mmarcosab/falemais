package br.com.vxtel.falemais.domain.factories;

import br.com.vxtel.falemais.domain.entities.Simulacao;

public interface SimulacaoFactory {
    Simulacao create(String codigoOrigem,
                     String codigoDestino,
                     int duracaoChamada,
                     int minutosPlano,
                     double valorMinuto) throws Exception;

}
