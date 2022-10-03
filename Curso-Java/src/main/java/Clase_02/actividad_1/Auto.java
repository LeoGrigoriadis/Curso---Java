package Clase_02.actividad_1;

public class Auto extends Vehiculo implements Acelerable{

	private String modelo;
	
	public Auto(String nColor, int nCantRuedas, String nModelo) {
		super(nColor, nCantRuedas);
		this.modelo = nModelo;
	}

	public String getModelo() { return modelo; }

	public void setModelo(String modelo) { this.modelo = modelo; }

	@Override
	public void acelerar() {
		System.out.println("Acelerando...");
	}

	@Override
	public void frenar() {
		System.out.println("Frenando...");
	}
	
}
