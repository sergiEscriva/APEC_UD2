package ObjetosSerivios;

import ObjetosDAO.MotorDAO;
import ObjetosImpl.MotorImpl;
import Objetos.Motor;
import Excepciones.DAOException;

import java.util.List;

public class MotorServicio {

    private MotorDAO motorDAO;

    public MotorServicio() {
        this.motorDAO = new MotorImpl();
    }

    public void agregarMotor(String nombre, String fabricante, int capacidad, String arquitectura, String anyoDebut, boolean gasolina, boolean diesel, boolean electrico, boolean turbo, int derivadoDesdeId) {
        Motor motor = new Motor();
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

    public Motor obtenerMotor(int id) {
        try {
            return motorDAO.obtenerPorId(id);
        } catch (DAOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Motor> listarMotores() {
        try {
            return motorDAO.obtenerTodas();
        } catch (DAOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void actualizarMotor(int id, String nombre, String fabricante, int capacidad, String arquitectura, String anyoDebut, boolean gasolina, boolean diesel, boolean electrico, boolean turbo, int derivadoDesdeId) {
        Motor motor = new Motor(id, nombre, fabricante, capacidad, arquitectura, anyoDebut, gasolina, diesel, electrico, turbo, derivadoDesdeId);
        try {
            motorDAO.actualizar(motor);
            System.out.println("Motor actualizado: " + motor);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    public void eliminarMotor(int id) {
        try {
            motorDAO.eliminar(id);
            System.out.println("Motor eliminado con ID: " + id);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }
}
