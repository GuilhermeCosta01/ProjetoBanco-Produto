package br.edu.cesarschool.next.poo.projetoreferencia.produto;

import java.util.Comparator;

public class ComparadorProdutoNome implements Comparator {
	@Override
	public int compare(Object o1, Object o2) {
		if (!(o1 instanceof Produto) || !(o2 instanceof Produto)) {
			return 0;
		} else {
			Produto p1 = (Produto)o1;
			Produto p2 = (Produto)o2;
			return p1.getNome().compareTo(p2.getNome());
		}
	}
	
	

}
