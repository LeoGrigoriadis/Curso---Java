package Clase_05.actividad_1;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Album{
	
	@Id
	@Column( name = "ID")
	private Long id;

	@Column( name = "TITULO")
	private String titulo;
	
	@OneToMany(fetch = FetchType.LAZY)
	@Column( name = "CANCIONES")
	private Collection<Cancion> canciones;
}
