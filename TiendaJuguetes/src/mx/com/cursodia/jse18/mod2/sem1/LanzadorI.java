package mx.com.cursodia.jse18.mod2.sem1;

public class LanzadorI 
{
	public static void main(String[] args) 
	{
		Modelo mod = new Modelo();
		TJInicio ini = new TJInicio();
		TJRegistrar reg = new TJRegistrar();
		TJMostrar mos = new TJMostrar();
		
		Controlador co = new Controlador(mod, ini, reg, mos);
		co.conectar();
	}
}
