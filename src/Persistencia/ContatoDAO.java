package Persistencia;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Dominio.Contato;

public class ContatoDAO {
    private Conexao conexaoContatoDao;
    private String RelatorioContatos = "select * from \"Contato\"";
    private String BuscaContatos = "select * from \"Contato\" where \"pk_fk_cpf\"=?";

    public ContatoDAO(){
        conexaoContatoDao = new Conexao("postgres","123","jdbc:postgresql://localhost:5432/postgres");
    }

    public ArrayList<Contato> emitirRelatorioContatos(){
        Contato pessoa;
        ArrayList<Contato> lista = new ArrayList<Contato>();
        try {
            conexaoContatoDao.conectar();
            Statement instrucao = conexaoClienteDao.getConexao().createStatement();
            ResultSet rs = instrucao.executeQuery(RelatorioContatos);
            while(rs.next()){
                pessoa = new Contato(rs.getInt("pk_fk_cpf"),rs.getString("email"), rs.getString("telefone"), rs.getString("telFixo"), rs.getString("telComercial"));
                lista.add(pessoa);
            }
            conexaoContatoDao.desconectar();
        } catch (Exception e){
            System.out.println("Erro no relatorio de Contatos");
        }
        return lista;
    }
}