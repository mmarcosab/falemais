package br.com.vxtel.falemais.domain.entities;

public class Tarifa {

    private String codigoOrigem;
    private String codigoDestino;
    private Double valorPorMinuto;

    public Tarifa() {
    }

    public Tarifa(String codigoOrigem, String codigoDestino, Double valorPorMinuto) {
        this.codigoOrigem = codigoOrigem;
        this.codigoDestino = codigoDestino;
        this.valorPorMinuto = valorPorMinuto;
    }

    public String getCodigoOrigem() {
        return codigoOrigem;
    }

    public void setCodigoOrigem(String codigoOrigem) {
        this.codigoOrigem = codigoOrigem;
    }

    public String getCodigoDestino() {
        return codigoDestino;
    }

    public void setCodigoDestino(String codigoDestino) {
        this.codigoDestino = codigoDestino;
    }

    public Double getValorPorMinuto() {
        return valorPorMinuto;
    }

    public void setValorPorMinuto(Double valorPorMinuto) {
        this.valorPorMinuto = valorPorMinuto;
    }

}
