package clase12.clase_12.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "SONG")
public class Cancion {
	
	@Id
	@Column( name = "ID")
	private Long id;
	
	@Column( name = "TITLE")
	private String titulo;

	@Column( name = "ARTIST")
	private Usuario artista;

	@Column( name = "ALBUM_ID")
	// @ManyToOne(fetch = FetchType.LAZY)
	private Album album;
}
