/**
 * 
 */
package actividades;

/*
 * Escribe un programa que solicite al usuario una cadena que represente un número entero.
 * Intenta convertir esta cadena a un entero y muestra el resultado. Maneja la excepción si la
 * cadena no es un número válido.
 * */

import java.util.Scanner;

/**
 * @autor josemi
 */
public class ACT1 {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
	
		boolean verificar = true;
		int num;
		
		
	do {
		
		try {
			
			System.err.println("Dime un numero entero");
			String numero = s.nextLine();
			
			/*Para combertir un numero de caracter a numero entero utilizamos parseint y 
			 * en el parentesis colocamos el string que queremos convertir*/
			num = Integer.parseInt(numero);
			
			verificar = true;
			
			System.out.println(num);
		
		} 
		catch (NumberFormatException e) {
			System.out.println("He dicho un numero");
			verificar = false;
		}
		
	} while (verificar == false);
			
	
		s.close();
	}

}
