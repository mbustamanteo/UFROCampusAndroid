package cl.dis.ufro.modelo;

public class Profesor {

	private String id;
	private String nombre;
	private String correo;
	
		
	public Profesor() {
		// TODO Auto-generated constructor stub
	}

	

	public Profesor(String id, String nombre, String correo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.correo = correo;
	}

	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	

}
