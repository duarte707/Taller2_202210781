package uniandes.dpoo.taller2.modelo;
import java.util.ArrayList;



public class Combo extends Producto {
	private double descuento;
	private String nombreCombo;
	private ArrayList<ProductoMenu> ItemsCombo;
	public Combo(String nombre, double descuento,ArrayList<ProductoMenu> ItemsCombo)
	{
		this.descuento = descuento;
		this.nombreCombo = nombre;
		this.ItemsCombo = ItemsCombo;
		
	}
	public void agregarItemACombo(ProductoMenu itemcombo)
	{
		this.ItemsCombo.add(itemcombo);
		
	}
	public int getPrecio()	
	{
		int precio_fin = 0;
		for(int i=2;i<this.ItemsCombo.size();i++)
		{
			int total =this.ItemsCombo.get(i).getPrecio();
			precio_fin += total;
			
		}
		precio_fin = precio_fin * (int)(1-this.descuento);
		return precio_fin;
	}
	public String getNombre()
	{
		String resultado = this.nombreCombo;
		return resultado;
	}
	public String generarTextoFactura()
	{
		String resultado_nom = getNombre();
		String resultado_prec = Integer.toString(getPrecio());
		String resultado_fin = resultado_nom + ":" + resultado_prec;
		return resultado_fin;
		
	}
	

}
