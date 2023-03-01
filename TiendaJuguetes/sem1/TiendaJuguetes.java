package mx.com.cursodia.jse18.mod2.sem1;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class TiendaJuguetes 
{
	
	ArrayList<Articulo> almacen = new ArrayList<Articulo>();
	int cve, inv; 
	String cat, nom;
	float pre;
	public static void main(String[] args) 
	{
		TiendaJuguetes tj = new TiendaJuguetes();
		tj.menu();
	}
	private void menu()
	{
		boolean d1 = true;
		do 
		{
			int d = Integer.parseInt(JOptionPane.showInputDialog("Que desea hacer?: 1. Agregar 2. Imprimir 3. Actualizar 4. Borrar 5. Salir"));
			switch(d)
			{
				case 1: leerArticulos(); break;
				case 2: imprimirArticulos(); break;
				case 3: actualizarArticulo(); break;
				case 4: borrarArticulo(); break;
				case 5: d1 = false; break;
			}
		}while(d1 != false);
	}
	private void leerArticulos()
	{
		int op = 2;
		do
		{
			cve = Integer.parseInt(JOptionPane.showInputDialog("Cve:"));
			cat = JOptionPane.showInputDialog("Categoria:");
			nom = JOptionPane.showInputDialog("Nombre:");
			pre = Float.parseFloat(JOptionPane.showInputDialog("Precio:"));
			inv = Integer.parseInt(JOptionPane.showInputDialog("Inventario:"));
			almacen.add(new Articulo(cve,cat,nom,pre,inv));
			
			op = Integer.parseInt(JOptionPane.showInputDialog("Agregar otro articulo? 1. Si 2. No"));
		}while(op != 2);
	}
	private void imprimirArticulos()
	{
		System.out.println("Clave\t\tCategoria\t\tNombre\t\tPrecio\t\tExistencia");
		for(Articulo A:almacen)
		{
			System.out.println(A);
		}
	}
	private void actualizarArticulo()
	{
		boolean found = false;
		int fails = 0;
		int aid = Integer.parseInt(JOptionPane.showInputDialog("Indique la clave del articulo a actualizar:"));
		for(Articulo A:almacen)
		{ 
			if(A.cve_art == aid)
			{
				A.setCve_art(Integer.parseInt(JOptionPane.showInputDialog("Cve:")));
				A.setCat_art(JOptionPane.showInputDialog("Categoria:"));
				A.setNom_art(JOptionPane.showInputDialog("Nombre:"));
				A.setPre_art(Float.parseFloat(JOptionPane.showInputDialog("Precio:")));
				A.setInv_art(Integer.parseInt(JOptionPane.showInputDialog("Inventario:")));
				found = true;
			}
			else
			{
				fails++;
			}
		}
		if(fails > 0 && found == false)
		{
			JOptionPane.showInternalMessageDialog(null, "No existe ningun articulo con esa clave");
		}
	}
	private void borrarArticulo()
	{
		boolean found = false;
		int fails = 0;
		int eid = Integer.parseInt(JOptionPane.showInputDialog("Indique la clave del articulo a eliminar:"));
		for(Articulo A:almacen)
		{ 
			if(A.cve_art == eid)
			{
				almacen.remove(A);
				found = true;
			}
			else
			{
				fails++;
			}
		}
		if(fails > 0 && found == false)
		{
			JOptionPane.showInternalMessageDialog(null, "No existe ningun articulo con esa clave");
		}
	}

}
