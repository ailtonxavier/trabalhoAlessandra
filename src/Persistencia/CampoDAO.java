//package Persistencia;
//
//import Dominio.Campo;
//
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//
//public class CampoDAO {
//    private Conexao conexaoEnderecoDAO;
//    private String inserir = "insert into campo (fk_pk_idAluguel,ocupado) values (?,?)";
//    private String buscar = "select * from campo where fk_pk_idAluguel = ?";
//    private String deletar = "delete from campo where fk_pk_idAluguel = ?";
//
//    public CampoDAO(){
//        conexaoEnderecoDAO = new Conexao("jdbc:postgresql://localhost:5432/BDSolo", "postgres", "123");
//    }
//
//    public Campo getCampo(String fk_pk_idAluguel){
//        Campo campo = null;
//        try {
//            conexaoEnderecoDAO.conectar();
//            PreparedStatement instrucao = conexaoEnderecoDAO.getConexao().prepareStatement(buscar);
//            instrucao.setString(1, fk_pk_idAluguel);
//            ResultSet rs = instrucao.executeQuery();
//            if(rs.next()){
//                campo = new Campo(rs.getInt("fk_pk_idAluguel"),rs.getInt("valorHora"),rs.getBoolean("ocupado"),rs.getInt("capacidade"));
//            }
//            conexaoEnderecoDAO.desconectar();
//        } catch (Exception e) {
//            System.out.println("Erro na busca: " + e.getMessage());
//        }
//        return campo;
//    }
//
//    public void setInserir(Campo campo){
//        try {
//            conexaoEnderecoDAO.conectar();
//            PreparedStatement instrucao = conexaoEnderecoDAO.getConexao().prepareStatement(inserir);
//            instrucao.setInt(1, campo.getFk_pk_idAluguel());
//            instrucao.setBoolean(2, campo.isOcupado());
//            instrucao.execute();
//            conexaoEnderecoDAO.desconectar();
//        } catch (Exception e){
//            System.out.println("Erro na inclusão: " + e.getMessage());
//        }
//    }
//
//    public void excluir(String fk_pk_idAluguel){
//        try {
//            conexaoEnderecoDAO.conectar();
//            PreparedStatement instrucao = conexaoEnderecoDAO.getConexao().prepareStatement(deletar);
//            instrucao.setString(1, fk_pk_idAluguel);
//            instrucao.execute();
//            conexaoEnderecoDAO.desconectar();
//        } catch (Exception e){
//            System.out.println("Erro na exclusão: " + e.getMessage());
//        }
//    }
//
//
//}
