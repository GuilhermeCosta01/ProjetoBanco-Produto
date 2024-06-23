package br.edu.cesarschool.next.poo.projetoreferencia.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {
	public static String formatar(LocalDateTime dh) {
		if (dh != null) {			
			DateTimeFormatter europeanDateFormatter = 
					DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");
			return europeanDateFormatter.format(dh);
		} else {
			return null;
		}
	}
}
