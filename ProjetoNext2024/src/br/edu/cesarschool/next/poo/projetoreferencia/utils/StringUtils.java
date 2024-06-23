package br.edu.cesarschool.next.poo.projetoreferencia.utils;

public class StringUtils {
	public static boolean stringVazia(String str) {
		return str == null || str.trim().equals("");
	}
	public static boolean stringEhNumeroInteiro(String str) {
		try {
			Long.parseLong(str);
			return true;
		} catch (Exception e) {
			return false;
		}
	} 
	public static String formatar(int valor, int qtdZeros) {
		return String.format("%0" + qtdZeros + "d", valor);
	}
}
