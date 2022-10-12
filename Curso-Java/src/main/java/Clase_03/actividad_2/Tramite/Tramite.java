package Clase_03.actividad_2.Tramite;

import java.security.Timestamp;

import Clase_03.actividad_2.sustancias.Sustancia;
import Clase_03.actividad_2.usuarios.Productor;

public class Tramite {
	private Timestamp inicioTramite;
	private Sustancia sustancia;
	private int cantidad;
	private Productor productor;
	private double monto;
	private String motivo;
	private Estado estado;
	
	public void resolverTramite(boolean flag) {
		if(flag) {
			estado = new Cerrado();
		} else {
			estado = new Rechazado();
			setMotivo("El motivo es el siguiente...");
		}
		estado.actualizar(this);
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
}
