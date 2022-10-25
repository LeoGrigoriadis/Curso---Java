package Clase_03.actividad_2.Tramite;

public class Cerrado implements Estado {

	@Override
	public void actualizar(Tramite tramite) {
		System.out.println("El trámite se realizó correctamente y fue cerrado.");
	}

}
