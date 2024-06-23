package br.edu.cesarschool.next.poo.projetoreferencia.conta;

public class ContaPoupanca extends ContaCorrente {

	private double percentualDeBonus;

	public ContaPoupanca() {

	}

	public ContaPoupanca(int agencia, String numero, String nomeDoCorrentista, double saldo, double percentualDeBonus) {
		super(agencia, numero, nomeDoCorrentista, saldo);
		this.percentualDeBonus = percentualDeBonus;
	}

	public double getPercentualDeBonus() {
		return percentualDeBonus;
	}

	public void setPercentualDeBonus(double percentualDeBonus) {
		this.percentualDeBonus = percentualDeBonus;
	}

	@Override
	public void creditar(double valor) {
		double valorPoupanca = valor * (1 + percentualDeBonus / 100);
		super.creditar(valorPoupanca);
	}
}
