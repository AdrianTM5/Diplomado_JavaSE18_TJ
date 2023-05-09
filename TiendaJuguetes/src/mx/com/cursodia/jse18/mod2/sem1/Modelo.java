package mx.com.cursodia.jse18.mod2.sem1;

import java.util.ArrayList;
import java.util.List;

public class Modelo
{
	 List<Articulo> Almacen = new ArrayList<Articulo>();
	 List<Proveedor> AlmacenP = new ArrayList<Proveedor>();
	
	Integer AlmacenGetLast()
	{
		int cve = Almacen.get(Almacen.size() - 1).getCve_art();
		return cve;
	}
	 
	void AlmacenAdd(String cat, String nom, float pre, int inv, int prov)
	{
		int cve = AlmacenGetLast();
		cve++;
		Articulo art = new Articulo(cve, cat, nom, pre, inv, prov);
		Almacen.add(art);
	}
}
