package mx.com.cursodia.jse18.mod2.sem1;

import java.util.ArrayList;

public class Modelo
{
	private ArrayList<Articulo> Almacen = new ArrayList<Articulo>();
	
	int getAlmacenSize()
	{
		return Almacen.size();
		
	}
	
	boolean isEmpty()
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
	
	void AlmacenAdd(Articulo articulo)
	{
		Almacen.add(articulo);
	}
	
	void AlmacenRemove(int i)
	{
		Almacen.remove(i);
	}
	
	public Articulo AlmacenGet(int i)
	{
		return Almacen.get(i);
	}
}
