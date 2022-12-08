package Dominio;

import Persistencia.AluguelDAO;
import Persistencia.ClienteDAO;
import Persistencia.ContatoDAO;
import Persistencia.EnderecoDAO;

import java.util.ArrayList;

public class Cliente {
    private AluguelDAO aluguelDAO = new AluguelDAO();
    private EnderecoDAO enderecoDAO = new EnderecoDAO();
    private ContatoDAO contatoDAO = new ContatoDAO();
    private ClienteDAO clienteDAO = new ClienteDAO();
    private Aluguel aluguel;
    private Cliente cliente;
    private String pk_cpf;
    private String nome;
    private String login;
    private String senha;
    private boolean ativo;
    private Endereco endereco;
    private Contato contato;
    private ArrayList<Cliente> clientes;
    private ArrayList<Aluguel> alugueis;

    public Cliente(){
        endereco = new Endereco();
        contato = new Contato();
        alugueis = new ArrayList<>();
        aluguel = new Aluguel();
    }
    public Cliente(String pk_cpf, String nome, String login, String senha, boolean ativo){
        this.pk_cpf = pk_cpf;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.ativo = ativo;
        aluguel = new Aluguel();
        alugueis = new ArrayList<Aluguel>();
        contato = new Contato();
        endereco = new Endereco();
        cliente = new Cliente();
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

    // EnderecoDAO
    public int getTamanhoLista(){return alugueis.size();}

    // ########## CLIENTE ##########
    public void insertCliente(Cliente cliente){
        this.clienteDAO.setInserir(cliente);
    }
    public void deleteCliente(String cpf){
        this.clienteDAO.excluir(cpf);
    }
    public void updateCliente(Cliente cliente){
        this.clienteDAO.setAlterar(cliente);
    }
    public Cliente queryCliente(String cpf){
        return this.clienteDAO.getCliente(cpf);
    }
    public ArrayList<Cliente> queryClientes(){
        return this.clienteDAO.getRelatorio();
    }
    // ########## CONTATO ##########
    public void insertContato(Contato contato){
        this.contato.insertContatoDAO(contato);
    }
    public void deleteContato(String cpf){
        this.contato.deleteContatoDAO(cpf);
    }
    public void updateContato(Contato contato){
        this.contato.updateContatoDAO(contato);
    }
    public void queryContato(String cpf){
        this.contato.queryContatoDAO(cpf);
    }
    // ########## ENDEREÇO ##########
    public void insertEndereco(Endereco endereco){
        this.endereco.insertEnderecoDAO(endereco);
    }
    public void deleteEndereco(String cpf){
        this.endereco.deleteEnderecoDAO(cpf);
    }
    public void updateEndereco(Endereco endereco){
        this.endereco.updateEnderecoDAO(endereco);
    }
    public void queryEndereco(String cpf){
        this.endereco.queryEnderecoDAO(cpf);
    }
    // ########## ALUGUEL ##########
    public void inserAluguel(Aluguel aluguel){
        this.aluguel.insertAluguel(aluguel);
    }
    public void deleteAluguel(String cpf){
        this.aluguel.deleteAluguel(cpf);
    }
    public void queryAluguelPorCpf(String cpf){
        this.aluguel.queryAluguel(cpf);
    }
    public void deleteAluguelPorID(int id){
        this.aluguel.deleteAluguel(id);
    }
    public ArrayList<Aluguel> queryAlugueis(){
        return this.aluguel.queryAlugueis();
    }
}
