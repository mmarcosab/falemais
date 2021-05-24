package br.com.vxtel.falemais.domain.entities;

public class Simulacao {

    private String codigoOrigem;
    private String codigoDestino;
    private int tempoDeChamada;
    private int codigoPlano;
    private Double valorComPlano;
    private Double valorSemplano;

    public Simulacao() {
    }

    public Simulacao(String codigoOrigem, String codigoDestino, int tempoDeChamada, int codigoPlano, Double valorComPlano, Double valorSemplano) {
        this.codigoOrigem = codigoOrigem;
        this.codigoDestino = codigoDestino;
        this.tempoDeChamada = tempoDeChamada;
        this.codigoPlano = codigoPlano;
        this.valorComPlano = valorComPlano;
        this.valorSemplano = valorSemplano;
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

    public int getTempoDeChamada() {
        return tempoDeChamada;
    }

    public void setTempoDeChamada(int tempoDeChamada) {
        this.tempoDeChamada = tempoDeChamada;
    }

    public int getCodigoPlano() {
        return codigoPlano;
    }

    public void setCodigoPlano(int codigoPlano) {
        this.codigoPlano = codigoPlano;
    }

    public Double getValorComPlano() {
        return valorComPlano;
    }

    public void setValorComPlano(Double valorComPlano) {
        this.valorComPlano = valorComPlano;
    }

    public Double getValorSemplano() {
        return valorSemplano;
    }

    public void setValorSemplano(Double valorSemplano) {
        this.valorSemplano = valorSemplano;
    }



}
