package Clase_02.actividad_1;

public class Moto extends Vehiculo{

	private double peso;
	
	public Moto(String nColor, int nCantRuedas, double nPeso) {
		super(nColor, nCantRuedas);
		this.peso = nPeso;
	}

	public double getPeso() { return peso; }

	public void setPeso(double peso) { this.peso = peso; }

}
