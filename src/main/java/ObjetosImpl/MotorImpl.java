package ObjetosImpl;

import Conexiones.ConexionMs;
import Excepciones.DAOException;
import Objetos.Motor;
import ObjetosDAO.MotorDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MotorImpl implements MotorDAO {
	private static final String INSERTAR = "INSERT INTO MOTOR(ID, NAME, MANUFACTER, CAPACITY, ARCHITECTURE, DEBUT_YEAR, PETROL_ENGINE, DIESEL_ENGINE, ELECTRIC_ENGINE, TURBO, DERIVED_FROM_ID) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
	private static final String OBTENER_POR_ID = "SELECT * FROM ENGINE WHERE ID =?";
	private static final String OBTENER_TODOS = "SELECT * FROM ENGINE";
	private static final String ACTUALIZAR = "UPDATE MOTOR SET NAME=?, MANUFACTER=?, CAPACITY=?, ARCHITECTURE=?, DEBUT_YEAR=?, PETROL_ENGINE=?, DIESEL_ENGINE=?, ELECTRIC_ENGINE=?, TURBO=?, DERIVED_FROM_ID=? WHERE ID=?";
	private static final String ELIMINAR = "DELETE FROM ENGINE WHERE ID =?";
	private static final String OBTENER_ULTIMO_ID = "SELECT MAX(ID) AS MAX_ID FROM ENGINE";	
	ConexionMs conexion = new ConexionMs();

	@Override
	public void insertar(Motor motor) throws DAOException {
		try (PreparedStatement ps = conexion.getConnection().prepareStatement(INSERTAR)) {
			ps.setInt(1, motor.getMotor());
			ps.setString(2, motor.getNombre());
			ps.setString(3, motor.getFabricante());
			ps.setInt(4, motor.getCapacidad());
			ps.setString(5, motor.getArquitectura());
			ps.setInt(6, motor.getAnyo_debut());
			ps.setBoolean(7, motor.isGasolina());
			ps.setBoolean(8, motor.isDiesel());
			ps.setBoolean(9, motor.isElectrico());
			ps.setBoolean(10, motor.isTurbo());
			ps.setInt(11, motor.getDerivado_desde_id());
			ps.executeUpdate();
		} catch (Exception e) {
			throw new DAOException("Error inserting motor", e);
		}
	}

	@Override
	public Motor obtenerPorId(int id) throws DAOException {
		try (PreparedStatement ps = conexion.getConnection().prepareStatement(OBTENER_POR_ID)) {
			ps.setInt(1, id);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					return crearMotor(rs);
				}
			}
		} catch (Exception e) {
			throw new DAOException("Error getting motor by ID", e);
		}
		return null;
	}

	@Override
	public List<Motor> obtenerTodas() throws DAOException {
		List<Motor> motores = new ArrayList<>();
		try (PreparedStatement ps = conexion.getConnection().prepareStatement(OBTENER_TODOS);
			 ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				motores.add(crearMotor(rs));
			}
		} catch (Exception e) {
			throw new DAOException("Error getting all motors", e);
		}
		return motores;
	}

	@Override
	public void actualizar(Motor motor) throws DAOException {
		try (PreparedStatement ps = conexion.getConnection().prepareStatement(ACTUALIZAR)) {
			ps.setString(1, motor.getNombre());
			ps.setString(2, motor.getFabricante());
			ps.setInt(3, motor.getCapacidad());
			ps.setString(4, motor.getArquitectura());
			ps.setInt(5, motor.getAnyo_debut());
			ps.setBoolean(6, motor.isGasolina());
			ps.setBoolean(7, motor.isDiesel());
			ps.setBoolean(8, motor.isElectrico());
			ps.setBoolean(9, motor.isTurbo());
			ps.setInt(10, motor.getDerivado_desde_id());
			ps.setInt(11, motor.getMotor());
			int filas_afectadas = ps.executeUpdate();

			if (filas_afectadas == 0) {
				throw new DAOException("Error updating motor", null);
			}
		} catch (Exception e) {
			throw new DAOException("Error updating motor", e);
		}
	}

	@Override
	public void eliminar(int id) throws DAOException {
		try (PreparedStatement ps = conexion.getConnection().prepareStatement(ELIMINAR)) {
			ps.setInt(1, id);
			int filas_afectadas = ps.executeUpdate();

			if (filas_afectadas == 0) {
				throw new DAOException("Error deleting motor", null);
			}
		} catch (Exception e) {
			throw new DAOException("Error deleting motor", e);
		}
	}

	@Override
	public int obtenerUltimoId() throws DAOException {
		try (PreparedStatement ps = conexion.getConnection().prepareStatement(OBTENER_ULTIMO_ID);
			 ResultSet rs = ps.executeQuery()) {
			if (rs.next()) {
				return rs.getInt("MAX_ID");
			}
		} catch (Exception e) {
			throw new DAOException("Error getting last motor ID", e);
		}
		return 0;
	}

	public static Motor crearMotor(ResultSet rs) {
		Motor motor = null;
		int id = 0;
		String nombre = null;
		String fabricante = null;
		int capacidad = 0;
		String arquitectura = null;
		int anyo_debut = 0;
		boolean gasolina = false;
		boolean diesel = false;
		boolean electrico = false;
		boolean turbo = false;
		int derivado_desde_id = 0;
		 
		try {

			id = rs.getInt("ID");
			nombre = rs.getString("NAME");
			fabricante = rs.getString("MANUFACTER");
			capacidad = rs.getInt("CAPACITY");
			arquitectura = rs.getString("ARCHITECTURE");
			anyo_debut = rs.getInt("DEBUT_YEAR");
			gasolina = rs.getBoolean("PETROL_ENGINE");
			diesel = rs.getBoolean("DIESEL_ENGINE");
			electrico = rs.getBoolean("ELECTRIC_ENGINE");
			turbo = rs.getBoolean("TURBO");
			derivado_desde_id = rs.getInt("DERIVED_FROM_ID");

			motor =  new Motor(id, nombre, fabricante, capacidad, arquitectura, anyo_debut, gasolina, diesel, electrico, turbo, derivado_desde_id);

		} catch (Exception e) {

		}
		return motor;

	}
}
