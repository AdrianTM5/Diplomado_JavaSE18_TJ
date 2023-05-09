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

public class GUIReg_P extends JFrame
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
	private JPanel ButtonPanel;
	JTextField IdTextField;
	JTextField NombreTextField;
	JTextField CategoriaTextField;
	JTextField InventarioTextField;
	JTextField PrecioTextField;
	JTextField ProveedorTextField;
	private JLabel EmailLabel;
	private JMenuBar menuBar;
	private JMenu JMenuAgregar;
	private JMenu JMenuMostrar;
	private JTextField TelefonoTextField;
	private JTextField DireccionTextField;
	private JTextField EmailTextField;
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
	public GUIReg_P()
	{
		setTitle("Agregar Proveedor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		IdLabel.setBounds(65, 31, 26, 15);
		Infopanel.add(IdLabel);
		
		IdTextField = new JTextField();
		IdTextField.setBounds(93, 29, 114, 19);
		Infopanel.add(IdTextField);
		IdTextField.setEditable(false);
		IdTextField.setColumns(10);
		
		JLabel NombreLabel = new JLabel("Nombre:");
		NombreLabel.setBounds(28, 123, 62, 15);
		Infopanel.add(NombreLabel);
		
		NombreTextField = new JTextField();
		NombreTextField.setColumns(10);
		NombreTextField.setBounds(93, 120, 114, 19);
		Infopanel.add(NombreTextField);
		
		JLabel TelefonoLabel = new JLabel("Telefono:");
		TelefonoLabel.setBounds(286, 31, 62, 15);
		Infopanel.add(TelefonoLabel);
		
		TelefonoTextField = new JTextField();
		TelefonoTextField.setColumns(10);
		TelefonoTextField.setBounds(351, 29, 114, 19);
		Infopanel.add(TelefonoTextField);
		
		JLabel DireccionLabel = new JLabel("Dirección:");
		DireccionLabel.setBounds(286, 123, 62, 15);
		Infopanel.add(DireccionLabel);
		
		DireccionTextField = new JTextField();
		DireccionTextField.setColumns(10);
		DireccionTextField.setBounds(351, 118, 114, 19);
		Infopanel.add(DireccionTextField);
		
		EmailTextField = new JTextField();
		EmailTextField.setColumns(10);
		EmailTextField.setBounds(351, 71, 114, 19);
		Infopanel.add(EmailTextField);
		
		EmailLabel = new JLabel("Correo Electronico:");
		EmailLabel.setBounds(228, 74, 120, 15);
		Infopanel.add(EmailLabel);
		
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