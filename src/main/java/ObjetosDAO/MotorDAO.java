package ObjetosDAO;

import Excepciones.DAOException;
import Objetos.Motor;

import java.util.List;

public interface MotorDAO {
	void insertar(Motor motor) throws DAOException;
	Motor obtenerPorId(int id) throws DAOException;
	List<Motor> obtenerTodas() throws DAOException;
	void actualizar(Motor motor) throws DAOException;
	void eliminar(int id ) throws DAOException;
}
