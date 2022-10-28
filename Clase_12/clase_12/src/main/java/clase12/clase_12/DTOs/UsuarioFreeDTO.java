package clase12.clase_12.DTOs;

import java.util.Collection;

import clase12.clase_12.Models.TipoUsuario;
import lombok.Data;

@Data
public class UsuarioFreeDTO {
	
	private Long id;
	private String nombre;
	private int edad;
	
	private TipoUsuario tipoUsuario;
	
	private Collection<CancionDTO> discografia;
}
