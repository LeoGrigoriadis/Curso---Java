package clase12.clase_12.DTOs.Usuarios;

import java.util.Collection;

import clase12.clase_12.DTOs.SongDTO;
import clase12.clase_12.Models.UserType;
import lombok.Data;

@Data
public class UserFreeDTO {
	
	private Long id;
	private String name;
	private int age;
	private UserType userType;
	private Collection<SongDTO> discography;
}
