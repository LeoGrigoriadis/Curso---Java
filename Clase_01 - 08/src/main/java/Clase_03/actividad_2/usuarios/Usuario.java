package Clase_03.actividad_2.usuarios;

import java.util.Date;

public class Usuario {

	private String nombre;
	private String apellido;
	private int edad;
	private String cuit;
	private String contra;
	private Date fechaAlta;
	
	public Usuario(String nombre, String apellido, int edad, String cuit, String contra, Date fechaAlta) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.cuit = cuit;
		this.contra = contra;
		this.fechaAlta = fechaAlta;
	}

	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	public String getContra() {
		return contra;
	}

	public void setContra(String contra) {
		this.contra = contra;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	
	
}
