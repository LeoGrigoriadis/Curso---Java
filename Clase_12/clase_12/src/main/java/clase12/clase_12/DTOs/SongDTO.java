package clase12.clase_12.DTOs;

import clase12.clase_12.DTOs.Usuarios.UserFreeDTO;
import lombok.Data;

@Data
public class SongDTO {

	private Long id;
	private String titulo;
	private UserFreeDTO artista;
}
