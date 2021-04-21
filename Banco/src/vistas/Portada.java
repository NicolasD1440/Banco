package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import inicio.Inicio;

import javax.swing.JProgressBar;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;

public class Portada extends JFrame {

	//Se colocan las variables de los label contentpane, JprogressBar 
	//en la parte superior ya que serán utilizadas en los métodos dentro de la interfaz.
	private JPanel contentPane;
	Generador_de_turnos ventana = new Generador_de_turnos();
	JLabel lblLogo = new JLabel("New label");
	JProgressBar progressBar = new JProgressBar();
	Timer timer = new Timer();// Aquí se pone en marcha el timer cada segundo.
	 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Portada frame = new Portada();
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
	public Portada() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 350);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("NACIMOS PARA SERVIR");
		lblNewLabel.setFont(new Font("Sitka Text", Font.BOLD, 25));
		lblNewLabel.setBounds(201, 131, 311, 32);
		contentPane.add(lblNewLabel);
		progressBar.setStringPainted(true);
		progressBar.setForeground(new Color(204, 153, 0));
		
		
		progressBar.setBounds(10, 226, 514, 25);
		contentPane.add(progressBar);
		
		lblLogo.setBounds(10, 11, 514, 204);
		contentPane.add(lblLogo);
		setLocationRelativeTo(null);//Se implementa este codigo para que la ventana se muestre en el centro
		carga();//Se implementa el metodo para la barra de carga
		Logo();//Se implementa el metodo para mostrar la imagen de fono
	}
	//Metodo de carga
	public void carga() {
		// Clase en la que está el código a ejecutar, esta instancia nos permite utilizar la clase java.util.Timer
		TimerTask tarea = new TimerTask() {
			  int x =0;//Se utiliza una varibale de tipo entero como un contador que sea igual a cero
					@Override
					public void run() {
						// TODO Auto-generated method stub
						// Aquí el código que queremos ejecutar.
						progressBar.setValue(x++);
						//Utilizamos una barra de progreso para que se vaya llenando
						if(x ==100) {
							//Se utiliza este condicional para que la variable x vaya aumentado desde cero a 100
							//y que apenas llegue a 100 muestre la siguiente interfaz
							ventana.setVisible(true);
							dispose();
			   		  
			   	  }
					}

			   	  };
			   //Empieza en 0 ms y luego que se llene la barra cada 30 milisegundos
			   	  timer.schedule(tarea, 0,30);
	}
	
	//Metodo para agregar una imagen de fondo
	private void Logo() {
		//la imagen está dentro del programa en una carpeta llamada recursos desde allí se trae esta imagen 
		Image imagen = new ImageIcon(this.getClass().getResource("/Logo.png"))
				.getImage().getScaledInstance(lblLogo.getWidth(), lblLogo.getHeight(),Image.SCALE_DEFAULT);
			lblLogo.setIcon(new ImageIcon(imagen));//Se setea para hacer visible la imagen seleccionada
	   //Con getScaledInstance(lblFondo.getWidth(),lblFondo.getHeight(),Image.SCALE_DEFAULT, se adapta al tamaño delLabel la imagen	
	}
}
