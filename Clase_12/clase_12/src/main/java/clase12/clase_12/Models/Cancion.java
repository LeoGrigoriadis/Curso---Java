package clase12.clase_12.Models;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "SONGS")
public class Cancion {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	
	@Column( name = "TITLE")
	private String titulo;

	@ManyToMany(cascade = {
		CascadeType.PERSIST,
		CascadeType.MERGE })
	@JoinTable( name = "ARTIST_USER",
		joinColumns = {@JoinColumn(name = "ARTIST_ID")},
		inverseJoinColumns = {@JoinColumn(name = "USER_ID")}
	)
	private Collection<Usuario> artistas;

	@ManyToOne()
	@JoinColumn( name = "ALBUM_ID")
	private Album album;

	// @ManyToOne()
	// @JoinColumn( name = "PLAYLIST_ID")
	// private Playlist playlist;
}
