package br.edu.cesarschool.next.poo.projetoreferencia.conta;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.edu.cesarschool.next.poo.projetoreferencia.utils.DAOGenerico;
import br.edu.cesarschool.next.poo.projetoreferencia.utils.Registro;
import br.edu.cesarschool.next.poo.projetoreferencia.utils.StringUtils;

public class MediatorContaCorrente {

	private DAOGenerico dao = new DAOGenerico(ContaCorrente.class);

	public String validarConta(ContaCorrente conta) {
		String mensagem = null;
		if (conta == null) {
			mensagem = "Conta não informada!";
		}
		if (conta.getAgencia() <= 0 || conta.getAgencia() > 999) {

			mensagem = "Sua agencia não pode ser menor que 0 ou maior que 999";
		} // informa se os valores são nulos ou vazios
		if (StringUtils.stringVazia(conta.getNumero())) {
			mensagem = "Nome não informado";
		}
		if (conta.getSaldo() < 0) {
			mensagem = "Saldo deve ser maior do que 0";
		}
		if (StringUtils.stringVazia(conta.getNomeDoCorrentista()) || conta.getNomeDoCorrentista().length() > 60) {
			mensagem = "Nome não informado";
		}

		if (conta instanceof ContaPoupanca) {
			ContaPoupanca contPoup = (ContaPoupanca) conta;
			if (contPoup.getPercentualDeBonus() < 0) {
				mensagem = "O percentual de bonus deve ser maior que 0";
			}
		}
		return mensagem;
	}

	public String incluir(ContaCorrente conta) {
		String mensagem = validarConta(conta);
		if (mensagem != null) {
			return mensagem;
		}
		if (!dao.incluir(conta)) {
			return "Conta já existente";
		}
		return null;
	}

	public String validarCreditaDebita(double valor, int agencia, String numero) {
		String mensagemCredDeb = null;
		if (valor < 0) {
			mensagemCredDeb = "O valor precisa ser igual ou maior que zero";
		} else if (agencia <= 0 || agencia > 999) {
			mensagemCredDeb = "A agencia tem que ser maior que zero e menor que 1000";
		} else if (StringUtils.stringVazia(numero)) {
			mensagemCredDeb = "numero não informado";
		}
		return mensagemCredDeb;
	}

	public String creditar(double valor, int agencia, String numero) {
		String mensagemCredito = validarCreditaDebita(valor, agencia, numero);
		if (mensagemCredito != null) {
			return mensagemCredito;
		}
		ContaCorrente busca = buscar(agencia, numero);

		busca.creditar(valor);

		if (!dao.alterar(busca)) {
			return "Conta não existe";
		}
		return mensagemCredito;
	}

	public String debitar(double valor, int agencia, String numero) {
		String mensagemDebito = validarCreditaDebita(valor, agencia, numero);
		if (mensagemDebito != null) {
			return mensagemDebito;
		}

		ContaCorrente busca = buscar(agencia, numero);
		if (busca.getSaldo() < valor) {
			return "Saldo insulficiente!";
		}
		busca.debitar(valor);
		if (!dao.alterar(busca)) {
			return "Conta não existe";
		}

		return mensagemDebito;
	}

	public ContaCorrente buscar(int agencia, String numero) {
		String buscar = ContaCorrente.obterChave(agencia, numero);
		return (ContaCorrente) dao.buscar(buscar);
	}

	List<ContaCorrente> gerarRelatorioGeral() {
		List<ContaCorrente> contas = new ArrayList<ContaCorrente>();
		Registro[] regs = dao.buscarTodos();

		for (int i = 0; i < regs.length; i++) {
			contas.add((ContaCorrente) regs[i]);

			/*
			 * for (Registro registro : regs) { //contas.add((ContaCorrente)registro);}
			 */
		}
		Collections.sort(contas, new ComparadorContaCorrente());
		return contas;
	}
}
