/**
 * 
 */
package act2;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @autor josemi
 */
public class Lista {

	//Atributos
	private String[] texto = {
			"Paco",
			"Astraroth",
			"Kayn",
			"Rufo",
			"Lolo",
			"Astra"
	};

	//Constructor
	Lista(){
		
	}
	
	
	//Metodos
	
	/*indica al compilador que ignore las advertencias relacionadas con el 
	 * manejo de recursos en una parte específica del código.
	 * 
	 * Lo he buscado en internet, no sabia que hacia hasta ahora, java me lo genera solo :D*/
	@SuppressWarnings("resource")
	//El throws te indica de que es posible que haya error de InputMismatchException
	public void obtenerElemento() throws InputMismatchException{
		Scanner s = new Scanner(System.in);
		
		System.out.println("Dime una posicion");
		int num = s.nextInt();
		
		/*En caso de que introduzcas un numero menor a 1 o mayor a 5 te va a generar un throw, el 
		 * cual te va a indicar que esa posicion no existe
		 * 
		 * Si introduces un numero el cual si esta en el array te va a mostrar el texto que esta en el mismo*/
		if(num < 1 || num > 5) {
			throw new ArrayIndexOutOfBoundsException();
		}else {
			System.out.println(texto[num]);
		}
		
		s.close();
		
	}
	
}
