package uniandes.dpoo.taller2.modelo;

import java.util.ArrayList;


public class ProductoAjustado extends Producto {
	private ProductoMenu base;
	private ArrayList<Ingrediente> eliminados;
	private ArrayList<Ingrediente> agregados;
	public ProductoAjustado(ProductoMenu base,ArrayList<Ingrediente> agregados,ArrayList<Ingrediente> eliminados)
	{
		this.base = base;
		this.agregados = agregados;
		this.eliminados = eliminados;
	}
	public String getNombre()
	{
		String resultado = this.base.getNombre();
		return resultado;
	}
	public int getPrecio()
	{
		int precio = 0;
		for(int i=0;i<this.eliminados.size();i++)
		{
			precio += this.eliminados.get(i).getCostoAdicional();
		}
		int respuesta = precio + this.base.getPrecio();
		return respuesta;
	}
 	public String generarTextoFactura()
	{
		String resultado_nom = this.base.getNombre();
		if(this.eliminados.size() > 0)
		{
			resultado_nom += " sin ";
			for(int i=0;i<this.eliminados.size();i++)
			{
				String ingredientes = this.eliminados.get(i).getNombre();
				resultado_nom += ingredientes;
				if(i != this.eliminados.size()-1)
				{
					
					resultado_nom += ",";
				}
			}
			
		}
		if (this.agregados.size() > 0)
		{
			resultado_nom += " con ";
			for(int i=0;i<this.agregados.size();i++)
			{
				String ingredientes = this.agregados.get(i).getNombre();
				resultado_nom += ingredientes;
				if(i != this.agregados.size()-1)
				{
					
					resultado_nom += ",";
				}
			}
			
		}
		String resultado_prec = Integer.toString(getPrecio());
		resultado_nom = resultado_nom + ":" + resultado_prec;
		return resultado_nom;
	}

}
