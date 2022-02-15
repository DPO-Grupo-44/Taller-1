package paqueteProcesamiento;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import paqueteModelo.Ingredientes;
import paqueteModelo.Menu;
import paqueteModelo.Producto;


public class CalculadoraEstadisticas {
	private List<Menu> menus;
	private List<Producto> todosproductos;
	
	
	public CalculadoraEstadisticas(Map<String, Menu> menus, Map<String, Producto> todosproductos){
		this.menus = new ArrayList<Menu>(menus.values());
		this.todosproductos = new ArrayList<Producto>(todosproductos.values());
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
		for (Producto evento : todosproductos) {
			nombres.add(evento.getNombre());
		}
		return nombres;
	}
	
	public Producto darIngredientePosicion(int i){
		System.out.println(todosproductos.isEmpty());
		Producto ingrediente = todosproductos.get(i);
		return ingrediente;
	}
}
