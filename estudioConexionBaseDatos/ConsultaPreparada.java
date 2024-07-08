package estudioConexionBaseDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ConsultaPreparada {
	
	
	public static void main(String[] args){
		Scanner sn = new Scanner(System.in);
		
		
		try {
			//CREAR CONEXION
			//la url es una ruta a mi base de datos de phpmyadmin en local host, si copias y pegas no funcionara el programa
			Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pokemon", "root", "");
			
			
			//Preparar la consulta
			PreparedStatement miSentencia = miConexion.prepareStatement(
					"SELECT * FROM pokemons "
				  + "Where nombre =?");
			//La interrogante es donde va a ir el nombre 
			
			
			System.out.println("Dime el nombre del pokemon");
			String nombre = sn.next();
			
			/*Establecer parametros de consulta
			Tienes que saber el campo de tu columna sql, si es texto o numero u hora, etc.
			En mi caso es texto, por eso le pongo string
			*/
			miSentencia.setString(1, nombre);
								/*el 1 representa la interrogante, si despues de esa 
								interrogante hubiera otra se le pondria otro igual pero con el 2*/
		
			
			
			//Ejecutar y recorrer consulta
			ResultSet rs = miSentencia.executeQuery();
			
			while (rs.next()) {
				
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4) );
				
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		sn.close();
		
	}

}
