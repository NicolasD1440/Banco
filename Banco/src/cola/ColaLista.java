package cola;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import vistas.Portada;

public class ColaLista {
	
	    //Elementos de la cola
		private Nodo primero; //El acceso al nodo
		private Nodo ultimo; 
		private int tam;//Tamaño de la lista
		
		//constructor
		public ColaLista() {
			this.primero = null;//Se inicializan los dos punteros en null
			this.ultimo = null;
			this.tam = 0;//Se inicializa el tamaño en cero
			
		}
		
		//Este metodo se encarga de verificar si la cola esta Vacia
		public boolean ColaVacia() {
			return this.primero == null && this.ultimo == null;
			 
		}
		
		//Metodo para encolar al inicio o al final
		public void encolar(Turnos v) {
			Nodo nodo = new Nodo();
			//Se instancia la clase nodo para permitir la interación entre las dos clases
			nodo.setInformacion(v);
			//Seteamos los valores que seran asignados a las variables de instancia
			if(ColaVacia()){ //Verifica que la cola este vacia
				this.primero = nodo;
				//Si la cola esta vacia se agrega el elemento al Inicio
			}else {
				this.ultimo.setReferencia(nodo);
				//Si la cola cuenta con un elemento entonces se agrega al final
			}
			this.ultimo = nodo;
			//Se usa el this para asignar el nuevo valor al nodo
			this.tam++;
			//Aqui se usa el this para asignar el nuevo tamaño
			System.out.println("Elemento agregado");
		}
		
		//Metodo para que se encarga de obtener el tamaño
		public int getTam() {
			return this.tam;
		}
		//Este método es el encargado de guardar los datos ingresados desde la interfaz y mostrarlos en la lista;
		public DefaultListModel<String> mostrarDatos(String cedula){
			
			Nodo objeto = primero;//Se implementa la conexión con el nodo
			boolean encontrado = false;//Se crea una variable de tipo logico que sea igual a falso
			int i = 0;//Se crea una variable de tipo entero que sea igual a cero
			while(encontrado == false && i < tam) {//Se implementa el ciclo while
				//Esto permite que el código se ejecute repetidamente en función de la condición booleana.
				if(objeto.getInformacion().getCedula().equals(cedula)) {
				//Se implementa un condiconal que por medio del atributo cedula me busque un elemento que sea igual a una cedula de un usuario
					encontrado = true;
					//Si se cumple esta condicion me devuelve un valor verdadero.
				}
				else {
					objeto = objeto.getReferencia();
					i++;//El valor de la expresión es el valor de la variable antes que el nuevo valor sea almacenado.
				}
			}
			//Se instancia la lista para poder mostrar los datos en la interfaz
			DefaultListModel<String> modelo = new DefaultListModel<String>();
			if(encontrado) {//Se implementa el resultado de la variable de tipo logico la cual es verdadera
				
				//Estos son los datos que se agregaran a la lista
				modelo.addElement("Nombre: " + objeto.getInformacion().getNombre().toUpperCase() );
				modelo.addElement("Cedula: " + objeto.getInformacion().getCedula() );
				modelo.addElement("Turno: " + objeto.getInformacion().getturno() );
				modelo.addElement("Posicion: " + (i+1) );
				
			}else {
				//Si la variable logica sigue siendo falsa entonces envia este mensaje
				JOptionPane.showMessageDialog(null, "Numero de cedula no encontrado");
			}
			//Se retornan los datos que se mostraran en la lista
			return modelo;
		}
		//Metodo encargado de dar acceso al nodo para ser utilizado
		//dentro de la interfaz
		public Nodo primero() {
			return primero;
			
		}

}
