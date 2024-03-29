package mx.com.cursodia.jse18.mod2.sem1;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;

public class GUIReg_A extends JFrame
{
	Thread ThreadR;
	/**
	 * Launch the application.
	 */
	public void lanzar() {
		ThreadR = new Thread(new Runnable() {
			public void run() {
				try {
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		ThreadR.start();
	}
	
	private JPanel contentPane;
	private JPanel InfoPanel;
	private JPanel ButtonPanel;
	private JLabel IdLabel;
	JTextField IdTextField;
	private JLabel NombreLabel;
	JTextField NombreTextField;
	private JLabel CategoriaLabel;
	JTextField CategoriaTextField;
	private JLabel InventarioLabel;
	JTextField InventarioTextField;
	private JLabel PrecioLabel;
	JTextField PrecioTextField;
	JTextField ProveedorTextField;
	private JMenuBar menuBar;
	private JMenu JMenuAgregar;
	private JMenu JMenuMostrar;
	JRadioButtonMenuItem MI_Articulo_A;
	JRadioButtonMenuItem MI_Proveedor_A;
	JRadioButtonMenuItem MI_Articulo_M;
	JRadioButtonMenuItem MI_Proveedor_M;
	/**
	 * Create the frame.
	 */
	JButton btnAgregar;
	Modelo m;
	private boolean isActive;
	public GUIReg_A()
	{
		this.isActive = false;
		setTitle("Agregar Articulo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		InfoPanel = new JPanel();
		InfoPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		InfoPanel.setBounds(23, 38, 488, 162);
		contentPane.add(InfoPanel);
		InfoPanel.setLayout(null);
		
		IdLabel = new JLabel("Id:");
		IdLabel.setBounds(67, 31, 33, 15);
		InfoPanel.add(IdLabel);
		
		IdTextField = new JTextField();
		IdTextField.setBounds(93, 29, 114, 19);
		IdTextField.setColumns(10);
		IdTextField.setEditable(false);
		InfoPanel.add(IdTextField);
		
		NombreLabel = new JLabel("Nombre:");
		NombreLabel.setBounds(27, 75, 60, 15);
		InfoPanel.add(NombreLabel);
		
		NombreTextField = new JTextField();
		NombreTextField.setBounds(93, 73, 114, 19);
		NombreTextField.setColumns(10);
		InfoPanel.add(NombreTextField);
		
		CategoriaLabel = new JLabel("Categoria:");
		CategoriaLabel.setBounds(12, 122, 75, 15);
		InfoPanel.add(CategoriaLabel);
		
		CategoriaTextField = new JTextField();
		CategoriaTextField.setBounds(93, 120, 114, 19);
		CategoriaTextField.setColumns(10);
		InfoPanel.add(CategoriaTextField);
		
		PrecioLabel = new JLabel("Precio:");
		PrecioLabel.setBounds(284, 29, 49, 15);
		InfoPanel.add(PrecioLabel);
		
		PrecioTextField = new JTextField();
		PrecioTextField.setBounds(351, 29, 114, 19);
		PrecioTextField.setColumns(10);
		InfoPanel.add(PrecioTextField);
		
		InventarioLabel = new JLabel("Existencias:");
		InventarioLabel.setBounds(254, 122, 84, 15);
		InfoPanel.add(InventarioLabel);
		
		InventarioTextField = new JTextField();
		InventarioTextField.setBounds(351, 118, 114, 19);
		InfoPanel.add(InventarioTextField);
		InventarioTextField.setColumns(10);
		
		JLabel ProveedorLabel = new JLabel("Proveedor:");
		ProveedorLabel.setBounds(254, 77, 84, 15);
		InfoPanel.add(ProveedorLabel);
		
		ProveedorTextField = new JTextField();
		ProveedorTextField.setColumns(10);
		ProveedorTextField.setBounds(351, 73, 114, 19);
		InfoPanel.add(ProveedorTextField);
		
		ButtonPanel = new JPanel();
		ButtonPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		ButtonPanel.setBounds(23, 211, 487, 139);
		contentPane.add(ButtonPanel);
		ButtonPanel.setLayout(null);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(25, 12, 445, 116);
		ButtonPanel.add(btnAgregar);
		
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
		JMenuMostrar.add(MI_Articulo_M);
		
		MI_Proveedor_M = new JRadioButtonMenuItem("Proovedor");
		JMenuMostrar.add(MI_Proveedor_M);
	}
	
	public void activar()
	{
		this.isActive = true;
		this.setVisible(true);
	}
	
	public void desactivar() 
	{
        this.isActive = false;
        this.dispose();
    }

    public boolean isActive() 
    {
        return this.isActive;
    }
}
