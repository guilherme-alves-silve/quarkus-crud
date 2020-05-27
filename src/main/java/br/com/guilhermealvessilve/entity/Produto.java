package br.com.guilhermealvessilve.entity;

import java.math.BigDecimal;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
@Table(name = "produto")
public class Produto extends PanacheEntity {

	private String nome;
	
	private BigDecimal valor;
	
	@CreationTimestamp
	private Date dataCriacao;
	
	@UpdateTimestamp
	private Date dataAtualizacao;

	public Produto() {
		
	}
	
	public Produto(String nome, BigDecimal valor) {
		this.nome = nome;
		this.valor = valor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}
}
