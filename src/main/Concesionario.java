/**
 * 
 */
package main;

import java.security.PublicKey;

/**
 * @author angel Gestiona los vehículos
 */
public class Concesionario {
	/**
	 * Valor que se usa para conocer la posición libre del array
	 */
	private int indice = 0;
	/**
	 * Lista de vehiculos que tiene la aplicación
	 */
	private Vehiculo[] vehiculos = new Vehiculo[50];

	/**
	 * <p>
	 * Busca los vehiculos en el array de vehiculos por matrícula
	 * </p>
	 * 
	 * @param matricula
	 * @return null | String
	 */
	public String buscaVehiculo(String matricula) {
		String datosVehiculo = null;

		for (int i = 0; i < indice; i++) {
			if (vehiculos[i].getMatricula().equals(matricula)) {
				datosVehiculo = "La matrícula es:" + vehiculos[i].getMatricula() + " el precio es: "
						+ vehiculos[i].getPrecio() + " y la marca es: " + vehiculos[i].getMarca();
			}
		}
		return datosVehiculo;
	}

	/**
	 * <p>
	 * Inserta los vehiculos en el array de vehiculos
	 * </p>
	 * 
	 * @param marca
	 * @param matricula
	 * @param descripcion
	 * @param precio
	 * @param kilometros
	 * @return 0,-1, 2 respectivamente: operación éxitosa, array lleno, Matrícula ya
	 *         en el array
	 */
	public int insertarVehiculo(String marca, String matricula, String descripcion, double precio, int kilometros,
			Propietario p) {
		if (indice == 50) {
			return -1;
		} else if (this.buscaVehiculo(matricula) != null) {
			return 2;
		}
		vehiculos[indice] = new Vehiculo(marca, matricula, descripcion, precio, kilometros, p);
		indice++;
		return 0;
	}

	/**
	 * Lista por pantalla los datos de todos los vehículos del concesionario.
	 * 
	 * @return void
	 */
	public void listaVehiculos() {
		for (int i = 0; i < indice; i++) {
			System.out.println(vehiculos[i].toString());
		}
	}

	/**
	 * Recibe por parámetro una matrícula y un número de kilómetros, busca el
	 * vehículo con la cuya matrícula coincida y actualiza sus kilómetros. Devuelve
	 * true si se hizo con éxito y false en caso contrario.
	 * 
	 * @param matricula
	 * @param kms
	 * @return boolean
	 */
	public boolean actualizaKms(String matricula, int kms) {
		for (int i = 0; i < indice; i++) {
			if (vehiculos[i].getMatricula().equals(matricula)) {
				vehiculos[i].setKilometros(kms);
				return true;
			}
		}
		return false;
	}

	/**
	 * vamos a copiar todo nuestro array menos el que queremos eliminar, actualizar
	 * el último índice
	 * 
	 * @param matricula
	 * @return boolean
	 */
	public boolean eliminarVehiculo(String matricula) {

		if (buscaVehiculo(matricula) != null) {
			Vehiculo[] vehiculosActualizados = new Vehiculo[50];
			int indiceActualizados = 0;
			for (int i = 0; i < indice; i++) {
				if (!vehiculos[i].getMatricula().equals(matricula)) {
					vehiculosActualizados[indiceActualizados] = vehiculos[i];
					indiceActualizados++;
				}
			}
			vehiculos = vehiculosActualizados;
			indice = indiceActualizados;
			return true;
		}
		return false;
	}

	/**
	 * @return the indice
	 */
	public int getIndice() {
		return indice;
	}

	/**
	 * @param indice the indice to set
	 */
	public void setIndice(int indice) {
		this.indice = indice;
	}

	/**
	 * @return the vehiculos
	 */
	public Vehiculo[] getVehiculos() {
		return vehiculos;
	}

	/**
	 * @param vehiculos the vehiculos to set
	 */
	public void setVehiculos(Vehiculo[] vehiculos) {
		this.vehiculos = vehiculos;
	}

}
