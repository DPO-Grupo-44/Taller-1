package paqueteModelo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import paqueteProcesamiento.CalculadoraEstadisticas;
import paqueteProcesamiento.LoaderMenu;

public class Restaurante {
	
	private CalculadoraEstadisticas calculadora;

	
	public Restaurante() {
		
	}
	
	public void mostrarMenu()
	{
		System.out.println("\n1. Platos Fuertes");
		System.out.println("2. Ingredientes Adicionales\n");	
	}
	
	public void iniciarPedido(String nombreCliente, String direccionCliente) {
		boolean continuar = true;
		ArrayList<Pedido> listaPedidos = new ArrayList<Pedido>();
		int tamaño = listaPedidos.size();
		int id = tamaño + 1;
		Pedido nuevoPedido = new Pedido(id,nombreCliente ,direccionCliente);
		while (continuar){
			try {
				mostrarMenu();
				int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione un producto a agregar"
						+ "\n" + "Para revisar el catalogo nuevamente seleccione la opcion 0"));
				if (opcion_seleccionada == 0) {
					ejecutarCargaMenu();
				}
				else if (opcion_seleccionada == 1) {
					int num = seleccionarPlatosFuertes();
					Producto ingredienteselec = calculadora.darIngredientePosicion(num);
					nuevoPedido.agregarProducto(ingredienteselec);
				}	
				else if (opcion_seleccionada == 14)
				{
					System.out.println("Saliendo de la aplicaciÃ³n ...");
					continuar = false;
				}
				else
				{
					System.out.println("Por favor seleccione una opciÃ³n vÃ¡lida.");
				}
			}
			catch (NumberFormatException e)
			{
				System.out.println("Debe seleccionar uno de los nÃºmeros de las opciones.");
			}
		}
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
	
	
	
	public void cerrayguardarPedido() {
		
	}
	
	private int seleccionarPlatosFuertes() {
		int numero = Integer.parseInt(input("Seleccione un plato fuerte"));
		return numero;
	}
	
	
	private void ejecutarCargaMenu() {
		try
		{
			calculadora = LoaderMenu.cargarArchivo("./data/menu.txt");
			System.out.println(" ");
			System.out.println("Platos fuertes" + "\n");
			Collection<String> menus = calculadora.darNombresDeportes();
			System.out.println("El menú: ");
			int i = 1;
			for (String dep : menus)
			{
				System.out.println(i + " - " + dep);
				i += 1;
			}
			calculadora = LoaderMenu.cargarArchivo("./data/ingredientes.txt");
			System.out.println(" ");
			System.out.println("Ingredientes adicionales" + "\n");
			
			Collection<String> ingredientes = calculadora.darNombresDeportes();
			System.out.println("Ingredientes adicionales: ");
			i = 1;
			for (String dep : ingredientes)
			{
				System.out.println(i + " - " + dep);
				i += 1;
			}
		}
			
		catch (IOException e)
		{
			System.out.println("ERROR: hubo un problema leyendo el archivo.");
			System.out.println(e.getMessage());
		}
	}
}
