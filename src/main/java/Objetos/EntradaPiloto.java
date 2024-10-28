package Objetos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntradaPiloto {
	private int entrada_id;
	private int piloto_id;
	private boolean rookie;
	private int categoria;
}
