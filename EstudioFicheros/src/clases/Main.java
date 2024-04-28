package clases;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {
	
	static Scanner sn = new Scanner(System.in);
	
	public static void obtenerDatos() {
		
		
		//Registramos ID
		System.out.println("Dime su id");
		int id =  sn.nextInt();
		
		//Registramos el nombre
		System.out.println("Dime el nombre");
		String nombre = sn.next();
		
		//Introducimos la fecha de nacimiento
		System.out.println("Año/mes/dia");
		int anio = sn.nextInt();
		int mes = sn.nextInt();
		int dia = sn.nextInt();
		
		//Creamos el objeto persona con sus datos
		Persona p = new Persona(id, nombre, LocalDate.of(anio, mes, dia));
		
		System.out.println("Se han guardado los datos correctamente");
		
		
		try {
			
			//Creamos el fichero y le decimos la ruta de donde esta el txt, si no existe el txt lo crea
			File archivo = new File("/home/astra/eclipse-workspace/EstudioFicheros/src/clases/nombres.txt");
			
			//Ahora le decimos donde vamos a escribir que es en el fichero creado y el true es para que se escriban datos mas de una vez
			FileWriter escribir = new FileWriter(archivo, true);
			
			
			//Aqui le decimos que es lo que vamos a escribir en el fichero
			try (BufferedWriter buffEscribir = new BufferedWriter(escribir)) {
				buffEscribir.write("ID; " + p.getId() + "--- Nombre; " + p.getNombre() + "--- Fecha Nacimiento; " + p.getFechaNacimiento());
				buffEscribir.newLine();//salta a la siguiente linea del fichero
			}
			
			
		//Excepcion obligatoria para usar ficheros
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error; " + e.getMessage());
		}
		
		
		
		
	}
	
	
	public static void MostrarDatos() throws IOException {
		
		File archivo = new File("/home/astra/eclipse-workspace/EstudioFicheros/src/clases/nombres.txt");
		
		FileReader leer = new FileReader(archivo);
		
		try (BufferedReader buffLeer = new BufferedReader(leer)) {
			String fila;
			while ((fila = buffLeer.readLine()) != null) {
				System.out.println(fila);
			}
		}
		
	}
	
	
	public static void main(String[] args) throws IOException {
		boolean validador = false;
		
		do {
			try {
				obtenerDatos();
				MostrarDatos();
				validador = true;
			} catch (DateTimeException e) {
				System.out.println("Error; " + e.getMessage());
				validador = false;
			}catch (InputMismatchException e) {
				System.out.println("Error; " + e.getMessage());
				sn.next();
				validador = false;
			}
		} while (validador == false);
		
		
		
	}

}
