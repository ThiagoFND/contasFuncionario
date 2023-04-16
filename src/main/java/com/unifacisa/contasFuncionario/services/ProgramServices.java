package com.unifacisa.contasFuncionario.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unifacisa.contasFuncionario.entities.Funcionario;
import com.unifacisa.contasFuncionario.repositories.FuncionarioRepository;

@Service
public class ProgramServices {

	@Autowired
	FuncionarioRepository funcionarioRepositories;
	
	// esse métdo adiciona ao banco de dados
	public void adicionarBDD(String nomeCompleto, double valorPorHora) {
		Funcionario funcionarioAdd = new Funcionario(nomeCompleto, valorPorHora);
		funcionarioRepositories.save(funcionarioAdd);
	}
	
	// esse método lista completo os dados
	public void listagemCompleta(String nomeCompleto, Long horasTrabalhadas, double valorPorHora) {
		for (Funcionario p : funcionarioRepositories.findAll()) {
			System.out.println("\nId" + p.getId());
			System.out.println("Nome: " + p.getNomeCompleto());
			System.out.println("Valor por hora: " + p.getValorPorHora());
			System.out.println("Horas trabalhadas: " + p.getHorasTrabalhadas());
		}
	}
	
	// esse método calcula o salário
	public void calcularSalario() {
		for (Funcionario p : funcionarioRepositories.findAll()) {
			System.out.println("Salário a se receber no mês: " + p.getValorPorHora() * p.getHorasTrabalhadas());
		}
	}
	
	// esse método incrementa horas
	public void incrementarHoras(int vHora) {
		for (Funcionario p : funcionarioRepositories.findAll()) {
			Long horasTrabalhadasAtual = p.getHorasTrabalhadas();
			Long horasTrabalhadasNovo = horasTrabalhadasAtual + vHora;
			System.out.println("Id: " + p.getId());
			System.out.println("Nome: " + p.getNomeCompleto());
			System.out.println("Valor incremetado:" + vHora + "\nTotal: " + horasTrabalhadasNovo);
		}
	}
	
	// esse método remove o id
	public void remover(Long id) {
		funcionarioRepositories.deleteById(id);
	}
	
	// esse método pega o valor total final do funcionário	
	public void valorTotal() {
		for (Funcionario p : funcionarioRepositories.findAll()) {
			System.out.println("\nId" + p.getId());
			System.out.println("Nome: " + p.getNomeCompleto());
			System.out.println("Valor por hora: " + p.getValorPorHora());
			System.out.println("Horas trabalhadas: " + p.getHorasTrabalhadas());
			
			System.out.println("Valor total a receber: " + p.getValorPorHora() * p.getHorasTrabalhadas());
		}
	}
}
