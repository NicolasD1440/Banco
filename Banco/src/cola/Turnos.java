package cola;

public class Turnos {
   int posicion;
   String codigo;
   String nombre;
   
  public Turnos(int posicion, String codigo, String nombre) {
	super();
	this.posicion = posicion;
	this.codigo = codigo;
	this.nombre = nombre;
}

public int getPosicion() {
	return posicion;
}

public void setPosicion(int posicion) {
	this.posicion = posicion;
}

public String getCodigo() {
	return codigo;
}

public void setCodigo(String codigo) {
	this.codigo = codigo;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}
  

   
}
