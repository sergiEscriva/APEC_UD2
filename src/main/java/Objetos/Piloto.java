package Objetos;

import lombok.AllArgsConstructor;
import lombok.Builder;
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
	private LocalDate fecha_nacimiento;
	private String lugar_muerte;
	private String nacionalidad;
	private String eventoNombre; // New field

	public Piloto(int id, String nombre, String apellido, LocalDate fecha_nacimiento, LocalDate fecha_muerte, String lugar_muerte, String nacionalidad) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fecha_nacimiento = fecha_nacimiento;
		this.fecha_muerte = fecha_muerte;
		this.lugar_muerte = lugar_muerte;
		this.nacionalidad = nacionalidad;
	}
}
