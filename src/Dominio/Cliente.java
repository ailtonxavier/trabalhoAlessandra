package Dominio;

public class Cliente {
    private int cpf;
    private String nome;
    private String login;
    private String senha;
    private boolean ativo;

    // Getters
    public int getCpf(){return cpf;}
    public String getNome(){return nome;}
    public String getLogin(){return login;}
    public String getSenha(){return senha;}
    public boolean getAtivo(){return ativo;}
    // Setters
    public void setCpf(int cpf){this.cpf = cpf;}
    public void setNome(String nome){this.nome = nome;}
    public void setLogin(String login){this.login = login;}
    public void setSenha(String senha){this.senha = senha;}
}
