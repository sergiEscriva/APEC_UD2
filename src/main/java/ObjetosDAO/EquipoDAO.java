package ObjetosDAO;

import Excepciones.DAOException;
import Objetos.Equipo;

import java.util.List;

public interface EquipoDAO {
	void insertar(Equipo equipo) throws DAOException;
	Equipo obtenerPorId(int id) throws DAOException;
	List<Equipo> obtenerTodas() throws DAOException;
	void actualizar(Equipo equipo) throws DAOException;
	void eliminar(int id ) throws DAOException;
	int obtenerUltimoID() throws DAOException;
}
