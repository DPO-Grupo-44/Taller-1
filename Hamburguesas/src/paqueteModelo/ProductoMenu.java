package paqueteModelo;

public class ProductoMenu implements Producto{
	private String nombre;
	private int precio;

	
	public ProductoMenu(String tnombre, int tprecio){
		nombre = tnombre;
		precio = tprecio;
		
	}
	public int getPrecio() {
		
		return precio;
	}


	public String getNombre() {
		
		return nombre;
	}


	public String generaTextoFactura() {
		
		
		return nombre + " $" + precio;
	}
	
}
