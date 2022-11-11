package clase12.clase_12.Models;

import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
@Table(name = "USERS")
public class User {
	
	public User(String username2, String passEncripted, UserType userType2) {
    }

    @Id 
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;

	@Column( name = "USERNAME")
	private String username;

	@Column (name = "PASSWORD")
	private String password;

	@JoinColumn (name = "USER_TYPE_ID")
    @ManyToOne()
    private UserType userType;
	
	//albums
	// @OneToMany(mappedBy = "artistaId", cascade = CascadeType.ALL)
	// private Collection<Album> albums;

	// @ManyToMany(mappedBy = "artistas")
	// private Collection<Cancion> discografia;



	

}