package com.unifacisa.contasFuncionario;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.unifacisa.contasFuncionario.services.Exceptions;
import com.unifacisa.contasFuncionario.services.ProgramServices;

/*
 * Este software cadastra usuário com o valor a se receber no mês, quantas horas ele trabalhou e valor por hora
 */
@SpringBootApplication
public class ContasFuncionarioApplication implements CommandLineRunner {

	@Autowired
	ProgramServices programServices;

	public static void main(String[] args) {
		SpringApplication.run(ContasFuncionarioApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Scanner entrada = new Scanner(System.in);
		Exceptions exc1 = new Exceptions();

		int entrarWhile = 0;
		while (entrarWhile != 5) {
			System.out.println("[1] - Adicionar Pessoa \n[2] - Adicionar valores \n[3] - Valor total a receber no mês \n[4] - Listar todos os dados \nDigite: ");
			int d1 = exc1.readWhole();

			if (d1 == 1) {
				// adicionar pessoa

				System.out.println("Nome: ");
				String nome = exc1.read();
				System.out.println("Sobrenome: ");
				String sobrenome = exc1.read();
				
				String nomeCompleto = nome + sobrenome;
				
				System.out.println("Horas trabalhadas: 8");
				System.out.println("Valor por hora: ");
				double valorPorHora = entrada.nextDouble();

				programServices.adicionarBDD(nomeCompleto, valorPorHora);

			} else if (d1 == 2) {
				// listar pessoa
				System.out.println("Adicionar Valores");

				programServices.listagemCompleta(null, null, d1);

				System.out.println(
						"Caso a pessoa que queira atribuir os valores esteja adicionada no banco de dados, selecione 1, remova e passe os valores novamente com as atualizações");
				System.out.println("[1] - Remover \n[2] - Adicionar Pessoa \n[3] - Sair");
				int d4 = exc1.readWhole();

				if (d4 == 1) {
					// removendo
					System.out.println("Os valores a se passar após a modificação estão abaixo\n");
					programServices.calcularSalario();

					
					
					System.out.println("Digite o valor a se incrementar na hora: ");
					int vHora = exc1.readWhole();
					programServices.incrementarHoras(vHora);

					
					System.out.println("\nRemova o id ao qual deseja aplicar as modificações\n");
					System.out.println("\nRemover por id \nId: ");
					long id = exc1.readWhole();
					
					programServices.remover(id);

					System.out.println("\nAgora passe os valores novamente com as modificações aplicadas acima\n");

					System.out.println("Nome: ");
					String nome = exc1.read();
					System.out.println("Sobrenome: ");
					String sobrenome = exc1.read();
					
					String nomeCompleto = nome + sobrenome;
					
					System.out.println("Horas trabalhadas: 8");
					System.out.println("Valor por hora: ");
					double valorPorHora = entrada.nextDouble();

					programServices.adicionarBDD(nomeCompleto, valorPorHora);

				} else if (d4 == 2) {
					// adicionando
					System.out.println("Nome: ");
					String nome = exc1.read();
					System.out.println("Sobrenome: ");
					String sobrenome = exc1.read();
					System.out.println("Horas trabalhadas: 8");
					
					String nomeCompleto = nome + sobrenome;
					
					System.out.println("Valor por hora: ");
					double valorPorHora = entrada.nextDouble();
					
					programServices.calcularSalario();
					
					System.out.println("Digite o valor a se incrementar na hora: ");
					int vHora = exc1.readWhole();
					programServices.incrementarHoras(vHora);

					programServices.adicionarBDD(nome, valorPorHora);
				} else if (d4 == 3) {
					System.out.println("Saindo");
					break;
				} else {
					System.out.println("Número inexistente");
				}

			} else if (d1 == 3) {
				// calcular quanto irá receber no mês
				
				programServices.valorTotal();
			} else if (d1 == 4) {
				// listar todos os dados
				programServices.listagemCompleta(null, null, d1);
			} else if (d1 == 5) {
				// sair
				System.out.println("Saindo");
				break;
			} else {
				System.out.println("Número inexistente");
			}
		}
	}

}
