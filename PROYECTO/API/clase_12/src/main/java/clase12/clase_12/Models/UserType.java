package clase12.clase_12.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "USER_TYPES")
public class UserType {
    
    @Id
	@GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "NAME") 
    private String name; // free, premium, artista

    // @OneToMany(mappedBy = "tipoUsuario", cascade = CascadeType.ALL)
    // private Collection<Usuario> usuarios;
}
