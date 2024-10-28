package ObjetosImpl;

public class RuedasImpl {
	private static final String INSERTAR = "INSERT INTO TYRE_PROVIDER(ID, NAME, LETTER_COLOR, BACKGROUND_COLOR) VALUES (?,?,?,?,?,?,?)";
	private static final  String OBTENER_POR_ID = "SELECT * FROM DRIVER WHERE ID =?";
	private static final String OBTENER_TODOS = "SELECT * FROM DRIVER";
	private static final String	ACTUALIZAR = "UPDATE DRIVER SET NAME=?, SURNAME=?, BIRTH_DATE=?, DEATH_DATE=?, NACIONALITY=? WHERE ID=?";
	private static final String ELIMINAR = "DELETE FROM DRIVER WHERE ID =?";
}
