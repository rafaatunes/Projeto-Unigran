package app;

import entidade.Cliente;
import javax.swing.JOptionPane;

public class Principal {

    public static void main(String[] args) {
        // Lendo dados do cliente com JOptionPane
        String nome = JOptionPane.showInputDialog("Digite o nome do cliente:");
        int idade = Integer.parseInt(JOptionPane.showInputDialog("Digite a idade do cliente:"));
        String endereco = JOptionPane.showInputDialog("Digite o endereço do cliente:");
        
        // Criando objeto Cliente com os dados fornecidos
        Cliente cliente = new Cliente(nome, idade, endereco);

        // Exibindo dados do cliente
        JOptionPane.showMessageDialog(null, 
            "Cliente cadastrado:\nNome: " + cliente.getNome() + 
            "\nIdade: " + cliente.getIdade() + 
            "\nEndereço: " + cliente.getEndereco());
    }
}
