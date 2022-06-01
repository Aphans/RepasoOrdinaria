package Ejercicio2;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Cliente {
	private String dni;
	private static HashMap <String,Integer> productos = new HashMap<String,Integer>();
	Cliente(String dni){
		this.dni=dni;
	}
	public void comprar() {
			BufferedReader br = null;
			try {
				br = new BufferedReader(new FileReader("productos.txt"));
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String linea;
			try {
				while((linea = br.readLine()) !=null) {
					String datos[]=linea.split(" ");
					String producto = String.valueOf(datos[0]); 
					Integer cantidad = Integer.valueOf(datos[1]);
					if(productos.containsKey(producto)) {
						Integer cantidadRepetida = productos.get(producto);
						cantidad+= cantidad+cantidadRepetida;
					}
					productos.put(producto, Integer.valueOf(cantidad));
				}
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	public  void añadirProducto(String producto,int cantidad) {
		File file = new File("productos.txt");
		BufferedWriter br = null ;
		try {
			 br = new BufferedWriter(new FileWriter(file,true));
			try {
				if(cantidad<=0) return;
				br.newLine();
				br.write(producto);
				br.write(" ");
				br.write(String.valueOf(cantidad));
				productos.put(producto, cantidad);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void eliminarProducto() {
		File file = new File("productos.txt");
		Scanner sc = new Scanner(System.in);
		String opcion;
		System.out.println("¿Desea eliminar un producto?S/N?");
		opcion = sc.next();
		opcion.toUpperCase();
		if(opcion.equals("N") | !opcion.equals("S"))return;
		if(opcion.equals("S")) {
			System.out.println("Indique el producto a eliminar");
			String producto = sc.next();
			System.out.println("Indica la cantidad del producto a eliminar");
			int cantidadEliminar = sc.nextInt();
			Integer cantidad = 0;
			if(cantidad==0)productos.remove(producto);
			String productos0 = null;
			for (Entry<String, Integer> entry : productos.entrySet()) {
				 if(producto.equals(entry.getKey())) {
				 cantidad = entry.getValue();
				cantidad-=cantidadEliminar;
				productos.put(producto, cantidad);
		}
			}
		}
			
		
	}
	public void mostrarProductos() {
		for (String key: productos.keySet()){  
			System.out.println(key+ " = " + productos.get(key));
		} 
	}
	public void sacarTicket() {
		File file =  new File("ticket.txt");
		File file2 = new File("precios.txt");
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(file));
				for (String key: productos.keySet()){  
				bw.write(key);
				bw.write(" ");
				bw.write(String.valueOf(productos.get(key)));
				bw.newLine();
			}
			
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			BufferedReader br2 = new BufferedReader(new FileReader(file2));
			String linea;
			while((linea=br2.readLine())!=null) {
				String[] datos=linea.split(" ");
				double precio = Double.valueOf(datos[1]);
				int cantidad=0;
				for (String key : productos.keySet()) {
					if(key.equals(datos[0])) { 
						 cantidad = productos.get(key);
							double precioTotal=+precio;
							bw.newLine();
							 DecimalFormat df = new DecimalFormat("#.00");
							bw.write("Precio Total:"+String.valueOf(df.format(precioTotal*cantidad)));
					return;
					}
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(bw!=null) {
				try {
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
}
	


