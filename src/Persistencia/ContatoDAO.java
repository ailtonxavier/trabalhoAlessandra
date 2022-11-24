package Persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Dominio.Cliente;
import Dominio.Contato;

public class ContatoDAO {
    private Conexao conexaoContatoDao;
    private String RelatorioContatos = "select * from \"Contato\"";
    private String BuscaContatos = "select * from \"Contato\" where \"pk_fk_cpf\"=?";

    public ContatoDAO(){
        conexaoContatoDao = new Conexao("postgres","123","jdbc:postgresql://localhost:5432/postgres");
    }

    public Contato buscar(int idaux){
        Contato contato = null;
        try{
            conexaoContatoDao.conectar();
            PreparedStatement pesquisa = conexaoContatoDao.getConexao().prepareStatement(BuscaContatos);
            pesquisa.setInt(1,idaux);
            ResultSet rs = pesquisa.executeQuery();
            if(rs.next()){
                contato = new Contato(rs.getInt("pk_fk_cpf"),rs.getString("email"),rs.getString("celular"),rs.getString("telFixo"),rs.getString("telComercial"));
            }
            conexaoContatoDao.desconectar();
        }catch(Exception e) {
            System.out.println("Erro na busca");
        }
        return contato;

    }

    public ArrayList<Contato> emitirRelatorioContatos(){
        Contato pessoa;
        ArrayList<Contato> lista = new ArrayList<Contato>();
        try {
            conexaoContatoDao.conectar();
            Statement instrucao = conexaoContatoDao.getConexao().createStatement();
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