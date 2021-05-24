package br.com.vxtel.falemais.domain.entities;

public enum Plano {

    FALEMAIS30(1, 30),
    FALEMAIS60(2, 60),
    FALEMAIS120(3, 120);

    private int codigo;
    private int tempo;

    Plano(int codigo, int tempo){
        this.codigo = codigo;
        this.tempo = tempo;
    }

    public int getCodigo() {
        return codigo;
    }

    public int getTempo() {
        return tempo;
    }
}
