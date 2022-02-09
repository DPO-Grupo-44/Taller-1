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
	
	
	public CalculadoraEstadisticas(Map<String, Menu> menus, Map<String, Ingredientes> todosingredientes){
		this.menus = new ArrayList<Menu>(menus.values());
		this.todosingredientes = new ArrayList<Ingredientes>(todosingredientes.values());
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
	public Collection<String> darNombresIngredientes(){
		Collection<String> nombres = new HashSet<String>();
		for (Ingredientes evento : todosingredientes) {
			nombres.add(evento.darNombre());
		}
		return nombres;
	}
}
