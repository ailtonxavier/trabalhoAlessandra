package Persistencia;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import Dominio.Cliente;

public class ClienteDAO {
    private Conexao conexaoClienteDAO;
    private String relatorio = "select * from cliente";
    private String inserir = "insert into cliente (pk_cpf,nome,login,senha,ativo) values (?,?,?,?,?)";
    private String buscar = "select * from cliente where pk_cpf = ?";
    private String alterar = "update cliente set pk_cpf = ?, nome = ?, login = ?, senha = ?, ativo = ? where pk_cpf = ?";
    private String deletar = "delete from cliente where pk_cpf = ?";

    public ClienteDAO(){
        conexaoClienteDAO = new Conexao("jdbc:postgresql://localhost:5432/BDSolo", "postgres", "123");
    }

    public Cliente getCliente(String pk_cpf){
        Cliente pessoa = null;
        try {
            conexaoClienteDAO.conectar();
            PreparedStatement instrucao = conexaoClienteDAO.getConexao().prepareStatement(buscar);
            instrucao.setString(1, pk_cpf);
            ResultSet rs = instrucao.executeQuery();
            if(rs.next()){
                pessoa = new Cliente(rs.getString("pk_cpf"), rs.getString("nome"), rs.getString("login"), rs.getString("senha"), rs.getBoolean("ativo"));
            }
            conexaoClienteDAO.desconectar();
        } catch (Exception e) {
            System.out.println("Erro na busca: " + e.getMessage());
        }
        return pessoa;
    }
    public void setInserir(Cliente pessoa){
        try {
            conexaoClienteDAO.conectar();
            PreparedStatement instrucao = conexaoClienteDAO.getConexao().prepareStatement(inserir);
            instrucao.setString(1, pessoa.getPk_cpf());
            instrucao.setString(2, pessoa.getNome());
            instrucao.setString(3, pessoa.getLogin());
            instrucao.setString(4, pessoa.getSenha());
            instrucao.setBoolean(5, pessoa.getAtivo());
            instrucao.execute();
            conexaoClienteDAO.desconectar();
        } catch (Exception e){
            System.out.println("Erro na inclusão: " + e.getMessage());
        }
    }
    public ArrayList<Cliente> getRelatorio(){
        Cliente pessoa;
        ArrayList<Cliente> lista = new ArrayList<Cliente>();
        try{
            conexaoClienteDAO.conectar();
            Statement instrucao = conexaoClienteDAO.getConexao().createStatement();
            ResultSet rs = instrucao.executeQuery(relatorio);
            while(rs.next()){
                pessoa = new Cliente(rs.getString("pk_cpf"), rs.getString("nome"), rs.getString("login"), rs.getString("senha"), rs.getBoolean("ativo"));
                lista.add(pessoa);
            }
            conexaoClienteDAO.desconectar();
        } catch (Exception e){
            System.out.println("Erro no relatorio" + e.getMessage());
        }
        return lista;
    }
    public void setAlterar(Cliente pessoa){
        try {
            conexaoClienteDAO.conectar();
            PreparedStatement instrucao = conexaoClienteDAO.getConexao().prepareStatement(alterar);
            instrucao.setString(1, pessoa.getPk_cpf());
            instrucao.setString(2, pessoa.getNome());
            instrucao.setString(3, pessoa.getLogin());
            instrucao.setString(4, pessoa.getSenha());
            instrucao.setBoolean(5, pessoa.getAtivo());
            instrucao.setString(6, pessoa.getPk_cpf());
            instrucao.execute();
            conexaoClienteDAO.desconectar();
        } catch (Exception e){
            System.out.println("Erro na alteração: " + e.getMessage());
        }
    }
    public void excluir(String pk_cpf){
        try {
            conexaoClienteDAO.conectar();
            PreparedStatement instrucao = conexaoClienteDAO.getConexao().prepareStatement(deletar);
            instrucao.setString(1, pk_cpf);
            instrucao.execute();
            conexaoClienteDAO.desconectar();
        } catch (Exception e){
            System.out.println("Erro na exclusão: " + e.getMessage());
        }
    }
}
