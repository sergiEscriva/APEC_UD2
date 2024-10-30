import Excepciones.DAOException;
import Objetos.*;
import ObjetosServicios.*;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class GestionEventos {

	static Scanner sc = new Scanner(System.in);
	static List<Piloto> pilotoList;

	public static void main(String[] args) {

		System.out.println("Bienvenid@ al creador de eventos de MotorSport");
		System.out.println("Elija la tabla a la que quiere acceder");
		seleccionOpcion();


	}
	/**
	 * Imprime las tablas disponibles.
	 */
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

	/**
	 * Imprime las opciones de gestión disponibles.
	 */
	private static void imprimirGestion() {
		System.out.println("1. Insertar\n" +
				"2. Modificar\n" +
				"3. Eliminar\n" +
				"4. Buscar\n" +
				"5. Ver Todos\n" +
				"!. Salir");
	}
	/**
	 * Gestiona las categorías, permitiendo agregar, actualizar, eliminar, buscar y listar categorías.
	 */
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
	/**
	 * Gestiona los chasis, permitiendo agregar, actualizar, eliminar, buscar y listar chasis.
	 */
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
	/**
	 * Gestiona los equipos, permitiendo agregar, actualizar, eliminar, buscar y listar equipos.
	 */
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
	/**
	 * Gestiona los eventos, permitiendo agregar, actualizar, eliminar, buscar y listar eventos.
	 */
	private static void gestionarEvento() {
		EventoServicio evento = new EventoServicio();
		int ultimoID = obtenerUltimoIdEvento(evento);
		List<Evento> eventoList;
		boolean finalizar = Boolean.FALSE;
		do {
			imprimirGestion();
			switch (seleccionGestion()) {
				case 1 ->
						evento.agregarEvento(obtenerID(ultimoID), obtenerNombre(), obtenerChassisId(), obtenerMotorId(), obtenerDirigidoPorId(), obtenerRuedasId(), obtenerNumeroPiloto(), obtenerEquipoId(), obtenerCategoriaId());
				case 2 ->
						evento.actualizarEvento(obtenerID(), obtenerNombre(), obtenerChassisId(), obtenerMotorId(), obtenerDirigidoPorId(), obtenerRuedasId(), obtenerNumeroPiloto(), obtenerEquipoId(), obtenerCategoriaId());
				case 3 -> evento.eliminarEvento(obtenerID());
				case 4 -> {
					Evento eventoEncontrado = evento.obtenerEvento(obtenerID());
					if (eventoEncontrado != null) {
						System.out.println(eventoEncontrado);
					} else {
						System.out.println("Evento no encontrado");
					}
				}
				case 5 -> {
					eventoList = evento.listarEventos();
					eventoList.forEach(System.out::println);
				}
				default -> finalizar = Boolean.TRUE;
			}
		} while (!finalizar);
	}
	/**
	 * Gestiona los motores, permitiendo agregar, actualizar, eliminar, buscar y listar motores.
	 */
	private static void gestionarMotor() {
		MotorServicio motor = new MotorServicio();
		int ultimoId = obtenerUltimoIdMotor(motor);
		List<Motor> motorList;
		boolean finalizar = Boolean.FALSE;
		do {
			imprimirGestion();
			switch (seleccionGestion()) {
				case 1 -> {
					boolean gasolina = obtenerGasolina();
					boolean diesel = obtenerDiesel();
					if (gasolina && diesel) {
						System.out.println("Un motor no puede ser gasolina y diesel a la vez.");
					} else {
						motor.agregarMotor(obtenerID(ultimoId), obtenerNombre(), obtenerFabricante(), obtenerCapacidad(), obtenerArquitectura(), obtenerAnyoDebut(), gasolina, diesel, obtenerElectrico(), obtenerTurbo(), obtenerDerivado());
					}
				}
				case 2 -> {
					boolean gasolina = obtenerGasolina();
					boolean diesel = obtenerDiesel();
					if (gasolina && diesel) {
						System.out.println("Un motor no puede ser gasolina y diesel a la vez.");
					} else {
						motor.actualizarMotor(obtenerID(), obtenerNombre(), obtenerFabricante(), obtenerCapacidad(), obtenerArquitectura(), obtenerAnyoDebut(), gasolina, diesel, obtenerElectrico(), obtenerTurbo(), obtenerDerivado());
					}
				}
				case 3 -> motor.eliminarMotor(obtenerID());
				case 4 -> {
					Motor motorEncontrado = motor.obtenerMotor(obtenerID());
					if (motorEncontrado != null) {
						System.out.println(motorEncontrado);
					} else {
						System.out.println("Motor no encontrado");
					}
				}
				case 5 -> {
					motorList = motor.listarMotores();
					motorList.forEach(System.out::println);
				}
				default -> finalizar = Boolean.TRUE;
			}
		} while (!finalizar);

	}
	/**
	 * Gestiona los pilotos, permitiendo agregar, actualizar, eliminar, buscar y listar pilotos.
	 */
	private static void gestionarPiloto() {
		PilotoServicio piloto = new PilotoServicio();
		int ultimoId = obtenerUltimoIdPiloto(piloto);
		boolean finalizar = Boolean.FALSE;
		do {
			imprimirGestion();
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
		} while (!finalizar);
	}

	/**
	 * Gestiona los proveedores de ruedas, permitiendo agregar, actualizar, eliminar, buscar y listar proveedores de ruedas.
	 */
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
	/**
	 * Gestiona las entradas de pilotos, permitiendo agregar, actualizar, eliminar, buscar y listar entradas.
	 */
	//TODO: Implementar verificacion de IDs
	private static void gestionarEntradaPiloto() {
		EntradaPilotoServicio entradaPiloto = new EntradaPilotoServicio();
		List<EntradaPiloto> entradaPilotoList;
		boolean finalizar = Boolean.FALSE;
		do {
			imprimirGestion();
			switch (seleccionGestion()) {
				case 1 ->
						entradaPiloto.agregarEntradaPiloto(obtenerEquipoId(), obtenerPilotoId(), obtenerRookie(), obtenerChassisId());
				case 2 ->
						entradaPiloto.actualizarEntradaPiloto(obtenerID(), obtenerPilotoId(), obtenerRookie(), obtenerCategoria());
				case 3 -> entradaPiloto.eliminarEntradaPiloto(obtenerID(), obtenerID());
				case 4 -> {
					EntradaPiloto entradaPilotoEncontrado = entradaPiloto.obtenerEntradaPiloto(obtenerID(), obtenerID());
					if (entradaPilotoEncontrado != null) {
						System.out.println(entradaPilotoEncontrado);
					} else {
						System.out.println("Entrada de piloto no encontrada");
					}
				}
				case 5 -> {
					entradaPilotoList = entradaPiloto.listarEntradasPiloto();
					entradaPilotoList.forEach(System.out::println);
				}
				default -> finalizar = Boolean.TRUE;
			}
		} while (!finalizar);
	}
	/**
	 * Obtiene el último ID de la categoría.
	 * @param categoriaServicio Servicio de categorías para obtener el último ID.
	 * @return Último ID de la categoría.
	 */
	private static int obtenerUltimoIDCategoria(CategoriaServicio categoriaServicio) {
		try {
			return categoriaServicio.obtenerUltimoID();
		} catch (DAOException e) {
			System.out.println("Error en la obencion del ultimo ID");
		}
		return 0;
	}
	/**
	 * Obtiene el último ID del chasis.
	 * @param chassisServicio Servicio de chasis para obtener el último ID.
	 * @return Último ID del chasis.
	 */
	private static int obtenerUltimoIdChassis(ChassisServicio chassisServicio) {
		try {
			return chassisServicio.obtenerUltimoId();
		} catch (DAOException e) {
			System.out.println("Error en la obencion del ultimo ID");
		}
		return 0;
	}
	/**
	 * Obtiene el último ID del equipo.
	 * @param equipoServicio Servicio de equipos para obtener el último ID.
	 * @return Último ID del equipo.
	 */
	private static int obtenerUltimoIdEquipo(EquipoServicio equipoServicio) {
		try {
			return equipoServicio.obtenerUltimoId();
		} catch (DAOException e) {
			System.out.println("Error en la obencion del ultimo ID");
		}
		return 0;
	}
	/**
	 * Obtiene el ID de un evento válido.
	 * @param eventoServicio Servicio de eventos para obtener la lista de eventos.
	 * @return ID del evento válido.
	 */
	private static int obtenerEventoId(EventoServicio eventoServicio) {
		int eventoId = 0;
		boolean exists = false;

		boolean verLista = obtenerBoolean("¿Desea ver la lista de eventos? (s/n):");
		if (verLista) {
			List<Evento> eventoList = eventoServicio.listarEventos();
			eventoList.forEach(evento -> System.out.println("ID: " + evento.getId()));
		}

		do {
			System.out.println("Introduzca el ID del evento: ");
			try {
				eventoId = sc.nextInt();
				Evento evento = eventoServicio.obtenerEvento(eventoId);
				if (evento != null) {
					exists = true;
				} else {
					System.out.println("ID del evento no encontrado. Intente de nuevo.");
				}
			} catch (InputMismatchException e) {
				System.out.println("Introduzca un número válido.");
				sc.next();
			}
		} while (!exists);
		return eventoId;
	}
	/**
	 * Obtiene el último ID del evento.
	 * @param eventoServicio Servicio de eventos para obtener el último ID.
	 * @return Último ID del evento.
	 */
	private static int obtenerUltimoIdEvento(EventoServicio eventoServicio) {
		return eventoServicio.obtenerUltimoId();
	}
	/**
	 * Obtiene el último ID del motor.
	 * @param motorServicio Servicio de motores para obtener el último ID.
	 * @return Último ID del motor.
	 */
	private static int obtenerUltimoIdMotor(MotorServicio motorServicio) {
		return motorServicio.obtenerUltimoId();
	}
	/**
	 * Obtiene el último ID del piloto.
	 * @param pilotoServicio Servicio de pilotos para obtener el último ID.
	 * @return Último ID del piloto.
	 */
	private static int obtenerUltimoIdPiloto(PilotoServicio pilotoServicio) {

		return pilotoServicio.obtenerUltimoId();

	}
	/**
	 * Obtiene el último ID del proveedor de ruedas.
	 * @param ruedasServicio Servicio de ruedas para obtener el último ID.
	 * @return Último ID del proveedor de ruedas.
	 */
	private static int obtenerUltimoIdProveedorRuedas(RuedasServicio ruedasServicio) {

		return ruedasServicio.obtenerUltimoId();

	}
	
	/**
	 * Selecciona una opción de gestión.
	 * @return Opción seleccionada.
	 */
	private static int seleccionGestion() {
		int opcionElejida = 0;
		boolean valido = false;
		do {
			String opcion = sc.nextLine().trim();
			switch (opcion) {
				case "1" -> {
					opcionElejida = 1;
					valido = true;
				}
				case "2" -> {
					opcionElejida = 2;
					valido = true;
				}
				case "3" -> {
					opcionElejida = 3;
					valido = true;
				}
				case "4" -> {
					opcionElejida = 4;
					valido = true;
				}
				case "5" -> {
					opcionElejida = 5;
					valido = true;
				}
				case "!" -> {
					opcionElejida = 6;
					valido = true;
				}
				default -> System.out.println("Opción no válida. Intente de nuevo.");
			}
		} while (!valido);
		return opcionElejida;
	}
	/**
	 * Selecciona una opción de tabla.
	 */
	private static void seleccionOpcion() {
		char opcion;
		do {
			imprimirTalbas();
			System.out.println("Seleccione una opción (1-8) o '!' para salir:");
			opcion = sc.nextLine().charAt(0);
			switch (opcion) {
				case '1' -> gestionarCategoria();
				case '2' -> gestionarChassis();
				case '3' -> gestionarEntradaPiloto();
				case '4' -> gestionarEquipo();
				case '5' -> gestionarEvento();
				case '6' -> gestionarMotor();
				case '7' -> gestionarPiloto();
				case '8' -> gestionarProveedorRuedas();
				case '!' -> System.out.println("Saliendo...");
				default -> System.out.println("Opción no válida");
			}
		} while (opcion != '!');
	}
	/**
	 * Obtiene un ID del usuario.
	 * @return ID ingresado por el usuario.
	 */
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
	/**
	 * Obtiene un ID derivado del usuario.
	 * @return ID derivado ingresado por el usuario.
	 */
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

	/**
	 * Obtiene un nuevo ID mayor que el último ID.
	 * @param ultimoID Último ID existente.
	 * @return Nuevo ID ingresado por el usuario.
	 */
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

	/**
	 * Obtiene un nombre del usuario.
	 * @return Nombre ingresado por el usuario.
	 */
	private static String obtenerNombre() {
		System.out.println("Introduze el nombre: ");
		return sc.nextLine();
	}
	/**
	 * Obtiene un nombre corto del usuario.
	 * @return Nombre corto ingresado por el usuario.
	 */
	private static String obtenerNombreCorto() {
		System.out.println("Introduze el nombre corto: ");
		return sc.nextLine();
	}

	/**
	 * Obtiene la relevancia del usuario.
	 * @return Relevancia ingresada por el usuario.
	 */
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
	/**
	 * Obtiene el fabricante del usuario.
	 * @return Fabricante ingresado por el usuario.
	 */
	private static String obtenerFabricante() {
		System.out.println("Introduzca el fabicante: ");
		return sc.nextLine();
	}
	/**
	 * Obtiene el año de debut del usuario.
	 * @return Año de debut ingresado por el usuario.
	 */
	private static int obtenerAnyoDebut() {
		System.out.println("Introduzca el anyo de debut: yyyy");
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
	/**
	 * Obtiene una descripción del usuario.
	 * @return Descripción ingresada por el usuario.
	 */
	private static String obtenerDescripcion() {
		System.out.println("Intruduzca la descripcion: ");
		return sc.nextLine();
	}
	/**
	 * Obtiene un apellido del piloto.
	 * @return Apellido ingresado por el usuario.
	 */
	private static String obtenerApellido() {
		System.out.println("Introduzca el apellido: ");
		return sc.nextLine();
	}
	/**
	 * Obtiene la fecha de nacimiento del piloto.
	 * @return Fecha de nacimiento ingresada por el usuario.
	 */
	private static LocalDate obtenerFechaNacimiento() {
		System.out.println("Introduzca la fecha de nacimiento: (yyyy-dd-mm)");
		String fecha_nacimiento = sc.nextLine();
		if (fecha_nacimiento.isEmpty() || fecha_nacimiento.isBlank() || fecha_nacimiento.equalsIgnoreCase("null")) {
			return null;
		}
		return LocalDate.parse(fecha_nacimiento);
	}
	/**
	 * Obtiene la fecha de muerte del piloto.
	 * @return Fecha de muerte ingresada por el usuario.
	 */
	private static LocalDate obtenerFechaMuerte() {
		System.out.println("Introduzca la fecha de muerte: (yyyy-dd-mm)");
		String fecha_muerte = sc.nextLine();
		if (fecha_muerte.isEmpty() || fecha_muerte.isBlank() || fecha_muerte.equalsIgnoreCase("null")) {
			return null;
		}
		return LocalDate.parse(fecha_muerte);
	}
	/**
	 * Obtiene el lugar de muerte del piloto.
	 * @return Lugar de muerte ingresado por el usuario.
	 */
	private static String obtenerLugarMuerte() {
		System.out.println("Introduzca el lugar de muerte: ");
		return sc.nextLine();
	}

	/**
	 * Obtiene la nacionalidad del del piloto.
	 * @return Nacionalidad ingresada por el usuario.
	 */
	private static String obtenerNacionalidad() {
		System.out.println("Introduzca la nacionalidad: ");
		return sc.nextLine();
	}
	/**
	 * Obtiene el color de la letra del neumatico.
	 * @return Color de la letra ingresado por el usuario.
	 */
	private static String obtenerColorLetra() {
		System.out.println("Introduzca el color de la letra: ");
		return sc.nextLine();
	}
	/**
	 * Obtiene el color de fondo del neumatico.
	 * @return Color de fondo ingresado por el usuario.
	 */
	private static String obtenerColorFondo() {
		System.out.println("Introduzca el color de fondo: ");
		return sc.nextLine();
	}
	/**
	 * Obtiene la capacidad del motor.
	 * @return Capacidad ingresada por el usuario.
	 */
	private static int obtenerCapacidad() {
		System.out.println("Introduzca la capacidad: ");
		int resultado = 0;
		boolean correcto = Boolean.FALSE;
		do {
			try {
				resultado = sc.nextInt();
				if (resultado > 0) {
					correcto = Boolean.TRUE;
				} else {
					System.out.println("Se debe introduzir un numero mayor que 0");
				}
			} catch (InputMismatchException e) {
				System.out.println("Introduze un numero valido");
				sc.next();
			}
		} while (!correcto);

		return resultado;
	}
	/**
	 * Obtiene la arquitectura del motor.
	 * @return Arquitectura ingresada por el usuario.
	 */
	private static String obtenerArquitectura() {
		System.out.println("Introduzca la arquitectura: ");
		return sc.nextLine();
	}
	/**
	 * Obtiene si es gasolina del motor.
	 * @return Valor booleano ingresado por el usuario.
	 */
	private static boolean obtenerGasolina() {
		System.out.println("¿Es gasolina? (true/false): ");
		return sc.nextBoolean();
	}
	/**
	 * Obtiene si es diesel del motro.
	 * @return Valor booleano ingresado por el usuario.
	 */
	private static boolean obtenerDiesel() {
		System.out.println("¿Es diesel? (true/false): ");
		return sc.nextBoolean();
	}
	/**
	 * Obtiene si es eléctrico del motor.
	 * @return Valor booleano ingresado por el usuario.
	 */
	private static boolean obtenerElectrico() {
		System.out.println("¿Es eléctrico? (true/false): ");
		return sc.nextBoolean();
	}
	/**
	 * Obtiene si tiene turbo del usuario.
	 * @return Valor booleano ingresado por el usuario.
	 */
	private static boolean obtenerTurbo() {
		System.out.println("¿Tiene turbo? (true/false): ");
		return sc.nextBoolean();
	}
	/**
	 * Obtiene si es rookie del usuario.
	 * @return Valor booleano ingresado por el usuario.
	 */
	private static boolean obtenerRookie() {
		System.out.println("¿Es rookie? (true/false): ");
		return sc.nextBoolean();
	}
	/**
	 * Muestra la lista de pilotos.
	 */
	private static void mostrarPilotos() {
		pilotoList.forEach(System.out::println);
	}
	/**
	 * Obtiene el ID del piloto.
	 * @return ID del piloto ingresado por el usuario.
	 */
	private static int obtenerPilotoId() {
		boolean verLista = obtenerBoolean("¿Desea ver la lista de pilotos? (s/n):");
		if (verLista) {
			PilotoServicio pilotoServicio = new PilotoServicio();
			pilotoList = pilotoServicio.listarPilotos();
			mostrarPilotos();
		}
		System.out.println("Introduzca el ID del piloto: ");
		return sc.nextInt();
	}
	/**
	 * Obtiene la categoría del usuario.
	 * @return Categoría ingresada por el usuario.
	 */
	private static int obtenerCategoria() {
		System.out.println("Introduzca el ID de la categoría: ");
		return sc.nextInt();
	}

	/**
	 * Obtiene el ID del motor.
	 * @return ID del motor ingresado por el usuario.
	 */
	private static int obtenerMotorId() {
		MotorServicio motorServicio = new MotorServicio();
		int motorId = 0;
		boolean exists = false;

		boolean verLista = obtenerBoolean("¿Desea ver la lista de IDs de motor? (s/n):");
		if (verLista) {
			List<Motor> motorList = motorServicio.listarMotores();
			motorList.forEach(motor -> System.out.println("ID: " + motor.getMotor() + ", Nombre: " + motor.getNombre()));
		}

		do {
			System.out.println("Introduzca el ID del motor: ");
			try {
				motorId = sc.nextInt();
				Motor motor = motorServicio.obtenerMotor(motorId);
				if (motor != null) {
					exists = true;
				} else {
					System.out.println("Motor ID no encontrado. Intente de nuevo.");
				}
			} catch (InputMismatchException e) {
				System.out.println("Introduzca un número válido.");
				sc.next();
			}
		} while (!exists);
		return motorId;
	}
	/**
	 * Obtiene el ID del equipo que dirige en el evento.
	 * @return ID del equipo ingresado por el usuario.
	 */
	private static int obtenerDirigidoPorId() {
		EquipoServicio equipoServicio = new EquipoServicio();
		int equipoId = 0;
		boolean exists = false;
		System.out.println("Introduzca el ID del equipo que dirige en el evento: ");
		boolean verLista = obtenerBoolean("¿Desea ver la lista de IDs de equipo? (s/n):");
		if (verLista) {
			List<Equipo> equipoList = equipoServicio.listarEquipos();
			equipoList.forEach(equipo -> System.out.println("ID: " + equipo.getId() + ", Nombre: " + equipo.getNombre()));
		}

		do {
			System.out.println("Introduzca el ID del equipo: ");
			try {
				equipoId = sc.nextInt();
				Equipo equipo = equipoServicio.obtenerEquipo(equipoId);
				if (equipo != null) {
					exists = true;
				} else {
					System.out.println("ID del equipo no encontrado. Intente de nuevo.");
				}
			} catch (InputMismatchException e) {
				System.out.println("Introduzca un número válido.");
				sc.next();
			}
		} while (!exists);
		return equipoId;
	}
	/**
	 * Obtiene el número del piloto en el evento.
	 * @return Número del piloto ingresado por el usuario.
	 */
	private static String obtenerNumeroPiloto() {
		System.out.println("Introduzca el número del piloto en el evento: ");
		return sc.nextLine();
	}
	/**
	 * Obtiene el ID del proveedor de ruedas.
	 * @return ID del proveedor de ruedas ingresado por el usuario.
	 */
	private static int obtenerRuedasId() {
		RuedasServicio ruedasServicio = new RuedasServicio();
		int ruedasId = 0;
		boolean exists = false;

		boolean verLista = obtenerBoolean("¿Desea ver la lista de IDs de proveedor de ruedas? (s/n):");
		if (verLista) {
			List<Ruedas> ruedasList = ruedasServicio.listarRuedas();
			ruedasList.forEach(ruedas -> System.out.println("ID: " + ruedas.getId() + ", Nombre: " + ruedas.getNombre()));
		}

		do {
			System.out.println("Introduzca el ID del proveedor de ruedas: ");
			try {
				ruedasId = sc.nextInt();
				Ruedas ruedas = ruedasServicio.obtenerRuedas(ruedasId);
				if (ruedas != null) {
					exists = true;
				} else {
					System.out.println("ID del proveedor de ruedas no encontrado. Intente de nuevo.");
				}
			} catch (InputMismatchException e) {
				System.out.println("Introduzca un número válido.");
				sc.next();
			}
		} while (!exists);
		return ruedasId;
	}
	/**
	 * Obtiene el ID de la categoría.
	 * @return ID de la categoría ingresado por el usuario.
	 */
	private static int obtenerCategoriaId() {
		CategoriaServicio categoriaServicio = new CategoriaServicio();
		int categoriaId = 0;
		boolean exists = false;

		boolean verLista = obtenerBoolean("¿Desea ver la lista de IDs de categoría? (s/n):");
		if (verLista) {
			List<Categoria> categoriaList = categoriaServicio.listarCategorias();
			categoriaList.forEach(categoria -> System.out.println("ID: " + categoria.getId() + ", Nombre: " + categoria.getNombre()));
		}

		do {
			System.out.println("Introduzca el ID de la categoría: ");
			try {
				categoriaId = sc.nextInt();
				Categoria categoria = categoriaServicio.obtenerCategoria(categoriaId);
				if (categoria != null) {
					exists = true;
				} else {
					System.out.println("ID de la categoría no encontrado. Intente de nuevo.");
				}
			} catch (InputMismatchException e) {
				System.out.println("Introduzca un número válido.");
				sc.next();
			}
		} while (!exists);
		return categoriaId;
	}
	/**
	 * Obtiene el ID del chasis.
	 * @return ID del chasis ingresado por el usuario.
	 */
	private static int obtenerChassisId() {
		ChassisServicio chassisServicio = new ChassisServicio();
		int chassisId = 0;
		boolean exists = false;

		boolean verLista = obtenerBoolean("¿Desea ver la lista de IDs de chasis? (s/n):");
		if (verLista) {
			List<Chassis> chassisList = chassisServicio.listarChassis();
			chassisList.forEach(chassis -> System.out.println("ID: " + chassis.getId() + ", Nombre: " + chassis.getNombre()));
		}

		do {
			System.out.println("Introduzca el ID del chasis: ");
			try {
				chassisId = sc.nextInt();
				Chassis chassis = chassisServicio.obtenerChassis(chassisId);
				if (chassis != null) {
					exists = true;
				} else {
					System.out.println("ID del chasis no encontrado. Intente de nuevo.");
				}
			} catch (InputMismatchException e) {
				System.out.println("Introduzca un número válido.");
				sc.next();
			}
		} while (!exists);
		return chassisId;
	}
	/**
	 * Obtiene el ID del equipo.
	 * @return ID del equipo ingresado por el usuario.
	 */
	private static int obtenerEquipoId() {
		EquipoServicio equipoServicio = new EquipoServicio();
		int equipoId = 0;
		boolean exists = false;

		boolean verLista = obtenerBoolean("¿Desea ver la lista de IDs de equipo? (s/n):");
		if (verLista) {
			List<Equipo> equipoList = equipoServicio.listarEquipos();
			equipoList.forEach(equipo -> System.out.println("ID: " + equipo.getId() + ", Nombre: " + equipo.getNombre()));
		}

		do {
			System.out.println("Introduzca el ID del equipo: ");
			try {
				equipoId = sc.nextInt();
				Equipo equipo = equipoServicio.obtenerEquipo(equipoId);
				if (equipo != null) {
					exists = true;
				} else {
					System.out.println("ID del equipo no encontrado. Intente de nuevo.");
				}
			} catch (InputMismatchException e) {
				System.out.println("Introduzca un número válido.");
				sc.next();
			}
		} while (!exists);
		return equipoId;
	}
	
	/**
	 * Obtiene un valor booleano del usuario.
	 * @param mensaje Mensaje a mostrar al usuario.
	 * @return Valor booleano ingresado por el usuario.
	 */
	private static boolean obtenerBoolean(String mensaje) {
		boolean entradaValida = false;
		boolean result = false;
		do {
			System.out.println(mensaje);
			char input = sc.next().trim().toLowerCase().charAt(0);
			if (input == 's') {
				result = true;
				entradaValida = true;
			} else if (input == 'n') {
				result = false;
				entradaValida = true;
			} else {
				System.out.println("Entrada no válida. Por favor, introduzca 's' o 'n'.");
			}
		} while (!entradaValida);
		return result;
	}
}
