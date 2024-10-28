package ObjetosSerivios;

import ObjetosDAO.PilotoDAO;
import ObjetosImpl.PilotoImpl;
import Objetos.Piloto;
import Excepciones.DAOException;

import java.util.List;

public class PilotoServicio {

    private PilotoDAO pilotoDAO;

    public PilotoServicio() {
        this.pilotoDAO = new PilotoImpl();
    }

    public void agregarPiloto(String nombre, String apellido, String fechaMuerte, String fechaNacimiento, String lugarMuerte, String nacionalidad) {
        Piloto piloto = new Piloto();
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

    public Piloto obtenerPiloto(int id) {
        try {
            return pilotoDAO.obtenerPorId(id);
        } catch (DAOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Piloto> listarPilotos() {
        try {
            return pilotoDAO.obtenerTodas();
        } catch (DAOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void actualizarPiloto(int id, String nombre, String apellido, String fechaMuerte, String fechaNacimiento, String lugarMuerte, String nacionalidad) {
        Piloto piloto = new Piloto(id, nombre, apellido, fechaMuerte, fechaNacimiento, lugarMuerte, nacionalidad);
        try {
            pilotoDAO.actualizar(piloto);
            System.out.println("Piloto actualizado: " + piloto);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    public void eliminarPiloto(int id) {
        try {
            pilotoDAO.eliminar(id);
            System.out.println("Piloto eliminado con ID: " + id);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }
}