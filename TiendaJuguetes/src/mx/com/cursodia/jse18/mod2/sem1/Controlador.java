package mx.com.cursodia.jse18.mod2.sem1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
		while(GUI.ThreadI.isAlive() == true && GUIMos.ThreadM.isAlive() == true && GUIReg.ThreadR.isAlive() == true)
		{
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
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
	Statement stat = null;
	ResultSet rset = null;
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
			Statement st = null;
			ResultSet rs = null;
			try 
			{
				
				st = con.createStatement();
				rs = st.executeQuery("SELECT * FROM articulo");
				convertirDatos(rs);
				
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
			}
			if(mod.Almacen.size() != 0)
			{
				GUI.dispose();
				GUIMos.setVisible(true);
				GUIMos.setResizable(false);
				GUIMos.btnPrimero.setEnabled(true);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Error, primero registre un juguete");
			}
		}
		else if(e.getSource() == GUI.btnSalir)
		{
			try 
			{
				if(stat != null) stat.close();
				if(rset != null) rset.close();
				if(con != null)
				{
					con.close(); 
					System.out.println("Desconectado exitosamente!");
				}
			} 
			catch (SQLException e1) 
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.exit(GUI.EXIT_ON_CLOSE);
		}
		//------------Registrar------------------
		int cve, inv;  
		String cat, nom;
		float pre;
		if(e.getSource() == GUIReg.btnAgregar)
		{
			try {
					cat = GUIReg.CategoriaTextField.getText();
					nom = GUIReg.NombreTextField.getText();
					pre = Float.parseFloat(GUIReg.PrecioTextField.getText());
					inv = Integer.parseInt(GUIReg.InventarioTextField.getText());
					
					String query = "INSERT INTO articulo (cat_art,nom_art,pre_art,inv_art) "
							+ "VALUES (?,?,?,?)";
					PreparedStatement pstm = null;
					Statement st = null;
					ResultSet rs = null;
					try 
					{
						pstm = con.prepareStatement(query);
						pstm.setString(1, cat);
						pstm.setString(2, nom);
						pstm.setFloat(3, pre);
						pstm.setInt(4, inv);
						
						pstm.execute();
						
						st = con.createStatement();
						rs = st.executeQuery("SELECT * FROM articulo");
						convertirDatos(rs);
						
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
								if(pstm != null) pstm.close();
								if(st != null) st.close();
								if(rs != null) rs.close();
							} 
							catch (SQLException e1) 
							{
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
					}
					sustituir(GUIReg.IdTextField, GUIReg.NombreTextField, GUIReg.CategoriaTextField, GUIReg.PrecioTextField, GUIReg.InventarioTextField);
					JOptionPane.showMessageDialog(null, "Juguete agregado exitosamente");
				} 
			catch (NumberFormatException e2)
				{
					JOptionPane.showMessageDialog(null, "Favor de llenar todos los campos");
				}
		}
		else if(e.getSource() == GUIReg.btnSalir)
		{
			GUIReg.dispose();
			GUI.setVisible(true);					
		}
		//------------Mostrar------------------
		short s;
		if(e.getSource() == GUIMos.btnPrimero)
		{
			i = 0;
			s = 1;
			mostrar(i, s);
			GUIMos.btnAnt.setEnabled(false);
			GUIMos.btnBorrar.setEnabled(true);
			GUIMos.btnEditar.setEnabled(true);
			if(mod.Almacen.size() > 1)
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
			i = mod.Almacen.size();
			s = 2;
			mostrar(i,s);
			GUIMos.btnBorrar.setEnabled(true);
			GUIMos.btnEditar.setEnabled(true);
			GUIMos.btnSig.setEnabled(false);
			if(mod.Almacen.size() > 1)
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
			if(mod.Almacen.size() > 1)
			{
				i--;
				s = 2;
				mostrar(i, s);
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
			if(mod.Almacen.size() > 1)
			{
				i++;
				s = 1;
				mostrar(i, s);
				GUIMos.btnAnt.setEnabled(true);
				if(i == mod.Almacen.size() - 1)
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
			sustituir(GUIMos.InventarioTextField, GUIMos.NombreTextField, GUIMos.PrecioTextField, GUIMos.PrecioTextField, GUIMos.CategoriaTextField);
			GUIMos.IdTextField.setEditable(false);
			GUIMos.NombreTextField.setEditable(true);
			GUIMos.CategoriaTextField.setEditable(true);
			GUIMos.PrecioTextField.setEditable(true);
			GUIMos.InventarioTextField.setEditable(true);
		}
		else if(e.getSource() == GUIMos.btnBorrar)
		{
			PreparedStatement pstmb = null, pstmt = null;
			ResultSet rs = null;
			Statement st = null;
			
			try 
			{
				pstmt = con.prepareStatement("SELECT * FROM articulo LIMIT 1 OFFSET "+i);
				rs = pstmt.executeQuery();
				rs.next();
				
				pstmb = con.prepareStatement("DELETE FROM articulo WHERE cve_art ="+rs.getInt("cve_art"));
				pstmb.executeUpdate();
				
				if(!mod.Almacen.isEmpty())
				{
					st = con.createStatement();
					rs = st.executeQuery("SELECT * FROM articulo");
					convertirDatos(rs);
				}
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
					if(pstmb != null) pstmb.close();
					if(pstmt != null) pstmt.close();
					if(rs != null) rs.close();
					if(st != null) st.close();
				} 
				catch (SQLException e1) 
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			sustituir(GUIMos.IdTextField, GUIMos.NombreTextField, GUIMos.CategoriaTextField, GUIMos.PrecioTextField, GUIMos.InventarioTextField);
			JOptionPane.showMessageDialog(null, "Juguete eliminado exitosamente");
			GUIMos.btnBorrar.setEnabled(false);
			GUIMos.btnAnt.setEnabled(false);
			GUIMos.btnSig.setEnabled(false);
			GUIMos.btnEditar.setEnabled(false);
			if(mod.Almacen.size() == 0)
			{
				GUIMos.btnPrimero.setEnabled(false);
				GUIMos.btnUltimo.setEnabled(false);
			}
			else
			{
				GUIMos.btnPrimero.setEnabled(true);
				GUIMos.btnUltimo.setEnabled(true);
			}
		}
		else if(e.getSource() == GUIMos.btnActualizar)
		{
			PreparedStatement pstm = null;
			ResultSet rs = null;
			Statement st = null;
			try 
			{
				pstm = con.prepareStatement("SELECT * FROM articulo LIMIT 1 OFFSET "+i);
				rs = pstm.executeQuery();
				rs.next();
				
				cve = Integer.parseInt(GUIMos.IdTextField.getText());
				cat = GUIMos.CategoriaTextField.getText();
				nom = GUIMos.NombreTextField.getText();
				pre = Float.parseFloat(GUIMos.PrecioTextField.getText());
				inv = Integer.parseInt(GUIMos.InventarioTextField.getText());
				
				String query = "UPDATE articulo "
						+ "SET cve_art = ?, cat_art = ?, nom_art = ?, pre_art = ?, inv_art = ? WHERE cve_art ="+rs.getInt("cve_art");
				
				pstm = con.prepareStatement(query);
				pstm.setInt(1, cve);
				pstm.setString(2, cat);
				pstm.setString(3, nom);
				pstm.setFloat(4, pre);
				pstm.setInt(5, inv);
				pstm.executeUpdate();
				pstm.close();
				rs.close();
				
				st = con.createStatement();
				rs = st.executeQuery("SELECT * FROM articulo");
				convertirDatos(rs);
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
					if(pstm != null) pstm.close();
					if(rs != null) rs.close();
				} 
				catch (SQLException e1) 
				{
					// TODO Auto-generated catch block
				}
			}
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
	
	Connection con;
	void conectar()
	{
		String server = "jdbc:mysql://localhost/tiendajuguetes";
		String user = "root"; //modificar despues
		String password = "";
		
		try 
		{
			con = DriverManager.getConnection(server,user,password);
			
		} 
		catch (SQLException e) 
		{
			System.out.println("Error en la conexion");
		}
		if(con != null)
		{
			System.out.println("Conexion exitosa!");
		}
		
	}
			
	private void sustituir(JTextField A, JTextField B, JTextField C, JTextField D, JTextField E)
	{
		A.setText("");
		B.setText("");
		C.setText("");
		D.setText("");
		E.setText("");
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
		GUIMos.IdTextField.setText(""+A.getCve_art());
		GUIMos.NombreTextField.setText(A.getNom_art());
		GUIMos.CategoriaTextField.setText(A.getCat_art());
		GUIMos.PrecioTextField.setText(""+A.getPre_art());
		GUIMos.InventarioTextField.setText(""+A.getInv_art());
	}
	
	private void convertirDatos(ResultSet rs)
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
					
					Articulo art = new Articulo(cve, cat, nom, pre, inv);
					mod.AlmacenAdd(art);
				}
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
