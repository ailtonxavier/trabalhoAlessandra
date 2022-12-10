package Persistencia;

import java.sql.ResultSet;
import java.sql.PreparedStatement;

import Dominio.Endereco;
import Dominio.Cliente;

public class EnderecoDAO {
        private Conexao conexaoEnderecoDAO;
        private String inserir = "insert into endereco (pk_fk_cpf,estado,cidade,bairro,rua,numero) values (?,?,?,?,?,?)";
        private String buscar = "select * from endereco where pk_fk_cpf = ?";
        private String alterar = "update endereco set pk_fk_cpf = ?, estado = ?, cidade = ?, bairro = ?, rua = ?, numero = ? where pk_fk_cpf = ?";
        private String deletar = "delete from endereco where pk_fk_cpf = ?";

        public EnderecoDAO(){
                conexaoEnderecoDAO = new Conexao("jdbc:postgresql://localhost:5432/BDSolo", "postgres", "123");
        }

        public Endereco getEndereco(String pk_fk_cpf){
                Endereco endereco = null;
                try {
                        conexaoEnderecoDAO.conectar();
                        PreparedStatement instrucao = conexaoEnderecoDAO.getConexao().prepareStatement(buscar);
                        instrucao.setString(1, pk_fk_cpf);
                        ResultSet rs = instrucao.executeQuery();
                        if(rs.next()){
                                endereco = new Endereco(rs.getString("pk_fk_cpf"), rs.getString("estado"), rs.getString("cidade"), rs.getString("bairro"), rs.getString("rua"), rs.getString("numero"));
                        }
                        conexaoEnderecoDAO.desconectar();
                } catch (Exception e) {
                        System.out.println("Erro na busca: " + e.getMessage());
                }
                return endereco;
        }

        public void setInserir(Endereco endereco){
                try {
                        conexaoEnderecoDAO.conectar();
                        PreparedStatement instrucao = conexaoEnderecoDAO.getConexao().prepareStatement(inserir);
                        instrucao.setString(1, endereco.getPk_fk_cpf());
                        instrucao.setString(2, endereco.getEstado());
                        instrucao.setString(3, endereco.getCidade());
                        instrucao.setString(4, endereco.getBairro());
                        instrucao.setString(5, endereco.getRua());
                        instrucao.setString(6,endereco.getNumero());
                        instrucao.execute();
                        conexaoEnderecoDAO.desconectar();
                } catch (Exception e){
                        System.out.println("Erro na inclusão: " + e.getMessage());
                }
        }

        public void setAlterar(Endereco endereco){
                try {
                        conexaoEnderecoDAO.conectar();
                        PreparedStatement instrucao = conexaoEnderecoDAO.getConexao().prepareStatement(alterar);
                        instrucao.setString(1, endereco.getPk_fk_cpf());
                        instrucao.setString(2, endereco.getEstado());
                        instrucao.setString(3, endereco.getCidade());
                        instrucao.setString(4, endereco.getBairro());
                        instrucao.setString(5, endereco.getRua());
                        instrucao.setString(6, endereco.getNumero());
                        instrucao.setString(7, endereco.getPk_fk_cpf());
                        instrucao.execute();
                        conexaoEnderecoDAO.desconectar();
                } catch (Exception e){
                        System.out.println("Erro na alteração do endereço: " + e.getMessage());
                }
        }

        public void excluir(String pk_fk_cpf){
                try {
                        conexaoEnderecoDAO.conectar();
                        PreparedStatement instrucao = conexaoEnderecoDAO.getConexao().prepareStatement(deletar);
                        instrucao.setString(1, pk_fk_cpf);
                        instrucao.execute();
                        conexaoEnderecoDAO.desconectar();
                } catch (Exception e){
                        System.out.println("Erro na exclusão: " + e.getMessage());
                }
        }


}
