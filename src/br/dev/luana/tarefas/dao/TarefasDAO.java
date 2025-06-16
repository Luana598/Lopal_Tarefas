package br.dev.luana.tarefas.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.List;

import br.dev.luana.tarefas.factory.FileFactoryTarefa;
import br.dev.luana.tarefas.model.Funcionario;
import br.dev.luana.tarefas.model.Tarefa;

public class TarefasDAO {
		private Tarefa tarefa;
		private FileFactoryTarefa ff = new FileFactoryTarefa();
		private Funcionario funcionario;
		
		public TarefasDAO(Tarefa tarefas) {
			this.tarefa = tarefas;
		}
		
		public void gravar() {
			try {
				BufferedWriter bw = ff.getBufferedWriter();
				bw.write(tarefa.toString());
				bw.flush();
			} catch (Exception error) {
				System.out.println(error.getMessage());
			}
		}
		public List<Tarefa> showTasks(){
		
			List<Tarefa> tarefas = new ArrayList<Tarefa>();
			
			try {
				
				BufferedReader br = ff.getBufferedReader();
				String linha = br.readLine();
			
				do {	
					linha = br.readLine();
					String tarefa[] = linha != null ? linha.split(",") : null;
					
					Tarefa t = new Tarefa();
					t.setCodigo(tarefa[0]);
					t.setTitulo(tarefa[1]);
					t.setDescricao(tarefa[2]);
					
					
					tarefas.add(t);
				} while(linha != null);
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			return tarefas;
	}
}
