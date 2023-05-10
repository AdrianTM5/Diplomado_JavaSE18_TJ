package mx.com.cursodia.jse18.mod2.sem1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
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
	Connection con;
	
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
				Statement st = null;
				ResultSet rs = null;
				try 
				{
								
					st = con.createStatement();
					rs = st.executeQuery("SELECT * FROM articulo");
					convertirDatos(rs, (short) 0);
					st.close();
					rs.close();
					
					st = con.createStatement();
					rs = st.executeQuery("SELECT * FROM proveedores");
					convertirDatos(rs, (short) 1);
					}
					catch (SQLException e1) 
					{
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					finally
					{
						try 
						{
							if(st != null) st.close();
							if(rs != null) rs.close();
						} 
						catch (SQLException e1) 
						{
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						GUI.dispose();
						GUIMosA.setVisible(true);
					}
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
			GUIMosA.btnPrimero.setEnabled(true);
			GUIMosA.btnUltimo.setEnabled(true);
			GUIMosA.btnActualizar.setEnabled(false);
			GUIMosA.btnEditar.setEnabled(false);
			GUIMosA.btnBorrar.setEnabled(false);
			GUIMosA.btnAnt.setEnabled(false);
			GUIMosA.btnSig.setEnabled(false);
		}
		else if(e.getSource() == GUIMosA.MI_Proveedor_M || e.getSource() == GUIRegA.MI_Proveedor_M || e.getSource() == GUIMosP.MI_Proveedor_M || e.getSource() == GUIRegP.MI_Proveedor_M)
			//Boton mostrar proveedor
		{
			if(GUIRegA.isVisible()) GUIRegA.setVisible(false);
			else if(GUIMosA.isVisible()) GUIMosA.setVisible(false);
			else if(GUIRegP.isVisible()) GUIRegP.setVisible(false);
			
			GUIMosP.setVisible(true);
			GUIMosP.MI_Proveedor_M.setSelected(true);
			GUIMosP.btnPrimero.setEnabled(true);
			GUIMosP.btnUltimo.setEnabled(true);
			GUIMosP.btnActualizar.setEnabled(false);
			GUIMosP.btnEditar.setEnabled(false);
			GUIMosP.btnBorrar.setEnabled(false);
			GUIMosP.btnAnt.setEnabled(false);
			GUIMosP.btnSig.setEnabled(false);
		}
		//------------Registrar------------------
		int cve, inv, prov;  
		String cat, nom, tel, email, dir;;
		float pre;
		short s = 0;
		if(e.getSource() == GUIRegA.btnAgregar || e.getSource() == GUIRegP.btnAgregar)
		{
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
			else if(e.getSource() == GUIRegP.btnAgregar)
			{
				nom = GUIRegP.NombreTextField.getText();
				tel = GUIRegP.TelefonoTextField.getText();
				email = GUIRegP.EmailTextField.getText();
				dir = GUIRegP.DireccionTextField.getText();
				mod.AlmacenPAdd(nom, tel, email, dir);
				
				sustituir(GUIRegP.NombreTextField, GUIRegP.TelefonoTextField, GUIRegP.EmailTextField, GUIRegP.DireccionTextField);
				JOptionPane.showMessageDialog(null, "Proveedor agregado exitosamente");
			}
		}
		//------------Mostrar------------------
		if(e.getSource() == GUIMosA.btnPrimero || e.getSource() == GUIMosP.btnPrimero)
		{
			i = 0;
			if(e.getSource() == GUIMosA.btnPrimero)
			{
				s = 0;
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
			else if(e.getSource() == GUIMosP.btnPrimero)
			{
				s = 1;
				GUIMosP.btnAnt.setEnabled(false);
				GUIMosP.btnBorrar.setEnabled(true);
				GUIMosP.btnEditar.setEnabled(true);
				if(mod.AlmacenP.size() > 1)
				{
					GUIMosP.btnSig.setEnabled(true);
					if(!GUIMosP.btnUltimo.isEnabled())
					{
						GUIMosP.btnUltimo.setEnabled(true);
					}
				}
				else
				{
					GUIMosP.btnSig.setEnabled(false);
						
				}
				GUIMosP.btnPrimero.setEnabled(false);
			}
			mostrar(i, (short) 1, s);
		}
		else if(e.getSource() == GUIMosA.btnUltimo || e.getSource() == GUIMosP.btnUltimo)
		{
			if(e.getSource() == GUIMosA.btnUltimo)
			{
				s = 0;
				GUIMosA.btnBorrar.setEnabled(true);
				GUIMosA.btnEditar.setEnabled(true);
				GUIMosA.btnSig.setEnabled(false);
				if(mod.Almacen.size() == 1)
				{
					i = mod.Almacen.size();
				}
				else if(mod.Almacen.size() > 1)
				{
					i = mod.Almacen.size() - 1;	
				}
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
				GUIMosA.btnUltimo.setEnabled(false);	
			}
			if(e.getSource() == GUIMosP.btnUltimo)
			{
				s = 1;
				GUIMosP.btnBorrar.setEnabled(true);
				GUIMosP.btnEditar.setEnabled(true);
				GUIMosP.btnSig.setEnabled(false);
				if(mod.AlmacenP.size() == 1)
				{
					i = mod.AlmacenP.size();
				}
				else if(mod.AlmacenP.size() > 1)
				{
					i = mod.AlmacenP.size() - 1;	
				}
				if(mod.AlmacenP.size() > 1)
				{
					GUIMosP.btnAnt.setEnabled(true);
					if(!GUIMosP.btnPrimero.isEnabled())
					{
						GUIMosP.btnPrimero.setEnabled(true);
					}
				}
				else
				{
					GUIMosP.btnAnt.setEnabled(false);
						
				}
				GUIMosP.btnUltimo.setEnabled(false);
			}
			mostrar(i, (short) 2, s);
		}
		else if(e.getSource() == GUIMosA.btnAnt || e.getSource() == GUIMosP.btnAnt) // <<
		{
			if(e.getSource() == GUIMosA.btnAnt)
			{
				s = 0;
				if(mod.Almacen.size() > 1)
				{
					i--;
					GUIMosA.btnSig.setEnabled(true);
					if(i == 0)
					{
						if(GUIMosA.btnPrimero.isEnabled())
						{
							GUIMosA.btnPrimero.setEnabled(false);
						}
						GUIMosA.btnAnt.setEnabled(false);
					}
				}
				if(!GUIMosA.btnUltimo.isEnabled())
				{
					GUIMosA.btnUltimo.setEnabled(true);
				}
			}
			else if(e.getSource() == GUIMosP.btnAnt)
			{
				s = 1;
				if(mod.AlmacenP.size() > 1)
				{
					i--;
					GUIMosP.btnSig.setEnabled(true);
					if(i == 0)
					{
						if(GUIMosP.btnPrimero.isEnabled())
						{
							GUIMosP.btnPrimero.setEnabled(false);
						}
						GUIMosP.btnAnt.setEnabled(false);
					}
				}
				if(!GUIMosP.btnUltimo.isEnabled())
				{
					GUIMosP.btnUltimo.setEnabled(true);
				}
			}
			mostrar(i, (short) 2, s);
		}
		else if(e.getSource() == GUIMosA.btnSig || e.getSource() == GUIMosP.btnSig) // >>
		{
			if(e.getSource() == GUIMosA.btnSig)
			{
				s = 0;
				if(mod.Almacen.size() > 1)
				{
					i++;
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
			else if(e.getSource() == GUIMosP.btnSig)
			{
				s = 1;
				if(mod.AlmacenP.size() > 1)
				{
					i++;
					GUIMosP.btnAnt.setEnabled(true);
					if(i == mod.AlmacenP.size() - 1)
					{
						if(GUIMosP.btnUltimo.isEnabled())
						{
							GUIMosP.btnUltimo.setEnabled(false);
						}
						GUIMosP.btnSig.setEnabled(false);
					}
					if(!GUIMosP.btnPrimero.isEnabled())
					{
						GUIMosP.btnPrimero.setEnabled(true);
					}
				}
			}
			mostrar(i, (short) 1, s);
		}
		else if(e.getSource() == GUIMosA.btnEditar || e.getSource() == GUIMosP.btnEditar)
		{
			if(e.getSource() == GUIMosA.btnEditar)
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
			else if(e.getSource() == GUIMosP.btnEditar)
			{
				GUIMosP.btnActualizar.setEnabled(true);
				GUIMosP.btnPrimero.setEnabled(false);
				GUIMosP.btnUltimo.setEnabled(false);
				GUIMosP.btnAnt.setEnabled(false);
				GUIMosP.btnSig.setEnabled(false);
				GUIMosP.btnBorrar.setEnabled(false);
				sustituir(GUIMosP.NombreTextField, GUIMosP.TelefonoTextField, GUIMosP.EmailTextField, GUIMosP.DireccionTextField, GUIMosP.DireccionTextField, GUIMosP.DireccionTextField);
				GUIMosA.IdTextField.setEditable(false);
				GUIMosA.NombreTextField.setEditable(true);
				GUIMosA.CategoriaTextField.setEditable(true);
				GUIMosA.PrecioTextField.setEditable(true);
				GUIMosA.InventarioTextField.setEditable(true);
				GUIMosA.ProveedorTextField.setEditable(true);
			}
		}
		else if(e.getSource() == GUIMosA.btnBorrar || e.getSource() == GUIMosP.btnBorrar)
		{
			if(e.getSource() == GUIMosA.btnBorrar)
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
			else if(e.getSource() == GUIMosP.btnBorrar)
			{
				if(!mod.AlmacenP.isEmpty())
				{
					mod.AlmacenP.remove(i);
					
					sustituir(GUIMosP.IdTextField, GUIMosP.NombreTextField, GUIMosP.TelefonoTextField, GUIMosP.EmailTextField, GUIMosP.DireccionTextField, GUIMosP.DireccionTextField);
					JOptionPane.showMessageDialog(null, "Juguete eliminado exitosamente");
					GUIMosP.btnBorrar.setEnabled(false);
					GUIMosP.btnAnt.setEnabled(false);
					GUIMosP.btnSig.setEnabled(false);
					GUIMosP.btnEditar.setEnabled(false);
				}
				if(mod.AlmacenP.size() == 0)
				{
					GUIMosP.btnPrimero.setEnabled(false);
					GUIMosP.btnUltimo.setEnabled(false);
				}
				else
				{
					GUIMosP.btnPrimero.setEnabled(true);
					GUIMosP.btnUltimo.setEnabled(true);
				}
			}
			
		}
		else if(e.getSource() == GUIMosA.btnActualizar || e.getSource() == GUIMosP.btnActualizar)
		{
			if(e.getSource() == GUIMosA.btnActualizar)
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
			else if(e.getSource() == GUIMosP.btnActualizar)
			{
				cve = Integer.parseInt(GUIMosP.IdTextField.getText());
				nom = GUIMosP.NombreTextField.getText();
				tel = GUIMosP.TelefonoTextField.getText();
				email = GUIMosP.EmailTextField.getText();
				dir = GUIMosP.DireccionTextField.getText();
				
				mod.AlmacenP.get(i).setCve_prov(cve);
				mod.AlmacenP.get(i).setNom_prov(nom);
				mod.AlmacenP.get(i).setTel_prov(tel);
				mod.AlmacenP.get(i).setEmail_prov(email);
				mod.AlmacenP.get(i).setDir_prov(dir);
				
				JOptionPane.showMessageDialog(null, "Juguete actualizado exitosamente");
				
				GUIMosP.btnPrimero.setEnabled(true);
				GUIMosP.btnUltimo.setEnabled(true);
				GUIMosP.btnActualizar.setEnabled(false);
					
				GUIMosP.IdTextField.setEditable(false);
				GUIMosP.NombreTextField.setEditable(false);
				GUIMosP.TelefonoTextField.setEditable(false);
				GUIMosP.EmailTextField.setEditable(false);
				GUIMosP.DireccionTextField.setEditable(false);
			}
		}
	}
	
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
	
	private void sustituir(JTextField A, JTextField B, JTextField C, JTextField D)
	{
		A.setText("");
		B.setText("");
		C.setText("");
		D.setText("");
	}
	
	Object B;
	private void mostrar(int i, short op, short op2)
	{
		switch(op2)
		{
			case 0:
			{	Articulo A;
				A = mod.Almacen.get(i);
				B = A;
				break;
			}
			case 1:
			{
				Proveedor A;
				A = mod.AlmacenP.get(i);
				B = A;
				break;
			}
		}
		while(B == null)
		{
			if(B == null)
			{
				switch(op)
				{
					case 1: i++;  break; //para >>
					case 2: i--;  break; //para <<
					case 3: break;
				}
			}
		}
		switch(op2)
		{
			case 0: //Articulo
			{
				B = mod.Almacen.get(i);

				
				GUIMosA.IdTextField.setText(""+((Articulo) B).getCve_art());
				GUIMosA.NombreTextField.setText(((Articulo) B).getNom_art());
				GUIMosA.CategoriaTextField.setText(((Articulo) B).getCat_art());
				GUIMosA.PrecioTextField.setText(""+((Articulo) B).getPre_art());
				GUIMosA.InventarioTextField.setText(""+((Articulo) B).getInv_art());
				GUIMosA.ProveedorTextField.setText(""+((Articulo) B).getProv_art());
				break;
			}
			case 1: //Proveedor
			{
				B = mod.AlmacenP.get(i);
				
				GUIMosP.IdTextField.setText(""+((Proveedor) B).getCve_prov());
				GUIMosP.NombreTextField.setText(((Proveedor) B).getNom_prov());
				GUIMosP.TelefonoTextField.setText(((Proveedor) B).getTel_prov());
				GUIMosP.EmailTextField.setText(""+((Proveedor) B).getEmail_prov());
				GUIMosP.DireccionTextField.setText(""+((Proveedor) B).getDir_prov());
				break;
			}
		}
	}
	
	private void convertirDatos(ResultSet rs, short op)
	{
		switch(op)
		{
			case 0: //para articulo
			{
				if(!mod.Almacen.isEmpty())
				{
					mod.Almacen.clear();
				}
				try {
					while(rs.next())
					{
						int cve = rs.getInt("cve_art");
						String cat = rs.getString("cat_art");
						String nom = rs.getString("nom_art");
						float pre = rs.getFloat("pre_art");
						int inv = rs.getInt("inv_art");
						int prov = rs.getInt("cveprov_art");
						
						Articulo art = new Articulo(cve, cat, nom, pre, inv, prov);
						mod.Almacen.add(art);
					}
				} 
				catch (SQLException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			case 1: //para proveedor
			{
				if(!mod.AlmacenP.isEmpty())
				{
					mod.AlmacenP.clear();
				}
				try {
					while(rs.next())
					{
						int cve = rs.getInt("cve_prov");
						String nom = rs.getString("nom_prov");
						String tel = rs.getString("tel_prov");
						String email = rs.getString("email_prov");
						String dir = rs.getString("dir_prov");
						
						Proveedor prov = new Proveedor(cve, nom, tel, email, dir);
						mod.AlmacenP.add(prov);
					}
				} 
				catch (SQLException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}