package Persistencia;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class ClienteDAO {
    private Conexao conexaoContatoDao;
    private String REL = "select * from \"Cliente\"";
    private String BUS = "select * from \"Cliente\" where \"pk_cpf\"=?";

}
