package br.dev.luana.tarefas.gui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class FrameInicial {
	
	private JButton btnFuncionarios;
	private JButton btnTarefas;
	private JLabel lblEscolha;
	
	public FrameInicial() {
		criarTela();
	}

	private void criarTela() {
		JFrame telaInicial = new JFrame();
		telaInicial.setSize(400, 300);
		telaInicial.setTitle("Menu Principal");
		telaInicial.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		telaInicial.setResizable(false);
		telaInicial.setLayout(null);
		telaInicial.setLocationRelativeTo(null);
		
		Container painel = telaInicial.getContentPane();
		
		lblEscolha = new JLabel("Selecione o que visualizar a seguir:");
		lblEscolha.setBounds(90, 50, 250, 30);
		
		
		btnFuncionarios = new JButton(" Funcionários");
		btnFuncionarios.setBounds(20, 100, 150, 50);
		
		btnFuncionarios.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				new FrameFuncionarioTabela();
				criarTela();
				
			}
		});
		
		

		btnTarefas = new JButton("tarefas");
		btnTarefas.setBounds(200, 100, 150, 50);
		
		btnTarefas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				new FrameTarefaTabela();
				criarTela();
								
			}
		});

		
		painel.add(btnFuncionarios);
		painel.add(btnTarefas);
		painel.add(lblEscolha);
		
		telaInicial.setVisible(true);
	}
	
	
	
	
	
}
