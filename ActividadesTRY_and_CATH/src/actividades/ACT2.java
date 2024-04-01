/**
 * 
 */
package actividades;

/*
 * Escribe un programa que cree un array de longitud 5 y solicite al usuario un número entero 
 * como índice. Intenta acceder al elemento del array en el índice proporcionado por el 
 * usuario y maneja la excepción si el índice está fuera del rango válido.
 * */

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @autor josemi
 */
public class ACT2 {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		boolean verificar = true;
		
		String array[] = {
			"paco",
			"Er manu",
			"Juan el caballo",
			"Anchas castillas",
			"Paquito el cocholatero",
			"Llados"
		};
		
		
		do {
			
		
			/*Cuando entramos al try nos pide un numero, en caso de que el numero no corresponda a un dato en el array
			 * te dira que esta fuera de rango*/
			try {
				
				System.out.println("Dime un numero");
				int num = s.nextInt();
				
				System.out.println(array[num]);
				
				verificar = true;
				
				
			}
			/*Con esta excepcion podemos decirle que el error de que este fuera de rango es posible
			 * por lo que una atrapado el error nos dirige al texto y el programa sigue nnormal*/
			catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("Esta fuera de rango");
				verificar = false;
			}
			catch (InputMismatchException e) {
				System.out.println("Eres tonto");
				verificar = false;
				s.next();
			}
			
		} while (verificar == false);
		
		s.close();
				
	}

}
