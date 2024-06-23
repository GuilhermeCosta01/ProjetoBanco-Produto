package br.edu.cesarschool.next.poo.projetoreferencia.produto;

public class ProdutoCestaBasica extends Produto {
	private boolean isentoImposto;
	private double descontoImposto;
	public ProdutoCestaBasica(long codigo, String nome, double precoBase, 
		boolean isentoImposto, double descontoImposto) {
		super(codigo, nome, precoBase);
		this.isentoImposto = isentoImposto;
		this.descontoImposto = descontoImposto;
	}
	public boolean isIsentoImposto() {
		return isentoImposto;
	}
	public void setIsentoImposto(boolean isentoImposto) {
		this.isentoImposto = isentoImposto;
	}
	public double getDescontoImposto() {
		return descontoImposto;
	}
	public void setDescontoImposto(double descontoImposto) {
		this.descontoImposto = descontoImposto;
	}
	@Override
	public double calcularPrecoFinal(double aliquotaImposto) {
		if (isentoImposto) {
			return getPrecoBase();
		} else {
			double aliquotaNova = aliquotaImposto * (1 - descontoImposto/100.0);
			return super.calcularPrecoFinal(aliquotaNova);
		}
	}	
}
