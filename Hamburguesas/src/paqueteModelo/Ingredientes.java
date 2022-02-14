package paqueteModelo;

public class Ingredientes {
	private String adicional;
	private int precioad;
	
	public Ingredientes(String tadicional, int tprecioad) {
		adicional = tadicional;
		precioad = tprecioad;
		
	}
	
	public String darNombre(){
		return adicional;
	}
	
	public int darPrecio() {
		return precioad;
	}
	
}
