package ObjetosServicios;

import ObjetosDAO.EventoDAO;
import ObjetosImpl.EventoImpl;
import Objetos.Evento;
import Excepciones.DAOException;

import java.util.List;

public class EventoServicio {

    private EventoDAO eventoDAO;
    /**
     * Constructor de la clase EventoServicio.
     * Inicializa la instancia de EventoDAO.
     */
    public EventoServicio() {
        this.eventoDAO = new EventoImpl();
    }
    /**
     * Agrega un nuevo evento.
     *
     * @param id El ID del evento.
     * @param nombreEquipo El nombre del equipo.
     * @param chassisId El ID del chasis.
     * @param motorId El ID del motor.
     * @param dirigidoPor El ID del director.
     * @param ruedasId El ID del proveedor de ruedas.
     * @param numeroPiloto El número del piloto en el evento.
     * @param equipoId El ID del equipo.
     * @param categoriaId El ID de la categoría.
     */
    public void agregarEvento(int id, String nombreEquipo, int chassisId, int motorId, int dirigidoPor, int ruedasId, String numeroPiloto, int equipoId, int categoriaId) {
        Evento evento = new Evento(id, nombreEquipo, chassisId, motorId, dirigidoPor, ruedasId, numeroPiloto, equipoId, categoriaId);
        try {
            eventoDAO.insertar(evento);
            System.out.println("Evento agregado con ID: " + evento.getId());
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Obtiene un evento por su ID.
     *
     * @param id El ID del evento.
     * @return El evento obtenido o null si ocurre un error.
     */
    public Evento obtenerEvento(int id) {
        try {
            return eventoDAO.obtenerPorId(id);
        } catch (DAOException e) {
            e.printStackTrace();
            return null;
        }
    }
    /**
     * Lista todos los eventos.
     *
     * @return Una lista de todos los eventos o null si ocurre un error.
     */
    public List<Evento> listarEventos() {
        try {
            return eventoDAO.obtenerTodos();
        } catch (DAOException e) {
            e.printStackTrace();
            return null;
        }
    }
    /**
     * Actualiza un evento existente.
     *
     * @param id El ID del evento.
     * @param nombreEquipo El nombre del equipo.
     * @param chassisId El ID del chasis.
     * @param motorId El ID del motor.
     * @param dirigidoPor El ID del director.
     * @param ruedasId El ID del proveedor de ruedas.
     * @param numeroPiloto El número del piloto en el evento.
     * @param equipoId El ID del equipo.
     * @param categoriaId El ID de la categoría.
     */
    public void actualizarEvento(int id, String nombreEquipo, int chassisId, int motorId, int dirigidoPor, int ruedasId, String numeroPiloto, int equipoId, int categoriaId) {
        Evento evento = new Evento(id, nombreEquipo, chassisId, motorId, dirigidoPor, ruedasId, numeroPiloto, equipoId, categoriaId);
        try {
            eventoDAO.actualizar(evento);
            System.out.println("Evento actualizado: " + evento);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Elimina un evento por su ID.
     *
     * @param id El ID del evento.
     */
    public void eliminarEvento(int id) {
        try {
            eventoDAO.eliminar(id);
            System.out.println("Evento eliminado con ID: " + id);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Obtiene el último ID de los eventos.
     *
     * @return El último ID de los eventos.
     * @throws DAOException Si ocurre un error al obtener el ID.
     */
	public int obtenerUltimoId() {
		try {
			return eventoDAO.obtenerUltimoId();
		} catch (DAOException e) {
			e.printStackTrace();
			return -1;
		}
	}

    public List<Evento> obtenerEventosConEquipos() {
        try {
            return eventoDAO.obtenerEventosConEquipos();
        } catch (DAOException e) {
            e.printStackTrace();
            return null;
        }
    }
}