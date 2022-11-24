package Persistencia;
import Dominio.Contato;
import Dominio.Endereco;
import Dominio.Cliente;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class EnderecoDAO {
    private Conexao conexaoEnderecoDao;
    private String BuscaEndereco = "select * from \"Endereco\" where \"pk_fk_cpf\"=?";

    public EnderecoDAO(){
        conexaoEnderecoDao = new Conexao("postgres","123","jdbc:postgresql://localhost:5432/postgres");
    }

    public Endereco buscar(int idaux){
        Endereco local = null;
        try{
            conexaoEnderecoDao.conectar();
            PreparedStatement pesquisa = conexaoEnderecoDao.getConexao().prepareStatement(BuscaEndereco);
            pesquisa.setInt(1,idaux);
            ResultSet rs = pesquisa.executeQuery();
            if(rs.next()){
                local = new Endereco(rs.getInt("pk_fk_cpf"),rs.getString("estado"),rs.getString("cidade"),rs.getString("bairro"),rs.getString("rua"),rs.getString("numero"));
            }
            conexaoEnderecoDao.desconectar();
        }catch(Exception e) {
            System.out.println("Erro na busca");
        }
        return local;

    }

}
