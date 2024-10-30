package ObjetosServicios;

import ObjetosDAO.PilotoDAO;
import ObjetosImpl.PilotoImpl;
import Objetos.Piloto;
import Excepciones.DAOException;

import java.time.LocalDate;
import java.util.List;

public class PilotoServicio {

    private PilotoDAO pilotoDAO;
    /**
     * Constructor de la clase PilotoServicio.
     * Inicializa la instancia de PilotoDAO.
     */
    public PilotoServicio() {
        this.pilotoDAO = new PilotoImpl();
    }
    
    /**
     * Agrega un nuevo piloto.
     *
     * @param id El ID del piloto.
     * @param nombre El nombre del piloto.
     * @param apellido El apellido del piloto.
     * @param fechaMuerte La fecha de muerte del piloto.
     * @param fechaNacimiento La fecha de nacimiento del piloto.
     * @param lugarMuerte El lugar de muerte del piloto.
     * @param nacionalidad La nacionalidad del piloto.
     */
    public void agregarPiloto(int id, String nombre, String apellido, LocalDate fechaMuerte, LocalDate fechaNacimiento, String lugarMuerte, String nacionalidad) {
        Piloto piloto = new Piloto();
        piloto.setId(id);
        piloto.setNombre(nombre);
        piloto.setApellido(apellido);
        piloto.setFecha_muerte(fechaMuerte);
        piloto.setFecha_nacimiento(fechaNacimiento);
        piloto.setLugar_muerte(lugarMuerte);
        piloto.setNacionalidad(nacionalidad);
        try {
            pilotoDAO.insertar(piloto);
            System.out.println("Piloto agregado con ID: " + piloto.getId());
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Obtiene un piloto por su ID.
     *
     * @param id El ID del piloto.
     * @return El piloto obtenido o null si ocurre un error.
     */
    public Piloto obtenerPiloto(int id) {
        try {
            return pilotoDAO.obtenerPorId(id);
        } catch (DAOException e) {
            e.printStackTrace();
            return null;
        }
    }
    /**
     * Lista todos los pilotos.
     *
     * @return Una lista de todos los pilotos o null si ocurre un error.
     */
    public List<Piloto> listarPilotos() {
        try {
            return pilotoDAO.obtenerTodas();
        } catch (DAOException e) {
            e.printStackTrace();
            return null;
        }
    }
    /**
     * Actualiza un piloto existente.
     *
     * @param id El ID del piloto.
     * @param nombre El nombre del piloto.
     * @param apellido El apellido del piloto.
     * @param fechaMuerte La fecha de muerte del piloto.
     * @param fechaNacimiento La fecha de nacimiento del piloto.
     * @param lugarMuerte El lugar de muerte del piloto.
     * @param nacionalidad La nacionalidad del piloto.
     */
    public void actualizarPiloto(int id, String nombre, String apellido, LocalDate fechaMuerte, LocalDate fechaNacimiento, String lugarMuerte, String nacionalidad) {
        Piloto piloto = new Piloto(id, nombre, apellido, fechaMuerte, fechaNacimiento, lugarMuerte, nacionalidad);
        try {
            pilotoDAO.actualizar(piloto);
            System.out.println("Piloto actualizado: " + piloto);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Elimina un piloto por su ID.
     *
     * @param id El ID del piloto.
     */
    public void eliminarPiloto(int id) {
        try {
            pilotoDAO.eliminar(id);
            System.out.println("Piloto eliminado con ID: " + id);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Obtiene el último ID de los pilotos.
     *
     * @return El último ID de los pilotos.
     * @throws DAOException Si ocurre un error al obtener el ID.
     */
    public int obtenerUltimoId() {
        try {
            return pilotoDAO.obtenerUltimoID();
        } catch (DAOException e) {
            System.out.println("Error en la obencion del ultimo ID");
        }
        return 0;
    }

    public List<Piloto> obtenerPilotosConEventos() {
        try {
            return pilotoDAO.obtenerPilotosConEventos();
        } catch (DAOException e) {
            e.printStackTrace();
            return null;
        }
    }
}