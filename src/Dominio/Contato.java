package Dominio;
import Dominio.Cliente;

public class Contato {
    private String pk_fk_cpf;
    private String email;
    private String celular;
    private String telFixo;
    private String telComercial;

    public Contato(){

    }



    public Contato(String pk_fk_cpf, String email, String celular, String telFixo, String telComercial) {
        this.pk_fk_cpf = pk_fk_cpf;
        this.email = email;
        this.celular = celular;
        this.telFixo = telFixo;
        this.telComercial = telComercial;
    }

    // Getters
    public String getPk_fk_cpf() {return pk_fk_cpf;}
    public String getEmail() { return email; }
    public String getCelular() { return celular; }
    public String getTelFixo() {return telFixo; }
    public String getTelComercial() {return telComercial; }

    //Setters
    public void setPk_fk_cpf(String pk_fk_cpf) {this.pk_fk_cpf = pk_fk_cpf;}
    public void setEmail(String email) {this.email = email; }
    public void setCelular(String celular) {this.celular = celular; }
    public void setTelFixo(String telFixo) {this.telFixo = telFixo; }
    public void setTelComercial(String telComercial) {this.telComercial = telComercial; }
}