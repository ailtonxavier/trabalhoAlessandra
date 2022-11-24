package Dominio;

public class Cliente {
    private int pk_cpf;
    private String nome;
    private String login;
    private String senha;
    private boolean ativo;

    //Construtor vazio
    public Cliente(){

    }


    public Cliente(int pk_cpf, String nome, String login, String senha, boolean ativo){
        this.pk_cpf = pk_cpf;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.ativo = ativo;
    }

    // Getters
    public int getPk_cpf(){return pk_cpf;}
    public String getNome(){return nome;}
    public String getLogin(){return login;}
    public String getSenha(){return senha;}
    public boolean getAtivo(){return ativo;}
    // Setters
    public void setPk_cpf(int pk_cpf){this.pk_cpf = pk_cpf;}
    public void setNome(String nome){this.nome = nome;}
    public void setLogin(String login){this.login = login;}
    public void setSenha(String senha){this.senha = senha;}
    public boolean isAtivo(boolean b) {return ativo; }
}
