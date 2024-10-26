package Excepciones;

public class DAOException extends Exception{
	public DAOException(String mensaje, Throwable causa) {
		super(mensaje, causa);
	}
}
