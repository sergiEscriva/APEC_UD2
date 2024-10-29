import Excepciones.DAOException;
import Objetos.*;
import ObjetosSerivios.*;

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
				case 1 ->
						chassis.agregarChassis(obtenerID(ultimoId), obtenerNombre(), obtenerFabricante(), obtenerAnyoDebut(), obtenerDerivado());
				case 2 ->
						chassis.actualizarChassis(obtenerID(), obtenerNombre(), obtenerFabricante(), obtenerAnyoDebut(), obtenerID());
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
		// Implement CRUD operations for EntradaPiloto
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
		} while (!finalizar);


	}

	private static int obtenerUltimoIdEquipo(EquipoServicio equipoServicio) {
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
		PilotoServicio piloto = new PilotoServicio();
		int ultimoId = obtenerUltimoIdPiloto(piloto);
		List<Piloto> pilotoList;
		boolean finalizar = Boolean.FALSE;
		switch (seleccionGestion()) {
			case 1 ->
					piloto.agregarPiloto(obtenerID(ultimoId), obtenerNombre(), obtenerApellido(), obtenerFechaNacimiento(), obtenerFechaMuerte(), obtenerLugarMuerte(), obtenerNacionalidad());
			case 2 ->
					piloto.actualizarPiloto(obtenerID(), obtenerNombre(), obtenerApellido(), obtenerFechaNacimiento(), obtenerFechaMuerte(), obtenerLugarMuerte(), obtenerNacionalidad());
			case 3 -> piloto.eliminarPiloto(obtenerID());
			case 4 -> {
				Piloto pilotoEncontrado = piloto.obtenerPiloto(obtenerID());
				if (pilotoEncontrado != null) {
					System.out.println(pilotoEncontrado);
				} else {
					System.out.println("Piloto no encontrado");
				}
			}
			case 5 -> {
				pilotoList = piloto.listarPilotos();
				pilotoList.forEach(System.out::println);
			}
			default -> finalizar = Boolean.TRUE;
		}
	}

	private static int obtenerUltimoIdPiloto(PilotoServicio pilotoServicio) {

		return pilotoServicio.obtenerUltimoId();

	}

	private static int obtenerUltimoIdProveedorRuedas(RuedasServicio ruedasServicio) {

		return ruedasServicio.obtenerUltimoId();

	}

	private static void gestionarProveedorRuedas() {
		RuedasServicio ruedas = new RuedasServicio();
		int ultimoID = obtenerUltimoIdProveedorRuedas(ruedas);
		List<Ruedas> ruedasList;
		boolean finalizar = Boolean.FALSE;
		do {
			imprimirGestion();
			switch (seleccionGestion()) {
				case 1 ->
						ruedas.agregarRuedas(obtenerID(ultimoID), obtenerNombre(), obtenerColorLetra(), obtenerColorFondo());
				case 2 ->
						ruedas.actualizarRuedas(obtenerID(), obtenerNombre(), obtenerColorLetra(), obtenerColorFondo());
				case 3 -> ruedas.eliminarRuedas(obtenerID());
				case 4 -> {
					Ruedas ruedasEncontrado = ruedas.obtenerRuedas(obtenerID());
					if (ruedasEncontrado != null) {
						System.out.println(ruedasEncontrado);
					} else {
						System.out.println("Provedor de ruedas no encontrado");
					}
				}
				case 5 -> {
					ruedasList = ruedas.listarRuedas();
					ruedasList.forEach(System.out::println);
				}
				default -> finalizar = Boolean.TRUE;
			}
		} while (!finalizar);
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

	private static int obtenerDerivado() {
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

	private static String obtenerDescripcion() {
		System.out.println("Intruduzca la descripcion: ");
		return sc.nextLine();
	}

	private static String obtenerApellido() {
		System.out.println("Introduzca el apellido: ");
		return sc.nextLine();
	}

	private static LocalDate obtenerFechaNacimiento() {
		System.out.println("Introduzca la fecha de nacimiento: ");
		return LocalDate.parse(sc.nextLine());
	}

	private static LocalDate obtenerFechaMuerte() {
		System.out.println("Introduzca la fecha de muerte: ");
		return LocalDate.parse(sc.nextLine());
	}

	private static String obtenerLugarMuerte() {
		System.out.println("Introduzca el lugar de muerte: ");
		return sc.nextLine();
	}

	private static String obtenerNacionalidad() {
		System.out.println("Introduzca la nacionalidad: ");
		return sc.nextLine();
	}
	
	private static String obtenerColorLetra() {
		System.out.println("Introduzca el color de la letra: ");
		return sc.nextLine();
	}
	private static String obtenerColorFondo() {
		System.out.println("Introduzca el color de fondo: ");
		return sc.nextLine();
	}


}