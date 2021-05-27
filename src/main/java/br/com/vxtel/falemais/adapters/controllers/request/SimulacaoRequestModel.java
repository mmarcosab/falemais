package br.com.vxtel.falemais.adapters.controllers.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SimulacaoRequestModel {

    @JsonProperty("codigo_origem")
    private String codigoOrigem;

    @JsonProperty("codigo_destino")
    private String codigoDestino;

    @JsonProperty("valor_minuto")
    private double valorMinuto;

    @JsonProperty("minutos_plano")
    private int minutosPlano;

    @JsonProperty("duracao_chamada")
    private int duracaoChamada;

}
