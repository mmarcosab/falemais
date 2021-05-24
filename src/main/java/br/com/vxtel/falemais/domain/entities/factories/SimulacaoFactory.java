package br.com.vxtel.falemais.domain.entities.factories;

import br.com.vxtel.falemais.domain.entities.Simulacao;

public interface SimulacaoFactory {
    Simulacao create(String codigoOrigem,
                     String codigoDestino,
                     int tempoChamada,
                     int codigoPlano,
                     Double valorComPlano,
                     Double valorSemPlano);
}
