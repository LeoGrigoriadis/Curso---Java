package Clase_02.actividad_1;

public class Vehiculo {

	private int cantRuedas;
	private String color;	
	
	public Vehiculo(String nColor, int nCantRuedas) {
		this.color = nColor;
		this.cantRuedas = nCantRuedas;
	}
	
	public int getCantRuedas() { return this.cantRuedas; }
	
	public void setCantRuedas(int nCantRuedas) { this.cantRuedas = nCantRuedas; }
	
	public String getColor() { return this.color; }
	
	public void setColor(String nColor) { this.color = nColor; } 
}
