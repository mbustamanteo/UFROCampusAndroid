package cl.dis.ufro.modelo;

import java.util.Date;

public class Tarea {

	private String id;
	private String texto;
	private Date fechaInicio;
	private Date fechaTermino;
	private Boolean enviado;
	private String nombre;
	
	public Tarea() {
		// TODO Auto-generated constructor stub
	}

	
	
	
	public Tarea(String id, String texto, Date fechaInicio, Date fechaTermino,
			Boolean enviado,String nombre) {
		super();
		this.id = id;
		this.texto = texto;
		this.fechaInicio = fechaInicio;
		this.fechaTermino = fechaTermino;
		this.enviado = enviado;
		this.nombre = nombre;
	}
	
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaTermino() {
		return fechaTermino;
	}

	public void setFechaTermino(Date fechaTermino) {
		this.fechaTermino = fechaTermino;
	}

	public Boolean getEnviado() {
		return enviado;
	}

	public void setEnviado(Boolean enviado) {
		this.enviado = enviado;
	}
	
	

}
