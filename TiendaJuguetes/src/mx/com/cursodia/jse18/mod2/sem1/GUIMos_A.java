package mx.com.cursodia.jse18.mod2.sem1;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JRadioButtonMenuItem;

public class GUIMos_A extends JFrame
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
	JButton btnAnt;
	JButton btnSig;
	JButton btnActualizar;
	
	Thread ThreadM;
	JTextField ProveedorTextField;
	private JLabel ProveedorLabel;
	private JMenuBar menuBar;
	private JMenu JMenuAgregar;
	private JMenu JMenuMostrar;
	JRadioButtonMenuItem MI_Articulo_A;
	JRadioButtonMenuItem MI_Proveedor_A;
	JRadioButtonMenuItem MI_Articulo_M;
	JRadioButtonMenuItem MI_Proveedor_M;
	
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
	public GUIMos_A() 
	{
		setTitle("Mostrar Articulo");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 550, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel Infopanel = new JPanel();
		Infopanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		Infopanel.setBounds(23, 38, 488, 162);
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
		
		ProveedorTextField = new JTextField();
		ProveedorTextField.setColumns(10);
		ProveedorTextField.setBounds(351, 71, 114, 19);
		Infopanel.add(ProveedorTextField);
		
		ProveedorLabel = new JLabel("Proveedor:");
		ProveedorLabel.setBounds(254, 75, 84, 15);
		ProveedorTextField.setEditable(false);
		Infopanel.add(ProveedorLabel);
		
		panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(23, 211, 487, 139);
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
		
		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 554, 22);
		contentPane.add(menuBar);
		
		JMenuAgregar = new JMenu("Agregar");
		menuBar.add(JMenuAgregar);
		
		MI_Articulo_A = new JRadioButtonMenuItem("Articulo");
		JMenuAgregar.add(MI_Articulo_A);
		
		MI_Proveedor_A = new JRadioButtonMenuItem("Proovedor");
		JMenuAgregar.add(MI_Proveedor_A);
		
		JMenuMostrar = new JMenu("Mostrar");
		menuBar.add(JMenuMostrar);
		
		MI_Articulo_M = new JRadioButtonMenuItem("Articulo");
		MI_Articulo_M.setSelected(true);
		JMenuMostrar.add(MI_Articulo_M);
		
		MI_Proveedor_M = new JRadioButtonMenuItem("Proovedor");
		JMenuMostrar.add(MI_Proveedor_M);
	}
}