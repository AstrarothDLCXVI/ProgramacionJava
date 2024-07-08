package estudioConexionBaseDatos;

import java.sql.*;


public class Conectar {
	
	public static void main(String[] args) {
		
		try {
			
			
			/*CONECTAR A LA BASE DE DATOS*/
			//CREAR CONEXION
			//la url es una ruta a mi base de datos de phpmyadmin en local host, si copias y pegas no funcionara el programa
			Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pokemon", "root", "");
			
			//CREAR OBJETO STATEMENT PARA EJECUTAR CONSULTA SQL
			Statement miStatement = miConexion.createStatement();
			
			/*************************************************/
			
			
			
			
			/**************MOSTAR LA BASE DE DATOS COMPLETA********************/
			//EJECUTAR SQL
			ResultSet miResulset = miStatement.executeQuery("SELECT * FROM pokemons ");
			
			
			
			//RECORRER EL RESULSET
			while (miResulset.next()) {
				
				System.out.println(miResulset.getString(1) + " " + miResulset.getString("nombre") + " " + miResulset.getString("tipo1")+ " " + miResulset.getString("tipo2"));
				
			}
			
			
		} catch (Exception e) {
			System.out.println("NO CONECTA");
			e.printStackTrace();
		}
		
	}
	

}
