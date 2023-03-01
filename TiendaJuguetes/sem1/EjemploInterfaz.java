package mx.com.cursodia.jse18.mod2.sem1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import java.awt.Color;

public class EjemploInterfaz extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField txtAdrian;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EjemploInterfaz frame = new EjemploInterfaz();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EjemploInterfaz() {
		setTitle("Titulo");
		setForeground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 575);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtAdrian = new JTextField();
		txtAdrian.setHorizontalAlignment(SwingConstants.CENTER);
		txtAdrian.setText("Adrian");
		txtAdrian.setFont(new Font("Arial", Font.PLAIN, 26));
		txtAdrian.setBounds(314, 180, 477, 119);
		contentPane.add(txtAdrian);
		txtAdrian.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Cual es tu nombre?");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 23));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(50, 208, 254, 65);
		contentPane.add(lblNewLabel);
		
		JToggleButton tglbtnNewToggleButton = new JToggleButton("Presiona");
		tglbtnNewToggleButton.addActionListener(this); 
		tglbtnNewToggleButton.setFont(new Font("Arial", Font.PLAIN, 20));
		tglbtnNewToggleButton.setBounds(143, 343, 511, 52);
		contentPane.add(tglbtnNewToggleButton);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		JOptionPane.showMessageDialog(null, "Hola "+txtAdrian.getText());
	}
}
