package cola;

 //Se crean los atributos del turno de tipo String
 public class Turnos {
   String cedula;
   String turno;
   String nombre;
  
   //Constructor que inicializamos el valor de las variables.
  public Turnos(String cedula, String turno, String nombre) {
	super();
	this.cedula = cedula;
	this.turno = turno;
	this.nombre = nombre;
}
  
//Métodos get y set para los atributos.
public String getCedula() {
	return cedula;
}

public void setCedula(String cedula) {
	this.cedula = cedula;
}

public String getturno() {
	return turno;
}

public void setturno(String turno) {
	this.turno = turno;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}
  

   
}
