package ObjetosServicios;

import ObjetosDAO.RuedasDAO;
import ObjetosImpl.RuedasImpl;
import Objetos.Ruedas;
import Excepciones.DAOException;

import java.util.List;

public class RuedasServicio {

    private RuedasDAO ruedasDAO;
    /**
     * Obtiene el último ID de los pilotos.
     *
     * @return El último ID de los pilotos.
     * @throws DAOException Si ocurre un error al obtener el ID.
     */
    public RuedasServicio() {
        this.ruedasDAO = new RuedasImpl();
    }
    /**
     * Agrega un nuevo proveedor de ruedas.
     *
     * @param id El ID del proveedor de ruedas.
     * @param nombre El nombre del proveedor de ruedas.
     * @param colorLetra El color de la letra del proveedor de ruedas.
     * @param colorFondo El color de fondo del proveedor de ruedas.
     */
    public void agregarRuedas(int id, String nombre, String colorLetra, String colorFondo) {
        Ruedas ruedas = new Ruedas();
        ruedas.setId(id);
        ruedas.setNombre(nombre);
        ruedas.setColor_letra(colorLetra);
        ruedas.setColor_fondo(colorFondo);
        try {
            ruedasDAO.insertar(ruedas);
            System.out.println("Ruedas agregadas con ID: " + ruedas.getId());
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Obtiene un proveedor de ruedas por su ID.
     *
     * @param id El ID del proveedor de ruedas.
     * @return El proveedor de ruedas obtenido o null si ocurre un error.
     */
    public Ruedas obtenerRuedas(int id) {
        try {
            return ruedasDAO.obtenerPorId(id);
        } catch (DAOException e) {
            e.printStackTrace();
            return null;
        }
    }
    /**
     * Lista todos los proveedores de ruedas.
     *
     * @return Una lista de todos los proveedores de ruedas o null si ocurre un error.
     */
    public List<Ruedas> listarRuedas() {
        try {
            return ruedasDAO.obtenerTodas();
        } catch (DAOException e) {
            e.printStackTrace();
            return null;
        }
    }
    /**
     * Actualiza un proveedor de ruedas existente.
     *
     * @param id El ID del proveedor de ruedas.
     * @param nombre El nombre del proveedor de ruedas.
     * @param colorLetra El color de la letra del proveedor de ruedas.
     * @param colorFondo El color de fondo del proveedor de ruedas.
     */
    public void actualizarRuedas(int id, String nombre, String colorLetra, String colorFondo) {
        Ruedas ruedas = new Ruedas(id, nombre, colorLetra, colorFondo);
        try {
            ruedasDAO.actualizar(ruedas);
            System.out.println("Ruedas actualizadas: " + ruedas);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Elimina un proveedor de ruedas por su ID.
     *
     * @param id El ID del proveedor de ruedas.
     */
    public void eliminarRuedas(int id) {
        try {
            ruedasDAO.eliminar(id);
            System.out.println("Ruedas eliminadas con ID: " + id);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Obtiene el último ID de los proveedores de ruedas.
     *
     * @return El último ID de los proveedores de ruedas.
     * @throws DAOException Si ocurre un error al obtener el ID.
     */
    public int obtenerUltimoId() {
        try {
            return ruedasDAO.obtenerUltimoID();
        } catch (DAOException e) {
            e.printStackTrace();
            return 0;
        }
    }
}