package Dominio;
import Dominio.Cliente;
public class Aluguel {

    private String fk_cpf;
    private int id;
    private String data;
    private String hora;
    private int qtdHoras;
    private double valorTotal;

    public Aluguel(){

    }
    public Aluguel(String fk_cpf, int id, String data, int qtdHoras, double valorTotal){
        this.fk_cpf = fk_cpf;
        this.id = id;
        this.data = data;
        this.qtdHoras = qtdHoras;
        this.valorTotal = valorTotal;
    }

    //Getters
    public String getFk_cpf() {return fk_cpf;}
    public int getId() {return id;}
    public String getData() {return data;}
    public String getHora() {return hora;}
    public int getQtdHoras() {return qtdHoras;}
    public double getValorTotal() {return valorTotal;}

    //Setters
    public void setFk_cpf(String fk_cpf) {this.fk_cpf = fk_cpf;}
    public void setId(int id) {this.id = id;}
    public void setData(String data) {this.data = data;}
    public void setHora(String hora) {this.hora = hora;}
    public void setQtdHoras(int qtdHoras) {this.qtdHoras = qtdHoras;}
    public void setValorTotal(double valorTotal) {this.valorTotal = valorTotal;}
}
