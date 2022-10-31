package clase12.clase_12.DTOs;

import clase12.clase_12.DTOs.Usuarios.UsuarioFreeDTO;
import lombok.Data;

@Data
public class CancionDTO {

	private Long id;
	private String titulo;
	private UsuarioFreeDTO artista;
}
