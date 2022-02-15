package paqueteConsola;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;

import paqueteModelo.Restaurante;
import paqueteProcesamiento.CalculadoraEstadisticas;
import paqueteProcesamiento.LoaderMenu;

public class ConsolaHamburguesas {

	
	public void ejecutarAplicacion() {
		
		System.out.println("Men� de El Corral");
		boolean continuar = true;
		while(continuar) {
			
		try {
			mostrarMenu();
			int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opción"));
			if (opcion_seleccionada == 1) {
				ejecutariniciarPedido();
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
			System.out.println("1. Iniciar un pedido");
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
		
		private void ejecutariniciarPedido() {
			System.out.println("Se est� iniciando el pedido..." + "\n");
			String nombre = input("Por favor ingrese su nombre");
			String direccion = input("Por favor ingrese su direccion");
			Restaurante restaurante = new Restaurante();
			restaurante.iniciarPedido(nombre, direccion);
			
		}
		
		
		public static void main(String[] args)
		{
			ConsolaHamburguesas consola = new ConsolaHamburguesas();
			consola.ejecutarAplicacion();
		}

}

