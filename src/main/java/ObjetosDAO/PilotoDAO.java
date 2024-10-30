package ObjetosDAO;

import Excepciones.DAOException;
import Objetos.Piloto;

import java.util.List;

public interface PilotoDAO {
	void insertar(Piloto piloto) throws DAOException;
	Piloto obtenerPorId(int id) throws DAOException;
	List<Piloto> obtenerTodas() throws DAOException;
	void actualizar(Piloto piloto) throws DAOException;
	void eliminar(int id ) throws DAOException;
	int obtenerUltimoID() throws DAOException;
	List<Piloto> obtenerPilotosConEventos() throws DAOException;

}
