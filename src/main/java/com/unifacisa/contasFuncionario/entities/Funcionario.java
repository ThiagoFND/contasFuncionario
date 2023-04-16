package com.unifacisa.contasFuncionario.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Funcionario {
	
	private String nomeCompleto;
	protected Long horasTrabalhadas;
	protected double valorPorHora;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public Funcionario() {

	}

	public Funcionario(String nomeCompleto, double valorPorHora) {
		super();
		this.nomeCompleto = nomeCompleto;
		this.horasTrabalhadas = (long) 8;
		this.valorPorHora = valorPorHora;
		this.id = id;
	}

	public Long getHorasTrabalhadas() {
		return horasTrabalhadas;
	}

	public void setHorasTrabalhadas(Long horasTrabalhadas) {
		this.horasTrabalhadas = horasTrabalhadas;
	}

	public double getValorPorHora() {
		return valorPorHora;
	}

	public void setValorPorHora(double valorPorHora) {
		this.valorPorHora = valorPorHora;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
	
	

}
