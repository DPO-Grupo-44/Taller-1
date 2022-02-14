package paqueteModelo;

import java.util.ArrayList;

public class ProductoAjustado implements Producto {
	private ProductoMenu base;
	private ArrayList<Ingredientes> iagregados;
	private ArrayList<Ingredientes> ieliminados;
	private int precioFinal;
	
	public ProductoAjustado( ProductoMenu tbase) {
		base = tbase;
		iagregados = new ArrayList<Ingredientes>();
		ieliminados = new ArrayList<Ingredientes>();
	}
	
	

	public int getPrecio() {
		int rta = base.getPrecio();
		for (int i = 0; i < iagregados.size(); i++) {
			rta += iagregados.get(i).darPrecio();
		}
		return rta;
	}


	public String getNombre() {

		return null;
	}

	public String generaTextoFactura() {
		
		return null;
	}
	
	public void agregarAgregados(Ingredientes ing) {
		iagregados.add(ing);
		
	}
	
}
	
	


