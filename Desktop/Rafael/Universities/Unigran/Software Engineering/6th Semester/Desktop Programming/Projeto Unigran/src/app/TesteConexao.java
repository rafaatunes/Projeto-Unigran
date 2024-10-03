package app;

import java.sql.Connection;
import java.sql.SQLException;

public class TesteConexao {

    public static void main(String[] args) {
        // Tentar estabelecer uma conexão com o banco de dados
        try {
            Connection conexao = ConexaoDB.getConnection();
            if (conexao != null) {
                System.out.println("Conexão estabelecida com sucesso!");

                // Fechar a conexão após o uso
                if (!conexao.isClosed()) {
                    conexao.close();
                    System.out.println("Conexão fechada com sucesso!");
                }
            } else {
                System.out.println("Erro ao conectar ao banco de dados.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }
}
