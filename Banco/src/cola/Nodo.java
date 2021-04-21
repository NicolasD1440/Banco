package cola;

public class Nodo {
	
	  private Turnos informacion;//Aqui se cambia por el objeto
	  private Nodo referencia;
	
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
