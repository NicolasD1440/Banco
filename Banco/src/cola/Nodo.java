package cola;



public class Nodo {
	  private int informacion;
	  private Nodo referencia;
	  
	  
	  
	public Nodo(int informacion) {
		super();
		this.informacion = informacion;
	}
	
	public int getInformacion() {
		return informacion;
	}
	public void setInformacion(int informacion) {
		this.informacion = informacion;
	}
	public Nodo getReferencia() {
		return referencia;
	}
	public void setReferencia(Nodo referencia) {
		this.referencia = referencia;
	}
	  
}
