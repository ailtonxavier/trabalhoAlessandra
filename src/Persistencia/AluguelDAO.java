package Persistencia;

import Dominio.Aluguel;
import Dominio.Cliente;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class AluguelDAO {
    private Conexao conexaoAluguelDAO;

    private String relatorio = "select * from aluguel";
    private String inserir = "insert into aluguel (fk_cpf,data, dataDaReserva, hora, horaDaReserva,qtdHoras,valorTotal) values (?,?,?,?,?,?,?)";
    private String buscar = "select * from aluguel where fk_cpf = ?";
    private String deletar = "delete from aluguel where fk_cpf = ?";

    public AluguelDAO(){
        conexaoAluguelDAO = new Conexao("jdbc:postgresql://localhost:5432/BDSolo", "postgres", "123");
    }

    public ArrayList<Aluguel> getRelatorio(){
        Aluguel aluguel;
        ArrayList<Aluguel> lista = new ArrayList<Aluguel>();
        try{
            conexaoAluguelDAO.conectar();
            Statement instrucao = conexaoAluguelDAO.getConexao().createStatement();
            ResultSet rs = instrucao.executeQuery(relatorio);
            while(rs.next()){
                aluguel = new Aluguel(rs.getString("fk_cpf"),rs.getInt("id"),rs.getString("data"), rs.getString("dataDaReserva"), rs.getString("hora"), rs.getString("horaDaReserva"), rs.getInt("qtdHoras"),rs.getDouble("valorTotal"));
                lista.add(aluguel);
            }
            conexaoAluguelDAO.desconectar();
        } catch (Exception e){
            System.out.println("Erro no relatorio" + e.getMessage());
        }
        return lista;
    }

    public ArrayList<Aluguel> getAluguel(String pk_fk_cpf){
        Aluguel aluguel = null;
        ArrayList<Aluguel> lista = new ArrayList<Aluguel>();
        try{
            conexaoAluguelDAO.conectar();
            PreparedStatement instrucao = conexaoAluguelDAO.getConexao().prepareStatement(buscar);
            instrucao.setString(1, pk_fk_cpf);
            ResultSet rs = instrucao.executeQuery();
            while(rs.next()){
                aluguel = new Aluguel(rs.getString("fk_cpf"),rs.getInt("id"),rs.getString("data"), rs.getString("dataDaReserva"),rs.getString("hora"), rs.getString("horaDaReserva"),rs.getInt("qtdHoras"),rs.getDouble("valorTotal"));
                lista.add(aluguel);
            }
            conexaoAluguelDAO.desconectar();
        } catch (Exception e){
            System.out.println("Erro no relatorio" + e.getMessage());
        }
        return lista;
    }

    public void setInserir(Aluguel aluguel){
        try {
            conexaoAluguelDAO.conectar();
            PreparedStatement instrucao = conexaoAluguelDAO.getConexao().prepareStatement(inserir);
            instrucao.setString(1, aluguel.getFk_cpf());
            instrucao.setString(2, aluguel.getData());
            instrucao.setString(3, aluguel.getDataDaReserva());
            instrucao.setString(4, aluguel.getHora());
            instrucao.setString(5, aluguel.getHoraDaReserva());
            instrucao.setInt(6, aluguel.getQtdHoras());
            instrucao.setDouble(7, aluguel.getValorTotal());
            instrucao.execute();
            conexaoAluguelDAO.desconectar();
        } catch (Exception e){
            System.out.println("Erro na inclusão: " + e.getMessage());
        }
    }


    public void excluir(String fk_cpf){
        try {
            conexaoAluguelDAO.conectar();
            PreparedStatement instrucao = conexaoAluguelDAO.getConexao().prepareStatement(deletar);
            instrucao.setString(1, fk_cpf);
            instrucao.execute();
            conexaoAluguelDAO.desconectar();
        } catch (Exception e){
            System.out.println("Erro na exclusão: " + e.getMessage());
        }
    }
}
