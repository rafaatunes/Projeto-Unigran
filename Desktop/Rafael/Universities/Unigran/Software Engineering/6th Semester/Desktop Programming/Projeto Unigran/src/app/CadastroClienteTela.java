package app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CadastroClienteTela extends JDialog {
    // Componentes da tela de cadastro
    private JTextField nomeField;
    private JTextField idadeField;
    private JTextField enderecoField;

    public CadastroClienteTela() {
        // Configurações da janela de cadastro
        setTitle("Cadastro de Cliente");
        setSize(300, 200);
        setModal(true); // Faz com que a janela seja modal
        setLocationRelativeTo(null); // Centraliza a janela

        // Layout e componentes
        setLayout(new GridLayout(4, 2));

        nomeField = new JTextField();
        idadeField = new JTextField();
        enderecoField = new JTextField();

        JButton salvarButton = new JButton("Salvar");
        JButton cancelarButton = new JButton("Cancelar");

        // Adicionando os componentes à tela
        add(new JLabel("Nome:"));
        add(nomeField);
        add(new JLabel("Idade:"));
        add(idadeField);
        add(new JLabel("Endereço:"));
        add(enderecoField);
        add(salvarButton);
        add(cancelarButton);

        // Ação do botão Salvar
        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvarCliente(); // Método que salva o cliente no banco
            }
        });

        // Ação do botão Cancelar
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Fecha a tela de cadastro
            }
        });

        // Tornando a janela visível
        setVisible(true);
    }

    private void salvarCliente() {
        try {
            String nome = nomeField.getText();
            int idade = Integer.parseInt(idadeField.getText());
            String endereco = enderecoField.getText();

            // Conectar ao banco de dados e inserir o cliente
            Connection conn = ConexaoDB.getConnection();

            // Consulta SQL para inserir o cliente
            String sql = "INSERT INTO cliente (nome, idade, endereco) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setInt(2, idade);
            stmt.setString(3, endereco);

            // Executar a consulta
            int rowsAffected = stmt.executeUpdate();

            // Verificar se a inserção foi bem-sucedida
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Cliente salvo com sucesso no banco de dados!");
            }

            // Fechar a conexão
            stmt.close();
            conn.close();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Erro: Idade inválida.", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao salvar o cliente no banco de dados: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
