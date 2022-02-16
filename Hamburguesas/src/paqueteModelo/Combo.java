package paqueteModelo;

import java.util.ArrayList;
import java.util.Map;

public class Combo implements Producto{

	private String descuento;
	private String nombre;
	private ArrayList<String> itemsCombo;

	
	public Combo(String tdescuento, String tnombre, ArrayList<String> agregados) {
		nombre = tnombre;
		descuento = tdescuento;
		itemsCombo = new ArrayList<String>();
	}
	
	public void agregarItemCombo(String itemCombo) {
		itemsCombo.add((String)itemCombo);
	}


	public int getPrecioTotal(Map<String, ProductoMenu> ingredientes) {
		int descuentoreal = Integer.parseInt(descuento.substring(0, descuento.length()-1));
		int precio = 0;
		for (int i=0;i<itemsCombo.size();i++) {
			if (ingredientes.containsKey(itemsCombo.get(i))){
				ProductoMenu adicional = ingredientes.get(itemsCombo.get(i));
				int ValorAdicional = adicional.getPrecio();
				precio += ValorAdicional;
			}
		      }
		return precio*(1-descuentoreal);
	}

	public String getNombre() {
		
		return nombre;
	}

	public String generaTextoFacturaTotal(Map<String, ProductoMenu> ingredientes) {
		int precio = getPrecioTotal(ingredientes);
		return ("Productos Añadidos: "+ itemsCombo + "\nValor Total:" + precio);
	}
	



	public int getPrecio() {

		return 0;
	}


	public String generaTextoFactura() {
	
		return null;
	}
	
	
}
