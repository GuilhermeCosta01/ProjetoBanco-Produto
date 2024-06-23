package br.edu.cesarschool.next.poo.projetoreferencia.conta;

import java.util.Comparator;

public class ComparadorContaCorrente implements Comparator <ContaCorrente>{
	
public int compare(ContaCorrente o1, ContaCorrente o2) {
	double ob1 = o1.getSaldo();
	double ob2 = o2.getSaldo();
	if (ob1>ob2) {
		return 1;
	}
	else if(ob1<ob2) {
		return -1;
	}
	return 0;	
}

}
