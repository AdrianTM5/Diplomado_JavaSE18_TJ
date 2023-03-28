package mx.com.cursodia.jse18.mod2.sem1;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;

public class TJMostrar extends JFrame
{
	private JPanel contentPane;
	JTextField IdTextField;
	JTextField NombreTextField;
	JTextField CategoriaTextField;
	JTextField PrecioTextField;
	JTextField InventarioTextField;
	private JPanel panel;
	JButton btnPrimero;
	JButton btnEditar;
	JButton btnBorrar;
	JButton btnUltimo;
	JButton btnSalir;
	JButton btnAnt;
	JButton btnSig;
	JButton btnActualizar;
	
	Thread ThreadM;
	
	/**
	 * Launch the application.
	 */
	void lanzar() {
		ThreadM = new Thread(new Runnable() {
			public void run() {
				try {
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		ThreadM.start();
	}

	/**
	 * Create the frame.
	 */
	public TJMostrar() 
	{
		setTitle("Mostrar Juguetes");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
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
		panel.add(btnPrimero);
		
		btnEditar = new JButton("Editar");
		btnEditar.setBounds(37, 61, 117, 25);
		btnEditar.setEnabled(false);
		panel.add(btnEditar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(324, 61, 117, 25);
		btnBorrar.setEnabled(false);
		panel.add(btnBorrar);
		
		btnUltimo = new JButton("Ultimo");
		btnUltimo.setBounds(345, 26, 117, 25);
		panel.add(btnUltimo);
		
		btnSalir = new JButton("Salir");
		btnSalir.setBounds(177, 26, 117, 25);
		panel.add(btnSalir);
		
		btnAnt = new JButton("<<");
		btnAnt.setEnabled(false);
		btnAnt.setBounds(124, 98, 117, 25);
		panel.add(btnAnt);
		
		btnSig = new JButton(">>");
		btnSig.setEnabled(false);
		btnSig.setBounds(240, 98, 117, 25);
		panel.add(btnSig);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setEnabled(false);
		btnActualizar.setBounds(177, 63, 117, 25);
		panel.add(btnActualizar);
	}
}