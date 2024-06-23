package br.edu.cesarschool.next.poo.projetoreferencia.conta;

import java.util.List;
import java.util.Scanner;

import br.edu.cesarschool.next.poo.projetoreferencia.utils.DateUtils;

public class TelaContaCorrente {

	MediatorContaCorrente mediator = new MediatorContaCorrente();
	Scanner scan = new Scanner(System.in);

	public void iniciar() {
		int opcao;
		do {
			System.out.println("Menu: ");
			System.out.println("1- Incluir Conta");
			System.out.println("2- Creditar");
			System.out.println("3- Debitar");
			System.out.println("4- Buscar Conta");
			System.out.println("5- Gerar Relatório");
			System.out.println("6- Sair");
			System.out.println("Escolha uma opção :");

			opcao = scan.nextInt();
			if (opcao == 1) {
				incluir();
			} else if (opcao == 2) {
				creditar();
			} else if (opcao == 3) {
				debitar();
			} else if (opcao == 4) {
				buscar();
			} else if (opcao == 5) {
				gerarRelatorioGeral();
			} else if (opcao == 6) {
				System.out.println("Fim de programa!!! Obrigado!");
			}

		} while (opcao != 6);

	}

	private void incluir() {

		System.out.print("Digite a agência: ");
		int agencia = scan.nextInt();

		System.out.print("Digite o numero: ");

		String numero = scan.next();

		System.out.print("Digite o Nome do dono da conta: ");

		String nomeDoCorrentista = scan.next();

		System.out.print("Digite o saldo da conta: ");
		double saldo = scan.nextDouble();

		System.out.print("É uma conta poupança? Digite 's' ou 'n' ");
		String poupanca = scan.next();

		ContaCorrente conta = null;
		if (poupanca.equalsIgnoreCase("s")) {
			double percentualDeBonus = scan.nextDouble();

			conta = new ContaPoupanca(agencia, numero, nomeDoCorrentista, saldo, percentualDeBonus);

		} else {
			conta = new ContaCorrente(agencia, numero, nomeDoCorrentista, saldo);
		}
		String mensagem = mediator.incluir(conta);
		if (mensagem == null) {
			System.out.println("Conta Criada com sucesso!!");
		} else {
			System.out.println("Erro" + mensagem);
		}
	}

	private void creditar() {

		System.out.print("Digite a agência: ");
		int agencia = scan.nextInt();

		System.out.print("Digite o numero: ");
		String numero = scan.next();

		System.out.print("Digite o valor a ser creditado: ");
		double valor = scan.nextDouble();

		String mensagem = mediator.creditar(valor, agencia, numero);

		if (mensagem == null) {
			System.out.println("Conta Creditada com sucesso!!");
		} else {
			System.out.println("Erro ao creditar" + mensagem);
		}
	}

	private void debitar() {

		System.out.print("Digite a agência: ");
		int agencia = scan.nextInt();

		System.out.print("Digite o numero: ");
		String numero = scan.next();

		System.out.print("Digite o valor a ser debitado: ");
		double valor = scan.nextDouble();

		String mensagem = mediator.debitar(valor, agencia, numero);

		if (mensagem == null) {
			System.out.println("Conta Debitada com sucesso!!");
		} else {
			System.out.println("Erro ao Debitar" + mensagem);
		}
	}

	private void buscar() {
		System.out.print("Agência: ");
		int agencia = scan.nextInt();

		System.out.print("Número: ");
		String numero = scan.next();

		ContaCorrente conta = mediator.buscar(agencia, numero);
		if (conta == null) {
			System.out.println("Conta não existe.");
		} else {
			System.out.println("Dados da Conta:");
			System.out.println("Agência: " + conta.getAgencia());
			System.out.println("Número: " + conta.getNumero());
			System.out.println("Nome do Correntista: " + conta.getNomeDoCorrentista());
			System.out.println("Saldo: " + conta.getSaldo());

			if (conta instanceof ContaPoupanca) {
				ContaPoupanca poupanca = (ContaPoupanca) conta;
				System.out.println("percentual Bônus: " + poupanca.getPercentualDeBonus());
			}
			System.out.println("data/hora da inclusão: " + DateUtils.formatar(conta.getDhInclusao()));
			System.out
					.println("Data/Hora da Última Atualização: " + DateUtils.formatar(conta.getDhUltimaAtualizacao()));

		}
	}

	private void gerarRelatorioGeral() {
		List<ContaCorrente> contas = mediator.gerarRelatorioGeral();
		if (contas == null || contas.isEmpty()) {
			System.out.println("Nenhuma conta encontrada.");
		} else {
			for (ContaCorrente conta : contas) {
				System.out.println("Dados da Conta:");
				System.out.println("Agência: " + conta.getAgencia());
				System.out.println("Número: " + conta.getNumero());
				System.out.println("Nome do Correntista: " + conta.getNomeDoCorrentista());
				System.out.println("Saldo: " + conta.getSaldo());

				if (conta instanceof ContaPoupanca) {
					ContaPoupanca poupanca = (ContaPoupanca) conta;
					System.out.println("Percentual de Bônus: " + poupanca.getPercentualDeBonus());
				}

				System.out.println("Data/Hora de Inclusão: " + DateUtils.formatar(conta.getDhInclusao()));
				System.out.println(
						"Data/Hora da Última Atualização: " + DateUtils.formatar(conta.getDhUltimaAtualizacao()));

			}
		}
	}
}
