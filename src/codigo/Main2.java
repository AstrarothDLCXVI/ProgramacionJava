package codigo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main2 {

	private static Scanner sn = new Scanner(System.in);
	
	public static void main(String[] args) {

		
		boolean verificador = false;
		
		while (verificador != true) {
		
			try {
				
				System.out.println("1.Añadir pregunta\n" + 
						"2.Eliminar test\n" +
						"3.Filtrar por test\n" +
						"4.Mostrar datos\n");
						
						
						int eleccion = sn.nextInt();
						
						switch (eleccion) {
						case 1:
								anadir();
							break;
							
						case 2:
								eliminar();
							break;
						
						case 3:
								filtrarPorTest();
							break;
							
						case 4:
								mostrar();
							break;
						default:
							break;
						}
			} catch (InputMismatchException e) {
				sn.next();
				verificador = false;
			}
			
			
		}
		
		
		
	}
	
	
	
	
	
	private static void anadir() {
		
		try {
			
			/*CONECTAR A LA BASE DE DATOS*/
			//CREAR CONEXION
			//la url es una ruta a mi base de datos de phpmyadmin en local host, si copias y pegas no funcionara el programa
			Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/autoescuela", "root", "");
			
			
			//Preparar la consulta
			String query = ("INSERT INTO fallos (test, pregunta, respuesta, sitio) VALUES (?, ?, ?, ?)");
			PreparedStatement miSentencia = miConexion.prepareStatement(query);
			
			
			System.out.println("Numero del test\n");
			int numeroTest = sn.nextInt();
			
			
			System.out.println("Numero de la pregunta\n");
			int numeroPregunta = sn.nextInt();
			
			
			System.out.println("Respuesta correcta\n");
			String respuesta = sn.next();
			
			
			System.out.println("1.Autoescuela / 2.Todotest");
			int eleccion = sn.nextInt();
			
			
			
			
			
			if (eleccion == 1) {
				miSentencia.setInt(1, numeroTest);
				miSentencia.setInt(2, numeroPregunta);
				miSentencia.setString(3, respuesta);
				miSentencia.setString(4, "Autoescuela");
				
				miSentencia.executeUpdate();
			}
			else if(eleccion == 2){
				miSentencia.setInt(1, numeroTest);
				miSentencia.setInt(2, numeroPregunta);
				miSentencia.setString(3, respuesta);
				miSentencia.setString(4, "Todotest");
				
				miSentencia.executeUpdate();
			}
			
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("Error al ejecutar o al conectar con la base de datos");
		}catch (InputMismatchException e) {
			System.err.println("Error sintactico");
			sn.next();
		}
		

		
	}
	
	
	private static void eliminar() {
		
		try {
			//Conectamos con la base de datos
			Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/autoescuela", "root", "");
			
		
			/*********************/
			
			//Preparamos la sentencia
			String query = "DELETE FROM fallos WHERE test = ? and pregunta = ?";
			PreparedStatement miSentencia = miConexion.prepareStatement(query);
			
			
			System.out.println("Numero del test\n");
			int numeroTest = sn.nextInt();
			
			
			System.out.println("Numero de la pregunta\n");
			int numeroPregunta = sn.nextInt();
			
			
			miSentencia.setInt(1, numeroTest);
			miSentencia.setInt(2, numeroPregunta);
			
			
			miSentencia.executeUpdate();
			
			
			
		
		} catch (SQLException e) {
			System.err.println("Error al ejecutar o al conectar con la base de datos");
			e.printStackTrace();
		}catch (InputMismatchException e) {
			System.err.println("Error sintactico");
			sn.next();
		}
		
	}
	
	
	private static void filtrarPorTest() {
		
		try {
			
			//Conectar con la base de datos
			Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/autoescuela", "root", "");
		
			//Preparar la consulta
			PreparedStatement miSentencia = miConexion.prepareStatement(
					"SELECT * FROM fallos "
				  + "Where test =?");
		
			
			System.out.println("Numero de test");
			int test = sn.nextInt();
			
			
			miSentencia.setInt(1, test);
			
			//Ejecutar y recorrer consulta
			ResultSet rs = miSentencia.executeQuery();
			
			System.out.println("Test" + " " + "Pregunta" + " " + "Respuesta" + " " + "Sitio");
			//RECORRER EL RESULSET
			while (rs.next()) {
				
				System.out.println(rs.getInt(2) + "     " + rs.getInt(3)+ "     " + rs.getString(4) + "     " + rs.getString(5));
				
			}
								
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
	private static void mostrar() {
		
		try {
			
			
			/*CONECTAR A LA BASE DE DATOS*/
			//CREAR CONEXION
			//la url es una ruta a mi base de datos de phpmyadmin en local host, si copias y pegas no funcionara el programa
			Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/autoescuela", "root", "");
			
			//CREAR OBJETO STATEMENT PARA EJECUTAR CONSULTA SQL
			Statement miStatement = miConexion.createStatement();
			
			/*************************************************/
			
			
			
			
			/**************MOSTAR LA BASE DE DATOS COMPLETA********************/
			//EJECUTAR SQL
			ResultSet miResulset = miStatement.executeQuery("SELECT * FROM  fallos");
			
			
			System.out.println("Test" + " " + "Pregunta" + " " + "Respuesta" + " " + "Sitio");
			//RECORRER EL RESULSET
			while (miResulset.next()) {
				
				System.out.println(miResulset.getInt(2) + "     " + miResulset.getInt(3)+ "     " + miResulset.getString(4) + "     " + miResulset.getString(5));
				
			}
			
			
		} catch (Exception e) {
			System.out.println("Error al ejecutar o al conectar con la base de datos");
		}
		
	}
	
	
	
}
