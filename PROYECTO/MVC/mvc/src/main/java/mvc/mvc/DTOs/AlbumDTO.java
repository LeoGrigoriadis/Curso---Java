package mvc.mvc.DTOs;

import java.util.Collection;
import lombok.Data;

@Data
public class AlbumDTO{

	private Long id;
	private String title;
	private Collection<SongDTO> songs;
}
