package br.com.vxtel.falemais.domain.entities;

public interface ISimulacao {

    String getCodigoOrigem();
    String getCodigoDestino();
    int getTempoDeChamada();
    int getCodigoPlano();
    Double getValorComPlano();
    Double getValorSemplano();

}
