package app;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaPrincipal extends JFrame {

    public TelaPrincipal() {
        // Configurações da janela principal
        setTitle("Tela Principal");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Criando a barra de menu
        JMenuBar menuBar = new JMenuBar();

        // Criando o menu
        JMenu menu = new JMenu("Opções");

        // Criando os itens do menu
        JMenuItem menuItemCadastro = new JMenuItem("Cadastro de Cliente");
        JMenuItem menuItemListar = new JMenuItem("Listar Clientes"); // Novo item de menu
        JMenuItem menuItemSair = new JMenuItem("Sair");

        // Adicionando itens ao menu
        menu.add(menuItemCadastro);
        menu.add(menuItemListar); // Adicionando ao menu
        menu.add(menuItemSair);

        // Adicionando o menu à barra de menu
        menuBar.add(menu);

        // Configurando a barra de menu na janela
        setJMenuBar(menuBar);

        // Ação para abrir a tela de cadastro de cliente
        menuItemCadastro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Abrir a tela de cadastro de cliente
                new CadastroClienteTela();
            }
        });

        // Ação para abrir a tela de listagem de clientes
        menuItemListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Abrir a tela de listar clientes
                new Listar();
            }
        });

        // Ação para sair do programa
        menuItemSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Fechar a aplicação
                System.exit(0);
            }
        });

        // Tornando a janela visível
        setVisible(true);
    }

    public static void main(String[] args) {
        // Inicializar a tela principal
        new TelaPrincipal();
    }
}
