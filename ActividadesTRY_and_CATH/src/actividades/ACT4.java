/**
 * 
 */
package actividades;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @autor josemi
 */

/*
 * Nota;
 * 
 * Este progama pretende ser utilizado como aprendizaje de distintos errores, es decir, solo
 * busco hacer varios errores y hacer que el programa siga funcionando bien.
 * 
 * Espero que les guste :D
 * 
 * PD; esta version solo utilizara una clase, la otra version si tendra clase objeto*/
public class ACT4 {
	
	public static void main(String[] args) {
		
		menu();
		System.exit(0);
	}
	
	public static void menu() {
		Scanner s = new Scanner(System.in);
		
		boolean verificar = true;
		
		
		
		do {
			try {
				System.out.println("Dime que quieres hacer\n"
						+ "1.Error aritmetico\n"
						+ "2.Error de array\n");
				
				int eleccion = s.nextInt();
				
				if(eleccion > 2 || eleccion < 1) {
					throw new ArithmeticException();
				}
				
					switch (eleccion) {
					case 1:
						verificar = true;
						ErrorAritmetico();
						break;
						
					case 2:
						ErrorArray();
						break;

					default:
						break;
					}
				
				
				
			} catch (ArithmeticException e) {
				System.out.println("Eso no es lo que te he pedido");
				verificar = false;
			}catch (InputMismatchException e) {
				s.next();
				verificar = false;
			}
			
		} while (verificar == false);
		
		s.close();
	}

	
	public static void ErrorAritmetico() {
		Scanner s = new Scanner(System.in);
		
		boolean verificar = true;
		
		System.out.println("Este error es uno basico, en el que el error es aritmetico, tambien voy a incluir\n"
				+ "un error para que no introduzcas letras\n");
		
		
		do {
		
			try {
				System.out.println("Dime un numero del 1 al 10");
				
				int num = s.nextInt();
				
				/*Al pedir un numero en caso de que te salgas de rango el programa
				 * va a crear una excepcion para ese error, y te va a volver a preguntar para que introduzcar
				 * el numero*/
				if(num < 1 || num > 10) {
					throw new ArithmeticException();
				
				}
				
				verificar = true;
					
			}/*Error que aparece en caso de que no cumplas los requisitos que te pide*/ 
			catch (ArithmeticException e) {
				System.out.println("Este es el error por haber introducido mal el numero");
				verificar = false;
			}/*Error el cual, en caso de introducir letras en vez de numeros te lo va a hacer saber*/
			catch (InputMismatchException e) {
				System.err.println("Este error es porque has metido una letra");
				s.next();
				verificar = false;
			}
		} while (verificar == false);
		
		System.out.println("Ese es el ejemplo de error aritmetico y del error al introducir letras\n");
		
		
	
		s.close();
	}
	
	
	public static void ErrorArray() {
		Scanner s = new Scanner(System.in);
		
		boolean verificar = true;
		
		int position = 0;
		
		
		do {
			try {
				/*Le pedimos al usuario que introduzca  cuantas posiciones quiere que tenga 
				 * el array, si me dices una letra en vez de numero te salta el error y te vuelve a preguntar*/
				System.out.println("Dime cuantas posiciones quieres que tenga el array");
				position = s.nextInt();
				verificar = true;
			} catch (InputMismatchException e) {
				System.out.println("ERROR; nada de caracteres");
				s.next();
				verificar = false;
			}
		} while (verificar == false);
		
		
		String[] texto = new String[position];
		
		/*Una vez introducida la posicion, le pedimos al usuario que introduzca lo que quiera*/
		System.out.println("Dime lo que quieras tantas veces como posiciones hay\n");
		
		for (int i = 0; i < position; i++) {
			texto[i] = s.nextLine();
		}
		
		/*Aqui falta pedirle al usuario que introduzca un numero, si el numero no coincide con el array 
		 * salta el error, me voy al gym XDD*/
		
		s.close();
	}
	
	
	
}


/*Apuntes;
 * 
 * Hacer una clase la cual de error en una cuenta cualquiera
 * Hacer error en el array
 * */
