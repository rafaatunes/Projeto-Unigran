package app;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Listar extends JFrame {

    private JTable table;
    private DefaultTableModel tableModel;

    public Listar() {
        setTitle("Lista de Clientes");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Criar a tabela
        tableModel = new DefaultTableModel(new String[]{"ID", "Nome", "Idade", "Endereço"}, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        // Carregar os dados dos clientes
        loadClientes();

        // Adiciona um botão para fechar a tela
        JButton fecharButton = new JButton("Fechar");
        fecharButton.addActionListener(e -> dispose());
        add(fecharButton, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void loadClientes() {
        try {
            // Obter a conexão com o banco de dados
            Connection conn = ConexaoDB.getConnection();

            // Criar uma declaração SQL
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM cliente";
            ResultSet rs = stmt.executeQuery(sql);

            // Preencher a tabela com os dados dos clientes
            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                int idade = rs.getInt("idade");
                String endereco = rs.getString("endereco");

                // Adicionar a linha à tabela
                tableModel.addRow(new Object[]{id, nome, idade, endereco});
            }

            // Fechar a conexão
            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar dados: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new Listar();
    }
}
