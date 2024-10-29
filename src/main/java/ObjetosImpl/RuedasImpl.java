package ObjetosImpl;

import Conexiones.ConexionMs;
import Excepciones.DAOException;
import Objetos.Ruedas;
import ObjetosDAO.RuedasDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RuedasImpl implements RuedasDAO {
	private static final String INSERTAR = "INSERT INTO TYRE_PROVIDER(ID, NAME, LETTER_COLOR, BACKGROUND_COLOR) VALUES (?,?,?,?,?,?,?)";
	private static final String OBTENER_POR_ID = "SELECT * FROM TYRE_PROVIDER WHERE ID =?";
	private static final String OBTENER_TODOS = "SELECT * FROM TYRE_PROVIDER";
	private static final String ACTUALIZAR = "UPDATE TYRE_PROVIDER SET NAME=?, SURNAME=?, BIRTH_DATE=?, DEATH_DATE=?, NACIONALITY=? WHERE ID=?";
	private static final String ELIMINAR = "DELETE FROM TYRE_PROVIDER WHERE ID =?";
	private static final String OBTENER_ULTIMO_ID = "SELECT MAX(ID) AS MAX_ID FROM TYRE_PROVIDER";

	ConexionMs conexion = new ConexionMs();

	@Override
	public void insertar(Ruedas ruedas) throws DAOException {
		try (PreparedStatement statement = conexion.getConnection().prepareStatement(INSERTAR)) {
			statement.setInt(1, ruedas.getId());
			statement.setString(2, ruedas.getNombre());
			statement.setString(3, ruedas.getColor_letra());
			statement.setString(4, ruedas.getColor_fondo());
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("Error inserting Ruedas", e);
		}
	}

	@Override
	public Ruedas obtenerPorId(int id) throws DAOException {
		try (PreparedStatement statement = conexion.getConnection().prepareStatement(OBTENER_POR_ID)) {
			statement.setInt(1, id);
			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					return new Ruedas(
							resultSet.getInt("ID"),
							resultSet.getString("NAME"),
							resultSet.getString("LETTER_COLOR"),
							resultSet.getString("BACKGROUND_COLOR")
					);
				}
			}
		} catch (SQLException e) {
			throw new DAOException("Error getting Ruedas by ID", e);
		}
		return null;
	}

	@Override
	public List<Ruedas> obtenerTodas() throws DAOException {
		List<Ruedas> ruedasList = new ArrayList<>();
		try (
				PreparedStatement statement = conexion.getConnection().prepareStatement(OBTENER_TODOS);
				ResultSet resultSet = statement.executeQuery()) {
			while (resultSet.next()) {
				Ruedas ruedas = new Ruedas(
						resultSet.getInt("ID"),
						resultSet.getString("NAME"),
						resultSet.getString("LETTER_COLOR"),
						resultSet.getString("BACKGROUND_COLOR")
				);
				ruedasList.add(ruedas);
			}
		} catch (SQLException e) {
			throw new DAOException("Error getting all Ruedas", e);
		}
		return ruedasList;
	}

	@Override
	public void actualizar(Ruedas ruedas) throws DAOException {
		try (PreparedStatement statement = conexion.getConnection().prepareStatement(ACTUALIZAR)) {
			statement.setString(1, ruedas.getNombre());
			statement.setString(2, ruedas.getColor_letra());
			statement.setString(3, ruedas.getColor_fondo());
			statement.setInt(4, ruedas.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("Error updating Ruedas", e);
		}
	}

	@Override
	public void eliminar(int id) throws DAOException {
		try (
			 PreparedStatement statement = conexion.getConnection().prepareStatement(ELIMINAR)) {
			statement.setInt(1, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("Error deleting Ruedas", e);
		}
	}

	@Override
	public int obtenerUltimoID() throws DAOException {
		try (
			 PreparedStatement statement = conexion.getConnection().prepareStatement(OBTENER_ULTIMO_ID);
			 ResultSet resultSet = statement.executeQuery()) {
			if (resultSet.next()) {
				return resultSet.getInt("MAX_ID");
			}
		} catch (SQLException e) {
			throw new DAOException("Error getting last Ruedas ID", e);
		}
		return 0;
	}
}
