package paqueteProcesamiento;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import paqueteModelo.Ingredientes;
import paqueteModelo.Menu;
import paqueteModelo.Producto;


public class LoaderMenu {
	
	public static CalculadoraEstadisticas cargarArchivo(String nombreArchivo) throws FileNotFoundException, IOException
	{
		Map<String, Menu> menus = new HashMap<>();
		Map<String, Producto> todosproductos = new HashMap<>();
		
		BufferedReader br = new BufferedReader(new FileReader(nombreArchivo));
		String linea = br.readLine(); 
		linea = br.readLine();
		while (linea != null)
		{
			String[] partes = linea.split(";");
			String nombreComida = partes[0];
			int precioComida = Integer.valueOf(partes[1]);
			
			Menu elMenu = menus.get(nombreComida);
			if (elMenu == null) {
				elMenu = new Menu(nombreComida, precioComida);
				menus.put(nombreComida, elMenu);
			}
			
			linea = br.readLine();
		}
		
		br.close();
		CalculadoraEstadisticas calculadora = new CalculadoraEstadisticas(menus, todosproductos);
		return calculadora;
	}
}
