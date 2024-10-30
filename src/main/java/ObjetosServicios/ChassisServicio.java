package ObjetosServicios;

import ObjetosDAO.ChassisDAO;
import ObjetosImpl.ChassisImpl;
import Objetos.Chassis;
import Excepciones.DAOException;

import java.util.List;

public class ChassisServicio {

    private ChassisDAO chassisDAO;
    /**
     * Constructor de la clase ChassisServicio.
     * Inicializa la instancia de ChassisDAO.
     */
    public ChassisServicio() {
        this.chassisDAO = new ChassisImpl();
    }
    /**
     * Agrega un nuevo chasis.
     *
     * @param id El ID del chasis.
     * @param nombre El nombre del chasis.
     * @param fabricante El fabricante del chasis.
     * @param anyoDebut El año de debut del chasis.
     * @param derivadoDesdeId El ID del chasis del cual se deriva.
     */
    public void agregarChassis(int id, String nombre, String fabricante, int anyoDebut, int derivadoDesdeId) {
        Chassis chassis = new Chassis();
        chassis.setId(id);
        chassis.setNombre(nombre);
        chassis.setFabricante(fabricante);
        chassis.setAnyo_debut(anyoDebut);
        chassis.setDerivado_desde_id(derivadoDesdeId);
        try {
            chassisDAO.insertar(chassis);
            System.out.println("Chassis agregado con ID: " + chassis.getId());
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Obtiene un chasis por su ID.
     *
     * @param id El ID del chasis.
     * @return El chasis obtenido o null si ocurre un error.
     */
    public Chassis obtenerChassis(int id) {
        try {
            return chassisDAO.obtenerPorId(id);
        } catch (DAOException e) {
            e.printStackTrace();
            return null;
        }
    }
    /**
     * Lista todos los chasis.
     *
     * @return Una lista de todos los chasis o null si ocurre un error.
     */
    public List<Chassis> listarChassis() {
        try {
            return chassisDAO.obtenerTodas();
        } catch (DAOException e) {
            e.printStackTrace();
            return null;
        }
    }
    /**
     * Actualiza un chasis existente.
     *
     * @param id El ID del chasis.
     * @param nombre El nombre del chasis.
     * @param fabricante El fabricante del chasis.
     * @param anyoDebut El año de debut del chasis.
     * @param derivadoDesdeId El ID del chasis del cual se deriva.
     */
    public void actualizarChassis(int id, String nombre, String fabricante, int anyoDebut, int derivadoDesdeId) {
        Chassis chassis = new Chassis(id, nombre, fabricante, anyoDebut, derivadoDesdeId);
        try {
            chassisDAO.actualizar(chassis);
            System.out.println("Chassis actualizado: " + chassis);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Elimina un chasis por su ID.
     *
     * @param id El ID del chasis.
     */
    public void eliminarChassis(int id) {
        try {
            chassisDAO.eliminar(id);
            System.out.println("Chassis eliminado con ID: " + id);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Obtiene el último ID de los chasis.
     *
     * @return El último ID de los chasis.
     * @throws DAOException Si ocurre un error al obtener el ID.
     */
    public int obtenerUltimoId() throws DAOException {
        return chassisDAO.obtenerUltimoID();
    }
}