package mx.com.cursodia.jse18.mod2.sem1;

import java.util.LinkedHashMap;

public class Modelo
{
	 LinkedHashMap<Integer,Articulo> Almacen = new LinkedHashMap<Integer,Articulo>();
	
	
	void AlmacenAdd(Articulo articulo)
	{
		Almacen.put(Almacen.size(), articulo);
	}
}
