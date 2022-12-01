package Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
    private String usuario;
    private String senha;
    private String caminho;
    private Connection minhaConexao;

    public Conexao(String caminho, String usuario, String senha){
        this.caminho = caminho;
        this.usuario = usuario;
        this.senha = senha;
    }

    public void conectar(){
        try {
            Class.forName("org.postgresql.Driver"); // CARREGA O DRIVER
            minhaConexao = DriverManager.getConnection(this.caminho, this.usuario, this.senha);
        } catch (Exception e){
            System.out.println("Erro na conexao" + e.getMessage());
        }
    }
    public void desconectar(){
        try {
            minhaConexao.close();
        } catch (Exception e){
            System.out.println("Erro na desconexao" + e.getMessage());
        }
    }

    public Connection getConexao(){
        return this.minhaConexao;
    }
}
