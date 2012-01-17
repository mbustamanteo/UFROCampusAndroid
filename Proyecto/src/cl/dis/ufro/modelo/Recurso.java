package cl.dis.ufro.modelo;

import java.util.ArrayList;

public class Recurso {
	
	private String id;
	private Boolean esEnlaceArchivo;
	private ArrayList<Archivo> archivos;
	private String descripcion;
	private String nombre;
	
	public Recurso(String id, Boolean esEnlaceArchivo,ArrayList<Archivo> archivos, String descripcion, String nombre) {
		super();
		this.id = id;
		this.esEnlaceArchivo = esEnlaceArchivo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		if(archivos != null){
			this.archivos = archivos;
		}else{
			this.archivos = new ArrayList<Archivo>();
		}
	}
	
	public Recurso(){
		super();
		this.archivos = new ArrayList<Archivo>();
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
	public Boolean getEsEnlaceArchivo() {
		return esEnlaceArchivo;
	}
	public void setEsEnlaceArchivo(Boolean esEnlaceArchivo) {
		this.esEnlaceArchivo = esEnlaceArchivo;
	}
	public ArrayList<Archivo> getArchivos() {
		return archivos;
	}
	public void setArchivos(ArrayList<Archivo> archivos) {
		this.archivos = archivos;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
	
	
}
