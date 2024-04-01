/**
 * 
 */
package act1;


/**
 * @autor josemi
 */
public class Main {

	public static void main(String[] args) {
		
		Conversor c = new Conversor("", 0);
			
			
		try {
			/*Llamamos al metodo que tenemos en la clase conversor
			 * en caso de que introduzcamos una letra te va a dar error, porque va a leer la conversion como tal
			 * si introducimos un numero va a devolvernos el numero pero pasado a int y lo mismo si introduces 
			 * decimales, tambien te sale error*/
			
			c.convertirEntero();
			System.out.println(c.toInt());
			
		} catch (NumberFormatException e) {
			System.out.println("ERROR");
		}
		
		
	}
}
