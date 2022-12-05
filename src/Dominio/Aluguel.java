package Dominio;

import java.util.ArrayList;

public class Aluguel {
    private String fk_cpf;
    private int id;
    private String data;
    private String dataDaReserva;
    private String hora;
    private String horaDaReserva;
    private int qtdHoras;
    private double valorTotal;
    private ArrayList<Cliente> clientes;

    public Aluguel(){

    }
    public Aluguel(String fk_cpf, int id, String data, String dataDaReserva, String hora, String horaDaReserva,int qtdHoras, double valorTotal){
        this.fk_cpf = fk_cpf;
        this.id = id;
        this.data = data;
        this.dataDaReserva = dataDaReserva;
        this.hora = hora;
        this.horaDaReserva = horaDaReserva;
        this.qtdHoras = qtdHoras;
        this.valorTotal = valorTotal;
    }

    //Getters
    public String getFk_cpf() {return fk_cpf;}
    public int getId() {return id;}
    public String getData() {return data;}

    public String getDataDaReserva() {return dataDaReserva;}

    public String getHora() {return hora;}
    public String getHoraDaReserva(){return horaDaReserva;}
    public int getQtdHoras() {return qtdHoras;}
    public double getValorTotal() {return valorTotal;}
    public ArrayList<Cliente> getClientes(){return clientes;}

    //Setters
    public void setFk_cpf(String fk_cpf) {this.fk_cpf = fk_cpf;}
    public void setId(int id) {this.id = id;}
    public void setData(String data) {this.data = data;}

    public void setDataDaReserva(String dataDaReserva) {this.dataDaReserva = dataDaReserva;}

    public void setHora(String hora) {this.hora = hora;}

    public void setHoraDaReserva(String horaDaReserva) {this.horaDaReserva = horaDaReserva;}

    public void setQtdHoras(int qtdHoras) {this.qtdHoras = qtdHoras;}
    public void setValorTotal(double valorTotal) {this.valorTotal = valorTotal;}
    public void setClientes(ArrayList<Cliente> clientes){this.clientes = clientes;}
}
