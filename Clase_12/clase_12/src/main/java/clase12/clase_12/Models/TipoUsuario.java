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

import lombok.Data;

@Entity
@Data
@Table(name = "USER_TYPES")
public class TipoUsuario {
    
    @Id
	@GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "NAME") 
    private String nombre; // free, premium, artista

    // @OneToMany(mappedBy = "tipoUsuario", cascade = CascadeType.ALL)
    // private Collection<Usuario> usuarios;
}
