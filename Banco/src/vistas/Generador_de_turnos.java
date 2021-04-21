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
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.SystemColor;
import java.awt.Color;

public class Generador_de_turnos extends JFrame {
	
	//Se colocan las variables de los label contentpane, Texfield, JButton
    //en la parte superior ya que serán utilizadas en los métodos dentro de la interfaz.
	private JPanel contentPane;
	JLabel token = new JLabel();
	private JTextField textCedula;
	JButton btnBuscar = new JButton("Buscar");
    Inicio ini = new Inicio();
    JLabel lblLogo = new JLabel("New label");
    JList<String> list = new JList<String>();//Instancia para implementar los datos dentro de la lista

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
	ColaLista lista = new ColaLista();//Se instancia para poder utilizar el metodo que esta en la clase ColaLista de agregar y buscar en la lista
	private JTextField txtCedula;
	public Generador_de_turnos() {
		setTitle("Menu");
				
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 602, 417);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(250, 235, 215));
		panel.setBounds(0, 72, 584, 228);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("GENERADOR DE TURNOS");
		lblNewLabel.setBounds(10, 25, 564, 27);
		panel.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Impact", Font.PLAIN, 20));
		
		JLabel lblNewLabel_2 = new JLabel("Por favor Ingrese su nombre:");
		lblNewLabel_2.setBounds(2, 61, 265, 20);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		txtNombre = new JTextField();
		txtNombre.setBounds(277, 65, 190, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		JButton btnGenerar = new JButton("GENERAR");
		btnGenerar.setBounds(477, 75, 97, 25);
		panel.add(btnGenerar);
		
		JLabel lblNewLabel_1_1 = new JLabel("Su turno es:");
		lblNewLabel_1_1.setBounds(10, 121, 564, 25);
		panel.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		token.setBounds(10, 157, 564, 66);
		panel.add(token);
		token.setFont(new Font("Impact", Font.PLAIN, 30));
		token.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_2_1 = new JLabel("Por favor Ingrese su cedula:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2_1.setBounds(10, 90, 258, 20);
		panel.add(lblNewLabel_2_1);
		
		txtCedula = new JTextField();
		txtCedula.setBounds(277, 90, 190, 20);
		panel.add(txtCedula);
		txtCedula.setColumns(10);
		
		
		btnGenerar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//En este boton nos encontramos con un condicional que dice que si los 
				//campos estan diligenciados agregue los datos ingresados en la cola
				if(!txtNombre.getText().isEmpty() && !txtCedula.getText().isEmpty()) {
				token.setText(generar());//Label donde se genera el codigo de forma aleatoria
				lista.encolar(new Turnos(txtCedula.getText(),token.getText(),txtNombre.getText()));//Agrega los elementos dentro de la cola
				txtNombre.setText("");//Coloca el campo nuevamente vacio
				txtCedula.setText("");//Coloca el campo nuevamente vacio
				}
				else {
					//Si hay un campo en blanco envia un mensaje parq que se diligencie todo
					JOptionPane.showMessageDialog(null, "Por favor ingrese el nombre");
				}
				
			}
		});
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(250, 235, 215));
		panel_1.setBounds(0, 72, 584, 228);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Escriba su cedula");
		lblNewLabel_1.setBounds(10, 11, 564, 23);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		textCedula = new JTextField();
		textCedula.setBounds(177, 45, 224, 20);
		panel_1.add(textCedula);
		textCedula.setColumns(10);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Este boton cuenta con un condicional que verifica si el campo de texto esta vacio
				if(textCedula.getText().isEmpty()) {
					//Si esta vacio se genera un mensaje que le pide al usuario dilingenciarlo bien
					JOptionPane.showMessageDialog(null, "Por favor ingrese su cedula");
				}else {
					//Si no esta vacio entonces muestra los datos del usuario con ese número de cedula
					list.setModel(lista.mostrarDatos(textCedula.getText()));
					//Como se instancia la clase cola lista, alla hay un metodo llamado mostrar datos el tiene un 
					//condicional de que si el numero ingresado no esta guardado en la cola muestra un mensaje de advertencia
					textCedula.setText("");//Coloca el campo nuevamente vacio
				}
				
			}
		});
		btnBuscar.setBounds(242, 76, 89, 23);
		panel_1.add(btnBuscar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(177, 110, 224, 107);
		panel_1.add(scrollPane);
		list.setBackground(SystemColor.control);
		list.setBorder(null);
		list.setEnabled(false);
		scrollPane.setViewportView(list);
		list.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel_1.setVisible(false);
		lblNombre.setBounds(191, 247, 125, 14);
		
		contentPane.add(lblNombre);
		
		JButton btnVer = new JButton("Datos de turno");
		btnVer.setBounds(239, 325, 118, 23);
		contentPane.add(btnVer);
		
		JButton btnAtras = new JButton("Nuevo turno");
		btnAtras.setBounds(239, 325, 118, 23);
		contentPane.add(btnAtras);
		
		lblLogo.setBounds(0, 0, 584, 359);
		contentPane.add(lblLogo);
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Al presionar este boton se ocultan los siguientes elementos 
				panel_1.setVisible(false);
				panel.setVisible(true);
				btnVer.setVisible(true);
				btnAtras.setVisible(false);
				token.setText("");//Y se coloca el campo nuevamente vacio
				
			}
		});
		btnVer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Al presionar este boton 
				panel.setVisible(false);//Se oculate este elemento
				panel_1.setVisible(true);//Se pone visible este elemento
				btnAtras.setVisible(true);//Se pone visible este elemento
				btnVer.setVisible(false);//Se oculate este elemento
				list.setListData(new String[0]);//Se pone visible la lista donde se mostraron los datos
			}
		});
		setLocationRelativeTo(null);//Se implementa este codigo para que la ventana de la interfaz se muestre en el centro
		btnAtras.setVisible(false);//Se oculta este boton y solo se activa hasta que se presiona el boton Ver
		Logo();//Se implementa el metodo para mostrar la imagen de fondo
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
	//Metodo para agregar una imagen de fondo
	private void Logo() {
		//La imagen está dentro del programa en una carpeta llamada recursos desde allí se trae esta imagen 
		Image imagen = new ImageIcon(this.getClass().getResource("/Fondo.jpg"))
				.getImage().getScaledInstance(lblLogo.getWidth(), lblLogo.getHeight(),Image.SCALE_DEFAULT);
			lblLogo.setIcon(new ImageIcon(imagen));
	 //Con getScaledInstance(lblFondo.getWidth(),lblFondo.getHeight(),Image.SCALE_DEFAULT, se adapta al tamaño delLabel la imagen			
	}
}
