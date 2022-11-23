package Persistencia;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Dominio.Aluguel;

public class AluguelDAO {
    private Conexao conexaoAluguelDao;
    private String RelatorioAluguel = "select * from \"Aluguel\"";
    private String BuscarAluguel = "select * from \"Aluguel\" where \"id\"=?";

    public AluguelDAO(){
        conexaoAluguelDao = new Conexao("postgres", "123", "jdbc:postgresql://localhost:5432/postgres");
    }

    public ArrayList<Aluguel> emitirRelatorioAluguel(){
        Aluguel nota;
        ArrayList<Aluguel> lista = new ArrayList<Aluguel>();
        try {
            conexaoAluguelDao.conectar();
            Statement instrucao = conexaoAluguelDao.getConexao().createStatement();
            ResultSet rs = instrucao.executeQuery(RelatorioAluguel);
            while(rs.next()){
                pessoa = new Aluguel(rs.getInt("id"), rs.getString("data"), rs.getInt("qtdHoras"), rs.getDouble("valorTotal"));
                lista.add(nota);
            }
            conexaoAluguelDao.desconectar();
        } catch (Exception e){
            System.out.println("Erro no relatorio de alugueis");
        }
        return lista;
    }
}