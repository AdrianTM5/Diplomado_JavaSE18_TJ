package mx.com.cursodia.jse18.mod2.sem1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;

public class TJMostrar extends JFrame implements ActionListener
{

	private JPanel contentPane;
	private JTextField IdTextField;
	private JTextField NombreTextField;
	private JTextField CategoriaTextField;
	private JTextField PrecioTextField;
	private JTextField InventarioTextField;
	private JPanel panel;
	private JButton btnPrimero;
	private JButton btnEditar;
	private JButton btnBorrar;
	private JButton btnUltimo;
	private JButton btnSalir;
	private JButton btnAnt;
	private JButton btnSig;
	private JButton btnActualizar;

	/**
	 * Create the frame.
	 */
	public TJMostrar() 
	{
		setTitle("Mostrar Juguetes");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 550, 372);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel Infopanel = new JPanel();
		Infopanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		Infopanel.setBounds(34, 12, 488, 162);
		contentPane.add(Infopanel);
		Infopanel.setLayout(null);
		
		JLabel IdLabel = new JLabel("Id:");
		IdLabel.setBounds(67, 31, 33, 15);
		Infopanel.add(IdLabel);
		
		IdTextField = new JTextField();
		IdTextField.setBounds(93, 29, 114, 19);
		Infopanel.add(IdTextField);
		IdTextField.setEditable(false);
		IdTextField.setColumns(10);
		
		JLabel NombreLabel = new JLabel("Nombre:");
		NombreLabel.setBounds(27, 75, 60, 15);
		Infopanel.add(NombreLabel);
		
		NombreTextField = new JTextField();
		NombreTextField.setColumns(10);
		NombreTextField.setBounds(93, 73, 114, 19);
		NombreTextField.setEditable(false);
		Infopanel.add(NombreTextField);
		
		JLabel CategoriaLabel = new JLabel("Categoria:");
		CategoriaLabel.setBounds(12, 122, 75, 15);
		Infopanel.add(CategoriaLabel);
		
		CategoriaTextField = new JTextField();
		CategoriaTextField.setColumns(10);
		CategoriaTextField.setBounds(93, 120, 114, 19);
		CategoriaTextField.setEditable(false);
		Infopanel.add(CategoriaTextField);
		
		JLabel PrecioLabel = new JLabel("Precio:");
		PrecioLabel.setBounds(284, 29, 49, 15);
		Infopanel.add(PrecioLabel);
		
		PrecioTextField = new JTextField();
		PrecioTextField.setColumns(10);
		PrecioTextField.setBounds(351, 29, 114, 19);
		PrecioTextField.setEditable(false);
		Infopanel.add(PrecioTextField);
		
		JLabel InventarioLabel = new JLabel("Existencias:");
		InventarioLabel.setBounds(254, 122, 84, 15);
		Infopanel.add(InventarioLabel);
		
		InventarioTextField = new JTextField();
		InventarioTextField.setColumns(10);
		InventarioTextField.setBounds(351, 118, 114, 19);
		InventarioTextField.setEditable(false);
		Infopanel.add(InventarioTextField);
		
		panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(34, 186, 487, 139);
		contentPane.add(panel);
		panel.setLayout(null);
		
		btnPrimero = new JButton("Primero");
		btnPrimero.setBounds(12, 26, 117, 25);
		btnPrimero.addActionListener(this);
		panel.add(btnPrimero);
		
		btnEditar = new JButton("Editar");
		btnEditar.setBounds(37, 61, 117, 25);
		btnEditar.addActionListener(this);
		btnEditar.setEnabled(false);
		panel.add(btnEditar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(324, 61, 117, 25);
		btnBorrar.addActionListener(this);
		btnBorrar.setEnabled(false);
		panel.add(btnBorrar);
		
		btnUltimo = new JButton("Ultimo");
		btnUltimo.setBounds(345, 26, 117, 25);
		btnUltimo.addActionListener(this);
		panel.add(btnUltimo);
		
		btnSalir = new JButton("Salir");
		btnSalir.setBounds(177, 26, 117, 25);
		btnSalir.addActionListener(this);
		panel.add(btnSalir);
		
		btnAnt = new JButton("<<");
		btnAnt.setEnabled(false);
		btnAnt.setBounds(124, 98, 117, 25);
		btnAnt.addActionListener(this);
		panel.add(btnAnt);
		
		btnSig = new JButton(">>");
		btnSig.setEnabled(false);
		btnSig.setBounds(240, 98, 117, 25);
		btnSig.addActionListener(this);
		panel.add(btnSig);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setEnabled(false);
		btnActualizar.setBounds(177, 63, 117, 25);
		btnActualizar.addActionListener(this);
		panel.add(btnActualizar);
	}

	int i = 0;
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		TJInicio GUI = new TJInicio();
		if(TJRegistrar.rAlmacen.size() > 0)
		{
			if(e.getSource() == btnPrimero)
			{
				i = 0;
				mostrar(i);
				btnAnt.setEnabled(false);
				btnBorrar.setEnabled(true);
				btnEditar.setEnabled(true);
				if(TJRegistrar.rAlmacen.size() > 1)
				{
					btnSig.setEnabled(true);
					if(!btnUltimo.isEnabled())
					{
						btnUltimo.setEnabled(true);
					}
				}
				else
				{
					btnSig.setEnabled(false);
					
				}
				btnPrimero.setEnabled(false);
			}
			else if(e.getSource() == btnUltimo)
			{
				i = TJRegistrar.rAlmacen.size() - 1;
				mostrar(i);
				btnBorrar.setEnabled(true);
				btnEditar.setEnabled(true);
				btnSig.setEnabled(false);
				if(TJRegistrar.rAlmacen.size() > 1)
				{
					btnAnt.setEnabled(true);
					if(!btnPrimero.isEnabled())
					{
						btnPrimero.setEnabled(true);
					}
				}
				else
				{
					btnAnt.setEnabled(false);
					
				}
				btnUltimo.setEnabled(false);		}
			else if(e.getSource() == btnAnt) // <<
			{
				if(TJRegistrar.rAlmacen.size() > 1)
				{
					i--;
					mostrar(i);
					btnSig.setEnabled(true);
					if(i == 0)
					{
						if(btnPrimero.isEnabled())
						{
							btnPrimero.setEnabled(false);
						}
						btnAnt.setEnabled(false);
					}
					
					if(!btnUltimo.isEnabled())
					{
						btnUltimo.setEnabled(true);
					}
				}
			}
			else if(e.getSource() == btnSig) // >>
			{
				if(TJRegistrar.rAlmacen.size() > 1)
				{
					i++;
					mostrar(i);
					btnAnt.setEnabled(true);
					if(i == TJRegistrar.rAlmacen.size() - 1)
					{
						if(btnUltimo.isEnabled())
						{
							btnUltimo.setEnabled(false);
						}
						btnSig.setEnabled(false);
					}
					
					if(!btnPrimero.isEnabled())
					{
						btnPrimero.setEnabled(true);
					}
				}
			}
			else if(e.getSource() == btnEditar)
			{
				btnActualizar.setEnabled(true);
				btnPrimero.setEnabled(false);
				btnUltimo.setEnabled(false);
				btnSalir.setEnabled(false);
				btnAnt.setEnabled(false);
				btnSig.setEnabled(false);
				btnBorrar.setEnabled(false);
				GUI.sustituir(InventarioTextField, NombreTextField, PrecioTextField, IdTextField, CategoriaTextField);
				IdTextField.setEditable(true);
				NombreTextField.setEditable(true);
				CategoriaTextField.setEditable(true);
				PrecioTextField.setEditable(true);
				InventarioTextField.setEditable(true);
				
				
			}
			else if(e.getSource() == btnBorrar)
			{
				
				TJRegistrar.rAlmacen.remove(i);
				GUI.sustituir(IdTextField, NombreTextField, CategoriaTextField, PrecioTextField, InventarioTextField);
				JOptionPane.showMessageDialog(null, "Juguete eliminado exitosamente");
				btnBorrar.setEnabled(false);
				btnAnt.setEnabled(false);
				btnSig.setEnabled(false);
				btnEditar.setEnabled(false);
				btnPrimero.setEnabled(true);
				btnUltimo.setEnabled(true);
			}
			else if(e.getSource() == btnActualizar)
			{
				Articulo A = TJRegistrar.rAlmacen.get(i);
				A.setCve_art(Integer.parseInt(IdTextField.getText()));
				A.setNom_art(NombreTextField.getText());
				A.setCat_art(CategoriaTextField.getText());
				A.setPre_art(Float.parseFloat(PrecioTextField.getText()));
				A.setInv_art(Integer.parseInt(InventarioTextField.getText()));
				
				JOptionPane.showMessageDialog(null, "Juguete actualizado exitosamente");
				
				btnPrimero.setEnabled(true);
				btnUltimo.setEnabled(true);
				btnSalir.setEnabled(true);
				btnActualizar.setEnabled(false);
				
				IdTextField.setEditable(false);
				NombreTextField.setEditable(false);
				CategoriaTextField.setEditable(false);
				PrecioTextField.setEditable(false);
				InventarioTextField.setEditable(false);
			}
			else if(e.getSource() == btnSalir) 
			{
				this.dispose();
				GUI.setVisible(true);
			}
		}
		else if(e.getSource() == btnSalir) 
		{
			this.dispose();
			GUI.setVisible(true);
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Favor de registrar un Juguete");
		}
	}
	
	protected void mostrar(int i)
	{
		Articulo A = TJRegistrar.rAlmacen.get(i);
		IdTextField.setText(""+A.getCve_art());
		NombreTextField.setText(A.getNom_art());
		CategoriaTextField.setText(A.getCat_art());
		PrecioTextField.setText(""+A.getPre_art());
		InventarioTextField.setText(""+A.getInv_art());
	}
}
