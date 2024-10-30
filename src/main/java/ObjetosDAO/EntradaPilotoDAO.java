package ObjetosDAO;

import Excepciones.DAOException;
import Objetos.EntradaPiloto;

import java.util.List;

public interface EntradaPilotoDAO {
	void insertar(EntradaPiloto entradaPiloto) throws DAOException;
	EntradaPiloto obtenerPorId(int entryId, int driverId) throws DAOException;
	List<EntradaPiloto> obtenerTodas() throws DAOException;
	void actualizar(EntradaPiloto entradaPiloto) throws DAOException;
	void eliminar(int entryId, int driverId ) throws DAOException;
	boolean existe(int entryId, int driverId) throws DAOException;
}
