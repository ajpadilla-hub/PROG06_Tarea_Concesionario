/**
 * 
 */
package main;

/**
 * @author angel
 * Almacena los datos de el dueño del coche
 */
public class Propietario {

	private String nombre;
	private String DNI;
	/**
	 * @param nombre
	 * @param dNI
	 */
	public Propietario(String nombre, String dNI) {
		super();
		this.nombre = nombre;
		DNI = dNI;
	}
	/**
	 * @return the DNI
	 */
	public String getDNI() {
		return DNI;
	}
	/**
	 * @param DNI the DNI to set
	 */
	public void setDNI(String dNI) {
		DNI = dNI;
	}
	
}
