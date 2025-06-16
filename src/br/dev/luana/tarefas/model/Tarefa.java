package br.dev.luana.tarefas.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Tarefa {

	private String codigo;
	private String titulo;
	private String descricao;
	private LocalDate dataInicial;
	private LocalDate prazo;
	private LocalDate dataConclusao;
	private Status status;
	private Funcionario responsavel;
	
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
	public LocalDate getDataInicial() {
		return dataInicial;
	}
	public void setDataInicial(LocalDate dataInicial) {
		this.dataInicial = dataInicial;
	}
	public LocalDate getPrazo() {
		return prazo;
	}
	public void setPrazo(LocalDate prazo) {
		this.prazo = prazo;
	}
	public LocalDate getDataConclusao() {
		return dataConclusao;
	}
	public void setDataConclusao(LocalDate dataConclusao) {
		this.dataConclusao = dataConclusao;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	} 
	
	public Funcionario getResponsavel() {
		return responsavel;
	}
	
	public void setResponsavel(Funcionario responsavel) {
		this.responsavel = responsavel;
	}
	
	@Override
	public String toString() {
		return this.codigo + "," + this.titulo + "," + this.status + "," + this.descricao + "," + this.responsavel + ","
				+ this.dataInicial + "," + this.dataConclusao + "," + this.prazo + "\n";
	}

}
