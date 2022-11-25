package Dominio;

import Dominio.Cliente;

public class Aluguel {
    private int fk_cpf;
    private int id;
    private String data;
    private int qtdHoras;
    private double valorTotal;

    public Aluguel(){

    }

    public Aluguel(int fk_cpf, int id, String data, int qtdHoras, double valorTotal){
        this.fk_cpf = fk_cpf;
        this.id = id;
        this.data = data;
        this.qtdHoras = qtdHoras;
        this.valorTotal = valorTotal;
    }

    //Getters
    public int getFk_cpf() {return fk_cpf;}
    public int getId() {return id;}
    public String getData() {return data;}
    public int getQtdHoras() {return qtdHoras;}
    public double getValorTotal() {return valorTotal;}

    //Setters
    public void setFk_cpf(int fk_cpf) {this.fk_cpf = fk_cpf;}
    public void setId(int id) {this.id = id;}
    public void setData(String data) {this.data = data;}
    public void setQtdHoras(int qtdHoras) {this.qtdHoras = qtdHoras;}
    public void setValorTotal(double valorTotal) {this.valorTotal = valorTotal;}
}
