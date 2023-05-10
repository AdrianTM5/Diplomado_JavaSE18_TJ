package mx.com.cursodia.jse18.mod2.sem1;

import java.util.ArrayList;
import java.util.List;

public class Modelo
{
	 List<Articulo> Almacen = new ArrayList<Articulo>();
	 List<Proveedor> AlmacenP = new ArrayList<Proveedor>();
	
	private Integer AlmacenGetLast()
	{
		int cve = Almacen.get(Almacen.size() - 1).getCve_art();
		return cve;
	}
	
	private Integer AlmacenPGetLast()
	{
		int cve = AlmacenP.get(AlmacenP.size() - 1).getCve_prov();
		return cve;
	}
	
	 
	void AlmacenAdd(String cat, String nom, float pre, int inv, int prov)
	{
		int cve = AlmacenGetLast();
		cve++;
		Articulo art = new Articulo(cve, cat, nom, pre, inv, prov);
		Almacen.add(art);
	}
	
	void AlmacenPAdd(String nom, String tel, String email, String dir)
	{
		int cve = AlmacenPGetLast();
		cve++;
		Proveedor prov = new Proveedor(cve, nom, tel, email, dir);
		AlmacenP.add(prov);
	}
	
}
