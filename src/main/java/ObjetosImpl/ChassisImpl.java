package ObjetosImpl;

import Conexiones.ConexionMs;
import Excepciones.DAOException;
import Objetos.Chassis;
import ObjetosDAO.ChassisDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ChassisImpl implements ChassisDAO {
	private static final String INSERTAR = "INSERT INTO CHASSIS(ID, NAME, manufacturer, DEBUT_YEAR, DERIVED_FROM_ID) VALUES (?,?,?,?,?)";
	private static final String OBTENER_POR_ID = "SELECT * FROM CHASSIS WHERE ID =?";
	private static final String OBTENER_TODOS = "SELECT * FROM CHASSIS";
	private static final String ACTUALIZAR = "UPDATE CHASSIS SET NAME=?, manufacturer=?, DEBUT_YEAR=?, DERIVED_FROM_ID=? WHERE ID=?";
	private static final String ELIMINAR = "DELETE FROM CHASSIS WHERE ID =?";
	private static final String OBTENER_ULTIMO_ID = "SELECT MAX(ID) AS MAX_ID FROM CHASSIS";
	ConexionMs conexion = new ConexionMs();

	@Override
	public void insertar(Chassis chassis) throws DAOException {
		try (PreparedStatement statement = conexion.getConnection().prepareStatement(INSERTAR)) {
			statement.setInt(1, chassis.getId());
			statement.setString(2, chassis.getNombre());
			statement.setString(3, chassis.getFabricante());
			statement.setInt(4, chassis.getAnyo_debut());
			statement.setInt(5, chassis.getDerivado_desde_id());
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("Error inserting Chassis", e);
		}
	}

	@Override
	public Chassis obtenerPorId(int id) throws DAOException {
		try (PreparedStatement statement = conexion.getConnection().prepareStatement(OBTENER_POR_ID)) {
			statement.setInt(1, id);
			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					return new Chassis(
							resultSet.getInt("ID"),
							resultSet.getString("NAME"),
							resultSet.getString("manufacturer"),
							resultSet.getInt("DEBUT_YEAR"),
							resultSet.getInt("DERIVED_FROM_ID")
					);
				}
			}
		} catch (SQLException e) {
			throw new DAOException("Error getting Chassis by ID", e);
		}
		return null;
	}

	@Override
	public List<Chassis> obtenerTodas() throws DAOException {
		List<Chassis> chassisList = new ArrayList<>();
		try (PreparedStatement statement = conexion.getConnection().prepareStatement(OBTENER_TODOS);
				ResultSet resultSet = statement.executeQuery()) {
			while (resultSet.next()) {
				Chassis chassis = new Chassis(
						resultSet.getInt("ID"),
						resultSet.getString("NAME"),
						resultSet.getString("manufacturer"),
						resultSet.getInt("DEBUT_YEAR"),
						resultSet.getInt("DERIVED_FROM_ID")
				);
				chassisList.add(chassis);
			}
		} catch (SQLException e) {
			throw new DAOException("Error getting all Chassis", e);
		}
		return chassisList;	}

	@Override
	public void actualizar(Chassis chassis) throws DAOException {
		try (PreparedStatement statement = conexion.getConnection().prepareStatement(ACTUALIZAR)) {
			statement.setString(1, chassis.getNombre());
			statement.setString(2, chassis.getFabricante());
			statement.setInt(3, chassis.getAnyo_debut());
			statement.setInt(4, chassis.getDerivado_desde_id());
			statement.setInt(5, chassis.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("Error updating Chassis", e);
		}
	}

	@Override
	public void eliminar(int id) throws DAOException {
		try (PreparedStatement statement = conexion.getConnection().prepareStatement(ELIMINAR)) {
			statement.setInt(1, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("Error deleting Chassis", e);
		}
	}

	@Override
	public int obtenerUltimoID() throws DAOException {
		try (PreparedStatement statement = conexion.getConnection().prepareStatement(OBTENER_ULTIMO_ID);
				ResultSet resultSet = statement.executeQuery()) {
			if (resultSet.next()) {
				return resultSet.getInt("MAX_ID");
			}
		} catch (SQLException e) {
			throw new DAOException("Error obteniendo el último ID de Categoria", e);
		}
		return 0;
	}
}
