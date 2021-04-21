package cola;

public class Nodo {
	
	  //Atributos
	  private Turnos informacion;//Aqui se cambia por el objeto
	  private Nodo referencia;// Variable para enlazar los nodos.

	//Respectivos get y set de los atributos
	public Turnos getInformacion() {
		return informacion;
	}
	public void setInformacion(Turnos informacion) {
		this.informacion = informacion;
	}
	public Nodo getReferencia() {
		return referencia;
	}
	public void setReferencia(Nodo referencia) {
		this.referencia = referencia;
	}
	
}
