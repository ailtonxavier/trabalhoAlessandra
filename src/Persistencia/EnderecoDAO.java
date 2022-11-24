package Persistencia;
import Dominio.Endereco;
import Dominio.Cliente;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class EnderecoDAO {
    private Conexao conexaoEnderecoDao;

    public EnderecoDAO(){
        conexaoEnderecoDao = new Conexao("postgres","123","jdbc:postgresql://localhost:5432/postgres");
    }

}
