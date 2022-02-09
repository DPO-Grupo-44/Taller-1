package paqueteConsola;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;

import paqueteProcesamiento.CalculadoraEstadisticas;
import paqueteProcesamiento.LoaderMenu;

public class ConsolaHamburguesas {

	private CalculadoraEstadisticas calculadora;
	
	public void ejecutarAplicacion() {
		
		System.out.println("Men� de El Corral");
		boolean continuar = true;
		while(continuar) {
			
		try {
			mostrarMenu();
			int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opción"));
			if (opcion_seleccionada == 1) {
				ejecutarCargaMenu();
			}
				
			else if (opcion_seleccionada == 14)
			{
				System.out.println("Saliendo de la aplicación ...");
				continuar = false;
			}
			else
			{
				System.out.println("Por favor seleccione una opción válida.");
			}
		}
		catch (NumberFormatException e)
		{
			System.out.println("Debe seleccionar uno de los números de las opciones.");
		}
	}
}
		
		public void mostrarMenu()
		{
			System.out.println("\nOpciones de la aplicación\n");
			System.out.println("1. Cargar un archivo de atletas");
			System.out.println("14. Salir de la aplicación\n");	
		}
		
		public String input(String mensaje)
		{
			try
			{
				System.out.print(mensaje + ": ");
				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				return reader.readLine();
			}
			catch (IOException e)
			{
				System.out.println("Error leyendo de la consola");
				e.printStackTrace();
			}
			return null;
		}
		
		private void ejecutarCargaMenu() {
			try
			{
				calculadora = LoaderMenu.cargarArchivo("./data/menu.txt");
				System.out.println(" ");
				System.out.println("Se est� cargando la informaci�n del menu...");
				Collection<String> menus = calculadora.darNombresDeportes();
				System.out.println("El men�: ");
				for (String dep : menus)
				{
					System.out.println(" - " + dep);
				}
			}
			catch (FileNotFoundException e)
			{
				System.out.println("ERROR: el archivo indicado no se encontró.");
			}
			catch (IOException e)
			{
				System.out.println("ERROR: hubo un problema leyendo el archivo.");
				System.out.println(e.getMessage());
			}
		}
		
		public static void main(String[] args)
		{
			ConsolaHamburguesas consola = new ConsolaHamburguesas();
			consola.ejecutarAplicacion();
		}

}

