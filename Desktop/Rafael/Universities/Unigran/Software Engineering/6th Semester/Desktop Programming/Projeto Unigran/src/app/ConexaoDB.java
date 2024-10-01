package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDB {

    // URL do banco de dados, nome de usuário e senha
    private static final String URL = "jdbc:mysql://localhost:3306/cadastro_clientes";
    private static final String USER = "root"; // altere se necessário
    private static final String PASSWORD = "password"; // altere se necessário

    // Método para obter a conexão
    public static Connection getConnection() throws SQLException {
        try {
            // Carregar o driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver não encontrado: " + e.getMessage());
        }

        // Retornar a conexão com o banco de dados
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
