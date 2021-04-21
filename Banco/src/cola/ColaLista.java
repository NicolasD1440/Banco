package cola;

import javax.swing.DefaultListModel;

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
		
		public DefaultListModel<String> mostrarDatos(String cedula){
			
			Nodo aux = primero;
			DefaultListModel<String> listModel = new DefaultListModel<String>();
			
			if(!ColaVacia()) {
				for(int i = 0; i < tam; i++) {
					listModel.addElement("Nombre: " + aux.getInformacion().getNombre());
					listModel.addElement("Cedula: " + aux.getInformacion().getCedula());
					listModel.addElement("Turno: " + aux.getInformacion().getturno());
					listModel.addElement("Posicion: " + (i+1));
					aux = aux.getReferencia();
				}
				return listModel;	
			}
			else {
				listModel.addElement("No hay ningun turno");
				return listModel;
			}
			
		}
		public Nodo primero() {
			return primero;
			
		}

}
