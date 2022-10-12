package Clase_03.actividad_2.usuarios;

import java.util.Date;

import Clase_03.actividad_2.interfaces.Renovable;
import Clase_03.actividad_2.sustancias.Sustancia;

public class Consumidor implements Renovable {

	private Date ultRenovacion;

	@Override
	public void renovarDatos(String dni) {
		this.ultRenovacion = new Date();
	}
	
	public boolean solicitarSustancia(Sustancia sustancia, Productor productor) {
		productor.getSustanciasDisponibles();
		boolean flag = false;
		return flag;
	}

	public Date getUltRenovacion() {
		return ultRenovacion;
	}

	public void setUltRenovacion(Date ultRenovacion) {
		this.ultRenovacion = ultRenovacion;
	}
}
