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
	private JButton btnSair;
	
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
				
				new FrameListaFuncionario();
				criarTela();
				
			}
		});
		
		

		btnTarefas = new JButton("tarefas");
		btnTarefas.setBounds(200, 100, 150, 50);
		
		btnTarefas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
								
			}
		});
		
		btnSair = new JButton("Sair");
		btnSair.setBounds(130, 200, 100, 40);
		
		btnSair.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int resposta = JOptionPane.showConfirmDialog(
						telaInicial, 
						"Confirma a saída do sistema?", 
						"Sair do Sistema",
						JOptionPane.YES_NO_OPTION 
						); 
				
				if (resposta == 0) {
					telaInicial.dispose();
				}
			}
		});
		
		painel.add(btnFuncionarios);
		painel.add(btnTarefas);
		painel.add(lblEscolha);
		painel.add(btnSair);
		
		telaInicial.setVisible(true);
	}
	
	
	
	
	
}
