/**
 * 
 */
package actividades;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @autor josemi
 */

/*Arreglar el programa;*/
public class ACT5 {

static Scanner sc = new Scanner(System.in);
    
	public static void main(String args[]) {
	   
	   Comprobador();     
	}
	
	/*He creado un menu que contiene el codigo que trae la actividad*/
	public static void menu() {
		 double n;
	        int posicion;
	        String cadena ;
	        double[] valores = {9.83, 4.5, -3.06, 0.06, 2.52, -11.3, 7.60, 3.00, -30.4, 105.2};                       

	        System.out.println("Contenido del array antes de modificar:");
	        for (int i = 0; i < valores.length; i++) {
	            System.out.printf("%.2f ", valores[i]);
	        }

	        System.out.print("\n\nIntroduce la posición del array a modificar: ");
	        cadena = sc.nextLine();
	        posicion = Integer.parseInt(cadena);

	        System.out.print("\nIntroduce el nuevo valor de la posición " + posicion + ": ");                         
	        n = sc.nextDouble();

	        valores[posicion] = n;
	        
	        System.out.println("\nPosición a modificar " + posicion);
	        System.out.println("Nuevo valor: " + n);
	        System.out.println("Contenido del array modificado:");
	        for (int i = 0; i < valores.length; i++) {
	            System.out.printf("%.2f ", valores[i]);
	        }
	}
	
	/*Este metodo es el que he añadido para que el programa funcione correctamente sin fallo*/
	public static void Comprobador() {
		/*Este booleano se encarga de salir o volver a preguntar en el bucle*/
		boolean verificador = true;
		
		do {
		
			try {
				/*Entramos al menu*/
				menu();
				/*Si todo esta correcto pasa al verificador y le da valor true para salir del bucle*/
				verificador = true;
			}/*Para cambiar string a int se necesita que el string sea un numero entero, si introduces una 
			 	letra o un numero con decimales va a saltar el siguiente error, el cual tambien va a convertir 
			 	el booleano a false para que te vuelva a preguntar*/ 
			catch (NumberFormatException e) {	
				System.out.println("Error; NumberFormatException");
				verificador = false;
			}/*Si en vez de numero introduces una letra te va a saltar este error, el cual tambien va a 
			 convertir el booleano a false para que te vuelva a preguntar*/
			catch (InputMismatchException e) {
				System.out.println("Error; InputMismatchException");
				sc.next();
				verificador = false;
			}/*Si introduces una posicion la cual esta fuera del rango del array te va a saltar este error,
			el cual tambien va a convertir el booleano a false para que te vuelva a preguntar*/
			catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("Error; ArrayIndexOutOfBoundsException");
				verificador = false;
			}
		} while (verificador == false);
		
		
	}
}
