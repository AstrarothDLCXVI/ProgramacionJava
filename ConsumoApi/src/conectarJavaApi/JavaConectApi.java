package conectarJavaApi;

import java.net.URL;
import java.util.Scanner;
import javax.net.ssl.HttpsURLConnection;

public class JavaConectApi {

	
	public static void main(String[] args) {
		Scanner nombrePoke = new Scanner(System.in);
		
		try {
			//Vamos a buscar los datos de un pokemon en la api a partir de un nombre
			System.out.println("Dime el nombre del pokemon");
			String nombre = nombrePoke.nextLine();
			
			//Esta es la url de la API
		
			//https://pokeapi.co/api/v2/pokemon/
			URL url = new URL("https://pokeapi.co/api/v2/pokemon/" + nombre);
			
			//Ahora vamos a conertarnos a la url desde una conexion http
															 //Abrimos la conexion
			HttpsURLConnection conect = (HttpsURLConnection) url.openConnection();
			
			//Metodo de peticion, que va a ser GET
			conect.setRequestMethod("GET");
			conect.connect();
			
			//Leemos el codigo que nos responde el get
			int respuestaCodigo = conect.getResponseCode();
			
			//Si la respues es distinta a 200 nos salta un error, de lo contrario vamos por buen camino
			if (respuestaCodigo != 200) {
				throw new RuntimeException("Error; " + respuestaCodigo);
			}else {
				//Objeto de StringBuilder al que se le añade toda la info que recibimos de la peticion API
				
				StringBuilder informacionString = new StringBuilder();
								
				//Luego tenemos el escaner que lee el flujo de datos optenido
				
				Scanner sn = new Scanner(url.openStream());
				
				while (sn.hasNext()) {
					informacionString.append(sn.nextLine());
					
				}
				
				//Una vez termina de leer cerramos el escanner
				sn.close();
				
				//Por ultimo mostramos la info
				System.out.println(informacionString);
				
			}
			
			
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		nombrePoke.close();
	}
}
