package br.edu.cesarschool.next.poo.projetoreferencia.produto;

public class RetornoPrecoTotal {
	private double precoTotal;
	private String mensagem;
	
	public RetornoPrecoTotal(double precoTotal, String mensagem) {
		super();
		this.precoTotal = precoTotal;
		this.mensagem = mensagem;
	}	
	public double getPrecoTotal() {
		return precoTotal;
	}
	public String getMensagem() {
		return mensagem;
	}
}
