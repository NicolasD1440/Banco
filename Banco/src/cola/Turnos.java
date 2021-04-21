package cola;

public class Turnos {
   String cedula;
   String turno;
   String nombre;
   
  public Turnos(String cedula, String turno, String nombre) {
	super();
	this.cedula = cedula;
	this.turno = turno;
	this.nombre = nombre;
}
  
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
