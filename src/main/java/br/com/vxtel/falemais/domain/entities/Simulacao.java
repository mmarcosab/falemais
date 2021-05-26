package br.com.vxtel.falemais.domain.entities;

public class Simulacao {

    private String codigoOrigem;
    private String codigoDestino;
    private int tempoDeChamada;
    private int minutosPlano;
    private Double valorComPlano;
    private Double valorSemplano;

    public Simulacao(String codigoOrigem, String codigoDestino, int tempoDeChamada, int minutosPlano, Double valorComPlano, Double valorSemplano) {
        this.codigoOrigem = codigoOrigem;
        this.codigoDestino = codigoDestino;
        this.tempoDeChamada = tempoDeChamada;
        this.minutosPlano = minutosPlano;
        this.valorComPlano = valorComPlano;
        this.valorSemplano = valorSemplano;
    }

    public String getCodigoOrigem() {
        return codigoOrigem;
    }

    public String getCodigoDestino() {
        return codigoDestino;
    }

    public int getTempoDeChamada() {
        return tempoDeChamada;
    }

    public int getMinutosPlano() {
        return minutosPlano;
    }

    public Double getValorComPlano() {
        return valorComPlano;
    }

    public Double getValorSemPlano() {
        return valorSemplano;
    }

    public static Double calculaValorComPlano(double valorMinuto, int duracaoChamada, int minutosPlano){
        // Aqui deve-se retornar o valor da tarifa * tempo excedentes de cada plano. ROF06
        double percentual = 10.0/100.0;
        if(duracaoChamada <= minutosPlano) { //esta dentro do plano e nada a mais sera cobrado
            return 0.00;
        } else {
            return ((duracaoChamada - minutosPlano) * valorMinuto) + (((duracaoChamada - minutosPlano) * valorMinuto) * percentual);
        }
    }

    public static Double calculaValorSemPlano (double valorMinuto, int duracaoChamada) {
        //Aqui deve-se retornar apenas o valor da tarifa * tempo de duracao em minutos. RF07
        return valorMinuto * duracaoChamada;
    }




}
