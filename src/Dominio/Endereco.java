package Dominio;

import Persistencia.EnderecoDAO;

public class Endereco {
    private EnderecoDAO enderecoDAO;
    private String pk_fk_cpf;
    private String estado;
    private String cidade;
    private String bairro;
    private String rua;
    private String numero;

    public Endereco(){
        enderecoDAO = new EnderecoDAO();
    }

    public Endereco(String pk_fk_cpf, String estado, String cidade, String bairro, String rua, String numero) {
        this.pk_fk_cpf = pk_fk_cpf;
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
        enderecoDAO = new EnderecoDAO();
    }
    //Getters
    public String getPk_fk_cpf() {return pk_fk_cpf; }
    public String getEstado() {return estado; }
    public String getCidade() {return cidade; }
    public String getBairro() {return bairro; }
    public String getRua() {return rua; }
    public String getNumero() {return numero; }

    //Setters
    public void setPk_fk_cpf(String pk_fk_cpf) {this.pk_fk_cpf = pk_fk_cpf;}
    public void setEstado(String estado) {this.estado = estado;}
    public void setCidade(String cidade) {this.cidade = cidade;}
    public void setBairro(String bairro) {this.bairro = bairro;}
    public void setRua(String rua) {this.rua = rua;}
    public void setNumero(String numero) {this.numero = numero;}

    public void insertEnderecoDAO(Endereco endereco){
        enderecoDAO.setInserir(endereco);
    }
    public void deleteEnderecoDAO(String cpf){
        enderecoDAO.excluir(cpf);
    }
    public void updateEnderecoDAO(Endereco endereco){
        enderecoDAO.setAlterar(endereco);
    }
    public Endereco queryEnderecoDAO(String cpf){
        return enderecoDAO.getEndereco(cpf);
    }
}
