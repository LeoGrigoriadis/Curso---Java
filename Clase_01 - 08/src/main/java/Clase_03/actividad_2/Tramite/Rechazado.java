package Clase_03.actividad_2.Tramite;

public class Rechazado implements Estado{

	private String motivoRechazo;
	@Override
	public void actualizar(Tramite tramite) {
		System.out.println("El trámite fue rechazado\n"
				+ "motivo del rechazo: "+ tramite.getMotivo());
	}
	
	public void setMotivoRechazo(String motivo) {
		this.motivoRechazo = motivo;
	}
	
}
