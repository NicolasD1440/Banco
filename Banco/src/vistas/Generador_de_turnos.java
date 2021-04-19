package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cola.ColaLista;
import cola.Nodo;
import inicio.Inicio;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class Generador_de_turnos extends JFrame {

	private JPanel contentPane;
	JLabel token = new JLabel();
	private JTextField textTurno;
	public static ColaLista cola = new ColaLista();
	JLabel lblRes = new JLabel("");
	JButton btnBuscar = new JButton("Buscar");
    Inicio ini = new Inicio();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Generador_de_turnos frame = new Generador_de_turnos(Inicio.cola.primero());
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
	private Nodo nodo;
	private JLabel lblNombre = new JLabel("");
	
	public Generador_de_turnos(Nodo primero) {
		this.nodo = primero;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnPrueba = new JButton("GENERAR");
		btnPrueba.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				token.setText("Numero de verificacion: " + generar());
			}
		});
		btnPrueba.setBounds(386, 267, 97, 33);
		contentPane.add(btnPrueba);
		
		JLabel lblNewLabel = new JLabel("GENERADOR DE TURNOS");
		lblNewLabel.setFont(new Font("Impact", Font.PLAIN, 20));
		lblNewLabel.setBounds(163, 11, 197, 27);
		contentPane.add(lblNewLabel);
		token.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		token.setBounds(104, 49, 309, 14);
		contentPane.add(token);
		
		textTurno = new JTextField();
		textTurno.setBounds(136, 130, 224, 20);
		contentPane.add(textTurno);
		textTurno.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Escribe tu turno");
		lblNewLabel_1.setBounds(191, 105, 97, 14);
		contentPane.add(lblNewLabel_1);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				
				int a = Integer.parseInt(textTurno.getText());
				try {
					lblRes.setText(Inicio.buscar(a));
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					lblNombre.setText(nodo.getInformacion().getNombre());
			}
		});
			
		btnBuscar.setBounds(199, 177, 89, 23);
		contentPane.add(btnBuscar);
		
		
		lblRes.setBounds(183, 222, 120, 14);
		contentPane.add(lblRes);
		lblNombre.setBounds(191, 247, 125, 14);
		
		contentPane.add(lblNombre);
		setLocationRelativeTo(null);
		
	}
	public String generar() {
		  String matricula = "";
		    int a;
		     String CaracteresNoDeseados = "AEIOU";
		    for (int i = 0; i < 7; i++) {
		        if (i < 4) {    // 0,1,2,3 posiciones de numeros
		            matricula = (int) (Math.random() * 9) + "" + matricula;

		        } else {       // 4,5,6 posiciones de letras
		            do {
		                a = (int) (Math.random() * 26 + 65);///
		            } while (CaracteresNoDeseados.indexOf(a) >= 0);

		            char letra = (char) a;
		            if (i == 4) {
		                matricula = matricula + "-" + letra;
		            } else {
		                matricula = matricula + "" + letra;
		            }

		        }
		    }
		    return matricula;
		
	
}
	
}
