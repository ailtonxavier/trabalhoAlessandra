package Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
    private String usuario;
    private String senha;
    private String caminho;
    private Connection minhaConexao;

    public Conexao(String usuario, String senha, String caminho){
        this.usuario = usuario;
        this.senha = senha;
        this.caminho = caminho;
    }

    public void conectar(){
        try{
            Class.forName("org.postgresql.Driver");
            minhaConexao = DriverManager.getConnection(caminho, usuario, senha);
        } catch (Exception e){
            System.out.println("Erro na conexão com o banco: "+ e.getMessage());
        }
    }

    public void desconectar(){
        try {
            minhaConexao.close();
        } catch (Exception e) {
            System.out.println("Erro na desconexão com o banco: " + e.getMessage());
        }
    }
    public Connection getConexao(){
        return minhaConexao;
    }
}
