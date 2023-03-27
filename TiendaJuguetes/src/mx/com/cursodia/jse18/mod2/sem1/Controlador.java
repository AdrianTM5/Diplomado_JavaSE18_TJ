package mx.com.cursodia.jse18.mod2.sem1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Controlador implements ActionListener
{
	Modelo mod;
	TJInicio GUI;
	TJRegistrar GUIReg;
	TJMostrar GUIMos;
	
	
	public Controlador(Modelo mode, TJInicio ini, TJRegistrar reg, TJMostrar mos) 
	{
		this.mod = mode;
		this.GUI = ini;
		this.GUIReg = reg;
		this.GUIMos = mos;
		inicializar();
	}
	
	private void inicializar()
	{
		GUI.lanzar();
		GUIReg.lanzar();
		GUIMos.lanzar();
//		while(GUI.)
//		{
//			try {
//				Thread.sleep(1);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		//------------Inicio------------------
		GUI.setVisible(true);
		GUI.setResizable(false);
		GUI.btnRegistrar.addActionListener(this);
		GUI.btnMostrar.addActionListener(this);
		GUI.btnSalir.addActionListener(this);
		//------------Registrar------------------
		GUIReg.setVisible(false);
		GUIReg.setResizable(false);
		GUIReg.btnAgregar.addActionListener(this);
		GUIReg.btnSalir.addActionListener(this);
		//------------Mostrar------------------
		GUIMos.setVisible(false);
		GUIMos.setResizable(false);
		GUIMos.btnPrimero.addActionListener(this);
		GUIMos.btnUltimo.addActionListener(this);
		GUIMos.btnSalir.addActionListener(this);
		GUIMos.btnSig.addActionListener(this);
		GUIMos.btnAnt.addActionListener(this);
		GUIMos.btnEditar.addActionListener(this);
		GUIMos.btnActualizar.addActionListener(this);
		GUIMos.btnBorrar.addActionListener(this);
	}
		
	@SuppressWarnings("static-access")
	int i = 0;
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		//------------Inicio------------------
		if(e.getSource() == GUI.btnRegistrar)
		{
			GUI.dispose();
			GUIReg.setVisible(true);
			GUIReg.setResizable(false);
		}
		else if(e.getSource() == GUI.btnMostrar)
		{
			if(!mod.isEmpty())
			{
				GUI.dispose();
				GUIMos.setVisible(true);
				GUIMos.setResizable(false);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Error, primero registre un juguete");
			}
		}
		else if(e.getSource() == GUI.btnSalir)
		{
			System.exit(GUI.EXIT_ON_CLOSE);
		}
		//------------Registrar------------------
		int cve, inv;  
		String cat, nom;
		float pre;
		if(e.getSource() == GUIReg.btnAgregar)
		{
			try {
					cve = Integer.parseInt(GUIReg.IdTextField.getText());
					cat = GUIReg.CategoriaTextField.getText();
					nom = GUIReg.NombreTextField.getText();
					pre = Float.parseFloat(GUIReg.PrecioTextField.getText());
					inv = Integer.parseInt(GUIReg.InventarioTextField.getText());
					mod.AlmacenAdd(new Articulo(cve,cat,nom,pre,inv));
					
					sustituir(GUIReg.IdTextField, GUIReg.NombreTextField, GUIReg.CategoriaTextField, GUIReg.PrecioTextField, GUIReg.InventarioTextField);
					JOptionPane.showMessageDialog(null, "Juguete agregado exitosamente");
				} 
			catch (NumberFormatException e2)
				{
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "Favor de llenar todos los campos");
				}
		}
		else if(e.getSource() == GUIReg.btnSalir)
		{
			GUIReg.dispose();
			GUI.setVisible(true);					
		}
		//------------Mostrar------------------
		if(mod.getAlmacenSize() > 0 && e.getSource() == GUI.btnMostrar)
		{
			if(e.getSource() == GUIMos.btnPrimero)
			{
				i = 0;
				mostrar(i);
				GUIMos.btnAnt.setEnabled(false);
				GUIMos.btnBorrar.setEnabled(true);
				GUIMos.btnEditar.setEnabled(true);
				if(mod.getAlmacenSize() > 1)
				{
					GUIMos.btnSig.setEnabled(true);
					if(!GUIMos.btnUltimo.isEnabled())
					{
						GUIMos.btnUltimo.setEnabled(true);
					}
				}
				else
				{
					GUIMos.btnSig.setEnabled(false);
					
				}
				GUIMos.btnPrimero.setEnabled(false);
			}
			else if(e.getSource() == GUIMos.btnUltimo)
			{
				i = mod.getAlmacenSize() - 1;
				mostrar(i);
				GUIMos.btnBorrar.setEnabled(true);
				GUIMos.btnEditar.setEnabled(true);
				GUIMos.btnSig.setEnabled(false);
				if(mod.getAlmacenSize() > 1)
				{
					GUIMos.btnAnt.setEnabled(true);
					if(!GUIMos.btnPrimero.isEnabled())
					{
						GUIMos.btnPrimero.setEnabled(true);
					}
				}
				else
				{
					GUIMos.btnAnt.setEnabled(false);
					
				}
				GUIMos.btnUltimo.setEnabled(false);		}
			else if(e.getSource() == GUIMos.btnAnt) // <<
			{
				if(mod.getAlmacenSize() > 1)
				{
					i--;
					mostrar(i);
					GUIMos.btnSig.setEnabled(true);
					if(i == 0)
					{
						if(GUIMos.btnPrimero.isEnabled())
						{
							GUIMos.btnPrimero.setEnabled(false);
						}
						GUIMos.btnAnt.setEnabled(false);
					}
					
					if(!GUIMos.btnUltimo.isEnabled())
					{
						GUIMos.btnUltimo.setEnabled(true);
					}
				}
					if(!GUIMos.btnUltimo.isEnabled())
					{
						GUIMos.btnUltimo.setEnabled(true);
					}
				}
			else if(e.getSource() == GUIMos.btnSig) // >>
			{
				if(mod.getAlmacenSize() > 1)
				{
					i++;
					mostrar(i);
					GUIMos.btnAnt.setEnabled(true);
					if(i == mod.getAlmacenSize() - 1)
					{
						if(GUIMos.btnUltimo.isEnabled())
						{
							GUIMos.btnUltimo.setEnabled(false);
						}
						GUIMos.btnSig.setEnabled(false);
					}
					
					if(!GUIMos.btnPrimero.isEnabled())
					{
						GUIMos.btnPrimero.setEnabled(true);
					}
				}
			}
			else if(e.getSource() == GUIMos.btnEditar)
			{
				GUIMos.btnActualizar.setEnabled(true);
				GUIMos.btnPrimero.setEnabled(false);
				GUIMos.btnUltimo.setEnabled(false);
				GUIMos.btnSalir.setEnabled(false);
				GUIMos.btnAnt.setEnabled(false);
				GUIMos.btnSig.setEnabled(false);
				GUIMos.btnBorrar.setEnabled(false);
				sustituir(GUIMos.InventarioTextField, GUIMos.NombreTextField, GUIMos.PrecioTextField, GUIMos.IdTextField, GUIMos.CategoriaTextField);
				GUIMos.IdTextField.setEditable(true);
				GUIMos.NombreTextField.setEditable(true);
				GUIMos.CategoriaTextField.setEditable(true);
				GUIMos.PrecioTextField.setEditable(true);
				GUIMos.InventarioTextField.setEditable(true);
			}
			else if(e.getSource() == GUIMos.btnBorrar)
			{
				mod.AlmacenRemove(i);
				sustituir(GUIMos.IdTextField, GUIMos.NombreTextField, GUIMos.CategoriaTextField, GUIMos.PrecioTextField, GUIMos.InventarioTextField);
				JOptionPane.showMessageDialog(null, "Juguete eliminado exitosamente");
				GUIMos.btnBorrar.setEnabled(false);
				GUIMos.btnAnt.setEnabled(false);
				GUIMos.btnSig.setEnabled(false);
				GUIMos.btnEditar.setEnabled(false);
				GUIMos.btnPrimero.setEnabled(true);
				GUIMos.btnUltimo.setEnabled(true);
			}
			else if(e.getSource() == GUIMos.btnActualizar)
			{
				Articulo A = mod.AlmacenGet(i);
				A.setCve_art(Integer.parseInt(GUIMos.IdTextField.getText()));
				A.setNom_art(GUIMos.NombreTextField.getText());
				A.setCat_art(GUIMos.CategoriaTextField.getText());
				A.setPre_art(Float.parseFloat(GUIMos.PrecioTextField.getText()));
				A.setInv_art(Integer.parseInt(GUIMos.InventarioTextField.getText()));
				
				JOptionPane.showMessageDialog(null, "Juguete actualizado exitosamente");
				
				GUIMos.btnPrimero.setEnabled(true);
				GUIMos.btnUltimo.setEnabled(true);
				GUIMos.btnSalir.setEnabled(true);
				GUIMos.btnActualizar.setEnabled(false);
				
				GUIMos.IdTextField.setEditable(false);
				GUIMos.NombreTextField.setEditable(false);
				GUIMos.CategoriaTextField.setEditable(false);
				GUIMos.	PrecioTextField.setEditable(false);
				GUIMos.InventarioTextField.setEditable(false);
			}
			else if(e.getSource() == GUIMos.btnSalir) 
			{
				GUIMos.dispose();
				GUI.setVisible(true);
			}
		}
		else if(e.getSource() == GUIMos.btnSalir) 
		{
			GUIMos.dispose();
			GUI.setVisible(true);
		}
	}
			
	public void sustituir(JTextField A, JTextField B, JTextField C, JTextField D, JTextField E)
	{
		A.setText("");
		B.setText("");
		C.setText("");
		D.setText("");
		E.setText("");
	}
	
	void mostrar(int i)
	{
		Articulo A = mod.AlmacenGet(i);
		GUIMos.IdTextField.setText(""+A.getCve_art());
		GUIMos.NombreTextField.setText(A.getNom_art());
		GUIMos.CategoriaTextField.setText(A.getCat_art());
		GUIMos.PrecioTextField.setText(""+A.getPre_art());
		GUIMos.InventarioTextField.setText(""+A.getInv_art());
	}
}
