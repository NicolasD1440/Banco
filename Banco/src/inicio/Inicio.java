package inicio;

import javax.swing.JOptionPane;

import cola.ColaLista;
import cola.Turnos;
import vistas.Portada;

public class Inicio {
	public static ColaLista cola = new ColaLista();
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
         
		cola.encolar(new Turnos(1 ,"320-PWE","Juanes"));
		cola.encolar(new Turnos(1 ,"322-PWE","Carlos"));
		cola.encolar(new Turnos(1 ,"354-PWE","Cristian"));
		cola.encolar(new Turnos(1 ,"3862-PWE","Johan"));
		cola.encolar(new Turnos(1 ,"3578-PWE","Nicolas"));
		
		System.out.println(buscar(0));
		Portada ventana = new Portada();
		ventana.setVisible(true);
	 
		
		
}
	public static String buscar(int v) throws Exception {
		return cola.searchPosition(v);
	}
}