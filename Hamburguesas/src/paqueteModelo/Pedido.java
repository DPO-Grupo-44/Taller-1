package paqueteModelo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class Pedido {

	private int numeroPedido;
	private int cantidadPedidos;
	private String nombreCliente;
	private String direccionCliente;
	private ArrayList<ProductoMenu> listaPedido;
	private ArrayList<Combo> pedidoenCombo;
	
	public Pedido(int tnumeroPedido, String tnombreCliente, String tdireccionCliente){
		numeroPedido = tnumeroPedido;
		nombreCliente = tnombreCliente;
		direccionCliente = tdireccionCliente;
		listaPedido = new ArrayList<ProductoMenu>();
		pedidoenCombo = new ArrayList<Combo>();
	}
	
	
	public int getIdPedido(){
		return numeroPedido;
	}
	
	public void agregarProducto(ProductoMenu ingredienteselec) {
		listaPedido.add((ProductoMenu)ingredienteselec);
	}
	
	public void agregarCombo(Combo ingredienteselec, Map<String, ProductoMenu> ingredientes) {
		pedidoenCombo.add((Combo)ingredienteselec);
	}
	
	private int getPrecioCombo(Map<String, ProductoMenu> ingredientes) {
		int rta = 0; 
		for (int i=0;i<pedidoenCombo.size();i++) {
			rta += pedidoenCombo.get(i).getPrecioTotal(ingredientes);}
		rta += getPrecioTotalPedido();
		return rta;
	}
	

	
	private int getPrecioNetoPedido() {
		int rta = 0;
		for (int i=0;i<listaPedido.size();i++) {
		      rta += listaPedido.get(i).getPrecio();}
		return rta;
		      	}
	
	private int getPrecioIVAPedido() {
		int preciobase = getPrecioNetoPedido();
		int IVA = (int) (preciobase * 0.19);
		return IVA;
	}
	private int getPrecioTotalPedido() {
		int preciobase = getPrecioNetoPedido();
		int IVA = getPrecioIVAPedido();
		return preciobase + IVA;

	}
	
	private String generarTextoFactura() {
		int id = getIdPedido();
		int total = getPrecioTotalPedido(); 
		ArrayList<String> comprados = new ArrayList<String>();
		ArrayList<Integer> precios = new ArrayList<Integer>();
		for (int i=0;i<listaPedido.size();i++) {
			comprados.add(listaPedido.get(i).getNombre());
			precios.add(listaPedido.get(i).getPrecio());
		      }
		int preciobase = getPrecioNetoPedido();
		int IVA = getPrecioIVAPedido();
		return ("Pedido #" + id + "\n Productos comprados: \n" + comprados + "\n" +
		precios + "\n Subtotal: $" + preciobase + "\n IVA: $" + IVA + "\n Total: $" + total);

		}
		
	public void generarFactura() throws IOException {
		File factura = new File ("C:\\Users\\santi\\Documents\\Universidad\\Diseño y Programación\\factura.txt");
		if(factura.createNewFile())
			System.out.println("File created: " + factura.getName());
		try {
			BufferedWriter escritor = new BufferedWriter(new FileWriter("C:\\Users\\santi\\Documents\\Universidad\\Diseño y Programación\\factura.txt"));
			String mensaje = generarTextoFactura();
			escritor.write(mensaje);
			escritor.close();
			
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("No se encontro");
		}
		
	}
	
			
}
