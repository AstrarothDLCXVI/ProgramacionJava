package estudioConexionBaseDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ActualizarDatosBBDD {

	public static void main(String[] args) {
		
		try {
			
			
			/*CONECTAR A LA BASE DE DATOS*/
			//CREAR CONEXION
			//la url es una ruta a mi base de datos de phpmyadmin en local host, si copias y pegas no funcionara el programa
			Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pokemon", "root", "");
			
			//CREAR OBJETO STATEMENT PARA EJECUTAR CONSULTA SQL
			Statement miStatement = miConexion.createStatement();
			
			/*************************************************/
			
			
			String instruccionSQL = "UPDATE pokemons set nombre = 'growlite' WHERE id = 10";
			
			miStatement.executeUpdate(instruccionSQL);
			
			System.out.println("Datos han sido modificados correctamente");
			
		} catch (Exception e) {
			System.out.println("NO CONECTA");
			e.printStackTrace();
		}
		
	}
}
