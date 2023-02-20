package uniandes.dpoo.taller2.modelo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;





public class Pedido {
	private int idPedido;
	private String nombreCliente;
	private String direccionCliente;
	private ArrayList<Producto> itemsPedido;
	private boolean pedidoEnCurso;
	public 	Pedido (String nombreCliente, String direccionCliente, boolean pedidoEnCurso, int idPedido, ArrayList<Producto> itemsPedido)
	{
		this.idPedido = idPedido;
		this.nombreCliente = nombreCliente;
		this.pedidoEnCurso = pedidoEnCurso;
		this.direccionCliente = direccionCliente;
		this.pedidoEnCurso = pedidoEnCurso;
		this.itemsPedido = itemsPedido;
	}
	public int 	getIdPedido()
	{ 
		return this.idPedido;
	}

	private int getPrecioNetoPedido()
	{
		int neto = 0;
		for(int i=0;i<this.itemsPedido.size();i++)
		{
			int precio_cosas = this.itemsPedido.get(i).getPrecio();
			neto += precio_cosas;
		}
		return neto;
	}
	private int getPrecioTotalPedido()
	{
		int Total = getPrecioNetoPedido() + getPrecioIVAPedido();
		return Total;
	}
	private int getPrecioIVAPedido()
	{
		
		return (int)(getPrecioNetoPedido() * 0.19);
	}
	public String getNombrecliente()
	{
		String resultado = this.nombreCliente;
		return resultado;
	}
	public String getDireccionCliente()
	{
		String resultado = this.direccionCliente;
		return resultado;
	}
	public boolean getPedidoEnCurso()
	{
		boolean resultado = this.pedidoEnCurso;
		return resultado;
	}
	public void agregarProducto(Producto item)
	{
		itemsPedido.add(item);
	}
	
	public void cerrarPedido()
	{
		this.pedidoEnCurso = false;
	
	}
	public ArrayList<Producto>  getItemsPedido()
	{
		ArrayList<Producto> resultado = this.itemsPedido;
		return resultado;
	}
	public void guardarFactura() throws IOException
	{
		File rutaFactura = new File("Facturas/" + Integer.toString(idPedido)+".txt");
		rutaFactura.createNewFile();
		FileWriter writer = new FileWriter(rutaFactura);
		writer.write("Cliente: " + this.nombreCliente+"\n");
		writer.write("Dirección: " + this.direccionCliente+"\n");
		writer.write("Comida:"+"\n");
		for(int i=0;i<this.itemsPedido.size();i++) {
			writer.write(this.itemsPedido.get(i).generarTextoFactura()+"\n");
		}
		writer.write("Total Neto:" +getPrecioNetoPedido()+"\n");
		writer.write("IVA:" +getPrecioIVAPedido()+"\n");
		writer.write("TOTAL:" + getPrecioTotalPedido()+"\n");
		writer.close();
	}

}
	