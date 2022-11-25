package Persistencia;
import Dominio.Campo;
import Dominio.Cliente;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class CampoDAO {
    private Conexao conexaoCampoDao;
    private String RelatorioCampos = "select * from \"Campo\"";
    private String BuscarCampo = "select * from \"Campo\" where \"id\"=?";

    public CampoDAO(){
        conexaoCampoDao = new Conexao("postgres","123","jdbc:postgresql://localhost:5432/postgres");
    }


    public Campo buscar(int idaux){
        Campo campo = null;
        try{
            conexaoCampoDao.conectar();
            PreparedStatement pesquisa = conexaoCampoDao.getConexao().prepareStatement(BuscarCampo);
            pesquisa.setInt(1,idaux);
            ResultSet rs = pesquisa.executeQuery();
            if(rs.next()){
                campo = new Campo(rs.getInt("pk_idAluguel"),rs.getInt("valorHora"),rs.getBoolean("ocupado"),rs.getInt("capacidade"));
            }
            conexaoCampoDao.desconectar();
        }catch(Exception e) {
            System.out.println("Erro na busca");
        }
        return campo;

    }

    //opcional
    /*public ArrayList<Campo> emitirRelatorioCampos(){
        Campo terreno;
        ArrayList<Campo> lista = new ArrayList<Campo>();
        try {
            conexaoCampoDao.conectar();
            Statement instrucao = conexaoCampoDao.getConexao().createStatement();
            ResultSet rs = instrucao.executeQuery(RelatorioCampos);
            while(rs.next()){
                terreno = new Campo(rs.getInt("pk_idAluguel"),rs.getInt("valorHora"),rs.getBoolean("ocupado"),rs.getInt("capacidade"));
                lista.add(terreno);
            }
            conexaoCampoDao.desconectar();
        } catch (Exception e){
            System.out.println("Erro no relatorio de Campos");
        }
        return lista;
    }*/
}