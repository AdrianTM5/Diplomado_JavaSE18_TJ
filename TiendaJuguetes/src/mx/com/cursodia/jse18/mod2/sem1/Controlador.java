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
	int valores = 0;
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
			
			getTableSize();
			if(valores != 0)
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
					cve = Integer.parseInt(GUIReg.IdTextField.getText());
					cat = GUIReg.CategoriaTextField.getText();
					nom = GUIReg.NombreTextField.getText();
					pre = Float.parseFloat(GUIReg.PrecioTextField.getText());
					inv = Integer.parseInt(GUIReg.InventarioTextField.getText());
					
					String query = "INSERT INTO articulo (cve_art,cat_art,nom_art,pre_art,inv_art) "
							+ "VALUES (?,?,?,?,?)";
					PreparedStatement pstm = null;
					try 
					{
						pstm = con.prepareStatement(query);
						pstm.setInt(1, cve);
						pstm.setString(2, cat);
						pstm.setString(3, nom);
						pstm.setFloat(4, pre);
						pstm.setInt(5, inv);
						
						pstm.execute();
					}
					catch (SQLException e1) 
					{
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					finally
					{
						if(pstm != null)
							try 
							{
								pstm.close();
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
		if(e.getSource() == GUIMos.btnPrimero)
		{
			i = 1;
			mostrar(i);
			GUIMos.btnAnt.setEnabled(false);
			GUIMos.btnBorrar.setEnabled(true);
			GUIMos.btnEditar.setEnabled(true);
			getTableSize();
			if(valores > 1)
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
			getTableSize();
			i = valores;
			mostrar(i);
			GUIMos.btnBorrar.setEnabled(true);
			GUIMos.btnEditar.setEnabled(true);
			GUIMos.btnSig.setEnabled(false);
			if(valores > 1)
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
			getTableSize();
			if(valores > 1)
			{
				i--;
				mostrar(i);
				GUIMos.btnSig.setEnabled(true);
				if(i == 1)
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
			getTableSize();
			if(valores > 1)
			{
				i++;
				mostrar(i);
				GUIMos.btnAnt.setEnabled(true);
				if(i == valores)
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
			PreparedStatement pstm = null;
			
			try 
			{
				pstm = con.prepareStatement("DELETE FROM articulo WHERE cve_art ="+i);
				pstm.executeUpdate();
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
			getTableSize();
			if(valores == 0)
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
			
			try 
			{
				cve = Integer.parseInt(GUIMos.IdTextField.getText());
				cat = GUIMos.CategoriaTextField.getText();
				nom = GUIMos.NombreTextField.getText();
				pre = Float.parseFloat(GUIMos.PrecioTextField.getText());
				inv = Integer.parseInt(GUIMos.InventarioTextField.getText());
				
				String query = "UPDATE articulo "
						+ "SET cve_art = ?, cat_art = ?, nom_art = ?, pre_art = ?, inv_art = ? WHERE cve_art ="+i;
				pstm = null;
				
				pstm = con.prepareStatement(query);
				pstm.setInt(1, cve);
				pstm.setString(2, cat);
				pstm.setString(3, nom);
				pstm.setFloat(4, pre);
				pstm.setInt(5, inv);
				
				pstm.execute();	
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
				} 
				catch (SQLException e1) 
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
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
			System.out.println("Conexion exisota!");
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
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try 
		{
			pstm = con.prepareStatement("SELECT * FROM articulo WHERE cve_art ="+i);
			rs = pstm.executeQuery();
			
			while(rs.next())
			{
				GUIMos.IdTextField.setText(rs.getInt("cve_art")+"");
				GUIMos.NombreTextField.setText(rs.getString("nom_art"));
				GUIMos.CategoriaTextField.setText(rs.getString("cat_art"));
				GUIMos.PrecioTextField.setText(rs.getFloat("pre_art")+"");
				GUIMos.InventarioTextField.setText(rs.getInt("inv_art")+"");
			}
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				if(rs != null) rs.close();
				if(pstm != null) pstm.close();
			} 
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private int getTableSize()
	{
		if(con != null)
		{
			try 
			 {
				stat = con.createStatement();
				rset = stat.executeQuery("SELECT COUNT(*) FROM articulo");
				rset.next();
				valores = rset.getInt(1);
			 } 
			 catch (SQLException e1) 
			 {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			 }
		}
		return valores;
	}
}
