package paqueteModelo;

public class Menu {
	private String comida;
	private int precio;
	
	public Menu(String tcomida, int tprecio) {
		comida = tcomida;
		precio = tprecio;
		
	}
	
	public String darNombre(){
		return comida;
	}
	
	public int darPrecio() {
		return precio;
	}
}
