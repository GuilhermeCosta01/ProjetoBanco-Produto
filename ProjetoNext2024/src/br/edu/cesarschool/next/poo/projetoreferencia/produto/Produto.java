package br.edu.cesarschool.next.poo.projetoreferencia.produto;

import br.edu.cesarschool.next.poo.projetoreferencia.utils.Registro;

public class Produto extends Registro {
	private long codigo;
	private String nome;
	private int estoque = 0;
	private double precoBase;
	public Produto(long codigo, String nome, double precoBase) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.precoBase = precoBase;
	}
	
	public long getCodigo() {
		return codigo;
	}
	public String getNome() {
		return nome;
	}
	public int getEstoque() {
		return estoque;
	}
	public double getPrecoBase() {
		return precoBase;
	}	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setPrecoBase(double precoBase) {
		this.precoBase = precoBase;
	}
	public void adicionarEstoque(int quantidade) {
		estoque = estoque + quantidade;
	}
	public void subtrairEstoque(int quantidade) {
		estoque = estoque - quantidade;
	}
	public double calcularPrecoFinal(double aliquotaImposto) {
		return precoBase * (1 + aliquotaImposto/100.0);
	}
	public String getIdUnico() {
		return "" + codigo;
	}
}
