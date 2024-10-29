package ObjetosSerivios;

import ObjetosDAO.EquipoDAO;
import ObjetosImpl.EquipoImpl;
import Objetos.Equipo;
import Excepciones.DAOException;

import java.util.List;

public class EquipoServicio {

    private EquipoDAO equipoDAO;

    public EquipoServicio() {
        this.equipoDAO = new EquipoImpl();
    }

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

    public Equipo obtenerEquipo(int id) {
        try {
            return equipoDAO.obtenerPorId(id);
        } catch (DAOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Equipo> listarEquipos() {
        try {
            return equipoDAO.obtenerTodas();
        } catch (DAOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void actualizarEquipo(int id, String nombre, String descripcion) {
        Equipo equipo = new Equipo(id, nombre, descripcion);
        try {
            equipoDAO.actualizar(equipo);
            System.out.println("Equipo actualizado: " + equipo);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    public void eliminarEquipo(int id) {
        try {
            equipoDAO.eliminar(id);
            System.out.println("Equipo eliminado con ID: " + id);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }
    
    public int obtenerUltimoId() throws DAOException {
        return equipoDAO.obtenerUltimoID();
    }
}