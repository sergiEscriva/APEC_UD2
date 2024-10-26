package ObjetosDAO;

import Excepciones.DAOException;
import Objetos.Chassis;

import java.util.List;

public interface ChassisDAO {
	void insertar(Chassis chassis) throws DAOException;
	Chassis obtenerPorId(int id) throws DAOException;
	List<Chassis> obtenerTodas() throws DAOException;
	void actualizar(Chassis chassis) throws DAOException;
	void eliminar(int id ) throws DAOException;
}
