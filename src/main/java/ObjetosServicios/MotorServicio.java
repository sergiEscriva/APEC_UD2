package ObjetosServicios;

import ObjetosDAO.MotorDAO;
import ObjetosImpl.MotorImpl;
import Objetos.Motor;
import Excepciones.DAOException;

import java.util.List;

public class MotorServicio {

    private MotorDAO motorDAO;
    /**
     * Constructor de la clase MotorServicio.
     * Inicializa la instancia de MotorDAO.
     */
    public MotorServicio() {
        this.motorDAO = new MotorImpl();
    }
    /**
     * Agrega un nuevo motor.
     *
     * @param id El ID del motor.
     * @param nombre El nombre del motor.
     * @param fabricante El fabricante del motor.
     * @param capacidad La capacidad del motor.
     * @param arquitectura La arquitectura del motor.
     * @param anyoDebut El año de debut del motor.
     * @param gasolina Indica si el motor es de gasolina.
     * @param diesel Indica si el motor es de diesel.
     * @param electrico Indica si el motor es eléctrico.
     * @param turbo Indica si el motor tiene turbo.
     * @param derivadoDesdeId El ID del motor del cual se deriva.
     */
    public void agregarMotor(int id, String nombre, String fabricante, int capacidad, String arquitectura, int anyoDebut, boolean gasolina, boolean diesel, boolean electrico, boolean turbo, int derivadoDesdeId) {
        Motor motor = new Motor();
        motor.setMotor(id);
        motor.setNombre(nombre);
        motor.setFabricante(fabricante);
        motor.setCapacidad(capacidad);
        motor.setArquitectura(arquitectura);
        motor.setAnyo_debut(anyoDebut);
        motor.setGasolina(gasolina);
        motor.setDiesel(diesel);
        motor.setElectrico(electrico);
        motor.setTurbo(turbo);
        motor.setDerivado_desde_id(derivadoDesdeId);
        try {
            motorDAO.insertar(motor);
            System.out.println("Motor agregado con ID: " + motor.getMotor());
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Obtiene un motor por su ID.
     *
     * @param id El ID del motor.
     * @return El motor obtenido o null si ocurre un error.
     */
    public Motor obtenerMotor(int id) {
        try {
            return motorDAO.obtenerPorId(id);
        } catch (DAOException e) {
            e.printStackTrace();
            return null;
        }
    }
    /**
     * Lista todos los motores.
     *
     * @return Una lista de todos los motores o null si ocurre un error.
     */
    public List<Motor> listarMotores() {
        try {
            return motorDAO.obtenerTodas();
        } catch (DAOException e) {
            e.printStackTrace();
            return null;
        }
    }
    /**
     * Actualiza un motor existente.
     *
     * @param id El ID del motor.
     * @param nombre El nombre del motor.
     * @param fabricante El fabricante del motor.
     * @param capacidad La capacidad del motor.
     * @param arquitectura La arquitectura del motor.
     * @param anyoDebut El año de debut del motor.
     * @param gasolina Indica si el motor es de gasolina.
     * @param diesel Indica si el motor es de diesel.
     * @param electrico Indica si el motor es eléctrico.
     * @param turbo Indica si el motor tiene turbo.
     * @param derivadoDesdeId El ID del motor del cual se deriva.
     */
    public void actualizarMotor(int id, String nombre, String fabricante, int capacidad, String arquitectura, int anyoDebut, boolean gasolina, boolean diesel, boolean electrico, boolean turbo, int derivadoDesdeId) {
        Motor motor = new Motor(id, nombre, fabricante, capacidad, arquitectura, anyoDebut, gasolina, diesel, electrico, turbo, derivadoDesdeId);
        try {
            motorDAO.actualizar(motor);
            System.out.println("Motor actualizado: " + motor);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Elimina un motor por su ID.
     *
     * @param id El ID del motor.
     */
    public void eliminarMotor(int id) {
        try {
            motorDAO.eliminar(id);
            System.out.println("Motor eliminado con ID: " + id);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Obtiene el último ID de los motores.
     *
     * @return El último ID de los motores.
     * @throws DAOException Si ocurre un error al obtener el ID.
     */
    public int obtenerUltimoId() {
        try {
            return motorDAO.obtenerUltimoId();
        } catch (DAOException e) {
            e.printStackTrace();
            return 0;
        }
    }
    
}
