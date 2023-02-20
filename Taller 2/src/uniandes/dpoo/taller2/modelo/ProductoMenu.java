package uniandes.dpoo.taller2.modelo;

public class ProductoMenu {
	private String nombre;
	private int precioBase;
	public ProductoMenu(String nombre, int precioBase)
	{
		this.nombre = nombre;
		this.precioBase = precioBase;
		
	}
	public String getNombre()
	{
		String resultado = this.nombre;
		return resultado;
		
	}
	public int getPrecio()
	{
		int resultado = this.precioBase;
		return resultado;
	}
	public  String generarTextoFactura()
	{
		String resultado_nom = getNombre();
		String resultado_prec = Integer.toString(getPrecio());
		String resultado_fin = resultado_nom + ":" + resultado_prec;
		return resultado_fin;
		
	}

}
