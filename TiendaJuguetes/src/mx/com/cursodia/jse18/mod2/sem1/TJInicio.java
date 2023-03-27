package mx.com.cursodia.jse18.mod2.sem1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class TJInicio extends JFrame 
{
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public void lanzar() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	JButton btnRegistrar;
	JButton btnMostrar;
	JButton btnSalir;
	public TJInicio()
	{
		setTitle("Menú Tienda Juguetes");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 239, 357);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(23, 15, 192, 69);
		contentPane.add(btnRegistrar);
		
		btnMostrar = new JButton("Mostrar");
		btnMostrar.setBounds(23, 130, 192, 69);
		contentPane.add(btnMostrar);
		
		btnSalir = new JButton("Salir");
		btnSalir.setBounds(23, 245, 192, 69);
		contentPane.add(btnSalir);
	}
}