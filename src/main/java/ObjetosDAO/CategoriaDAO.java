package ObjetosDAO;

import Excepciones.DAOException;
import Objetos.Categoria;

import java.util.List;

public interface CategoriaDAO {
	
	void insertar(Categoria categoria) throws DAOException;
	Categoria obtenerPorId(int id) throws DAOException;
	List<Categoria> obtenerTodas() throws DAOException;
	void actualizar(Categoria categoria) throws DAOException;
	void eliminar(int id ) throws DAOException;
	int obtenerUltimoID() throws DAOException;

}
