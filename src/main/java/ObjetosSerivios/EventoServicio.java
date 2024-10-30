package ObjetosSerivios;

import ObjetosDAO.EventoDAO;
import ObjetosImpl.EventoImpl;
import Objetos.Evento;
import Excepciones.DAOException;

import java.util.List;

public class EventoServicio {

    private EventoDAO eventoDAO;

    public EventoServicio() {
        this.eventoDAO = new EventoImpl();
    }

    public void agregarEvento(int id, String nombreEquipo, int chassisId, int motorId, int dirigidoPor, int ruedasId, String numeroPiloto, int equipoId, int categoriaId) {
        Evento evento = new Evento(id, nombreEquipo, chassisId, motorId, dirigidoPor, ruedasId, numeroPiloto, equipoId, categoriaId);
        try {
            eventoDAO.insertar(evento);
            System.out.println("Evento agregado con ID: " + evento.getId());
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    public Evento obtenerEvento(int id) {
        try {
            return eventoDAO.obtenerPorId(id);
        } catch (DAOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Evento> listarEventos() {
        try {
            return eventoDAO.obtenerTodos();
        } catch (DAOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void actualizarEvento(int id, String nombreEquipo, int chassisId, int motorId, int dirigidoPor, int ruedasId, String numeroPiloto, int equipoId, int categoriaId) {
        Evento evento = new Evento(id, nombreEquipo, chassisId, motorId, dirigidoPor, ruedasId, numeroPiloto, equipoId, categoriaId);
        try {
            eventoDAO.actualizar(evento);
            System.out.println("Evento actualizado: " + evento);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    public void eliminarEvento(int id) {
        try {
            eventoDAO.eliminar(id);
            System.out.println("Evento eliminado con ID: " + id);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }
	public int obtenerUltimoId() {
		try {
			return eventoDAO.obtenerUltimoId();
		} catch (DAOException e) {
			e.printStackTrace();
			return -1;
		}
	}
}