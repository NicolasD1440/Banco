package cola;

public class ColaArray {
	//Elementos de la cola
		private static final int TAM = 10;
		private int cabeza;
		private int cola;
		private boolean[] listacola;
		
		//constructor
		public ColaArray() {
			this.cabeza = 0;
			this.cola = -1;
			this.listacola = new boolean[TAM];
		}
		 
		//validar si la cola esta vacia
		public boolean ColaVacia() {
			return cabeza > cola;
		}
		
		//validra si la cola esta llena
		public boolean ColaLlena() {
			return cola == TAM -1;
		}
		//Borrar o reiniciar la cola
		public void borrarCola() {
			this.cabeza = 0;
			this.cola = -1;
			System.out.println("cola borrada");
		}
		
		//obtener cabeza - si se maneja objetos se retorna el objeto
		public boolean obntenerCabeza() {
			if(!ColaVacia()){
				return listacola[cabeza];
			}else {
				System.out.println("cola vacia");
				return false;
			}
		}
		
		//Insertar elemento
		public void insertar(boolean v) {
			if(!ColaLlena()) {
				listacola[++cola] = v;
			}else {
				System.out.println("cola llena");
			}
		}
		
		//Quitar
		public void quitar() {
			if(!ColaVacia()) {
				cabeza++;
				System.out.println("Elemto eliminado :" + listacola[cabeza++]);
			}else {
				System.out.println("cola vacia");
				//return -1;
			}
		}
		
		//Mostrar
		
		public void mostrar() {
			if(!ColaVacia()) {
				System.out.println("cola mostrar");
				for (int i = cabeza; i < cola; i++) {
					System.out.println(listacola[i] + " ");
				}
			}else {
			System.out.println("cola vacia");
			}
		}
		
		
		
		
		
		
		
}
