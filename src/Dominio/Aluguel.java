package Dominio;

import Persistencia.AluguelDAO;
import java.util.ArrayList;

public class Aluguel {
    private AluguelDAO aluguelDAO;
    private ArrayList<Aluguel> alugueis;
    private String fk_cpf;
    private int id;
    private String data;
    private String dataDaReserva;
    private String hora;
    private String horaDaReserva;
    private int qtdHoras;
    private double valorTotal;

    public Aluguel(){
        alugueis = new ArrayList<Aluguel>();
        aluguelDAO = new AluguelDAO();
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
        alugueis = new ArrayList<Aluguel>();
        aluguelDAO = new AluguelDAO();
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

    //Setters
    public void setFk_cpf(String fk_cpf) {this.fk_cpf = fk_cpf;}
    public void setId(int id) {this.id = id;}
    public void setData(String data) {this.data = data;}

    public void setDataDaReserva(String dataDaReserva) {this.dataDaReserva = dataDaReserva;}

    public void setHora(String hora) {this.hora = hora;}

    public void setHoraDaReserva(String horaDaReserva) {this.horaDaReserva = horaDaReserva;}

    public void setQtdHoras(int qtdHoras) {this.qtdHoras = qtdHoras;}
    public void setValorTotal(double valorTotal) {this.valorTotal = valorTotal;}

    public void insertAluguel(Aluguel aluguel){
        aluguelDAO.setInserir(aluguel);
    }
    public void deleteAluguel(String cpf){
        aluguelDAO.excluir(cpf);
    }
    public void deleteAluguel(int id){
        aluguelDAO.excluir(id);
    }
    public void queryAluguel(String cpf){
        aluguelDAO.getAluguelPorCpf(cpf);
    }
    public ArrayList<Aluguel> queryAlugueis(){
        return alugueis = aluguelDAO.getRelatorio();
    }
}
