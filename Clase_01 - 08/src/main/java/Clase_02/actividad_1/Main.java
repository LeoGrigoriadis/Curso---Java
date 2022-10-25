package Clase_02.actividad_1;

public class Main {

	public static void main(String[] args) {
		Auto auto = new Auto("blanco", 4, "gt-86");
		Moto moto = new Moto("verde", 2, 160.5);
		
		moto.setCantRuedas(3);
		System.out.println("Peso de la moto "+moto.getPeso());
		System.out.println("Cantidad de ruedas del auto: "+auto.getCantRuedas());		
		auto.setModelo("ss");
		System.out.println("Nuevo modelo del auto: "+auto.getModelo());
	}
	
}
