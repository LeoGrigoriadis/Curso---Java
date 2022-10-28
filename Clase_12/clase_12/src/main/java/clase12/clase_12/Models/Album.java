package clase12.clase_12.Models;

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

@Table(name = "ALBUM")
public class Album{
	
	@Id
	@Column( name = "ID")
	private Long id;

	@Column( name = "TITLE")
	private String titulo;
	
	@Column( name = "SONG_ID")
	// @OneToMany(fetch = FetchType.LAZY)
	private Collection<Cancion> canciones;
}
