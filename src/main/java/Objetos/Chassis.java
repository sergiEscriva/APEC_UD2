package Objetos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Chassis {
	
	private int id;
	private String nombre;
	private  String fabricante;
	private  int anyo_debut;
	private int derivado_desde_id;
	
}
