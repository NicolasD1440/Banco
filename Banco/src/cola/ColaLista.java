package cola;



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
		public void encolar(int v) {
			Nodo nodo = new Nodo(v);
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
		public void desencolar() {
			this.primero = this.primero.getReferencia();
			if(this.primero == null) {
				this.ultimo = null;
			}
			this.tam--;
		}
		
		public void mostrar() {
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
		}
}
