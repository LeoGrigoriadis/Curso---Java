package clase12.clase_12.Models;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "USERS")
public class Usuario {
	
	@Id 
	@Column(name = "ID")
	private Long id;

	@Column( name = "USERNAME")
	private String usuario;

	@Column (name = "PASSWORD")
	private int contrasena;

	@Column (name = "USER_TYPE_ID")
    // @ManyToOne(fetch = FetchType.LAZY)
    private TipoUsuario tipoUsuario;
	
	@Column (name = "DISCOGRAPHY")
	// @OneToMany(fetch = FetchType.EAGER)
	private Collection<Cancion> discografia;


}