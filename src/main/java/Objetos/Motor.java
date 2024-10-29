package Objetos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Motor {
	
	private int motor;
	private String nombre;
	private String fabricante;
	private int capacidad;
	private String arquitectura;
	private int anyo_debut;
	private boolean gasolina;
	private boolean diesel;
	private boolean electrico;
	private boolean turbo;
	private int derivado_desde_id;
	
}
