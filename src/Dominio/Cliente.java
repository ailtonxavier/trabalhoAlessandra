package Dominio;

import Persistencia.AluguelDAO;
import Persistencia.ClienteDAO;
import Persistencia.ContatoDAO;
import Persistencia.EnderecoDAO;

import java.util.ArrayList;

public class Cliente {
    AluguelDAO aluguelDAO = new AluguelDAO();
    EnderecoDAO enderecoDAO = new EnderecoDAO();
    ContatoDAO contatoDAO = new ContatoDAO();
    ClienteDAO clienteDAO = new ClienteDAO();
    Cliente cliente;
    private String pk_cpf;
    private String nome;
    private String login;
    private String senha;
    private boolean ativo;
    private Endereco endereco;
    private Contato contato;
    private ArrayList<Aluguel> alugueis;

    public Cliente(){
        endereco = new Endereco();
        contato = new Contato();
        alugueis = new ArrayList<>();
    }
    public Cliente(String pk_cpf, String nome, String login, String senha, boolean ativo){
        this.pk_cpf = pk_cpf;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.ativo = ativo;
        alugueis = new ArrayList<>();
        contato = new Contato();
        endereco = new Endereco();
    }

    // Getters
    public String getPk_cpf(){return pk_cpf;}
    public String getNome(){return nome;}
    public String getLogin(){return login;}
    public String getSenha(){return senha;}
    public boolean getAtivo(){return ativo;}
    public Endereco getEndereco(){return endereco;}
    public Contato getContato(){return contato;}
    public ArrayList<Aluguel> getAlugueis(){return alugueis;}
    // Setters
    public void setPk_cpf(String pk_cpf){this.pk_cpf = pk_cpf;}
    public void setNome(String nome){this.nome = nome;}
    public void setLogin(String login){this.login = login;}
    public void setSenha(String senha){this.senha = senha;}
    public void setAtivo(boolean ativo) {this.ativo = ativo;}
    public void setAlugueis(ArrayList<Aluguel> alugueis){
        this.alugueis = alugueis;
    }
    // ClientesDAO
    public void setClienteDAO(Cliente cliente){
        this.cliente = cliente;
        clienteDAO.setInserir(this.cliente);
    }
    public void excluirClienteDAO(String pk_cpf){
        clienteDAO.excluir(pk_cpf);
    }
    // EnderecoDAO
    public void setEnderecoDAO(Endereco endereco){
        this.endereco = endereco;
        enderecoDAO.setInserir(this.endereco);
    }
    // AluguelDAO
    public void setContatoDAO(Contato contato){
        this.contato = contato;
        contatoDAO.setInserir(contato);
    }
    // ContatoDAO
    public void excluirContatoDAO(String pk_cpf){
        contatoDAO.excluir(pk_cpf);
    }
    public void excluirAluguelDAO(String pk_cpf){
        aluguelDAO.excluir(pk_cpf);
    }
    public void excluirEnderecoDAO(String pk_cpf){
        enderecoDAO.excluir(pk_cpf);
    }
    public int getTamanhoLista(){return alugueis.size();}
}
