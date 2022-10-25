package Clase_03.actividad_2.sustancias;

import Clase_03.actividad_2.usuarios.Productor;

public class SustanciaSimple extends Sustancia{

	private String color;

	public SustanciaSimple(String nombre, double pureza, String formula, String color, Productor productor) {
		super(nombre, pureza, formula, productor);
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
}
