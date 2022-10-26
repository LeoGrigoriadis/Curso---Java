package clase11.clase_11.Models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Persona {

    private Long id;
    private String nombre;
    private String apellido;
    private Long edad;
    private String documento;
    private double peso;
}
