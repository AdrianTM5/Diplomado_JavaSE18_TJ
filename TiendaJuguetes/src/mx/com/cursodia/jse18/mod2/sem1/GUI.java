package mx.com.cursodia.jse18.mod2.sem1;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class GUI extends JFrame
{
	Thread ThreadI;
	JPanel contentPane;
	JTextField UsuarioTextField;
	JPasswordField PasswordField;
	JButton btnEnviar;
	private JLabel ContraseñaLabel;
	private JLabel UsuarioLabel;
	private JLabel TituloLabel;
	
	
	void lanzar() {
		ThreadI = new Thread(new Runnable() {
			public void run() {
				try {
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		ThreadI.start();
	}
	
	public GUI() 
	{
		setTitle("Iniciar sesión");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 400);
		getContentPane().setLayout(null);
		
		TituloLabel = new JLabel("Tienda Juguetes");
		TituloLabel.setHorizontalAlignment(SwingConstants.CENTER);
		TituloLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		TituloLabel.setBounds(10, 43, 514, 46);
		getContentPane().add(TituloLabel);
		
		UsuarioLabel = new JLabel("Usuario:");
		UsuarioLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		UsuarioLabel.setBounds(145, 157, 79, 23);
		getContentPane().add(UsuarioLabel);
		
		ContraseñaLabel = new JLabel("Contraseña:");
		ContraseñaLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ContraseñaLabel.setBounds(145, 229, 79, 23);
		getContentPane().add(ContraseñaLabel);
		
		UsuarioTextField = new JTextField();
		UsuarioTextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		UsuarioTextField.setBounds(234, 160, 136, 20);
		getContentPane().add(UsuarioTextField);
		UsuarioTextField.setColumns(10);
		
		PasswordField = new JPasswordField();
		PasswordField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		PasswordField.setColumns(10);
		PasswordField.setBounds(234, 232, 136, 20);
		getContentPane().add(PasswordField);
		
		btnEnviar = new JButton("Enviar");
		btnEnviar.setBounds(165, 278, 185, 39);
		getContentPane().add(btnEnviar);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
	}
}
