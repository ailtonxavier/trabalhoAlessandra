package Dominio;

public class Campo {
    private int fk_pk_idAluguel;
    private static final int valorHora = 50;
    private boolean ocupado;
    private int capacidade;

    public Campo(int fk_pk_idAluguel, int valorHora, boolean ocupado, int capacidade){
        this.fk_pk_idAluguel = fk_pk_idAluguel;
        this.ocupado = ocupado;
        this.capacidade = capacidade;
    }

    //getters
    public int getFk_pk_idAluguel() {return fk_pk_idAluguel;}
    public static int getValorHora() {return valorHora;}
    public boolean isOcupado() {return ocupado;}
    public int getCapacidade() {return capacidade;}

    //setters
    public void setFk_pk_idAluguel(int fk_pk_idAluguel) {this.fk_pk_idAluguel = fk_pk_idAluguel;}
    public void setCapacidade(int capacidade) {this.capacidade = capacidade;}
    public void setOcupado(boolean ocupado) {this.ocupado = ocupado;}
}
