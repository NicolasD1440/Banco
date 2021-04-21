package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cola.ColaLista;
import cola.Nodo;
import cola.Turnos;
import inicio.Inicio;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class Generador_de_turnos extends JFrame {

	private JPanel contentPane;
	JLabel token = new JLabel();
	private JTextField textTurno;
	JLabel lblRes = new JLabel("En este espacio que aparezcan los datos: Nombre, cedula, Turno y la posicion al ingresar la cedula y presionar bus");
	JButton btnBuscar = new JButton("Buscar");
    Inicio ini = new Inicio();
    JLabel lblLogo = new JLabel("New label");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Generador_de_turnos frame = new Generador_de_turnos();
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
	
	private JLabel lblNombre = new JLabel("");
	private JTextField txtNombre;
	ColaLista lista = new ColaLista();
	private JTextField txtCedula;
	public Generador_de_turnos() {
				
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 72, 584, 228);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("GENERADOR DE TURNOS");
		lblNewLabel.setBounds(10, 11, 564, 27);
		panel.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Impact", Font.PLAIN, 20));
		
		JLabel lblNewLabel_2 = new JLabel("Por favor Ingrese su nombre:");
		lblNewLabel_2.setBounds(10, 49, 265, 20);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		txtNombre = new JTextField();
		txtNombre.setBounds(277, 49, 190, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		JButton btnPrueba = new JButton("GENERAR");
		btnPrueba.setBounds(477, 63, 97, 25);
		panel.add(btnPrueba);
		
		JLabel lblNewLabel_1_1 = new JLabel("Su turno es:");
		lblNewLabel_1_1.setBounds(10, 121, 564, 25);
		panel.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		token.setBounds(10, 157, 564, 66);
		panel.add(token);
		token.setFont(new Font("Impact", Font.PLAIN, 30));
		token.setText("t");
		token.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_2_1 = new JLabel("Por favor Ingrese su cedula:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2_1.setBounds(10, 80, 258, 20);
		panel.add(lblNewLabel_2_1);
		
		txtCedula = new JTextField();
		txtCedula.setBounds(277, 80, 190, 20);
		panel.add(txtCedula);
		txtCedula.setColumns(10);
		btnPrueba.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(!txtNombre.getText().isEmpty() && !txtCedula.getText().isEmpty()) {
				token.setText(generar());
				lista.encolar(new Turnos(1,txtCedula.getText(),token.getText(),txtNombre.getText()));
				txtNombre.setText("");
				txtCedula.setText("");
				}
				else {
					JOptionPane.showMessageDialog(null, "Por favor ingrese el nombre");
				}
				
			}
		});
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 72, 584, 228);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Escriba su cedula");
		lblNewLabel_1.setBounds(10, 11, 564, 23);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		textTurno = new JTextField();
		textTurno.setBounds(177, 45, 224, 20);
		panel_1.add(textTurno);
		textTurno.setColumns(10);
		btnBuscar.setBounds(242, 76, 89, 23);
		panel_1.add(btnBuscar);
		lblRes.setBounds(10, 118, 564, 92);
		panel_1.add(lblRes);
		lblRes.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.setVisible(false);
		lblNombre.setBounds(191, 247, 125, 14);
		
		contentPane.add(lblNombre);
		
		JButton btnVer = new JButton("Datos de turno");
		btnVer.setBounds(239, 311, 118, 23);
		contentPane.add(btnVer);
		
		JButton btnAtras = new JButton("Nuevo turno");
		btnAtras.setBounds(239, 311, 118, 23);
		contentPane.add(btnAtras);
		
		lblLogo.setBounds(102, 0, 373, 72);
		contentPane.add(lblLogo);
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel_1.setVisible(false);
				panel.setVisible(true);
				btnVer.setVisible(true);
				btnAtras.setVisible(false);
				
			}
		});
		btnVer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel.setVisible(false);
				panel_1.setVisible(true);
				btnAtras.setVisible(true);
				btnVer.setVisible(false);
			}
		});
		setLocationRelativeTo(null);
		btnAtras.setVisible(false);
		Logo();
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
	private void Logo() {
		
		Image imagen = new ImageIcon(this.getClass().getResource("/Logo.png"))
				.getImage().getScaledInstance(lblLogo.getWidth(), lblLogo.getHeight(),Image.SCALE_DEFAULT);
			lblLogo.setIcon(new ImageIcon(imagen));
	}
}
