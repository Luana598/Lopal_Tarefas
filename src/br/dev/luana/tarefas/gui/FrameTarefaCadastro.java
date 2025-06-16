package br.dev.luana.tarefas.gui;

import java.awt.Container;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.dev.luana.tarefas.dao.FuncionarioDAO;
import br.dev.luana.tarefas.dao.TarefasDAO;
import br.dev.luana.tarefas.model.Funcionario;
import br.dev.luana.tarefas.model.Status;
import br.dev.luana.tarefas.model.Tarefa;
import br.dev.luana.tarefas.utils.Utils;

public class FrameTarefaCadastro {
	
	JLabel lblTitulo;
	JTextField txtTitulo;
	JLabel lblDescricao;
	JTextField txtDescricao;
	JLabel lblDataInicial;
	JTextField txtDataInicial;
	JLabel lblPrazo;
	JTextField txtPrazo;
	JLabel lblConclusao;
	JTextField txtConclusao;
	JLabel lblStatus;
	JComboBox<String> boxStatus;
	JLabel lblFuncionario;
	JComboBox<String> boxFuncionario;
	JButton btnSalvar;
	JButton btnSair;
	
	public FrameTarefaCadastro() {
		criarTela();
	}
	
	private void criarTela(){
		JFrame tela = new JFrame();
		tela.setTitle("Cadastro de Tarefas");
		tela.setSize(400, 600);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setResizable(false);
		tela.setLayout(null);
		tela.setLocationRelativeTo(null);
		
		Container painel = tela.getContentPane();
		
		lblTitulo = new JLabel("Título");
		lblTitulo.setBounds(10, 10, 50, 50);
		txtTitulo = new JTextField();
		txtTitulo.setBounds(10, 50, 250, 35);
		
		lblDescricao = new JLabel("Descrição da tarefa");
		lblDescricao.setBounds(10, 80, 150, 50);
		txtDescricao = new JTextField();
		txtDescricao.setBounds(10, 120, 250, 35);
		
		lblDataInicial = new JLabel("Data de início");
		lblDataInicial.setBounds(10, 150, 150, 50);
		txtDataInicial = new JTextField();
		txtDataInicial.setBounds(10, 190, 250, 35);
		
		lblPrazo = new JLabel("Prazo");
		lblPrazo.setBounds(10, 220, 150, 50);
		txtPrazo = new JTextField();
		txtPrazo.setBounds(10, 260, 250, 35);
		
		lblConclusao = new JLabel("Data de conclusão");
		lblConclusao.setBounds(10, 290, 150, 50);
		txtConclusao = new JTextField();
		txtConclusao.setBounds(10, 330, 250, 35);
		
		lblStatus= new JLabel("Status");
		lblStatus.setBounds(10, 360, 150, 50);
		boxStatus = new JComboBox<String>();
		boxStatus.setBounds(10, 400, 130, 30);
		boxStatus.addItem("NÃO_INICIADA");
		boxStatus.addItem("EM_ANDAMENTO");
		boxStatus.addItem("FINALIZADA");
		boxStatus.addItem("EM_ATRASO");
		
		lblFuncionario = new JLabel("Funcionário");
		lblFuncionario.setBounds(170, 360, 150, 50);
		boxFuncionario = new JComboBox<String>();
		boxFuncionario.setBounds(160, 400, 150, 30);
		FuncionarioDAO dao = new FuncionarioDAO(null);
		List<Funcionario> funcionarios = dao.showEmployees();
		for (Funcionario f : funcionarios) {
			boxFuncionario.addItem(f.getNome());
		}
		
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(10, 445, 150, 50);
		
		btnSalvar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Tarefa tarefa = new Tarefa();
				tarefa.setTitulo(txtTitulo.getText());
				tarefa.setDescricao(txtDescricao.getText());
				tarefa.setStatus((Status)boxStatus.getSelectedItem());
				tarefa.setResponsavel((Funcionario)boxFuncionario.getSelectedItem());
				tarefa.setCodigo(Utils.gerarUUID());
				
				TarefasDAO dao = new TarefasDAO(tarefa);
				dao.gravar();
				JOptionPane.showMessageDialog(
						tela, 
						txtTitulo.getText() + "Gravado com Sucesso",
						"REGISTRO BEM-SUCEDIDO",
						JOptionPane.INFORMATION_MESSAGE
						);
				
			}
		});
		 
		
		btnSair = new JButton("Sair");
		btnSair.setBounds(170, 445, 150, 50);
		
		btnSair.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tela.dispose();
			}
		});
		
		
		painel.add(lblTitulo);
		painel.add(txtTitulo);
		painel.add(lblDescricao);
		painel.add(txtDescricao);
		painel.add(lblDataInicial);
		painel.add(txtDataInicial);
		painel.add(lblPrazo);
		painel.add(txtPrazo);
		painel.add(lblConclusao);
		painel.add(txtConclusao);
		painel.add(lblStatus);
		painel.add(boxStatus);
		painel.add(lblFuncionario);
		painel.add(boxFuncionario);
		painel.add(btnSalvar);
		painel.add(btnSair);
		
		
		tela.setVisible(true);
	}

}
