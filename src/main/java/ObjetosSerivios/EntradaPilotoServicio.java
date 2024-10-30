package ObjetosSerivios;

import Excepciones.DAOException;
import Objetos.EntradaPiloto;
import ObjetosDAO.EntradaPilotoDAO;
import ObjetosImpl.EntradaPilotoImpl;

import java.util.List;

public class EntradaPilotoServicio {
	private EntradaPilotoDAO entradaPilotoDAO;

	public EntradaPilotoServicio() {
		this.entradaPilotoDAO = new EntradaPilotoImpl();
	}
	public void agregarEntradaPiloto(int entryId, int driverId, boolean rookie, int category) {
		try {
			EntradaPiloto existente = entradaPilotoDAO.obtenerPorId(entryId, driverId);
			if (existente != null) {
				System.out.println("Error: El ID ya existe.");
				return;
			}

			// Si no existe, insertar el nuevo registro
			EntradaPiloto entradaPiloto = new EntradaPiloto(entryId, driverId, rookie, category);
			entradaPilotoDAO.insertar(entradaPiloto);
			System.out.println("EntradaPiloto agregada con ID: " + entradaPiloto.getEntrada_id());
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}
	

	public EntradaPiloto obtenerEntradaPiloto(int entryId, int driverId) {
		try {
			return entradaPilotoDAO.obtenerPorId(entryId, driverId);
		} catch (DAOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<EntradaPiloto> listarEntradasPiloto() {
		try {
			return entradaPilotoDAO.obtenerTodas();
		} catch (DAOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void actualizarEntradaPiloto(int entryId, int driverId, boolean rookie, int category) {
		EntradaPiloto entradaPiloto = new EntradaPiloto(entryId, driverId, rookie, category);
		try {
			entradaPilotoDAO.actualizar(entradaPiloto);
			System.out.println("EntradaPiloto actualizada: " + entradaPiloto);
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}

	public void eliminarEntradaPiloto(int entryId, int driverId) {
		try {
			entradaPilotoDAO.eliminar(entryId, driverId);
			System.out.println("EntradaPiloto eliminada con ID: " + entryId);
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}
}