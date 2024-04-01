/**
 * 
 */
package actividades;

import java.util.Random;

/*
 * Escribe un programa que genere un número aleatorio e indique si el número generado es
 * par o impar. El programa utilizará para ello el lanzamiento de una excepción
 * */
/**
 * @autor josemi
 */
public class ACT3 {

	public static void main(String[] args) {
		
		/*Declaramos el ramdon*/
		Random aleatorio = new Random();
		
		try {
			
			/*Le decimos que el ramdon va a ser int, ademas de poder sacar cualquier numero*/
			int num = aleatorio.nextInt();
			
			/*En caso de que num dividido entre 2 te de resto 0 crearemos una excepcion de tipo aritmetica,
			 *la cual nos va a mostrar que es par, si el resto no es 0 nos dara impar*/
			if(num % 2 == 0) {
				throw new ArithmeticException();
			}else {
				System.out.println("Es impar");
			}
			
		} catch (ArithmeticException e) {
			System.out.println("Es par");
		}
		
		
		
	}
}
