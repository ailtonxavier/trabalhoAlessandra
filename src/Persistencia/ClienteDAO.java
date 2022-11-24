package Persistencia;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.PreparedStatement;

import Dominio.Cliente;

public class ClienteDAO {
    private Conexao conexaoClienteDao;
    private String RelatorioCliente = "select * from \"Cliente\"";
    private String BuscarCliente = "select * from \"Cliente\" where \"pk_cpf\"=?";
    
    public ClienteDAO(){
        conexaoClienteDao = new Conexao("postgres", "123", "jdbc:postgresql://localhost:5432/postgres");
    }
    //Buscando
    public Cliente buscar(int idaux){
        Cliente pessoa = null;
        try{
            conexaoClienteDao.conectar();
            PreparedStatement pesquisa = conexaoClienteDao.getConexao().prepareStatement(BuscarCliente);
            pesquisa.setInt(1,idaux);
            ResultSet rs = pesquisa.executeQuery();
            if(rs.next()){
                pessoa = new Cliente(rs.getInt("pk_cpf"),rs.getString("nome"),rs.getString("login"), rs.getString("senha"), rs.getBoolean("ativo"));
            }
            conexaoClienteDao.desconectar();
        }catch(Exception e) {
            System.out.println("Erro na busca");
        }
        return pessoa;

    }
    public ArrayList<Cliente> emitirRelatorioClientes(){
        Cliente pessoa;
        ArrayList<Cliente> lista = new ArrayList<Cliente>();
        try {
            conexaoClienteDao.conectar();
            Statement instrucao = conexaoClienteDao.getConexao().createStatement();
            ResultSet rs = instrucao.executeQuery(RelatorioCliente);
            while(rs.next()){
                pessoa = new Cliente(rs.getInt("pk_cpf"), rs.getString("nome"), rs.getString("senha"), rs.getString("login"), rs.getBoolean("ativo"));
                lista.add(pessoa);
            }
            conexaoClienteDao.desconectar();
        } catch (Exception e){
            System.out.println("Erro no relatorio");
        }
        return lista;
    }
}
