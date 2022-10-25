package Clase_03.actividad_2.usuarios;

import java.util.ArrayList;
import java.util.Date;

import Clase_03.actividad_2.interfaces.Renovable;
import Clase_03.actividad_2.sustancias.Sustancia;

public class Productor implements Renovable {

	private Date ultRenovacion;
	private ArrayList<Sustancia> sustanciasDisponibles;
	
	@Override
	public void renovarDatos(String dni) {
		this.ultRenovacion = new Date();
	}
	
	public void disponerSustancia(Sustancia sustancia) {
		this.sustanciasDisponibles.add(sustancia);
	}

	public Date getUltRenovacion() {
		return ultRenovacion;
	}

	public ArrayList<Sustancia> getSustanciasDisponibles() {
		return sustanciasDisponibles;
	}
}
