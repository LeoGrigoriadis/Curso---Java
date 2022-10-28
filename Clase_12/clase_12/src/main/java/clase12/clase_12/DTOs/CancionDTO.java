package clase12.clase_12.DTOs;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "CANCIONES")
public class CancionDTO {
	
	@Id
	@Column( name = "ID")
	private Long id;
	
	@Column( name = "TITULO")
	private String titulo;

	@Column( name = "ARTISTA")
	private UsuarioFreeDTO artista;
}
