package ObjetosSerivios;

import ObjetosDAO.ChassisDAO;
import ObjetosImpl.ChassisImpl;
import Objetos.Chassis;
import Excepciones.DAOException;

import java.util.List;

public class ChassisServicio {

    private ChassisDAO chassisDAO;

    public ChassisServicio() {
        this.chassisDAO = new ChassisImpl();
    }

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

    public Chassis obtenerChassis(int id) {
        try {
            return chassisDAO.obtenerPorId(id);
        } catch (DAOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Chassis> listarChassis() {
        try {
            return chassisDAO.obtenerTodas();
        } catch (DAOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void actualizarChassis(int id, String nombre, String fabricante, int anyoDebut, int derivadoDesdeId) {
        Chassis chassis = new Chassis(id, nombre, fabricante, anyoDebut, derivadoDesdeId);
        try {
            chassisDAO.actualizar(chassis);
            System.out.println("Chassis actualizado: " + chassis);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    public void eliminarChassis(int id) {
        try {
            chassisDAO.eliminar(id);
            System.out.println("Chassis eliminado con ID: " + id);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }
    
    public int obtenerUltimoId() throws DAOException {
        return chassisDAO.obtenerUltimoID();
    }
}