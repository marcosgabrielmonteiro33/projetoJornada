package Projeto;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		GerenciadorDeDemandas gerenciador = new GerenciadorDeDemandas();
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("===================");
			System.out.println("Menu:");			
			System.out.println("1- Criar demanda");
			System.out.println("2- Listar demandas");
			System.out.println("3- Sair");
			System.out.println("===================");
			

			System.out.println("Digite sua opção: ");
			System.out.println("===================");
			int op = scanner.nextInt();

			switch (op) {
			case 1:
				System.out.println("Digite os atributos da nova demanda:");

				System.out.print("Tipo (1-Urgente, 2-Crítico, 3-Normal): ");
				int tipo = scanner.nextInt();
				System.out.print("Distância da sede: ");
				int distanciaDaSede = scanner.nextInt();
				System.out.print("Distância da equipe: ");
				int distanciaDaEquipe = scanner.nextInt();
				System.out.print("Custo do reparo: ");
				int custoReparo = scanner.nextInt();
				System.out.print("Custo do impacto: ");
				int custoImpacto = scanner.nextInt();
				System.out.print("Pré-prioridade: ");
				int prePrioridade = scanner.nextInt();
				System.out.print("Regulamento: ");
				System.out.print("Prejuízo fiscal: ");
				int prejuizoFiscal = scanner.nextInt();
				System.out.print("Tempo de espera: ");
				int tempoEspera = scanner.nextInt();

				Demanda novaDemanda = new Demanda(tipo, distanciaDaSede, distanciaDaEquipe, custoReparo, custoImpacto,
						prePrioridade, prejuizoFiscal, tempoEspera);

				boolean emAndamento = false;
				while (true) {
					System.out.print("Adicionar à fila de andamento? (true/false): ");
					String entrada = scanner.next().trim().toLowerCase();

					if (entrada.equals("true")) {
						emAndamento = true;
						break;
					} else if (entrada.equals("false")) {
						emAndamento = false;
						break;
					} else {
						System.out.println(" Entrada inválida! Digite apenas 'true' ou 'false'.");
					}
				}

				gerenciador.adicionarDemanda(novaDemanda, emAndamento);
				break;

			case 2:
				gerenciador.listarDemandas();
				break;

			case 3:
				System.out.println("Saindo");
				scanner.close();
				return;

			default:
				System.out.println("Opção inválida. Tente novamente.");
				break;
			}
		}
	}
}