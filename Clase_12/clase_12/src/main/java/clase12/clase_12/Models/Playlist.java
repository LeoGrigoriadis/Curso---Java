package clase12.clase_12.Models;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table( name = "PLAYLIST")
public class Playlist {
    
    @Id
	@GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column( name = "NAME")
    private String nombre;

    @OneToMany(mappedBy = "playlist", cascade = CascadeType.ALL)
    private Collection<Cancion> canciones;
}
