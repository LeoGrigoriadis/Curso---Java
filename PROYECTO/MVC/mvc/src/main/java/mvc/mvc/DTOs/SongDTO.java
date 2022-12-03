package mvc.mvc.DTOs;

import lombok.Data;
import mvc.mvc.DTOs.Usuarios.UserFreeDTO;

@Data
public class SongDTO {

	private Long id;
	private String titulo;
	private UserFreeDTO artista;
}
