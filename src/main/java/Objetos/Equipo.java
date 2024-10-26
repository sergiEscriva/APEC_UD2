package Objetos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Equipo {
	
	private int id;
	private String nombre;
	private String descripcion;
	private String hq_localizacion;
	
}
