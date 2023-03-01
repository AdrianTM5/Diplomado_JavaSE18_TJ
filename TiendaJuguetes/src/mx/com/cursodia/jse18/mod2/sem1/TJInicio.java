package mx.com.cursodia.jse18.mod2.sem1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TJInicio extends JFrame implements ActionListener 
{

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	static TJInicio Inicio = new TJInicio();
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio.setVisible(true);
					Inicio.setResizable(false);
					
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 239, 357);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(23, 15, 192, 69);
		btnRegistrar.addActionListener(this);
		contentPane.add(btnRegistrar);
		
		btnMostrar = new JButton("Mostrar");
		btnMostrar.setBounds(23, 130, 192, 69);
		btnMostrar.addActionListener(this);
		contentPane.add(btnMostrar);
		
		btnSalir = new JButton("Salir");
		btnSalir.setBounds(23, 245, 192, 69);
		btnSalir.addActionListener(this);
		contentPane.add(btnSalir);
	}
	
	TJRegistrar GUIVis = new TJRegistrar();
	TJMostrar GUIMos = new TJMostrar();
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == btnRegistrar)
		{
			this.dispose();
			GUIVis.setVisible(true);
			GUIVis.setResizable(false);
		}
		else if(e.getSource() == btnMostrar)
		{
			if(!TJRegistrar.rAlmacen.isEmpty())
			{
				this.dispose();
				GUIMos.setVisible(true);
				GUIMos.setResizable(false);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Error, primero registre un juguete");
			}
		}
		else if(e.getSource() == btnSalir)
		{
			System.exit(EXIT_ON_CLOSE);
		}
	}
	
	protected void sustituir(JTextField A, JTextField B, JTextField C, JTextField D, JTextField E)
	{
		A.setText("");
		B.setText("");
		C.setText("");
		D.setText("");
		E.setText("");
	}
	
	
}