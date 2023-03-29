package mx.com.cursodia.jse18.mod2.sem1;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TJRegistrar extends JFrame
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
	/**
	 * Create the frame.
	 */
	JButton btnAgregar;
	JButton btnSalir;
	Modelo m;
	private boolean isActive;
	public TJRegistrar()
	{
		this.isActive = false;
		setTitle("Tienda de juguetes");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 550, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		InfoPanel = new JPanel();
		InfoPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		InfoPanel.setBounds(22, 0, 497, 194);
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
		
		ButtonPanel = new JPanel();
		ButtonPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		ButtonPanel.setBounds(22, 206, 497, 95);
		contentPane.add(ButtonPanel);
		ButtonPanel.setLayout(null);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(25, 12, 178, 71);
		ButtonPanel.add(btnAgregar);
		
		btnSalir = new JButton("Salir");
		btnSalir.setBounds(295, 12, 178, 71);
		ButtonPanel.add(btnSalir);
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
