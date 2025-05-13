/**
 * 
 */
package main;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author angel
 *         <p>
 *         Punto de entrada de la aplicación donde se ejecuta el bucle principal
 *         </p>
 */
public class Principal {
	private static final int NUEVO_VEHICULO = 1;
	private static final int LISTAR_VEHICULOS = 2;
	private static final int BUSCAR_VEHICULO = 3;
	private static final int MODIFICAR_KMS = 4;
	private static final int SALIR = 5;
	private static final int ELIMINAR = 6;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			Concesionario concesionario = new Concesionario();
			String matricula = "";
			int kms = 0;
			String dni = "";
			int opcion = 0;
			do {

				verMenu();
				opcion = scanner.nextInt();
				scanner.nextLine();

				switch (opcion) {
				case NUEVO_VEHICULO:
					System.out.println("Introduzca los siguientes datos");
					System.out.print("Marca: ");
					String marca = scanner.nextLine();

					System.out.print("Matrícula : ");
					matricula = scanner.nextLine();
					while (!Validacion.validarMatricula(matricula)) {
						System.out.print("introduzca una matrícula válida : ");
						matricula = scanner.nextLine();
					}

					System.out.print("Precio: ");
					double precio = scanner.nextDouble();
					scanner.nextLine();

					System.out.print("Kilómetros: ");
					kms = scanner.nextInt();
					scanner.nextLine();

					System.out.print("Descripción: ");
					String descripcion = scanner.nextLine();

					System.out.print("Nombre propietario: ");
					String nombre = scanner.nextLine();
					while (!Validacion.validarNombreApellidos(nombre)) {
						System.out.print("introduzca un nombre y apellidos válidos : ");
						nombre = scanner.nextLine();
					}

					System.out.print("DNI propietario: ");
					dni = scanner.nextLine();
					while (!Validacion.validarDNI(dni)) {
						System.out.print("introduzca un DNI válido : ");
						dni = scanner.nextLine();
					}

					Propietario propietario = new Propietario(nombre, dni);

					int resultadoInsertar = concesionario.insertarVehiculo(marca, matricula, descripcion, precio, kms,
							propietario);
					switch (resultadoInsertar) {
					case 0:
						System.out.println("Vehículo añadido con éxito.");
						break;
					case -1:
						System.out.println("Error: El concesionario está lleno.");
						break;
					case -2:
						System.out.println("Error: La matrícula ya existe.");
						break;
					}
					break;
				case LISTAR_VEHICULOS:
					concesionario.listaVehiculos();
					break;
				case BUSCAR_VEHICULO:
					System.out.print("Introduce la matrícula a buscar: ");
					matricula = scanner.nextLine();
					String resultado = concesionario.buscaVehiculo(matricula);
					if (resultado != null) {
						System.out.println(resultado);
					} else {
						System.out.println("No existe vehículo con la matrícula introducida.");
					}
					break;
				case MODIFICAR_KMS:
					System.out.print("Introduce la matrícula del vehículo: ");
					matricula = scanner.nextLine();

					System.out.print("Introduce los nuevos kilómetros: ");
					kms = scanner.nextInt();
					scanner.nextLine();
					if (concesionario.actualizaKms(matricula, kms)) {
						System.out.println("Kilómetros actualizados correctamente.");
					} else {
						System.out.println("No se encontró el vehículo.");
					}
					break;
				case SALIR:
					System.out.println("Hasta la próxima!.");
					break;
				case ELIMINAR:
					System.out.print("Introduce la matrícula del vehículo a eliminar: ");
					matricula = scanner.nextLine();
					boolean resultadoEliminar = concesionario.eliminarVehiculo(matricula);
					if (resultadoEliminar) {
						System.out.println("Vehículo eliminado con éxito!");
					}
					break;
				default:
					System.out.println("Opción inválida!");
				}
			} while (opcion != SALIR);
		}
	}

	/**
	 * <p>
	 * Muestra el menu por la salida estándar
	 * </p>
	 */
	private static void verMenu() {
		System.out.println(NUEVO_VEHICULO + ". Nuevo Vehículo.");
		System.out.println(LISTAR_VEHICULOS + ". Listar Vehículos.");
		System.out.println(BUSCAR_VEHICULO + ". Buscar Vehículo.");
		System.out.println(MODIFICAR_KMS + ". Modificar kms Vehículo.");
		System.out.println(SALIR + ". Salir.");
		System.out.println(ELIMINAR + ". Eliminar.");
	}

}
