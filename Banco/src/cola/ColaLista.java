package cola;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import vistas.Portada;

public class ColaLista {
	//Elemntos 
		private Nodo primero;
		private Nodo ultimo;
		private int tam;
		
		//constructor
		public ColaLista() {
			this.primero = null;
			this.ultimo = null;
			this.tam = 0;
			
		}
		
		//Verificar si la cola Vacia
		
		public boolean ColaVacia() {
			return this.primero == null && this.ultimo == null;
					}
		public void encolar(Turnos v) {
			Nodo nodo = new Nodo();
			nodo.setInformacion(v);
			if(ColaVacia()){
				this.primero = nodo;
			}else {
				this.ultimo.setReferencia(nodo);
			}
			this.ultimo = nodo;
			this.tam++;
			System.out.println("Elemento agregado");
		}
		
		public int getTam() {
			return this.tam;
		}
		/*public void desencolar() {
			this.primero = this.primero.getReferencia();
			if(this.primero == null) {
				this.ultimo = null;
			}
			this.tam--;
		}*/
		
		/*public void mostrar() {
			if(!ColaVacia()) {
				Nodo aux = this.primero;
				int i = 0;
				while(aux != null) {
					System.out.println(i + " " + aux.getInformacion());
					aux = aux.getReferencia();
					i++;
				}
			}else {
				System.out.println("cola vacia");
			}
		}*/
		/*public String searchPosition(int p) throws Exception {
			if((p >= 0) && (p < this.tam)) {
				if(p == 0) {
					return this.primero.getInformacion().getturno();
				}else {
					Nodo aux = this.primero; //Nodo de acceso a la lista
					for(int i = 0; i < p; i++) {
						aux = aux.getReferencia();
						
					}
					return aux.getInformacion().getturno();
				}
			}else {
				throw new Exception("La posicion esta fuera de la lista.");
			}
		}*/
		/*public DefaultTableModel elnombre(){
			
			Nodo aux = primero; 
			DefaultTableModel modelo = new DefaultTableModel();
			int i = 0;
			i++;
			String[] info = new String[3];
			info[0] = aux.getInformacion().getNombre();
			info[1] = aux.getInformacion().getCedula();
			info[2] = aux.getInformacion().getturno();
			info[3] = String.valueOf(i);
			
			modelo.addRow(info);
			return modelo;
		}*/
		
		public DefaultListModel<String> mostrarDatos(String cedula){
			
			Nodo objeto = primero;
			boolean encontrado = false;
			int i = 0;
			while(encontrado == false && i < tam) {
				if(objeto.getInformacion().getCedula().equals(cedula)) {
					encontrado = true;
				}
				else {
					objeto = objeto.getReferencia();
					i++;
				}
			}
			DefaultListModel<String> modelo = new DefaultListModel<String>();
			if(encontrado) {
				
				modelo.addElement("Nombre: " + objeto.getInformacion().getNombre().toUpperCase() );
				modelo.addElement("Cedula: " + objeto.getInformacion().getCedula() );
				modelo.addElement("Turno: " + objeto.getInformacion().getturno() );
				modelo.addElement("Posicion: " + (i+1) );
				
			}else {
				JOptionPane.showMessageDialog(null, "Numero de cedula no encontrado");
			}
			return modelo;
		}
		public Nodo primero() {
			return primero;
			
		}
		
		

}
