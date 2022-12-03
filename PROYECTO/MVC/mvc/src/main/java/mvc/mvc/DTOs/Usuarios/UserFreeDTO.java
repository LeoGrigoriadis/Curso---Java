package mvc.mvc.DTOs.Usuarios;

import java.util.Collection;

import lombok.Data;
import mvc.mvc.DTOs.SongDTO;

@Data
public class UserFreeDTO {
	
	private Long id;
	private String name;
	private int age;
	private int userType;
	private Collection<SongDTO> discography;
}
