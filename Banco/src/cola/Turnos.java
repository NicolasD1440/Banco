package cola;

public class Turnos {
   int posicion;
   String cedula;
   String turno;
   String nombre;
   
  public Turnos(int posicion,String cedula, String turno, String nombre) {
	super();
	this.posicion = posicion;
	this.cedula = cedula;
	this.turno = turno;
	this.nombre = nombre;
}

public int getPosicion() {
	return posicion;
}

public void setPosicion(int posicion) {
	this.posicion = posicion;
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
