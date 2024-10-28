package ObjetosImpl;

import Conexiones.ConexionMs;
import Excepciones.DAOException;
import Objetos.Categoria;
import ObjetosDAO.CategoriaDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaImpl implements CategoriaDAO {
	private static final String INSERTAR = "INSERT INTO CATEGORY(ID, NAME, SHORTNAME, RELEVANCE) VALUES (?,?,?,?)";
	private static final String OBTENER_POR_ID = "SELECT * FROM CATEGORY WHERE ID =?";
	private static final String OBTENER_TODOS = "SELECT * FROM CATEGORY";
	private static final String ACTUALIZAR = "UPDATE CATEGORY SET NAME=?, SHORTNAME=?, RELEVANCE=? WHERE ID=?";
	private static final String ELIMINAR = "DELETE FROM CATEGORY WHERE ID =?";
	ConexionMs conexion = new ConexionMs();

	@Override
	public void insertar(Categoria categoria) throws DAOException {
		try (PreparedStatement statement = conexion.getConnection().prepareStatement(INSERTAR)) {
			statement.setInt(1, categoria.getId());
			statement.setString(2, categoria.getNombre());
			statement.setString(3, categoria.getNombre_corto());
			statement.setInt(4, categoria.getRelevancia());
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("Error inserting Categoria", e);
		}
	}

	@Override
	public Categoria obtenerPorId(int id) throws DAOException {
		try (PreparedStatement statement = conexion.getConnection().prepareStatement(OBTENER_POR_ID)) {
			statement.setInt(1, id);
			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					return new Categoria(
							resultSet.getInt("ID"),
							resultSet.getString("NAME"),
							resultSet.getString("SHORTNAME"),
							resultSet.getInt("RELEVANCE")
					);
				}
			}
		} catch (SQLException e) {
			throw new DAOException("Error getting Categoria by ID", e);
		}
		return null;
	}

	@Override
	public List<Categoria> obtenerTodas() throws DAOException {
		List<Categoria> categoriaList = new ArrayList<>();
		try (PreparedStatement statement = conexion.getConnection().prepareStatement(OBTENER_TODOS);
				ResultSet resultSet = statement.executeQuery()) {
			while (resultSet.next()) {
				Categoria categoria = new Categoria(
						resultSet.getInt("ID"),
						resultSet.getString("NAME"),
						resultSet.getString("SHORTNAME"),
						resultSet.getInt("RELEVANCE")
				);
				categoriaList.add(categoria);
			}
		} catch (SQLException e) {
			throw new DAOException("Error getting all Categorias", e);
		}
		return categoriaList;
	}

	@Override
	public void actualizar(Categoria categoria) throws DAOException {
		try (PreparedStatement statement = conexion.getConnection().prepareStatement(ACTUALIZAR)) {
			statement.setString(1, categoria.getNombre());
			statement.setString(2, categoria.getNombre_corto());
			statement.setInt(3, categoria.getRelevancia());
			statement.setInt(4, categoria.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("Error updating Categoria", e);
		}
	}

	@Override
	public void eliminar(int id) throws DAOException {
		try (PreparedStatement statement = conexion.getConnection().prepareStatement(ELIMINAR)) {
			statement.setInt(1, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("Error deleting Categoria", e);
		}
	}
}
