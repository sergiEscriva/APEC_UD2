package ObjetosImpl;

import Conexiones.ConexionMs;
import Excepciones.DAOException;
import Objetos.Piloto;
import ObjetosDAO.PilotoDAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PilotoImpl implements PilotoDAO {
	private static final String INSERTAR = "INSERT INTO DRIVER(ID, NAME, SURNAME, BIRTH_DATE, DEATH_DATE, DEATH_PLACE, NACIONALITY) VALUES (?,?,?,?,?,?,?)";
	private static final  String OBTENER_POR_ID = "SELECT * FROM DRIVER WHERE ID =?";
	private static final String OBTENER_TODOS = "SELECT * FROM DRIVER";
	private static final String	ACTUALIZAR = "UPDATE DRIVER SET NAME=?, SURNAME=?, BIRTH_DATE=?, DEATH_DATE=?, NACIONALITY=? WHERE ID=?";
	private static final String ELIMINAR = "DELETE FROM DRIVER WHERE ID =?";
	private static final String OBTENER_ULTIMO_ID = "SELECT MAX(ID) AS MAX_ID FROM DRIVER";
	
	ConexionMs conexion = new ConexionMs();


	@Override
	public void insertar(Piloto piloto) throws DAOException {
		try (PreparedStatement ps = conexion.getConnection().prepareStatement(INSERTAR)){

			ps.setInt(1, piloto.getId());
			ps.setString(2, piloto.getNombre());
			ps.setString(3, piloto.getApellido());
			ps.setDate(4, Date.valueOf(piloto.getFecha_nacimiento()));
			ps.setDate(5, Date.valueOf(piloto.getFecha_muerte()));
			ps.setString(6, piloto.getLugar_muerte());
			ps.setString(7, piloto.getNacionalidad());
			int filas_afectadas = ps.executeUpdate();
			
			if (filas_afectadas == 0){
				throw new DAOException("Error al insertar el piloto", null);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Piloto obtenerPorId(int id) throws DAOException {
		Piloto piloto = null;
		try (PreparedStatement ps = conexion.getConnection().prepareStatement(OBTENER_POR_ID)){
			ps.setInt(1, id);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()){
					piloto = crearPiloto(rs);
				}
				
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return piloto;
	}

	@Override
	public List<Piloto> obtenerTodas() throws DAOException {
		List<Piloto> pilotos = new ArrayList<>();
		try(PreparedStatement ps = conexion.getConnection().prepareStatement(OBTENER_TODOS);
			ResultSet rs = ps.executeQuery()){
			while (rs.next()){
				Piloto piloto = crearPiloto(rs);
				pilotos.add(piloto);
			}
			
		}catch (Exception e){
			
		}
		return pilotos;
	}

	@Override
	public void actualizar(Piloto piloto) throws DAOException {
		try (PreparedStatement ps = conexion.getConnection().prepareStatement(ACTUALIZAR)) {
			ps.setString(1, piloto.getNombre());
			ps.setString(2, piloto.getApellido());
			ps.setDate(3, Date.valueOf(piloto.getFecha_nacimiento()));
			ps.setDate(4, Date.valueOf(piloto.getFecha_muerte()));
			ps.setString(5, piloto.getNacionalidad());
			ps.setInt(6, piloto.getId());
			int filas_afectadas = ps.executeUpdate();

			if (filas_afectadas == 0) {
				throw new DAOException("Error al actualizar el piloto", null);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void eliminar(int id) throws DAOException {
		try (PreparedStatement ps = conexion.getConnection().prepareStatement(ELIMINAR)) {
			ps.setInt(1, id);
			int filas_afectadas = ps.executeUpdate();

			if (filas_afectadas == 0) {
				throw new DAOException("Error al eliminar el piloto", null);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
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

	public static Piloto crearPiloto(ResultSet rs){
		Piloto piloto = null;
		int id = 0;
		String nombre = null;
		String apellido = null;
		LocalDate fecha_nacimiento = null;
		LocalDate fecha_muerte = null;
		String lugar_muerte = null;
		String nacionalidad = null;
		
		try {

			id = rs.getInt("id");
			nombre = rs.getString("name");
			apellido = rs.getString("surname");
			fecha_nacimiento = rs.getDate("birth_date").toLocalDate();
			fecha_muerte = rs.getDate("death_date").toLocalDate();
			lugar_muerte =rs.getString("death_place");
			nacionalidad = rs.getString("nationality");
			
			piloto = new Piloto(id, nombre, apellido, fecha_nacimiento, fecha_muerte, lugar_muerte, nacionalidad);
			
		}catch (Exception e){
			
		}
		return piloto;
	}
}
