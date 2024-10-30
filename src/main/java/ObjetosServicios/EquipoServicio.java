package ObjetosServicios;

import ObjetosDAO.EquipoDAO;
import ObjetosImpl.EquipoImpl;
import Objetos.Equipo;
import Excepciones.DAOException;

import java.util.List;

public class EquipoServicio {

    private EquipoDAO equipoDAO;

    /**
     * Constructor de la clase EquipoServicio.
     * Inicializa la instancia de EquipoDAO.
     */
    public EquipoServicio() {
        this.equipoDAO = new EquipoImpl();
    }
    /**
     * Agrega un nuevo equipo.
     *
     * @param id El ID del equipo.
     * @param nombre El nombre del equipo.
     * @param descripcion La descripción del equipo.
     */
    public void agregarEquipo(int id, String nombre, String descripcion) {
        Equipo equipo = new Equipo();
        equipo.setId(id);
        equipo.setNombre(nombre);
        equipo.setDescripcion(descripcion);
        try {
            equipoDAO.insertar(equipo);
            System.out.println("Equipo agregado con ID: " + equipo.getId());
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Obtiene un equipo por su ID.
     *
     * @param id El ID del equipo.
     * @return El equipo obtenido o null si ocurre un error.
     */
    public Equipo obtenerEquipo(int id) {
        try {
            return equipoDAO.obtenerPorId(id);
        } catch (DAOException e) {
            e.printStackTrace();
            return null;
        }
    }
    /**
     * Lista todos los equipos.
     *
     * @return Una lista de todos los equipos o null si ocurre un error.
     */
    public List<Equipo> listarEquipos() {
        try {
            return equipoDAO.obtenerTodas();
        } catch (DAOException e) {
            e.printStackTrace();
            return null;
        }
    }
    /**
     * Actualiza un equipo existente.
     *
     * @param id El ID del equipo.
     * @param nombre El nombre del equipo.
     * @param descripcion La descripción del equipo.
     */
    public void actualizarEquipo(int id, String nombre, String descripcion) {
        Equipo equipo = new Equipo(id, nombre, descripcion);
        try {
            equipoDAO.actualizar(equipo);
            System.out.println("Equipo actualizado: " + equipo);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Elimina un equipo por su ID.
     *
     * @param id El ID del equipo.
     */
    public void eliminarEquipo(int id) {
        try {
            equipoDAO.eliminar(id);
            System.out.println("Equipo eliminado con ID: " + id);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Obtiene el último ID de los equipos.
     *
     * @return El último ID de los equipos.
     * @throws DAOException Si ocurre un error al obtener el ID.
     */
    public int obtenerUltimoId() throws DAOException {
        return equipoDAO.obtenerUltimoID();
    }
}