package mx.com.cursodia.jse18.mod2.sem1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Modelo
{
	private ArrayList<Articulo> Almacen = new ArrayList<Articulo>();
	
	public int getAlmacenSize()
	{
		return Almacen.size();
		
	}
	
	public boolean isEmpty()
	{
		if(Almacen.size() == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void AlmacenAdd(Articulo articulo)
	{
		Almacen.add(articulo);
	}
	
	public void AlmacenRemove(int i)
	{
		Almacen.remove(i);
	}
	
	public Articulo AlmacenGet(int i)
	{
		return Almacen.get(i);
	}
}
