package Dominio;

public class Cliente {
    private String pk_cpf;
    private String nome;
    private String login;
    private String senha;
    private boolean ativo;


    public Cliente(){

    }
    public Cliente(String pk_cpf, String nome, String login, String senha, boolean ativo){
        this.pk_cpf = pk_cpf;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.ativo = ativo;
    }

    // Getters
    public String getPk_cpf(){return pk_cpf;}
    public String getNome(){return nome;}
    public String getLogin(){return login;}
    public String getSenha(){return senha;}
    public boolean getAtivo(){return ativo;}
    // Setters
    public void setPk_cpf(String pk_cpf){this.pk_cpf = pk_cpf;}
    public void setNome(String nome){this.nome = nome;}
    public void setLogin(String login){this.login = login;}
    public void setSenha(String senha){this.senha = senha;}
    public void setAtivo(boolean ativo) {this.ativo = ativo;}
}
