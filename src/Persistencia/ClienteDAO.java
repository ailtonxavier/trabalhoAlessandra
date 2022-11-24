package Persistencia;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Dominio.Cliente;

public class ClienteDAO {
    private Conexao conexaoClienteDao;
    private String RelatorioCliente = "select * from \"Cliente\"";
    private String BUS = "select * from \"Cliente\" where \"pk_cpf\"=?";
    
    public ClienteDAO(){
        conexaoClienteDao = new Conexao("postgres", "123", "jdbc:postgresql://localhost:5432/postgres");
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
