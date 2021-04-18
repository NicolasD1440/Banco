package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import javax.swing.JButton;

public class Portada extends JFrame {

	private JPanel contentPane;
	JProgressBar progressBar = new JProgressBar();
	JButton btnStart = new JButton("New button");
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
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		progressBar.setBounds(10, 226, 514, 25);
		contentPane.add(progressBar);
		
		JLabel lblLogo = new JLabel("New label");
		lblLogo.setBounds(10, 11, 514, 204);
		contentPane.add(lblLogo);
		
		
		btnStart.setBounds(225, 277, 89, 23);
		contentPane.add(btnStart);
		setLocationRelativeTo(null);
		carga();
		btnStart.setVisible(false);
	}
	
	public void carga() {
		TimerTask tarea = new TimerTask() {
			  int x =0;
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						progressBar.setValue(x++);
						if(x ==100) {
							btnStart.setVisible(true);

			   		  
			   	  }
					}

			   	  };
			   	  timer.schedule(tarea, 0,10);
	}
}
