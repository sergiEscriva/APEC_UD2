package ObjetosDAO;

import Excepciones.DAOException;
import Objetos.Evento;

import java.util.List;

public interface EventoDAO {
	void insertar(Evento evento) throws DAOException;
	Evento obtenerPorId(int id) throws DAOException;
	List<Evento> obtenerTodos() throws DAOException;
	void actualizar(Evento evento) throws DAOException;
	void eliminar(int id ) throws DAOException;
	int obtenerUltimoId() throws DAOException;
}
