package mx.com.cursodia.jse18.mod2.sem1;

public class LanzadorI 
{
	public static void main(String[] args) 
	{
		Modelo mod = new Modelo();
		GUI gui = new GUI();
		GUIReg_A regA = new GUIReg_A();
		GUIMos_A mosA = new GUIMos_A();
		GUIMos_P mosP = new GUIMos_P();
		GUIReg_P regP = new GUIReg_P();
		
		
		Controlador co = new Controlador(mod, gui, regA, mosA, mosP, regP);
	}
}