package br.edu.cesarschool.next.poo.projetoreferencia.conta;

import br.edu.cesarschool.next.poo.projetoreferencia.utils.Registro;

public class ContaCorrente extends Registro {

	private int agencia;
	private String numero;
	private String nomeDoCorrentista;
	private double saldo;

	public ContaCorrente() {

	}

	public ContaCorrente(int agencia, String numero, String nomeDoCorrentista, double saldo) {
		this.agencia = agencia;
		this.numero = numero;
		this.nomeDoCorrentista = nomeDoCorrentista;
		this.saldo = saldo;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public String getNomeDoCorrentista() {
		return nomeDoCorrentista;
	}

	public void setNomeDoCorrentista(String nomeDoCorrentista) {
		this.nomeDoCorrentista = nomeDoCorrentista;
	}

	public void creditar(double valor) {
		this.saldo = saldo + valor;
	}

	public void debitar(double valor) {
		this.saldo = saldo - valor;
	}

	public static String obterChave(int agencia, String numero) {
		return String.format("%03d", agencia) + numero;
	}

	public String getIdUnico() {
		return obterChave(agencia, numero);

	}

}
