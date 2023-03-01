package mx.com.cursodia.jse18.mod2.sem1;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class FormulaGeneral extends JFrame implements ActionListener
{
	JTextField txtA, txtB, txtC, txtX1, txtX2; 
	JButton btnCalcular;
	public static void main(String[] args)
	{
		FormulaGeneral fg = new FormulaGeneral();
		fg.createGUI();
		fg.setSize(250,235);
		fg.setResizable(false);
		fg.setVisible(true);
	}
	
	private void createGUI()
	{
		//Formateo del Contenedor
		setDefaultCloseOperation(EXIT_ON_CLOSE); //Invesigar más opciones
		Container frame = this.getContentPane(); 
		frame.setLayout(new FlowLayout());//Investigar de tipos de Layout
		this.setTitle("Formula general");
	
		//Instanciación de los elementos
		JLabel lbA = new JLabel("A:");
		JLabel lbB = new JLabel("B:");
		JLabel lbC = new JLabel("C:");
		JLabel lbX1 = new JLabel("X1:");
		JLabel lbX2 = new JLabel("X2:");
		
		txtA = new JTextField(20); //El 20 es el limite de caracteres visibles
		txtB = new JTextField(20);
		txtC = new JTextField(20);
		txtX1 = new JTextField(20);
		txtX2 = new JTextField(20);
		
		btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(this); // Asignar función al botón
		
		//Agregar elementos al contenedor
		frame.add(lbA); //Agregar el label
		frame.add(txtA); // Agregar el TextField
		frame.add(lbB); 
		frame.add(txtB);
		frame.add(lbC); 
		frame.add(txtC);
		frame.add(lbX1); 
		frame.add(txtX1);
		frame.add(lbX2); 
		frame.add(txtX2);
		frame.add(btnCalcular);
		
		//Modificar elementos
		
		txtX1.setEditable(false); //Para que los TextFields no puedan ser modificables por el usuario y solo por el programa
		txtX2.setEditable(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		double A = Double.parseDouble(txtA.getText());
		double B = Double.parseDouble(txtB.getText());
		double C = Double.parseDouble(txtC.getText());
		
		double radical = Math.pow(B,2) - (4 * A * C);
		
		if(radical >= 0)
		{
			double X1 = (- B + Math.sqrt(radical))/ (2*A);
			double X2 = (- B - Math.sqrt(radical))/ (2*A);
			txtX1.setText(""+X1); //Manda los valores a imprimir en el campo de texto de txtX1 
			txtX2.setText(""+X2);
		}
		else
		{
			JOptionPane.showMessageDialog(this, "La ecuación no tiene raices reales");
		}
	}
}
