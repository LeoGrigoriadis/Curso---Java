package clase11.clase_11.DTOs;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonaDTO implements Serializable{
    
    private Long id;
    private String nombre;
    private String apellido;
    private String documento;
}
