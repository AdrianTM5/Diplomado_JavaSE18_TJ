package mx.com.cursodia.jse18.mod2.sem1;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Modelo
{
	private LinkedHashMap<Integer,Articulo> Almacen = new LinkedHashMap<Integer,Articulo>();
	
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
		Almacen.put(articulo.getCve_art(),articulo);
	}
	
	void AlmacenRemove(int i)
	{
		Almacen.remove(i);
	}
	
	public Articulo AlmacenGet(int i)
	{
		return Almacen.get(i);
	}
	
	Articulo AlmacenKey(Articulo A)
	{
		return Almacen.get(A);
	}
}
