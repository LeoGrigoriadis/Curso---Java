package Clase_03.actividad_2.sustancias;

import Clase_03.actividad_2.usuarios.Productor;

public class Sustancia {
	private String nombre;
	private double pureza;
	private String formula;
	private Productor productor;
	
	public Sustancia(String nombre, double pureza, String formula, Productor productor) {
		this.nombre = nombre;
		this.pureza = pureza;
		this.formula = formula;
		this.productor = productor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPureza() {
		return pureza;
	}

	public void setPureza(double pureza) {
		this.pureza = pureza;
	}

	public String getFormula() {
		return formula;
	}

	public void setFormula(String formula) {
		this.formula = formula;
	}
	
	
}
