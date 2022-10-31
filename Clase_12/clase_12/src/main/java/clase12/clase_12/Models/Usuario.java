package clase12.clase_12.Models;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "USERS")
public class Usuario {
	
	@Id 
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;

	@Column( name = "USERNAME")
	private String usuario;

	@Column (name = "PASSWORD")
	private String contrasena;

	@JoinColumn (name = "USER_TYPE_ID")
    @ManyToOne()
    private TipoUsuario tipoUsuario;
	
	@OneToMany(mappedBy = "album", cascade = CascadeType.ALL)
	private Collection<Cancion> albums;

	@ManyToMany(mappedBy = "artistas")
	private Collection<Cancion> discografia;



	

}