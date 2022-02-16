package paqueteModelo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import paqueteProcesamiento.CalculadoraEstadisticas;
import paqueteProcesamiento.LoaderMenu;

public class Restaurante {
	
	private CalculadoraEstadisticas calculadora;

	
	public Restaurante() {
		
	}
	
	public void mostrarMenu()
	{
		System.out.println("1. Platos Fuertes");
		System.out.println("2. Ingredientes Adicionales");	
		System.out.println("3. Combos");
		System.out.println("13. Mostrar factura");
		
	}
	
	public void iniciarPedido(String nombreCliente, String direccionCliente) {
		boolean continuar = true;
		ArrayList<Pedido> listaPedidos = new ArrayList<Pedido>();
		int tamaÒo = listaPedidos.size();
		int id = tamaÒo + 1;
		Pedido nuevoPedido = new Pedido(id,nombreCliente ,direccionCliente);
		ejecutarCargaMenu("./data/menu.txt", "./data/ingredientes.txt", "./data/combos.txt");
		while (continuar){
			try {
				mostrarMenu();
				int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione un producto a agregar"));
				boolean platosfuertes = true;
				boolean adicionales = true;
				boolean combosbool = true;
				if (opcion_seleccionada == 1) {
					while (platosfuertes) {
					System.out.println(" ");
					Collection<String> menus = calculadora.darNombresProductos();
					System.out.println("Platos Fuertes: ");
					int i = 1;
					for (String dep : menus)
					{
						System.out.println(i + " - " + dep);
						i += 1;
					}
					int num = seleccionarPlatosFuertes() - 1;
					if (num == -1) {
						platosfuertes = false;
					}
					else {
					ProductoMenu ingredienteselec = calculadora.darMenuPosicion(num);
					nuevoPedido.agregarProducto(ingredienteselec);
					}	
					}
				}
				else if (opcion_seleccionada == 2) {
					while (adicionales) {
					System.out.println(" ");
					Collection<String> ingredientes = calculadora.darNombresIngredientes();
					System.out.println("Adicionales: ");
					int i = 1;
					for (String dep : ingredientes)
					{
						System.out.println(i + " - " + dep);
						i += 1;
					}
					int num = seleccionarPlatosFuertes() - 1;
					if (num == -1) {
						adicionales = false;
					}
					else {
					ProductoMenu ingredienteselec = calculadora.darIngredientePosicion(num);
					nuevoPedido.agregarProducto(ingredienteselec);
					}}
				}
				else if (opcion_seleccionada == 3) {
					while (combosbool) {
					System.out.println(" ");
					Collection<String> combos = calculadora.darNombresCombos();
					System.out.println("Combos: ");
					int i = 1;
					for (String dep : combos)
					{
						System.out.println(i + " - " + dep);
						i += 1;
					}
					int num = seleccionarPlatosFuertes() - 1;
					if (num == -1) {
						combosbool = false;
					}
					else {
					Combo ingredienteselec = calculadora.darComboPosicion(num);
					nuevoPedido.agregarCombo(ingredienteselec, calculadora.darIngredientes());
					
					}}
				}
				else if (opcion_seleccionada == 13)
				{
					try {
						nuevoPedido.generarFactura();
						System.out.println("Factura Creada");
					} catch (IOException e) {
						e.printStackTrace();
						System.out.println("Hubo un error");
					}
				}	
				else if (opcion_seleccionada == 14)
				{
					continuar = false;
				}
				else
				{
					System.out.println("Por favor seleccione una opci√≥n v√°lida.");
				}
			}
			catch (NumberFormatException e)
			{
				System.out.println("Debe seleccionar uno de los n√∫meros de las opciones.");
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
		int numero = Integer.parseInt(input("Seleccione un plato (Para volver a elegir tipo de plato utilice el 0)"));
		return numero;
	}
	
	
	private void ejecutarCargaMenu(String ArchivoMenu, String ArchivoIng, String ArchivoCombo) {
		try
		{
			calculadora = LoaderMenu.cargarArchivos(ArchivoMenu, ArchivoIng, ArchivoCombo);
		}
			catch (IOException e)
			{
				System.out.println("ERROR: hubo un problema leyendo el archivo.");
				System.out.println(e.getMessage());
			}
			
		}
	
}
