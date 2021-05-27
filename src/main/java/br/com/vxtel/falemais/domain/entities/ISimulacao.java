package br.com.vxtel.falemais.domain.entities;

public interface ISimulacao {

    String getCodigoOrigem();
    String getCodigoDestino();
    int getDuracaoChamada();
    int getMinutosPlano();
    Double getValorComPlano();
    Double getValorSemPlano();

}
