package ObjetosDAO;

import Excepciones.DAOException;
import Objetos.Ruedas;

import java.util.List;

public interface RuedasDAO {
	void insertar(Ruedas ruedas) throws DAOException;
	Ruedas obtenerPorId(int id) throws DAOException;
	List<Ruedas> obtenerTodas() throws DAOException;
	void actualizar(Ruedas ruedasE) throws DAOException;
	void eliminar(int id ) throws DAOException;
	int obtenerUltimoID() throws DAOException;
}
