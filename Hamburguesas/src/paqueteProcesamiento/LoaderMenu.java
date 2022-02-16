package paqueteProcesamiento;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import paqueteModelo.Combo;
import paqueteModelo.Ingredientes;
import paqueteModelo.Menu;
import paqueteModelo.Producto;
import paqueteModelo.ProductoMenu;


public class LoaderMenu {
	
	public static Map<String, ProductoMenu> cargarArchivoMenu(String nombreArchivo) throws FileNotFoundException, IOException
	{
		Map<String, ProductoMenu> menus = new HashMap<>();
		
		
		BufferedReader br = new BufferedReader(new FileReader(nombreArchivo));
		String linea = br.readLine(); 
		linea = br.readLine();
		while (linea != null)
		{
			String[] partes = linea.split(";");
			String nombreComida = partes[0];
			int precioComida = Integer.valueOf(partes[1]);
			
			ProductoMenu elMenu = menus.get(nombreComida);
			if (elMenu == null) {
				elMenu = new ProductoMenu(nombreComida, precioComida);
				menus.put(nombreComida, elMenu);
			}
			
			linea = br.readLine();
		}
		br.close();
		
	
		return menus;
	}
	
	
	public static Map<String, ProductoMenu> cargarArchivoIngredientes(String nombreIngredientes) throws FileNotFoundException, IOException
	{
		Map<String, ProductoMenu> ingredientes = new HashMap<>();
		
		
		BufferedReader br = new BufferedReader(new FileReader(nombreIngredientes));
		String linea = br.readLine(); 
		linea = br.readLine();
		while (linea != null)
		{
			String[] partes = linea.split(";");
			String nombreComida = partes[0];
			int precioComida = Integer.valueOf(partes[1]);
			
			ProductoMenu elMenu = ingredientes.get(nombreComida);
			if (elMenu == null) {
				elMenu = new ProductoMenu(nombreComida, precioComida);
				ingredientes.put(nombreComida, elMenu);
			}
			
			linea = br.readLine();
		}
		br.close();
		return ingredientes;
	}
	
	public static Map<String, Combo> cargarArchivoCombo(String nombreCombos) throws FileNotFoundException, IOException
	{
		Map<String, Combo> combos = new HashMap<>();
		
		BufferedReader br = new BufferedReader(new FileReader(nombreCombos));
		String linea = br.readLine(); 
		linea = br.readLine();
		while (linea != null)
		{
			String[] partes = linea.split(";");
			String nombreCombo = partes[0];
			String descuento= partes[1];
			String hamburguesa = partes[2];
			String papas = partes[3];
			String gaseosa = partes[4];
			
			
			Combo elMenu = combos.get(nombreCombo);
			if (elMenu == null) {
				ArrayList<String> agregados = new ArrayList<String>();
				agregados.add(hamburguesa);
				agregados.add(papas);
				agregados.add(gaseosa);
				
				
				elMenu = new Combo(descuento, nombreCombo, agregados);
				combos.put(nombreCombo, elMenu);
			}
			
			linea = br.readLine();
		}
		br.close();
		return combos;
	}
	
	public static CalculadoraEstadisticas cargarArchivos(String ArchivoMenu, String ArchivoIngredientes, String ArchivoCombos) throws IOException {
		Map<String, ProductoMenu> menus = cargarArchivoMenu(ArchivoMenu);
		Map<String, ProductoMenu> ingredientes = cargarArchivoIngredientes(ArchivoIngredientes);
		Map<String, Combo> combos = cargarArchivoCombo(ArchivoCombos);
		CalculadoraEstadisticas calculadora = new CalculadoraEstadisticas(menus, ingredientes, combos);
		return calculadora;
		
	}

}
