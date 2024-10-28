package ObjetosSerivios;

import ObjetosDAO.RuedasDAO;
import ObjetosImpl.RuedasImpl;
import Objetos.Ruedas;
import Excepciones.DAOException;

import java.util.List;

public class RuedasServicio {

    private RuedasDAO ruedasDAO;

    public RuedasServicio() {
        this.ruedasDAO = new RuedasImpl();
    }

    public void agregarRuedas(String nombre, String colorLetra, String colorFondo) {
        Ruedas ruedas = new Ruedas();
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

    public Ruedas obtenerRuedas(int id) {
        try {
            return ruedasDAO.obtenerPorId(id);
        } catch (DAOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Ruedas> listarRuedas() {
        try {
            return ruedasDAO.obtenerTodas();
        } catch (DAOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void actualizarRuedas(int id, String nombre, String colorLetra, String colorFondo) {
        Ruedas ruedas = new Ruedas(id, nombre, colorLetra, colorFondo);
        try {
            ruedasDAO.actualizar(ruedas);
            System.out.println("Ruedas actualizadas: " + ruedas);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    public void eliminarRuedas(int id) {
        try {
            ruedasDAO.eliminar(id);
            System.out.println("Ruedas eliminadas con ID: " + id);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }
}