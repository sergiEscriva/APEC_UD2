package ObjetosImpl;

import Conexiones.ConexionMs;
import Excepciones.DAOException;
import Objetos.Equipo;
import ObjetosDAO.EquipoDAO;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EquipoImpl implements EquipoDAO {
	private static final String INSERTAR = "INSERT INTO TEAM(ID, NAME,DESCRIPTION) VALUES (?,?,?)";
	private static final String OBTENER_POR_ID = "SELECT * FROM TEAM WHERE ID =?";
	private static final String OBTENER_TODOS = "SELECT * FROM TEAM";
	private static final String ACTUALIZAR = "UPDATE TEAM SET NAME=?, DESCRIPTION=? WHERE ID=?";
	private static final String ELIMINAR = "DELETE FROM TEAM WHERE ID =?";
	private static final String OBTENER_ULTIMO_ID = "SELECT MAX(ID) AS MAX_ID FROM TEAM";

	ConexionMs conexion = new ConexionMs();

	@Override
	public void insertar(Equipo equipo) throws DAOException {
		try (
			 PreparedStatement statement = conexion.getConnection().prepareStatement(INSERTAR)) {
			statement.setInt(1, equipo.getId());
			statement.setString(2, equipo.getNombre());
			statement.setString(3, equipo.getDescripcion());
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("Error inserting Equipo", e);
		}
	}

	@Override
	public Equipo obtenerPorId(int id) throws DAOException {
		try (
			 PreparedStatement statement = conexion.getConnection().prepareStatement(OBTENER_POR_ID)) {
			statement.setInt(1, id);
			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					return new Equipo(
							resultSet.getInt("ID"),
							resultSet.getString("NAME"),
							resultSet.getString("DESCRIPTION")
					);
				}
			}
		} catch (SQLException e) {
			throw new DAOException("Error getting Equipo by ID", e);
		}
		return null;
	}

	@Override
	public List<Equipo> obtenerTodas() throws DAOException {
		List<Equipo> equipoList = new ArrayList<>();
		try (
			 PreparedStatement statement = conexion.getConnection().prepareStatement(OBTENER_TODOS);
			 ResultSet resultSet = statement.executeQuery()) {
			while (resultSet.next()) {
				Equipo equipo = new Equipo(
						resultSet.getInt("ID"),
						resultSet.getString("NAME"),
						resultSet.getString("DESCRIPTION")
				);
				equipoList.add(equipo);
			}
		} catch (SQLException e) {
			throw new DAOException("Error getting all Equipos", e);
		}
		return equipoList;	}

	@Override
	public void actualizar(Equipo equipo) throws DAOException {
		try (
			 PreparedStatement statement = conexion.getConnection().prepareStatement(ACTUALIZAR)) {
			statement.setString(1, equipo.getNombre());
			statement.setString(2, equipo.getDescripcion());
			statement.setInt(3, equipo.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("Error updating Equipo", e);
		}
	}

	@Override
	public void eliminar(int id) throws DAOException {
		try (
			 PreparedStatement statement = conexion.getConnection().prepareStatement(ELIMINAR)) {
			statement.setInt(1, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("Error deleting Equipo", e);
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
			throw new DAOException("Error getting last ID", e);
		}
		return 0;
		
	}
}
