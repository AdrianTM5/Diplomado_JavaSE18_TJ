package mx.com.cursodia.jse18.mod2.sem1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Controlador implements ActionListener
{
	Modelo mod;
	GUI GUI;
	GUIReg_A GUIRegA;
	GUIMos_A GUIMosA;
	GUIMos_P GUIMosP;
	GUIReg_P GUIRegP;
	private ButtonGroup bg = new ButtonGroup();
	
	
	public Controlador(Modelo mode, GUI gui, GUIReg_A regA, GUIMos_A mosA, GUIMos_P mosP, GUIReg_P regP) 
	{
		this.mod = mode;
		this.GUI = gui;
		this.GUIRegA = regA;
		this.GUIMosA = mosA;
		this.GUIMosP = mosP;
		this.GUIRegP = regP;
		inicializar();
	}
	
	private void inicializar()
	{
		if(con != null)
		{
			GUIRegA.lanzar();
			GUIMosA.lanzar();
			GUIMosP.lanzar();
			GUIRegP.lanzar();
			while(GUIMosA.ThreadM.isAlive() == true && GUIRegA.ThreadR.isAlive() == true && GUIMosP.ThreadM.isAlive() == true && GUIRegP.ThreadR.isAlive() == true)
			{
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		//------------JMenuBar------------------
		GUIMosA.MI_Articulo_A.addActionListener(this);
		GUIMosA.MI_Proveedor_A.addActionListener(this);
		GUIMosA.MI_Articulo_M.addActionListener(this);
		GUIMosA.MI_Proveedor_M.addActionListener(this);
		bg.add(GUIMosA.MI_Articulo_A);
		bg.add(GUIMosA.MI_Proveedor_A);
		bg.add(GUIMosA.MI_Articulo_M);
		bg.add(GUIMosA.MI_Proveedor_M);
		GUIRegA.MI_Articulo_A.addActionListener(this);
		GUIRegA.MI_Proveedor_A.addActionListener(this);
		GUIRegA.MI_Articulo_M.addActionListener(this);
		GUIRegA.MI_Proveedor_M.addActionListener(this);
		bg.add(GUIRegA.MI_Articulo_A);
		bg.add(GUIRegA.MI_Proveedor_A);
		bg.add(GUIRegA.MI_Articulo_M);
		bg.add(GUIRegA.MI_Proveedor_M);
		GUIMosP.MI_Articulo_A.addActionListener(this);
		GUIMosP.MI_Proveedor_A.addActionListener(this);
		GUIMosP.MI_Articulo_M.addActionListener(this);
		GUIMosP.MI_Proveedor_M.addActionListener(this);
		bg.add(GUIMosP.MI_Articulo_A);
		bg.add(GUIMosP.MI_Proveedor_A);
		bg.add(GUIMosP.MI_Articulo_M);
		bg.add(GUIMosP.MI_Proveedor_M);
		GUIRegP.MI_Articulo_A.addActionListener(this);
		GUIRegP.MI_Proveedor_A.addActionListener(this);
		GUIRegP.MI_Articulo_M.addActionListener(this);
		GUIRegP.MI_Proveedor_M.addActionListener(this);
		bg.add(GUIRegP.MI_Articulo_A);
		bg.add(GUIRegP.MI_Proveedor_A);
		bg.add(GUIRegP.MI_Articulo_M);
		bg.add(GUIRegP.MI_Proveedor_M);
		
		//------------GUI------------------
		GUI.setVisible(true);
		GUI.setResizable(false);
		GUI.btnEnviar.addActionListener(this);
		//------------RegistrarA------------------
		GUIRegA.setVisible(false);
		GUIRegA.setResizable(false);
		GUIRegA.btnAgregar.addActionListener(this);
		//------------MostrarA------------------
		GUIMosA.setVisible(false);
		GUIMosA.setResizable(false);
		GUIMosA.btnPrimero.addActionListener(this);
		GUIMosA.btnUltimo.addActionListener(this);
		GUIMosA.btnSig.addActionListener(this);
		GUIMosA.btnAnt.addActionListener(this);
		GUIMosA.btnEditar.addActionListener(this);
		GUIMosA.btnActualizar.addActionListener(this);
		GUIMosA.btnBorrar.addActionListener(this);
		//------------RegistrarP------------------
		GUIRegP.setVisible(false);
		GUIRegP.setResizable(false);
		GUIRegP.btnAgregar.addActionListener(this);
		//------------MostrarP------------------
		GUIMosP.setVisible(false);
		GUIMosP.setResizable(false);
		GUIMosP.btnPrimero.addActionListener(this);
		GUIMosP.btnUltimo.addActionListener(this);
		GUIMosP.btnSig.addActionListener(this);
		GUIMosP.btnAnt.addActionListener(this);
		GUIMosP.btnEditar.addActionListener(this);
		GUIMosP.btnActualizar.addActionListener(this);
		GUIMosP.btnBorrar.addActionListener(this);
	}
		
	@SuppressWarnings("static-access")
	int i = 0;
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		//------------GUI------------------
		if(e.getSource() == GUI.btnEnviar)
		{
			String usr, pw;
			usr = GUI.UsuarioTextField.getText();
			pw = GUI.PasswordField.getText();
			
			conectar(usr, pw);
			if(con != null)
			{
				GUI.dispose();
				GUIMosA.setVisible(true);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Datos erroneos.", "Error", JOptionPane.ERROR_MESSAGE);

			}
		}
		//------------JMenuBar------------------
		if(e.getSource() == GUIMosA.MI_Articulo_A || e.getSource() == GUIRegA.MI_Articulo_A || e.getSource() == GUIMosP.MI_Articulo_A || e.getSource() == GUIRegP.MI_Articulo_A )
			//Boton agregar articulo
		{
			if(GUIMosA.isVisible()) GUIMosA.setVisible(false);
			else if(GUIMosP.isVisible()) GUIMosP.setVisible(false);
			else if(GUIRegP.isVisible()) GUIRegP.setVisible(false);
			
			GUIRegA.setVisible(true);
			GUIRegA.MI_Articulo_A.setSelected(true);
		}
		else if(e.getSource() == GUIMosA.MI_Proveedor_A || e.getSource() == GUIRegA.MI_Proveedor_A || e.getSource() == GUIMosP.MI_Proveedor_A || e.getSource() == GUIRegP.MI_Proveedor_A)
			// Boton agregar proveedor
		{
			if(GUIRegA.isVisible()) GUIRegA.setVisible(false);
			else if(GUIMosA.isVisible()) GUIMosA.setVisible(false);
			else if(GUIMosP.isVisible()) GUIMosP.setVisible(false);
			
			GUIRegP.setVisible(true);
			GUIRegP.MI_Proveedor_A.setSelected(true);
		}
		else if(e.getSource() == GUIMosA.MI_Articulo_M || e.getSource() == GUIRegA.MI_Articulo_M || e.getSource() == GUIMosP.MI_Articulo_M || e.getSource() == GUIRegP.MI_Articulo_M)
			//Boton mostrar articulo
		{
			if(GUIRegA.isVisible()) GUIRegA.setVisible(false);
			else if(GUIMosP.isVisible()) GUIMosP.setVisible(false);
			else if(GUIRegP.isVisible()) GUIRegP.setVisible(false);
			
			GUIMosA.setVisible(true);
			GUIMosA.MI_Articulo_M.setSelected(true);
		}
		else if(e.getSource() == GUIMosA.MI_Proveedor_M || e.getSource() == GUIRegA.MI_Proveedor_M || e.getSource() == GUIMosP.MI_Proveedor_M || e.getSource() == GUIRegP.MI_Proveedor_M)
			//Boton mostrar proveedor
		{
			if(GUIRegA.isVisible()) GUIRegA.setVisible(false);
			else if(GUIMosA.isVisible()) GUIMosA.setVisible(false);
			else if(GUIRegP.isVisible()) GUIRegP.setVisible(false);
			
			GUIMosP.setVisible(true);
			GUIMosP.MI_Proveedor_M.setSelected(true);
		}
		//------------Registrar------------------
		int cve, inv, prov;  
		String cat, nom;
		float pre;
		if(e.getSource() == GUIRegA.btnAgregar)
		{
				cat = GUIRegA.CategoriaTextField.getText();
				nom = GUIRegA.NombreTextField.getText();
				pre = Float.parseFloat(GUIRegA.PrecioTextField.getText());
				inv = Integer.parseInt(GUIRegA.InventarioTextField.getText());
				prov = Integer.parseInt(GUIRegA.ProveedorTextField.getText());
				mod.AlmacenAdd(cat, nom, pre, inv, prov);
				
				sustituir(GUIRegA.IdTextField, GUIRegA.NombreTextField, GUIRegA.CategoriaTextField, GUIRegA.PrecioTextField, GUIRegA.InventarioTextField, GUIRegA.ProveedorTextField);
				JOptionPane.showMessageDialog(null, "Juguete agregado exitosamente");
		}
		//------------Mostrar------------------
		short s;
		if(e.getSource() == GUIMosA.btnPrimero)
		{
			i = 0;
			s = 1;
			mostrar(i, s);
			GUIMosA.btnAnt.setEnabled(false);
			GUIMosA.btnBorrar.setEnabled(true);
			GUIMosA.btnEditar.setEnabled(true);
			if(mod.Almacen.size() > 1)
			{
				GUIMosA.btnSig.setEnabled(true);
				if(!GUIMosA.btnUltimo.isEnabled())
				{
					GUIMosA.btnUltimo.setEnabled(true);
				}
			}
			else
			{
				GUIMosA.btnSig.setEnabled(false);
					
			}
			GUIMosA.btnPrimero.setEnabled(false);
		}
		else if(e.getSource() == GUIMosA.btnUltimo)
		{
			if(mod.Almacen.size() == 1)
			{
				i = mod.Almacen.size();
			}
			else if(mod.Almacen.size() > 1)
			{
				i = mod.Almacen.size() - 1;	
			}
			s = 2;
			mostrar(i,s);
			GUIMosA.btnBorrar.setEnabled(true);
			GUIMosA.btnEditar.setEnabled(true);
			GUIMosA.btnSig.setEnabled(false);
			if(mod.Almacen.size() > 1)
			{
				GUIMosA.btnAnt.setEnabled(true);
				if(!GUIMosA.btnPrimero.isEnabled())
				{
					GUIMosA.btnPrimero.setEnabled(true);
				}
			}
			else
			{
				GUIMosA.btnAnt.setEnabled(false);
					
			}
			GUIMosA.btnUltimo.setEnabled(false);		}
		else if(e.getSource() == GUIMosA.btnAnt) // <<
		{
			if(mod.Almacen.size() > 1)
			{
				i--;
				s = 2;
				mostrar(i, s);
				GUIMosA.btnSig.setEnabled(true);
				if(i == 0)
				{
					if(GUIMosA.btnPrimero.isEnabled())
					{
						GUIMosA.btnPrimero.setEnabled(false);
					}
					GUIMosA.btnAnt.setEnabled(false);
				}
				if(!GUIMosA.btnUltimo.isEnabled())
				{
					GUIMosA.btnUltimo.setEnabled(true);
				}
			}
			if(!GUIMosA.btnUltimo.isEnabled())
			{
				GUIMosA.btnUltimo.setEnabled(true);
			}
		}
		else if(e.getSource() == GUIMosA.btnSig) // >>
		{
			if(mod.Almacen.size() > 1)
			{
				i++;
				s = 1;
				mostrar(i, s);
				GUIMosA.btnAnt.setEnabled(true);
				if(i == mod.Almacen.size() - 1)
				{
					if(GUIMosA.btnUltimo.isEnabled())
					{
						GUIMosA.btnUltimo.setEnabled(false);
					}
					GUIMosA.btnSig.setEnabled(false);
				}
				if(!GUIMosA.btnPrimero.isEnabled())
				{
					GUIMosA.btnPrimero.setEnabled(true);
				}
			}
		}
		else if(e.getSource() == GUIMosA.btnEditar)
		{
			GUIMosA.btnActualizar.setEnabled(true);
			GUIMosA.btnPrimero.setEnabled(false);
			GUIMosA.btnUltimo.setEnabled(false);
			GUIMosA.btnAnt.setEnabled(false);
			GUIMosA.btnSig.setEnabled(false);
			GUIMosA.btnBorrar.setEnabled(false);
			sustituir(GUIMosA.InventarioTextField, GUIMosA.NombreTextField, GUIMosA.PrecioTextField, GUIMosA.PrecioTextField, GUIMosA.CategoriaTextField, GUIMosA.ProveedorTextField);
			GUIMosA.IdTextField.setEditable(false);
			GUIMosA.NombreTextField.setEditable(true);
			GUIMosA.CategoriaTextField.setEditable(true);
			GUIMosA.PrecioTextField.setEditable(true);
			GUIMosA.InventarioTextField.setEditable(true);
			GUIMosA.ProveedorTextField.setEditable(true);
		}
		else if(e.getSource() == GUIMosA.btnBorrar)
		{
			if(!mod.Almacen.isEmpty())
			{
				mod.Almacen.remove(i);
				
				sustituir(GUIMosA.IdTextField, GUIMosA.NombreTextField, GUIMosA.CategoriaTextField, GUIMosA.PrecioTextField, GUIMosA.InventarioTextField, GUIMosA.ProveedorTextField);
				JOptionPane.showMessageDialog(null, "Juguete eliminado exitosamente");
				GUIMosA.btnBorrar.setEnabled(false);
				GUIMosA.btnAnt.setEnabled(false);
				GUIMosA.btnSig.setEnabled(false);
				GUIMosA.btnEditar.setEnabled(false);
			}
			if(mod.Almacen.size() == 0)
			{
				GUIMosA.btnPrimero.setEnabled(false);
				GUIMosA.btnUltimo.setEnabled(false);
			}
			else
			{
				GUIMosA.btnPrimero.setEnabled(true);
				GUIMosA.btnUltimo.setEnabled(true);
			}
		}
		else if(e.getSource() == GUIMosA.btnActualizar)
		{
			cve = Integer.parseInt(GUIMosA.IdTextField.getText());
			cat = GUIMosA.CategoriaTextField.getText();
			nom = GUIMosA.NombreTextField.getText();
			pre = Float.parseFloat(GUIMosA.PrecioTextField.getText());
			inv = Integer.parseInt(GUIMosA.InventarioTextField.getText());
			prov = Integer.parseInt(GUIMosA.ProveedorTextField.getText());
			
			mod.Almacen.get(i).setCve_art(cve);
			mod.Almacen.get(i).setCat_art(cat);
			mod.Almacen.get(i).setNom_art(nom);
			mod.Almacen.get(i).setPre_art(pre);
			mod.Almacen.get(i).setInv_art(inv);
			mod.Almacen.get(i).setProv_art(prov);
			
			JOptionPane.showMessageDialog(null, "Juguete actualizado exitosamente");
			
			GUIMosA.btnPrimero.setEnabled(true);
			GUIMosA.btnUltimo.setEnabled(true);
			GUIMosA.btnActualizar.setEnabled(false);
				
			GUIMosA.IdTextField.setEditable(false);
			GUIMosA.NombreTextField.setEditable(false);
			GUIMosA.CategoriaTextField.setEditable(false);
			GUIMosA.PrecioTextField.setEditable(false);
			GUIMosA.InventarioTextField.setEditable(false);
			GUIMosA.ProveedorTextField.setEditable(false);
		}
	}
	
	Connection con;
	void conectar(String usr, String pw)
	{
		String server = "jdbc:mysql://localhost/tiendajuguetes";
		usr = "Adri_TM5";
		pw = "Mario654321!";
		
		try 
		{
			con = DriverManager.getConnection(server,usr,pw);
			
		} 
		catch (SQLException e) {}
	}
			
	private void sustituir(JTextField A, JTextField B, JTextField C, JTextField D, JTextField E, JTextField F)
	{
		A.setText("");
		B.setText("");
		C.setText("");
		D.setText("");
		E.setText("");
		F.setText("");
	}
	
	private void mostrar(int i, short op)
	{
		Articulo A = mod.Almacen.get(i);
		while(A == null)
		{
			if(A == null)
			{
				switch(op)
				{
					case 1: i++;  break; //para >>
					case 2: i--;  break; //para <<
					case 3: break;
				}
			}
			A = mod.Almacen.get(i);
		}
		GUIMosA.IdTextField.setText(""+A.getCve_art());
		GUIMosA.NombreTextField.setText(A.getNom_art());
		GUIMosA.CategoriaTextField.setText(A.getCat_art());
		GUIMosA.PrecioTextField.setText(""+A.getPre_art());
		GUIMosA.InventarioTextField.setText(""+A.getInv_art());
		GUIMosA.ProveedorTextField.setText(""+A.getProv_art());
	}
}