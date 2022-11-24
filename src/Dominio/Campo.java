package Dominio;

public class Campo {
    private int fk_pk_id_aluguel;
    private static final int valorHora = 50;
    private boolean ocupado;
    private int capacidade;

    public Campo(int fk_pk_id_aluguel, int valorHora, boolean ocupado, int capacidade){
        this.fk_pk_id_aluguel = fk_pk_id_aluguel;
        this.ocupado = ocupado;
        this.capacidade = capacidade;
    }

    //getters
    public int getFk_pk_id_aluguel() {return fk_pk_id_aluguel;}
    public static int getValorHora() {return valorHora;}
    public boolean isOcupado() {return ocupado;}
    public int getCapacidade() {return capacidade;}

    //setters
    public void setFk_pk_id_aluguel(int fk_pk_id_aluguel) {this.fk_pk_id_aluguel = fk_pk_id_aluguel;}
    public void setCapacidade(int capacidade) {this.capacidade = capacidade;}
    public void setOcupado(boolean ocupado) {this.ocupado = ocupado;}
}
