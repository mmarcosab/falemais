package br.com.vxtel.falemais.adapters.controllers.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Builder
@ToString
@EqualsAndHashCode
public class SimulacaoResponseModel {

    @JsonProperty("codigo_origem")
    private String codigoOrigem;

    @JsonProperty("codigo_destino")
    private String codigoDestino;

    @JsonProperty("duracao_chamada")
    private int duracaoChamada;

    @JsonProperty("minutos_plano")
    private int minutosPlano;

    @JsonProperty("valor_com_plano")
    private Double valorComPlano;

    @JsonProperty("valor_sem_plano")
    private Double valorSemplano;

}
