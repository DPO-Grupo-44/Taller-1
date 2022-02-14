package paqueteModelo;

import java.util.ArrayList;

public class Combo implements Producto{

	private double descuento;
	private String nombre;
	private ArrayList<ProductoMenu> itemsCombo;
	
	public Combo(double tdescuento, String tnombre, ArrayList<ProductoMenu> titemsCombo) {
		nombre = tnombre;
		descuento = tdescuento;
		itemsCombo = new ArrayList<ProductoMenu>();
	}
	
	public void agregarItemCombo(Producto itemCombo) {
		itemsCombo.add((ProductoMenu)itemCombo);
	}


	public int getPrecio() {
	
		return 0;
	}

	@Override
	public String getNombre() {
		
		return null;
	}

	@Override
	public String generaTextoFactura() {
		
		return null;
	}
	
	
}
