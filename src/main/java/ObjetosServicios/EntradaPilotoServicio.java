package ObjetosServicios;

import Excepciones.DAOException;
import Objetos.EntradaPiloto;
import ObjetosDAO.EntradaPilotoDAO;
import ObjetosImpl.EntradaPilotoImpl;

import java.util.List;

public class EntradaPilotoServicio {
	private EntradaPilotoDAO entradaPilotoDAO;
	/**
	 * Constructor de la clase EntradaPilotoServicio.
	 * Inicializa la instancia de EntradaPilotoDAO.
	 */
	public EntradaPilotoServicio() {
		this.entradaPilotoDAO = new EntradaPilotoImpl();
	}
	
	/**
	 * Agrega una nueva entrada de piloto.
	 * @param entryId ID de la entrada.
	 * @param driverId ID del piloto.
	 * @param rookie Si el piloto es novato.
	 * @param category ID de la categoría.
	 */
	public void agregarEntradaPiloto(int entryId, int driverId, boolean rookie, int category) {
		try {
			EntradaPiloto existente = entradaPilotoDAO.obtenerPorId(entryId, driverId);
			if (existente != null) {
				System.out.println("Error: El ID ya existe.");
				return;
			}
			EntradaPiloto entradaPiloto = new EntradaPiloto(entryId, driverId, rookie, category);
			entradaPilotoDAO.insertar(entradaPiloto);
			System.out.println("EntradaPiloto agregada con ID: " + entradaPiloto.getEntrada_id());
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Obtiene una entrada de piloto por su ID.
	 *
	 * @param entryId El ID de la entrada.
	 * @param driverId El ID del piloto.
	 * @return La entrada de piloto obtenida o null si ocurre un error.
	 */
	public EntradaPiloto obtenerEntradaPiloto(int entryId, int driverId) {
		try {
			return entradaPilotoDAO.obtenerPorId(entryId, driverId);
		} catch (DAOException e) {
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * Lista todas las entradas de piloto.
	 *
	 * @return Una lista de todas las entradas de piloto o null si ocurre un error.
	 */
	public List<EntradaPiloto> listarEntradasPiloto() {
		try {
			return entradaPilotoDAO.obtenerTodas();
		} catch (DAOException e) {
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * Actualiza una entrada de piloto existente.
	 *
	 * @param entryId El ID de la entrada.
	 * @param driverId El ID del piloto.
	 * @param rookie Indica si el piloto es novato.
	 * @param category La categoría de la entrada.
	 */
	public void actualizarEntradaPiloto(int entryId, int driverId, boolean rookie, int category) {
		EntradaPiloto entradaPiloto = new EntradaPiloto(entryId, driverId, rookie, category);
		try {
			entradaPilotoDAO.actualizar(entradaPiloto);
			System.out.println("EntradaPiloto actualizada: " + entradaPiloto);
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Elimina una entrada de piloto por su ID.
	 *
	 * @param entryId El ID de la entrada.
	 * @param driverId El ID del piloto.
	 */
	public void eliminarEntradaPiloto(int entryId, int driverId) {
		try {
			entradaPilotoDAO.eliminar(entryId, driverId);
			System.out.println("EntradaPiloto eliminada con ID: " + entryId);
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}

	
}