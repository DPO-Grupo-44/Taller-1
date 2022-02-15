package paqueteModelo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Pedido {

	private int numeroPedido;
	private int cantidadPedidos;
	private String nombreCliente;
	private String direccionCliente;
	private ArrayList<ProductoMenu> listaPedido;
	
	public Pedido(int tnumeroPedido, String tnombreCliente, String tdireccionCliente){
		numeroPedido = tnumeroPedido;
		nombreCliente = tnombreCliente;
		direccionCliente = tdireccionCliente;
	}
	
	
	public int getIdPedido(){
		return numeroPedido;
	}
	
	public void agregarProducto(Producto nuevoItem) {
		listaPedido.add((ProductoMenu)nuevoItem);
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
		int idpedido = getIdPedido();
		int total = getPrecioTotalPedido();
		return ("El pedido numero " + idpedido + "tiene un valor total de $" + total);
	}

	public void generarFactura() throws IOException {
		File factura = new File ("c:/Usuarios/santi/Documents/factura.txt");
		if(factura.createNewFile())
			System.out.println("File created: " + factura.getName());
		try {
			BufferedWriter escritor = new BufferedWriter(new FileWriter("c:/Usuarios/santi/Documents/factura.txt"));
			String mensaje = generarTextoFactura();
			escritor.write(mensaje);
			escritor.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
			
}
