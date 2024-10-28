package ObjetosImpl;

import Conexiones.ConexionMs;
import Excepciones.DAOException;
import Objetos.EntradaPiloto;
import ObjetosDAO.EntradaPilotoDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EntradaPilotoImpl implements EntradaPilotoDAO {
	private static final String INSERTAR = "INSERT INTO DRIVER_ENTRY(ENTRY_ID, DRIVER_ID, ROOKIE, CATEGORY) VALUES (?,?,?,?,?,?,?)";
	private static final String OBTENER_POR_ID = "SELECT * FROM DRIVER_ENTRY WHERE ID =? AND DRIVER_ID =?";
	private static final String OBTENER_TODOS = "SELECT * FROM DRIVER_ENTRY";
	private static final String ACTUALIZAR = "UPDATE DRIVER_ENTRY SET ROOKIE=?, ROOKIE=? WHERE ENTRY_ID=?, DRIVER_ID=?";
	private static final String ELIMINAR = "DELETE FROM DRIVER_ENTRY WHERE ENTRY_ID=?, DRIVER_ID=?";
	ConexionMs conexion = new ConexionMs();


	@Override
	public void insertar(EntradaPiloto entradaPiloto) throws DAOException {
		try (
				PreparedStatement statement = conexion.getConnection().prepareStatement(INSERTAR)) {
			statement.setInt(1, entradaPiloto.getEntrada_id());
			statement.setInt(2, entradaPiloto.getPiloto_id());
			statement.setBoolean(3, entradaPiloto.isRookie());
			statement.setInt(4, entradaPiloto.getCategoria());
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("Error inserting EntradaPiloto", e);
		}
		
	}

	@Override
	public EntradaPiloto obtenerPorId(int entryId, int driverId) throws DAOException {
		return null;
	}

	@Override
	public List<EntradaPiloto> obtenerTodas() throws DAOException {
		List<EntradaPiloto> entradaPilotoList = new ArrayList<>();
		try (
				PreparedStatement statement = conexion.getConnection().prepareStatement(OBTENER_TODOS);
				ResultSet resultSet = statement.executeQuery()) {
			while (resultSet.next()) {
				EntradaPiloto entradaPiloto = new EntradaPiloto(
						resultSet.getInt("ENTRY_ID"),
						resultSet.getInt("DRIVER_ID"),
						resultSet.getBoolean("ROOKIE"),
						resultSet.getInt("CATEGORY")
				);
				entradaPilotoList.add(entradaPiloto);
			}
		} catch (SQLException e) {
			throw new DAOException("Error getting all EntradaPiloto", e);
		}
		return entradaPilotoList;
	}

	@Override
	public void actualizar(EntradaPiloto entradaPiloto) throws DAOException {
		try (
				PreparedStatement statement = conexion.getConnection().prepareStatement(ACTUALIZAR)) {
			statement.setBoolean(1, entradaPiloto.isRookie());
			statement.setInt(2, entradaPiloto.getCategoria());
			statement.setInt(3, entradaPiloto.getEntrada_id());
			statement.setInt(4, entradaPiloto.getPiloto_id());
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("Error updating EntradaPiloto", e);
		}
	}

	@Override
	public void eliminar(int entryId, int driverId) throws DAOException {
		try (
				PreparedStatement statement = conexion.getConnection().prepareStatement(ELIMINAR)) {
			statement.setInt(1, entryId);
			statement.setInt(2, driverId);
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("Error deleting EntradaPiloto", e);
		}
	}
}
