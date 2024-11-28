package ObjetosImpl;

import Conexiones.ConexionMs;
import Excepciones.DAOException;
import Objetos.Evento;
import ObjetosDAO.EventoDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EventoImpl implements EventoDAO {
	private static final String INSERTAR = "INSERT INTO EVENT_ENTRY(ID, TEAM_NAME, CHASSIS_ID, ENGINE_ID, OPERATED_BY_ID, EVENT_EDITION_ID, RACE_NUMBER, TEAM_ID, CATEGORY_ID, TYRES_ID) VALUES (?,?,?,?,?,?,?,?,?, ?)";
	private static final String OBTENER_POR_ID = "SELECT * FROM EVENT_ENTRY WHERE ID =?";
	private static final String OBTENER_TODOS = "SELECT * FROM EVENT_ENTRY";
	private static final String ACTUALIZAR = "UPDATE EVENT_ENTRY SET TEAM_NAME=?, CHASSIS_ID=?, ENGINE_ID=?, OPERATED_BY_ID=?, EVENT_EDITION_ID=?, RACE_NUMBER=?, TEAM_ID=?, CATEGORY_ID=? WHERE ID=?";
	private static final String ELIMINAR = "DELETE FROM EVENT_ENTRY WHERE ID =?";
	private static final String OBTENER_ULTIMO_ID = "SELECT MAX(ID) AS MAX_ID FROM EVENT_ENTRY";
	private static final String OBTENER_EVENTOS_CON_EQUIPOS = "SELECT e.ID, e.TEAM_NAME, eq.name AS EQUIPO_NOMBRE " +
																"FROM EVENT_ENTRY e JOIN TEAM eq ON e.TEAM_ID = eq.ID";

	ConexionMs conexion = new ConexionMs();

	@Override
	public void insertar(Evento evento) throws DAOException {
		try (
				PreparedStatement statement = conexion.getConnection().prepareStatement(INSERTAR)) {
			statement.setInt(1, evento.getId());
			statement.setString(2, evento.getNombre_equipo());
			statement.setInt(3, evento.getChassis_id());
			statement.setInt(4, evento.getMotor_id());
			statement.setInt(5, evento.getDirigido_por());
			statement.setInt(6, evento.getRuedas_id());
			statement.setString(7, evento.getNumero_piloto());
			statement.setInt(8, evento.getEquipo_id());
			statement.setInt(9, evento.getCategoria_id());
			statement.setInt(10, evento.getRuedas_id());
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("Error inserting Evento", e);
		}

	}

	@Override
	public Evento obtenerPorId(int id) throws DAOException {
		try (
				PreparedStatement statement = conexion.getConnection().prepareStatement(OBTENER_POR_ID)) {
			statement.setInt(1, id);
			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					return new Evento(
							resultSet.getInt("ID"),
							resultSet.getString("TEAM_NAME"),
							resultSet.getInt("CHASSIS_ID"),
							resultSet.getInt("ENGINE_ID"),
							resultSet.getInt("OPERATED_BY_ID"),
							resultSet.getInt("EVENT_EDITION_ID"),
							resultSet.getString("RACE_NUMBER"),
							resultSet.getInt("TEAM_ID"),
							resultSet.getInt("CATEGORY_ID")
					);
				}
			}
		} catch (SQLException e) {
			throw new DAOException("Error getting Evento by ID", e);
		}
		return null;
	}

	@Override
	public List<Evento> obtenerTodos() throws DAOException {
		List<Evento> eventoList = new ArrayList<>();
		try (
				PreparedStatement statement = conexion.getConnection().prepareStatement(OBTENER_TODOS);
				ResultSet resultSet = statement.executeQuery()) {
			while (resultSet.next()) {
				Evento evento = new Evento(
						resultSet.getInt("ID"),
						resultSet.getString("TEAM_NAME"),
						resultSet.getInt("CHASSIS_ID"),
						resultSet.getInt("ENGINE_ID"),
						resultSet.getInt("OPERATED_BY_ID"),
						resultSet.getInt("EVENT_EDITION_ID"),
						resultSet.getString("RACE_NUMBER"),
						resultSet.getInt("TEAM_ID"),
						resultSet.getInt("CATEGORY_ID")
				);
				eventoList.add(evento);
			}
		} catch (SQLException e) {
			throw new DAOException("Error getting all Eventos", e);
		}
		return eventoList;
	}

	@Override
	public void actualizar(Evento evento) throws DAOException {
		try (
				PreparedStatement statement = conexion.getConnection().prepareStatement(ACTUALIZAR)) {
			statement.setString(1, evento.getNombre_equipo());
			statement.setInt(2, evento.getChassis_id());
			statement.setInt(3, evento.getMotor_id());
			statement.setInt(4, evento.getDirigido_por());
			statement.setInt(5, evento.getRuedas_id());
			statement.setString(6, evento.getNumero_piloto());
			statement.setInt(7, evento.getEquipo_id());
			statement.setInt(8, evento.getCategoria_id());
			statement.setInt(9, evento.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("Error updating Evento", e);
		}
	}

	@Override
	public void eliminar(int id) throws DAOException {
		try (
				PreparedStatement statement = conexion.getConnection().prepareStatement(ELIMINAR)) {
			statement.setInt(1, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("Error deleting Evento", e);
		}
	}

	@Override
	public int obtenerUltimoId() throws DAOException {
		try (
				PreparedStatement statement = conexion.getConnection().prepareStatement(OBTENER_ULTIMO_ID);
				ResultSet resultSet = statement.executeQuery()) {
			if (resultSet.next()) {
				return resultSet.getInt("MAX_ID");
			}
		} catch (SQLException e) {
			throw new DAOException("Error getting last Evento ID", e);
		}
		return 0;
	}

	@Override
	public List<Evento> obtenerEventosConEquipos() throws DAOException {
		List<Evento> eventos = new ArrayList<>();
		try (PreparedStatement statement = conexion.getConnection().prepareStatement(OBTENER_EVENTOS_CON_EQUIPOS);
			 ResultSet resultSet = statement.executeQuery()) {
			while (resultSet.next()) {
				Evento evento = new Evento();
				evento.setId(resultSet.getInt("ID"));
				evento.setNombre_equipo(resultSet.getString("TEAM_NAME"));
				evento.setNombre_equipo(resultSet.getString("EQUIPO_NOMBRE"));
				eventos.add(evento);
			}
		} catch (SQLException e) {
			throw new DAOException("Error getting Eventos with Equipos", e);
		}
		return eventos;	}

}
