package clase12.clase_12.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "USER_TYPE")
public class TipoUsuario {
    
    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME") 
    private String nombre; // free, premium, artista
}
