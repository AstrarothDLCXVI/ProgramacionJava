/**
 * 
 */
package act2;

import java.util.InputMismatchException;

/**
 * @autor josemi
 */
public class Main {

	public static void main(String[] args) {
		
		Lista llamar = new Lista();
		
		try {
			llamar.obtenerElemento();
		}//Si introduces una letra te va a saltar este error
		catch (InputMismatchException e) {
			System.out.println("Eso no es un numero");
		}//En caso de que la posicion que has pedido al array no exista te va a saltar este error
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Esa posicion no existe");
		}
		
	}
}
