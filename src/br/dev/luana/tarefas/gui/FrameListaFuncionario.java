package br.dev.luana.tarefas.gui;

import java.awt.Container;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class FrameListaFuncionario {
	
	private JLabel labelTitulo;
	private JTable tableFuncionarios;
	private JScrollPane scrollFuncionarios;
	private JButton btnNovo;
	private JButton btnExcluir;
	private JButton btnAlterar;
	private JButton btnSair;
	
	private Font fontTitulo = new Font("Arial", Font.BOLD, 18);
	
	public FrameListaFuncionario() {
		criarTela();
	}
	
	private void criarTela() {
		JFrame tela = new JFrame();
		tela.setTitle("Cadastro de funcionários");
		tela.setSize(600, 600);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setResizable(false);
		tela.setLayout(null);
		tela.setLocationRelativeTo(null);
		
		Container painel = tela.getContentPane();
		
		labelTitulo = new JLabel("Cadastro de Funcionários");
		labelTitulo.setBounds(10, 20, 500, 30);
		labelTitulo.setFont(fontTitulo);
		
		//Tabela
		String[]colunas = {"Código","Nome", "E-mail"};
		
		Object[][]dados = {
				{"xxx","bbb","aaa"},
				{"aaa","bbb","ccc"},
				{"ddd","eee","fff"},
		};
		
		tableFuncionarios = new JTable(dados, colunas);
		
		scrollFuncionarios = new JScrollPane(tableFuncionarios);
		scrollFuncionarios.setBounds(10, 70, 500, 300);
		
		
		painel.add(labelTitulo);
		painel.add(scrollFuncionarios);
		tela.setVisible(true);
	}

}
