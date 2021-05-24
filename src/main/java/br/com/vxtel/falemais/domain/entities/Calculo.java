package br.com.vxtel.falemais.domain.entities;


public enum Calculo {

    COM_PLANO,
    SEM_PLANO;

    public static Double apply (Calculo calculo, Tarifa tarifa, int duracaoChamada, Plano plano) throws Exception{
        switch (calculo){
            case COM_PLANO:
                return getValorComPlano(tarifa, duracaoChamada, plano);
            case SEM_PLANO:
                return getValorSemPlano(tarifa, duracaoChamada);
            default:
               throw new UnsupportedOperationException("Operacao nao implementada");
        }
    }

    private static Double getValorComPlano(Tarifa tarifa, int duracaoChamada, Plano plano){
        // Aqui deve-se retornar o valor da tarifa * tempo excedentes de cada plano. ROF06
        int minutosExcedentes = 0;
        if(duracaoChamada <= plano.getTempo()) { //esta dentro do plano e nada a mais sera cobrado
            return 0.00;
        } else {
            minutosExcedentes = duracaoChamada - plano.getTempo();
            return (minutosExcedentes * tarifa.getValorPorMinuto()) * 0.10;
        }
    }

    private static Double getValorSemPlano(Tarifa tarifa, int duracaoChamada){
        //Aqui deve-se retornar apenas o valor da tarifa * tempo de duracao em minutos. RF07
        return tarifa.getValorPorMinuto() * duracaoChamada;
    }


}
