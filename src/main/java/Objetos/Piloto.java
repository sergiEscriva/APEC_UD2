package Objetos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Piloto {
	private int id;
	private String nombre;
	private String apellido;
	private LocalDate fecha_muerte;
	private String lugar_muerte;
	private String nacionalidad;

}
