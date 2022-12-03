package clase12.clase_12.Models;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table( name = "PLAYLIST")
public class Playlist {
    
    @Id
	@GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column( name = "NAME")
    private String name;
    
    @ManyToOne()
    @JoinColumn( name = "USER_ID")
    private User creator;

    @Column( name = "IS_PUBLIC")
    private Boolean isPublic;

    @Column( name = "IS_ALBUM")
    private Boolean isAlbum;

	@ManyToMany(cascade = {
		CascadeType.PERSIST,
		CascadeType.MERGE })
	@JoinTable( name = "SONG_PLAYLIST",
		joinColumns = { @JoinColumn(name = "SONG_ID")},
		inverseJoinColumns = {@JoinColumn(name = "PLAYLIST_ID")}
	)
	private Collection<Cancion> songs;

    // @OneToMany(mappedBy = "playlist", cascade = CascadeType.ALL)
    // private Collection<Cancion> canciones;
}
