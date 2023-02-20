package uniandes.dpoo.taller2.modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;



public class AplicacionRestaurante 
{
	private Restaurante restaurante = new Restaurante();
	
	public void ejecutarOpcion() throws FileNotFoundException, IOException 
	{
		System.out.println("Bienvenido al Corral!");
		

		boolean continuar = true;
		boolean Inicio = false;
		cargarInfo();
		while (continuar)
		{
			
			try
			{
				mostrarOpciones();
				int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opción"));
				
				if (opcion_seleccionada == 1)
				{
					mostrarMenu();
				}
				else if (opcion_seleccionada == 2)
				{
					Iniciar_Pedido();
					Inicio = true;
				}

				else if (opcion_seleccionada == 3 && Inicio == true)
				{
					agregarItem();
					System.out.println("Item agregado");
				}
				else if (opcion_seleccionada == 3 && Inicio == false)
				{
					System.out.println("No hay un pedido activo, por favor inicie un pedido");
				}
				else if (opcion_seleccionada == 4 )
				{
					restaurante.cerrarYGuardarPedido();
					System.out.println("Su pedido a sido cerrado con exito.");
					Inicio = false;
				}
					
				else if (opcion_seleccionada == 5 )
				{
					int idPed = Integer.parseInt(input("Ingrese el Id del pedido del cual desea consultar:"));
					Pedido pedido = restaurante.getId(idPed);
					String cliente = pedido.getNombrecliente();
					String direcc = pedido.getDireccionCliente();
					System.out.println("Cliente: " + cliente);
					System.out.println("Dirección: " + direcc);
					for(int i=0;i<pedido.getItemsPedido().size();i++)
					{
						System.out.println(pedido.getItemsPedido().get(i).getNombre());
					}
				}
					

				else if (opcion_seleccionada == 6)
					
				{
					System.out.println("Saliendo de la aplicación ...");
					continuar = false;
				}
				else
				{
					System.out.println("Por favor seleccione una opción válida.");
				}
			}
			catch (NumberFormatException e)
			{
				System.out.println("Debe seleccionar uno de los números de las opciones.");
			}
		}
	}
	
	public String input(String mensaje)
	{
		try
		{
			System.out.print(mensaje);
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		}
		catch (IOException e)
		{
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
		return null;
	}

	private void Iniciar_Pedido() { 
		if (restaurante.getNumeroPedidos() == 0 || restaurante.getPedidoEnCurso().getPedidoEnCurso() == false) {
			
		String nombre = input("Por favor ingrese su nombre: ");
		String direccion = input("Por favor ingrese su dirección: ");
		restaurante.iniciarPedido(nombre, direccion);
		int id =restaurante.getPedidoEnCurso().getIdPedido();
		System.out.println("Pedido creado exitosamento con el id:" + id); }
		else { System.out.println("Ya hay un pedido en curso.");}
		
	}
	private void agregarItem()
	{
		if(restaurante.getPedidoEnCurso().getPedidoEnCurso()==true)
		{
			String elemento = input("Ingrese el nombre del producto que desea  agregar: ");
			for(int i = 0; i<restaurante.getMenuBase().size();i++)
			{
				if(restaurante.getMenuBase().get(i).getNombre().equals(elemento))
				{
					//restaurante.getPedidoEnCurso().agregarProducto(restaurante.getMenuBase().get(i));
				}
				
			}
		} 
	}
	public void mostrarOpciones()
	{
		System.out.println("\nOpciones de la aplicación\n");
		System.out.println("1. Mostrar el menu");
		System.out.println("2. Iniciar un nuevo pedido");
		System.out.println("3. Agregar un elemento al pedido");
		System.out.println("4. Cerrar un pedido, y guardar la factura");
		System.out.println("5. Consultar el pedido con tu ID");
		System.out.println("6. Terminar el proceso");

	}

	public void mostrarMenu() 
	{
		System.out.println("1. MENÚ\n");
		System.out.println("\t101 - corral: 14000");
		System.out.println("\t102 - corral queso: 16000");
		System.out.println("\t103 - corral pollo: 15000");
		System.out.println("\t104 - corralita: 13000");
		System.out.println("\t105 - todoterreno: 25000");
		System.out.println("\t106 - 1/2 libra: 25000");
		System.out.println("\t107 - especial: 24000");
		System.out.println("\t108 - casera: 23000");
		System.out.println("\t109 - mexicana: 22000");
		System.out.println("\t110 - criolla: 22000");
		System.out.println("\t111 - costeña: 20000");
		System.out.println("\t112 - hawaiana: 20000");
		System.out.println("\t113 - wrap de pollo: 15000");
		System.out.println("\t114 - wrap de lomo: 22000");
		System.out.println("\t115 - ensalada mexicana: 20900");
		System.out.println("\t116 - papas medianas: 5500");
		System.out.println("\t117 - papas grandes: 6900");
		System.out.println("\t118 - papas en casco medianas: 5500");
		System.out.println("\t119 - papas en casco grandes: 6900");
		System.out.println("\t120 - agua cristal sin gas: 5000");
		System.out.println("\t121 - agua cristal con gas: 5000");
		System.out.println("\t122 - gaseosa: 5000");
		System.out.println("\n2. INGREDIENTES");
		System.out.println("\t201 - lechuga: 1000");
		System.out.println("\t202 - tomate: 1000");
		System.out.println("\t203 - cebolla: 1000");
		System.out.println("\t204 - queso mozzarella: 2500");
		System.out.println("\t205 - huevo: 2500");
		System.out.println("\t206 - queso americano: 2500");
		System.out.println("\t207 - tocineta express: 2500");
		System.out.println("\t208 - papa callejera: 2000");
		System.out.println("\t209 - pepinillos: 2500");
		System.out.println("\t210 - cebolla grille: 2500");
		System.out.println("\t211 - suero costeño: 3000");
		System.out.println("\t212 - frijol refrito: 4500");
		System.out.println("\t213 - queso fundido: 4500");
		System.out.println("\t214 - tocineta picada: 6000");
		System.out.println("\t215 - piña: 2500");
		System.out.println("\n3. COMBOS");
		System.out.println("\t301 - combo corral (corral, papas medianas, gaseosa): 22050");
		System.out.println("\t302 - combo corral queso (corral queso, papas medianas, gaseosa): 23850");
		System.out.println("\t303 - combo todoterreno (todoterreno, papas grandes, gaseosa): 34317");
		System.out.println("\t304 - combo especial (especial, papas medianas, gaseosa): 34317");
	}
	private void cargarInfo() throws IOException {
		File ingredientes = new File("data/ingredientes.txt");
		File menu = new File("data/menu.txt");
		File combos = new File("data/combos.txt");
		restaurante.cargarInformacionRestaurante(ingredientes, menu, combos);
	}

	public static void main(String[] args) throws FileNotFoundException, IOException
	{
		AplicacionRestaurante consola = new AplicacionRestaurante();
		consola.ejecutarOpcion();
	}
	
	
}
