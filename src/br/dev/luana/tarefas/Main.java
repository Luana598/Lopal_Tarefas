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
import br.dev.luana.tarefas.gui.FrameFuncionario;
import br.dev.luana.tarefas.gui.FrameInicial;
import br.dev.luana.tarefas.gui.FrameListaFuncionario;
import br.dev.luana.tarefas.model.Funcionario;
import br.dev.luana.tarefas.model.Tarefa;
import br.dev.luana.tarefas.utils.Utils;

public class Main {
	private static String path = "C:\\Users\\25132776\\tarefa\\tarefas.txt";

	public static void main(String[] args) {
		
		new FrameInicial();
		
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
