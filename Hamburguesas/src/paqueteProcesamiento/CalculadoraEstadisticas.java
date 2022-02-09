package paqueteProcesamiento;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import paqueteModelo.Ingredientes;
import paqueteModelo.Menu;


public class CalculadoraEstadisticas {
	private List<Menu> menus;
	private List<Ingredientes> todosingredientes;
	
	
	public CalculadoraEstadisticas(Map<String, Menu> menus){
		this.menus = new ArrayList<Menu>(menus.values());
	}
	
	public Collection<String> darNombresDeportes()
	{
		Collection<String> nombres = new HashSet<String>();
		for (Menu evento : menus)
		{
			nombres.add(evento.darNombre());
		}

		return nombres;
	}
}
