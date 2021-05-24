package br.com.vxtel.falemais.adapters.controllers.model;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SimulacaoRequestModel {

    private String codigoOrigem;
    private String codigoDestino;
    private int codigoPlano;
    private int tempoChamada;

}
