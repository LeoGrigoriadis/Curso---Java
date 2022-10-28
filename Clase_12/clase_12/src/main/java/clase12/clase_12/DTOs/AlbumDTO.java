package clase12.clase_12.DTOs;

import java.util.Collection;
import lombok.Data;

@Data
public class AlbumDTO{

	private Long id;
	private String titulo;
	private Collection<CancionDTO> canciones;
}
