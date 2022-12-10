package Persistencia;

import Dominio.Contato;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ContatoDAO {
    private Conexao conexaoContatoDAO;
    private String inserir = "insert into contato (pk_fk_cpf,email,celular,telFixo,telComercial) values (?,?,?,?,?)";
    private String buscar = "select * from contato where pk_cpf = ?";
    private String alterar = "update contato set pk_fk_cpf = ?, email = ?, celular = ?, telFixo = ?, telComercial = ? where pk_fk_cpf = ?";
    private String deletar = "delete from contato where pk_fk_cpf = ?";

    public ContatoDAO(){
        conexaoContatoDAO = new Conexao("jdbc:postgresql://localhost:5432/BDSolo", "postgres", "123");
    }

    public Contato getContato(String pk_cpf){
        Contato contato = null;
        try {
            conexaoContatoDAO.conectar();
            PreparedStatement instrucao = conexaoContatoDAO.getConexao().prepareStatement(buscar);
            instrucao.setString(1, pk_cpf);
            ResultSet rs = instrucao.executeQuery();
            if(rs.next()){
                contato = new Contato(rs.getString("pk_fk_cpf"), rs.getString("email"), rs.getString("celular"), rs.getString("telFixo"), rs.getString("telComercial"));
            }
            conexaoContatoDAO.desconectar();
        } catch (Exception e) {
            System.out.println("Erro na busca: " + e.getMessage());
        }
        return contato;
    }
    public void setInserir(Contato contato){
        try {
            conexaoContatoDAO.conectar();
            PreparedStatement instrucao = conexaoContatoDAO.getConexao().prepareStatement(inserir);
            instrucao.setString(1, contato.getPk_fk_cpf());
            instrucao.setString(2, contato.getEmail());
            instrucao.setString(3, contato.getCelular());
            instrucao.setString(4, contato.getTelFixo());
            instrucao.setString(5, contato.getTelComercial());
            instrucao.execute();
            conexaoContatoDAO.desconectar();
        } catch (Exception e){
            System.out.println("Erro na inclusão: " + e.getMessage());
        }
    }

    public void setAlterar(Contato contato){
        try {
            conexaoContatoDAO.conectar();
            PreparedStatement instrucao = conexaoContatoDAO.getConexao().prepareStatement(alterar);
            instrucao.setString(1, contato.getPk_fk_cpf());
            instrucao.setString(2, contato.getEmail());
            instrucao.setString(3, contato.getCelular());
            instrucao.setString(4, contato.getTelFixo());
            instrucao.setString(5, contato.getTelComercial());
            instrucao.setString(6, contato.getPk_fk_cpf());
            instrucao.execute();
            conexaoContatoDAO.desconectar();
        } catch (Exception e){
            System.out.println("Erro na alteração de contato: " + e.getMessage());
        }
    }
    public void excluir(String pk_fk_cpf){
        try {
            conexaoContatoDAO.conectar();
            PreparedStatement instrucao = conexaoContatoDAO.getConexao().prepareStatement(deletar);
            instrucao.setString(1, pk_fk_cpf);
            instrucao.execute();
            conexaoContatoDAO.desconectar();
        } catch (Exception e){
            System.out.println("Erro na exclusão: " + e.getMessage());
        }
    }
}
