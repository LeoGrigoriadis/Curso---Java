package Clase_02.actividad_1;

import java.util.ArrayList;

public class Bicicleta extends Vehiculo{

	private String tipoCadena;
	private ArrayList<String> accesorios;
	
	public Bicicleta(String nColor, int nCantRuedas, String nTipoCadena) {
		super(nColor, nCantRuedas);
		this.tipoCadena = nTipoCadena;
	}

	public String getTipoCadena() { return tipoCadena; }

	public void setTipoCadena(String tipoCadena) { this.tipoCadena = tipoCadena; }

	public ArrayList<String> getAccesorios() { return accesorios; }

	public void setAccesorio(String nAccesorio) { this.accesorios.add(nAccesorio); }
	
}
