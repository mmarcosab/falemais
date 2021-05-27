package br.com.vxtel.falemais.domain.entities;

public class Simulacao implements ISimulacao{

    private String codigoOrigem;
    private String codigoDestino;
    private int duracaoChamada;
    private int minutosPlano;
    private double valorMinuto;
    private Double valorComPlano;
    private Double valorSemPlano;

    public Simulacao(String codigoOrigem, String codigoDestino, int duracaoChamada, int minutosPlano, double valorMinuto) throws Exception {
        validarCampos(codigoOrigem, codigoDestino, duracaoChamada, minutosPlano);
        this.codigoOrigem = codigoOrigem;
        this.codigoDestino = codigoDestino;
        this.duracaoChamada = duracaoChamada;
        this.minutosPlano = minutosPlano;
        this.valorMinuto = valorMinuto;
        this.valorComPlano = calcularComPlano(this.valorMinuto, this.duracaoChamada, this.minutosPlano);
        this.valorSemPlano = calcularSemPlano(this.valorMinuto, this.duracaoChamada);
    }

    public String getCodigoOrigem() {
        return codigoOrigem;
    }

    public String getCodigoDestino() {
        return codigoDestino;
    }

    public int getDuracaoChamada() {
        return duracaoChamada;
    }

    public int getMinutosPlano() {
        return minutosPlano;
    }

    public Double getValorComPlano() {
        return valorComPlano;
    }

    public Double getValorSemPlano() {
        return valorSemPlano;
    }

    public double calcularComPlano(double valorMinuto, int duracaoChamada, int minutosPlano){
        // Aqui deve-se retornar o valor da tarifa * tempo excedentes de cada plano. ROF06
        double percentual = 10.0/100.0;
        if(duracaoChamada <= minutosPlano) { //esta dentro do plano e nada a mais sera cobrado
            return 0.00;
        } else {
            return ((duracaoChamada - minutosPlano) * valorMinuto) + (((duracaoChamada - minutosPlano) * valorMinuto) * percentual);
        }
    }

    public double calcularSemPlano (double valorMinuto, int duracaoChamada) {
        //Aqui deve-se retornar apenas o valor da tarifa * tempo de duracao em minutos. RF07
        return valorMinuto * duracaoChamada;
    }


    public void validarCampos(String codigoOrigem, String codigoDestino, int duracaoChamada, int minutosPlano) throws Exception {
        if(codigoOrigem == null || codigoOrigem.isEmpty()) {
            throw new Exception("Codigo de origem nulo ou vazio");
        }
        if(codigoDestino == null || codigoDestino.isEmpty()) {
            throw new Exception("Codigo de destino nulo ou vazio");
        }
        if(duracaoChamada < 1) {
            throw new Exception("Duracao da chamada invalida");
        }
        if(minutosPlano < 1) {
            throw new Exception("O campo minutos do plano esta invalido");
        }
    }

}
