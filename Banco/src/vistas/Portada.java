package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;

public class Portada extends JFrame {

	private JPanel contentPane;
	Generador_de_turnos ventana = new Generador_de_turnos();
	JLabel lblLogo = new JLabel("New label");
	JProgressBar progressBar = new JProgressBar();
	Timer timer = new Timer();
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
		progressBar.setForeground(new Color(204, 153, 102));
		
		
		progressBar.setBounds(10, 226, 514, 25);
		contentPane.add(progressBar);
		
		lblLogo.setBounds(10, 11, 514, 204);
		contentPane.add(lblLogo);
		setLocationRelativeTo(null);
		carga();
		Logo();
	}
	
	public void carga() {
		TimerTask tarea = new TimerTask() {
			  int x =0;
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						progressBar.setValue(x++);
						if(x ==100) {
							ventana.setVisible(true);
							dispose();
			   		  
			   	  }
					}

			   	  };
			   	  timer.schedule(tarea, 0,10);
	}
	
	private void Logo() {
		
		Image imagen = new ImageIcon(this.getClass().getResource("/Logo.png"))
				.getImage().getScaledInstance(lblLogo.getWidth(), lblLogo.getHeight(),Image.SCALE_DEFAULT);
			lblLogo.setIcon(new ImageIcon(imagen));
	}
}
