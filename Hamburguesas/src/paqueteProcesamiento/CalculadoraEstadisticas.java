package paqueteProcesamiento;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import paqueteModelo.Combo;
import paqueteModelo.Menu;
import paqueteModelo.Producto;
import paqueteModelo.ProductoMenu;


public class CalculadoraEstadisticas {
	private List<ProductoMenu> menus;
	private List<ProductoMenu> ingredientes;
	private List<Combo> combos;
	private Map<String, ProductoMenu> mapaIngredientes;
	
	public CalculadoraEstadisticas(Map<String, ProductoMenu> tmenus, Map<String, ProductoMenu> tingredientes, Map<String, Combo> tcombos){
		menus = new ArrayList<ProductoMenu>(tmenus.values());
		ingredientes = new ArrayList<ProductoMenu>(tingredientes.values());
		combos = new ArrayList<Combo>(tcombos.values());
		mapaIngredientes = tingredientes;
	}
	
	public Collection<String> darNombresProductos()
	{
		Collection<String> nombres = new HashSet<String>();
		for (ProductoMenu evento : menus)
		{
			nombres.add(evento.getNombre());
		}
		return nombres;
	}
	
	
	
	public Collection<String> darNombresIngredientes(){
		Collection<String> nombres = new HashSet<String>();
		for (ProductoMenu evento : ingredientes) {
			nombres.add(evento.getNombre());
		}
		return nombres;
	}
	
	public Collection<String> darNombresCombos(){
		Collection<String> nombres = new HashSet<String>();
		for (Combo evento : combos) {
			nombres.add(evento.getNombre());
		}
		return nombres;
	}
	
	public ProductoMenu darMenuPosicion(int i){
		ProductoMenu ingrediente = menus.get(i);
		return ingrediente;
	}
	
	public ProductoMenu darIngredientePosicion(int i){
		ProductoMenu ingrediente = ingredientes.get(i);
		return ingrediente;
	}
	public Combo darComboPosicion(int i){
		Combo ingrediente = combos.get(i);
		return ingrediente;
	}
	
	public Map<String, ProductoMenu> darIngredientes(){
		return mapaIngredientes;
	}
}
