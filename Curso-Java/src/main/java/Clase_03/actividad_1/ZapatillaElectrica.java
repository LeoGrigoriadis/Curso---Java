package Clase_03.actividad_1;

public class ZapatillaElectrica extends Enchufe{

	private int cantConectores;
	
	public ZapatillaElectrica(int patas, String color, int cantConectores) {
		super(patas, color);
		this.cantConectores = cantConectores;
	}
}
