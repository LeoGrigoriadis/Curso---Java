package Clase_03.actividad_2.sustancias;

import java.util.ArrayList;

import Clase_03.actividad_2.usuarios.Productor;

public class SustanciaCompuesta extends Sustancia{

	ArrayList<Sustancia> sustanciasSimples;

	public SustanciaCompuesta(String nombre, double pureza, String formula, ArrayList<Sustancia> sustanciasSimples, Productor productor) {
		super(nombre, pureza, formula, productor);
		this.sustanciasSimples = sustanciasSimples;
	}
	
	public ArrayList<Sustancia> separar(){
		return this.sustanciasSimples;
	}
}
