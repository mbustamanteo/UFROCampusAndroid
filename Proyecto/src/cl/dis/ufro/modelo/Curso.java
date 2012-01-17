package cl.dis.ufro.modelo;

import java.util.ArrayList;
import java.util.Arrays;

public class Curso {

	private String id;
	private String nombre;
	private Profesor profesor;
	private ArrayList<Tarea> tareas;
	private ArrayList<Recurso> recursos;
	
	
	public Curso(){
		
	}
	
	public Curso(String id, Profesor profesor, ArrayList<Tarea> tareas,ArrayList<Recurso> recursos, String nombre) {
		super();
		this.id = id;
		this.profesor = profesor;
		this.nombre = nombre;
		
		if(tareas != null){
			this.tareas = tareas;
		}else{
			this.tareas = new ArrayList<Tarea>();
		}
		
		if(recursos != null){
			this.recursos = recursos;
		}else{
			this.recursos = new ArrayList<Recurso>();
		}
	}
	
	public String[] getNombreRecursos(){
		
		if(this.recursos.size() == 0){
			return null;
		}
		
		String[] nombres = new String[this.recursos.size()];
		for(int i= 0; i < this.recursos.size(); i++){
			nombres[i] = this.recursos.get(i).getNombre();
		}
		return nombres;
	}
	
	public String[] getNombreTareas(){
		
		if(this.tareas.size() == 0){
			return null;
		}
		
		String[] nombres = new String[this.tareas.size()];
		for(int i= 0; i < this.tareas.size(); i++){
			nombres[i] = this.tareas.get(i).getNombre();
		}
		return nombres;
	}
	
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void agregarTarea(Tarea object){
		this.tareas.add(object);
	}
	
	public void agregarRecurso(Recurso obj){
		this.recursos.add(obj);
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public Profesor getProfesor() {
		return profesor;
	}


	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}


	public ArrayList<Tarea> getTareas() {
		return tareas;
	}


	public void setTareas(ArrayList<Tarea> tareas) {
		this.tareas = tareas;
	}


	public ArrayList<Recurso> getRecursos() {
		return recursos;
	}


	public void setRecursos(ArrayList<Recurso> recursos) {
		this.recursos = recursos;
	}
	
	
	
	
	
	
	
}
