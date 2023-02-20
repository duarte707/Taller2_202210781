package uniandes.dpoo.taller2.modelo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Restaurante {
	private static int numeroPedidos = 0;
	private Pedido pedidoEnCurso;
	private ArrayList<Ingrediente> ingredientes;
	private ArrayList<ProductoMenu> productosMenu;
	private ArrayList<Combo> combos;
	private ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
	public Restaurante()
	{
		
	}
	public void iniciarPedido(String nombreCliente, String direccionCliente)
	{
		ArrayList<Producto> itemsPedido= new ArrayList<Producto>(); 
		pedidoEnCurso = new Pedido(nombreCliente,direccionCliente,true, numeroPedidos+1,itemsPedido);
		numeroPedidos++;
		}
	public void cerrarYGuardarPedido() throws IOException
	{
		pedidoEnCurso.cerrarPedido();
		pedidoEnCurso.guardarFactura();
		pedidos.add(pedidoEnCurso);
		}
	public Pedido getPedidoEnCurso()
	{
		return pedidoEnCurso;
		}
	public ArrayList<ProductoMenu> getMenuBase()
	{
		return productosMenu;
		}
	public ArrayList<Ingrediente> getIngrendientes()
	{
		return ingredientes;
		}
	public void cargarInformacionRestaurante(File archivoIngredientes, File archivoMenu, File archivoCombos) throws IOException
	{
		ingredientes = cargarIngredientes(archivoIngredientes);
		productosMenu = cargarMenu(archivoMenu);
		combos = cargarCombos(archivoCombos);
	}
	private ArrayList<Ingrediente> cargarIngredientes(File archivoIngredientes) throws FileNotFoundException, IOException
	{
		try (BufferedReader br = new BufferedReader(new FileReader(archivoIngredientes)))
		{
			String st;
			ArrayList<Ingrediente> productos = new ArrayList<Ingrediente>();
			while ((st = br.readLine()) != null)
			{
				String[] split = st.split(";");
				Ingrediente productoMenu = new Ingrediente(split[0],Integer.parseInt(split[1]));
				productos.add(productoMenu);
				}
			return productos;
			}
	}
	private ArrayList<ProductoMenu> cargarMenu(File archivoMenu) throws IOException
	{
		try (BufferedReader br = new BufferedReader(new FileReader(archivoMenu)))
		{
		String st;
		ArrayList<ProductoMenu> productos = new ArrayList<ProductoMenu>();
		while ((st = br.readLine()) != null) 
		{
			String[] split = st.split(";");
			ProductoMenu productoMenu = new ProductoMenu(split[0],Integer.parseInt(split[1]));
			productos.add(productoMenu);
			}
		return productos;
		}
	}
	private ArrayList<Combo> cargarCombos(File archivoCombos) throws IOException
	{
		 try (BufferedReader br = new BufferedReader(new FileReader(archivoCombos))) {
			String st;
			ArrayList<Combo> combos = new ArrayList<Combo>();
			 while ((st = br.readLine()) != null)
			 {		 
			        String[] split = st.split(";");
			        String name = split[0];
			        double descuento = Double.parseDouble(split[1].replace("%",""))/100;
			        ArrayList<ProductoMenu> productos = new ArrayList<ProductoMenu>();
			        for(int i =2;i<split.length;i++)
			        {
			        	productos.add(new ProductoMenu(split[i],getPrecio(split[i])));
			        	}
			        Combo combo = new Combo(name,descuento,productos);
			        combos.add(combo);
			        }
			 }
		 return combos;
		 }
	private int getPrecio(String name)
	{
		int price = 0;
		for(int i=0;i<productosMenu.size();i++)
		{
			if(productosMenu.get(i).getNombre() == name) 
			{
				price =  productosMenu.get(i).getPrecio();
			}
		}
		return price;
	}
	public Pedido getId(int id)
	{
		return pedidos.get(id-1);
		}
	public int getNumeroPedidos()
	{
		return numeroPedidos;
		}
	
	
	
}