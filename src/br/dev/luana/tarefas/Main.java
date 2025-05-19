package br.dev.luana.tarefas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.dev.luana.tarefas.dao.FuncionarioDAO;
import br.dev.luana.tarefas.model.Funcionario;
import br.dev.luana.tarefas.model.Tarefa;

public class Main {
	private static String path = "C:\\Users\\25132776\\tarefa\\tarefas.txt";

	public static void main(String[] args) {
		
		List<String> frutas = new ArrayList<>();
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		List<Double> numeros = new ArrayList<>();
		
		Funcionario funcionario = new Funcionario();
		funcionario.setCodigo(4);
		funcionario.setNome("Carlos Eduardo");
		funcionario.setMatricula("25132776");
		funcionario.setEmail("carlos@gmail.com");
		
		Funcionario funcionario2 = new Funcionario();
		funcionario2.setCodigo(5);
		funcionario2.setNome("Camila Loures");
		funcionario2.setMatricula("251456758");
		funcionario2.setEmail("camila@gmail.com");
		
		funcionarios.addAll(List.of(funcionario, funcionario2));
		
		frutas.add("maracujá");
		frutas.add("manga");
		frutas.add("uva verde");
		frutas.add("abacaxi");
	
		System.out.println(frutas);
		System.out.println(funcionarios);
		
		 for (Funcionario f : funcionarios) {
			 System.out.println(f.getNome() + " - " + f.getEmail());
		 }
		
//		Funcionario funcionario = new Funcionario();
//		funcionario.setCodigo(3);
//		funcionario.setNome("Rebeca gomes");
//		funcionario.setMatricula("25132567");
//		funcionario.setEmail("rebeca@gmail.com");
//		
//		FuncionarioDAO dao = new FuncionarioDAO(funcionario);
//		dao.gravar();
//		
//		System.out.println(funcionario.toString());
		
		
//		gravarArquivo();
	//  lerArquivo();
	
	}
	
	private static void gravarArquivo() {
		FileWriter arquivo = null;
		BufferedWriter escritor = null;
		
		try {
			//true = append (adicionar)
			arquivo = new FileWriter(path, true);
			escritor = new BufferedWriter(arquivo);
			
			escritor.write("Essa é a ultima linha!!!!! (será?) \n");
			escritor.flush();
			
		} catch (Exception erro) {
			System.out.println(erro.getMessage());
		}
	}

	private static void lerArquivo() {

		//abrir o arquivo para leitura 
		FileReader file = null;
		BufferedReader buffer = null;
		
		try {
		file = new FileReader(path);
		buffer = new BufferedReader(file);
		
		String linha ="";
		
		while (linha != null) {
			linha = buffer.readLine();
			if (linha != null) {
			System.out.println(linha);
			}
		}

		
		} catch (FileNotFoundException erro) {
			System.out.println("Arquivo não encontrado!");
			System.out.println(erro.getMessage());
		}catch (IOException erro) {
			System.out.println("Você não pode ler o arquivo!");
			System.out.println(erro.getMessage());
		}catch (Exception erro) {
			System.out.println("Erro genérico");
			System.out.println(erro.getMessage());
		}
	}

}
