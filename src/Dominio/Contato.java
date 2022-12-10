package Dominio;

import Persistencia.ContatoDAO;

public class Contato {
    private ContatoDAO contatoDAO;
    private String pk_fk_cpf;
    private String email;
    private String celular;
    private String telFixo;
    private String telComercial;

    public Contato(){
        contatoDAO = new ContatoDAO();
    }



    public Contato(String pk_fk_cpf, String email, String celular, String telFixo, String telComercial) {
        this.pk_fk_cpf = pk_fk_cpf;
        this.email = email;
        this.celular = celular;
        this.telFixo = telFixo;
        this.telComercial = telComercial;
        contatoDAO = new ContatoDAO();
    }

    // Getters
    public String getPk_fk_cpf() {return pk_fk_cpf;}
    public String getEmail() { return email; }
    public String getCelular() { return celular; }
    public String getTelFixo() {return telFixo; }
    public String getTelComercial() {return telComercial; }

    // Setters
    public void setPk_fk_cpf(String pk_fk_cpf) {this.pk_fk_cpf = pk_fk_cpf;}
    public void setEmail(String email) {this.email = email; }
    public void setCelular(String celular) {this.celular = celular; }
    public void setTelFixo(String telFixo) {this.telFixo = telFixo; }
    public void setTelComercial(String telComercial) {this.telComercial = telComercial; }

    // DAO

    public void insertContatoDAO(Contato contato){
        contatoDAO.setInserir(contato);
    }
    public void deleteContatoDAO(String cpf){
        contatoDAO.excluir(cpf);
    }
    public void updateContatoDAO(Contato contato){
        contatoDAO.setAlterar(contato);
    }
    public Contato queryContatoDAO(String cpf){
        return contatoDAO.getContato(cpf);
    }
}