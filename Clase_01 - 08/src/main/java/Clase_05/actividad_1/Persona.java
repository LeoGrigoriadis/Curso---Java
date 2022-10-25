package Clase_05.actividad_1;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "PERSONAS")
public class Persona {
	
	@Id 
	@Column(name = "ID")
	private Long id;
	@Column( name = "NOMBRE")
	private String nombre;
	@Column (name = "EDAD")
	private int edad;
	
	@OneToMany(fetch = FetchType.EAGER)
	private Collection<Cancion> discografia;
}
