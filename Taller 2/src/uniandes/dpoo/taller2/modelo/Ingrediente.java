package uniandes.dpoo.taller2.modelo;

public class Ingrediente {
	private String nombre;
	private int CostoAdicional;
	public Ingrediente(String nombre, int costoAdicional)
	{
		this.nombre = nombre;
		this.CostoAdicional = costoAdicional;
		
	}
	public String getNombre()
	{
		String resultado = this.nombre;
		return resultado;
	}
	public int getCostoAdicional()
	{ 
		int resultado = this.CostoAdicional;
		return resultado;
	} 
	

}
