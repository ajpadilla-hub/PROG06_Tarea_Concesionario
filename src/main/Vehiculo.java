/**
 * 
 */
package main;

/**
 * @author angel Clase que almacena los datos de un vehiculo
 */
public class Vehiculo {
	private String marca, matricula, descripcion;
	private double precio;
	private int kilometros;
	private Propietario propietario;

	/**
	 * @param marca
	 * @param matricula
	 * @param descripcion
	 * @param precio
	 * @param kilometros
	 * @param propietario
	 */
	public Vehiculo(String marca, String matricula, String descripcion, double precio, int kilometros,
			Propietario propietario) {
		super();
		this.marca = marca;
		this.matricula = matricula;
		this.descripcion = descripcion;
		this.precio = precio;
		this.kilometros = kilometros;
		this.propietario = propietario;
	}

	/**
	 * @return the marca
	 */
	public String getMarca() {
		return marca;
	}

	/**
	 * @param marca the marca to set
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}

	/**
	 * @return the matricula
	 */
	public String getMatricula() {
		return matricula;
	}

	/**
	 * @param matricula the matricula to set
	 */
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the precio
	 */
	public double getPrecio() {
		return precio;
	}

	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	/**
	 * @return the kilometros
	 */
	public int getKilometros() {
		return kilometros;
	}

	/**
	 * @param kilometros the kilometros to set
	 */
	public void setKilometros(int kilometros) {
		this.kilometros = kilometros;
	}

	/**
	 * @return the propietario
	 */
	public Propietario getPropietario() {
		return propietario;
	}

	/**
	 * @param propietario the propietario to set
	 */
	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}

	@Override
	public String toString() {
		return "Vehiculo [marca=" + marca + ", matricula=" + matricula + ", descripcion=" + descripcion + ", precio="
				+ precio + ", kilometros=" + kilometros + "]";
	}

}