package Clase_05.actividad_1;

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
public class Cancion {
	
	@Id
	@Column( name = "ID")
	private Long id;
	
	@Column( name = "TITULO")
	private String titulo;

	@Column( name = "ARTISTA")
	private Persona artista;
}
