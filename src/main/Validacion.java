package main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validacion {
	/**
	 * Valida el formato del DNI introducido
	 * 
	 * @param dni
	 * @return
	 */
	public static boolean validarDNI(String DNI) {
		Pattern p = Pattern.compile("\\d{8}[A-Z]");
		Matcher m = p.matcher(DNI);
		return m.matches();
	}

	/**
	 * Valida el formato de la matrícula introducida
	 * 
	 * @param matricula
	 * @return
	 */
	public static boolean validarMatricula(String matricula) {
		Pattern p = Pattern.compile("\\d{4}[A-Z]{3}");
		Matcher m = p.matcher(matricula);
		return m.matches();
	}

	/**
	 * Valida el formato para que el nombre del propietario contenga al menos un
	 * nombre y dos apellidos (no trata nombres compuestos) y su longitud no excede
	 * de 40 caracteres.
	 * 
	 * @param nombre
	 * @return
	 */
	public static boolean validarNombreApellidos(String nombre) {
		return nombre.split(" ").length >= 3 && nombre.length() <= 40;
	}
}
