/**
 * 
 */
package act1;

import java.util.Scanner;

/**
 * @autor josemi
 */

/*
 * Crea una clase Conversor que tenga un método convertirEntero que acepte una cadena
como parámetro y devuelva el número entero correspondiente. Maneja la excepción si la
cadena no es un número válido.*/

public class Conversor {

	//Atributos
	
	private String cadena;
	private int num;
	
	//Constructor
	public Conversor(String cadena, int num) {
		// TODO Auto-generated constructor stub
		this.cadena = cadena;
		this.num = num;
	}

	
	//Get and Set
	public String getCadena() {
		return cadena;
	}

	public void setCadena(String cadena) {
		this.cadena = cadena;
	}
	
	public int getNum() {
		return num;
	}


	public void setNum(int num) {
		this.num = num;
	}
	
	//METODOS


	/*En este metodo nos encargamos de introducir un numero como string y cambiarlo a int*/
	public void convertirEntero() /*Con el throws le decimos que es posible este error en el code*/throws NumberFormatException{
		Scanner s = new Scanner(System.in);
		
		
		System.out.println("Dime un numero, el numero va a ser introducido como String y convertido a int");
		String cadena = s.nextLine();
		
		/*Integer.parseInt(cadena) = Le estamos diciendo que lea el valor de cadena como numero entero para luego 
		 * pasarle el valor de cadena a num*/
		num = Integer.parseInt(cadena);
		
		s.close();
	}
	
	/*Retornamos el numero que nos ha dado*/
	public int toInt() {
		return num;
		
	}
	
}
