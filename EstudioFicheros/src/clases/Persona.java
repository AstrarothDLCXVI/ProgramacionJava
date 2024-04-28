package clases;

import java.time.LocalDate;

public class Persona {

	//Atributos
	private int id;
	private String nombre;
	private LocalDate fechaNacimiento;
	
	//CONTRUCTOR
	public Persona(int id, String nombre, LocalDate fechaNacimiento) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
	}


	//GET and SET
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}


	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	
	//METODOS
	
	public void obternerFechaNacimiento() {
		
		LocalDate fechaActual = null;
		
		int edad = fechaNacimiento.getYear() - fechaActual.getYear();
		
	}
	
	
	
	
}
