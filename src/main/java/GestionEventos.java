import Excepciones.DAOException;
import Objetos.Categoria;
import Objetos.Chassis;
import Objetos.Equipo;
import ObjetosSerivios.CategoriaServicio;
import ObjetosSerivios.ChassisServicio;
import ObjetosSerivios.EquipoServicio;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class GestionEventos {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("Bienvenid@ al creador de eventos de MotorSport");
		System.out.println("Elija la tabla a la que quiere acceder");
		imprimirTalbas();

		seleccionOpcion();


	}

	private static void imprimirTalbas() {
		System.out.println("1. Categoria\n" +
				"2. Chassis\n" +
				"3. EntradaPiloto\n" +
				"4. Equipo\n" +
				"5. Evento\n" +
				"6. Motor\n" +
				"7. Piloto\n" +
				"8. Proveedor de Ruedas");
	}

	private static void imprimirGestion() {
		System.out.println("1. Insertar\n" +
				"2. Modificar\n" +
				"3. Eliminar\n" +
				"4. Buscar\n" +
				"5. Ver Todos");
	}

	private static void gestionarCategoria() {

		CategoriaServicio categoria = new CategoriaServicio();
		int ultimoID = obtenerUltimoIDCategoria(categoria);
		List<Categoria> categorias;
		boolean finalizar = Boolean.FALSE;
		do {
			imprimirGestion();
			switch (seleccionGestion()) {
				case 1 ->
						categoria.agregarCategoria(obtenerID(ultimoID), obtenerNombre(), obtenerNombreCorto(), obtenerRelevancia());
				case 2 ->
						categoria.actualizarCategoria(obtenerID(), obtenerNombre(), obtenerNombreCorto(), obtenerRelevancia());
				case 3 -> categoria.eliminarCategoria(obtenerID());
				case 4 -> {
					Categoria categoriaEncontrada = categoria.obtenerCategoria(obtenerID());
					if (categoriaEncontrada != null) {
						System.out.println(categoriaEncontrada);
					} else {
						System.out.println("Categoria no encontrada");
					}
				}
				case 5 -> {
					categorias = categoria.listarCategorias();
					categorias.forEach(System.out::println);
				}
				default -> finalizar = Boolean.TRUE;
			}
			sc.nextLine();
		} while (!finalizar);

	}

	private static int obtenerUltimoIDCategoria(CategoriaServicio categoriaServicio) {
		try {
			return categoriaServicio.obtenerUltimoID();
		} catch (DAOException e) {
			System.out.println("Error en la obencion del ultimo ID");
		}
		return 0;
	}

	private static void gestionarChassis() {
		ChassisServicio chassis = new ChassisServicio();
		int ultimoId = obtenerUltimoIdChassis(chassis);
		List<Chassis> chassisList;
		boolean finalizar = Boolean.FALSE;
		do {
			imprimirGestion();
			switch (seleccionGestion()) {
				case 1 -> chassis.agregarChassis(obtenerID(ultimoId), obtenerNombre(), obtenerFabricante(), obtenerAnyoDebut(), obtenerDerivado());
				case 2 -> chassis.actualizarChassis(obtenerID(), obtenerNombre(), obtenerFabricante(), obtenerAnyoDebut(), obtenerID());
				case 3 -> chassis.eliminarChassis(obtenerID());
				case 4 -> {
					Chassis chassisEncontrado = chassis.obtenerChassis(obtenerID());
					if (chassisEncontrado != null) {
						System.out.println(chassisEncontrado);
					} else {
						System.out.println("Categoria no encontrada");
					}
				}
				case 5 -> {
					chassisList = chassis.listarChassis();
					chassisList.forEach(System.out::println);
				}
				default -> finalizar = Boolean.TRUE;
			}
			sc.nextLine();

		} while (!finalizar);

	}

	private static int obtenerUltimoIdChassis(ChassisServicio chassisServicio) {
		try {
			return chassisServicio.obtenerUltimoId();
		} catch (DAOException e) {
			System.out.println("Error en la obencion del ultimo ID");
		}
		return 0;
	}

	private static void gestionarEntradaPiloto() {
		System.out.println("Gestionando EntradaPiloto");
	}

	private static void gestionarEquipo() {
		EquipoServicio equipo = new EquipoServicio();
		int ultimoID = obtenerUltimoIdEquipo(equipo);
		List<Equipo> equipoList;
		boolean finalizar = Boolean.FALSE;
		do {
			imprimirGestion();
			switch (seleccionGestion()) {
				case 1 -> equipo.agregarEquipo(obtenerID(ultimoID), obtenerNombre(), obtenerDescripcion());
				case 2 -> equipo.actualizarEquipo(obtenerID(), obtenerNombre(), obtenerDescripcion());
				case 3 -> equipo.eliminarEquipo(obtenerID());
				case 4 -> {
					Equipo equipoencontrado = equipo.obtenerEquipo(obtenerID());
					if (equipoencontrado != null) {
						System.out.println(equipo);
					} else {
						System.out.println("Categoria no encontrada");
					}
				}
				case 5 -> {
					equipoList = equipo.listarEquipos();
					equipoList.forEach(System.out::println);
				}
				default -> finalizar = Boolean.TRUE;
			}
			sc.nextLine();
		}while (!finalizar);


	}
	
	private static int obtenerUltimoIdEquipo(EquipoServicio equipoServicio){
		try {
			return equipoServicio.obtenerUltimoId();
		} catch (DAOException e) {
			System.out.println("Error en la obencion del ultimo ID");
		}
		return 0;
	}
	private static void gestionarEvento() {
		// Implement CRUD operations for Evento
		System.out.println("Gestionando Evento");
	}

	private static void gestionarMotor() {
		// Implement CRUD operations for Motor
		System.out.println("Gestionando Motor");
	}

	private static void gestionarPiloto() {
		// Implement CRUD operations for Piloto
		System.out.println("Gestionando Piloto");
	}

	private static void gestionarProveedorRuedas() {
		// Implement CRUD operations for Proveedor de Ruedas
		System.out.println("Gestionando Proveedor de Ruedas");
	}

	private static int seleccionGestion() {
		char opcion = sc.nextLine().charAt(0);
		int opcionElejida = 0;
		switch (opcion) {
			case '1' -> opcionElejida = 1;
			case '2' -> opcionElejida = 2;
			case '3' -> opcionElejida = 3;
			case '4' -> opcionElejida = 4;
			case '5' -> opcionElejida = 5;
		}
		return opcionElejida;
	}

	private static void seleccionOpcion() {

		char opcion = sc.nextLine().charAt(0);
		switch (opcion) {
			case '1' -> gestionarCategoria();
			case '2' -> gestionarChassis();
			case '3' -> gestionarEntradaPiloto();
			case '4' -> gestionarEquipo();
			case '5' -> gestionarEvento();
			case '6' -> gestionarMotor();
			case '7' -> gestionarPiloto();
			case '8' -> gestionarProveedorRuedas();
			default -> System.out.println("Opción no válida");
		}

	}

	private static int obtenerID() {
		System.out.println("Obtener id: ");
		int resultado = 0;
		boolean correcto = Boolean.FALSE;
		do {
			try {
				resultado = sc.nextInt();
				correcto = Boolean.TRUE;

			} catch (InputMismatchException e) {
				System.out.println("Introduze un numero valido");
				sc.next();
			}
		} while (!correcto);
		sc.nextLine();

		return resultado;
	}
	
	private static int obtenerDerivado(){
		System.out.println("Obtener id del derivado: ");
		int resultado = 0;
		boolean correcto = Boolean.FALSE;
		do {
			try {
				resultado = sc.nextInt();
				correcto = Boolean.TRUE;

			} catch (InputMismatchException e) {
				System.out.println("Introduze un numero valido");
				sc.next();
			}
		} while (!correcto);
		sc.nextLine();

		return resultado;
	}

	private static int obtenerID(int ultimoID) {
		int nuevoID = 0;
		boolean correcto = false;
		do {
			try {
				System.out.println("Introduce un ID posterior a " + ultimoID + ": ");
				nuevoID = sc.nextInt();
				if (nuevoID > ultimoID) {
					correcto = true;
				} else {
					System.out.println("El ID debe ser mayor que " + ultimoID);
				}
			} catch (Exception e) {
				System.out.println("Introduce un número válido.");
				sc.next();
			}
			sc.nextLine();
		} while (!correcto);
		return nuevoID;
	}

	private static String obtenerNombre() {
		System.out.println("Introduze el nombre: ");
		return sc.nextLine();
	}

	private static String obtenerNombreCorto() {
		System.out.println("Introduze el nombre corto: ");
		return sc.nextLine();
	}

	private static int obtenerRelevancia() {
		System.out.println("Obtener relevancia: ");
		int resultado = 0;
		boolean correcto = Boolean.FALSE;
		do {
			try {
				resultado = sc.nextInt();
				if (resultado < 1000) {
					correcto = Boolean.TRUE;
				} else {
					System.out.println("Se debe untroduzir un numero menos de 1000");
				}
			} catch (InputMismatchException e) {
				System.out.println("Introduze un numero valido");
			}
		} while (!correcto);

		return resultado;
	}

	private static String obtenerFabricante() {
		System.out.println("Introduzca el fabicante: ");
		return sc.nextLine();
	}

	private static int obtenerAnyoDebut() {
		System.out.println("Introduzca el anyo de debut: ");
		int resultado = 0;
		boolean correcto = Boolean.FALSE;
		int anyoActual = LocalDate.now().getYear();
		do {
			try {
				resultado = sc.nextInt();
				if (resultado > 1900 && resultado <= anyoActual) {
					correcto = Boolean.TRUE;
				} else {
					System.out.println("Se debe introduzir un numero entre el 1900 y " + anyoActual);
				}
			} catch (InputMismatchException e) {
				System.out.println("Introduze un numero valido");
				sc.next();
			}
		} while (!correcto);
		sc.nextLine();

		return resultado;
	}
	
	private static String  obtenerDescripcion(){
		System.out.println("Intruduzca la descripcion: ");
		return sc.nextLine();
	}


}
