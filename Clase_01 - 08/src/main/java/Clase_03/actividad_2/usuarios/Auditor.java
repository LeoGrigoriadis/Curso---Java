package Clase_03.actividad_2.usuarios;

import java.util.ArrayList;

import Clase_03.actividad_2.sustancias.Sustancia;

public class Auditor{

	private ArrayList<Sustancia> sustanciasActivas;
	public void darAlta(Sustancia sustancia) {
		this.sustanciasActivas.add(sustancia);
	}
	
	public void darBaja(Sustancia sustancia) {
		this.sustanciasActivas.remove(sustancia);
	}
	
}
