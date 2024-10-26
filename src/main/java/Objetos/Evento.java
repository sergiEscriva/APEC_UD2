package Objetos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Evento {
	private int id;
	private String nombre_equipo;
	private int chassis_id;
	private int motor_id;
	private int dirigido_por;
	private int ruedas_id;
	private String numero_piloto;
	private int equipo_id;
	private int categoria_id;
	
	
}
