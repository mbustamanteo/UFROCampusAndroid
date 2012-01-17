package cl.dis.ufro.modelo;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;

import android.util.Log;

import cl.dis.ufro.lib.ConexionCampus;
import cl.dis.ufro.lib.ParserUfro;

public class Campus {
	
	private File cookie;
	private String nombreDeUsuario;
	private String contraseña;
	private ArrayList<Curso> cursos;
	//--- variables entre actividades
	private Curso cursoActual;
	private Recurso recursoActual;
	private Tarea tareaActual;
	private DefaultHttpClient clienteHttp; //guardado para mantener las cookies! - no borrar nunca!
	
	  
	// Private constructor prevents instantiation from other classes
    private Campus() {
    	this.clienteHttp = new DefaultHttpClient();
    	
    /*	
    	Profesor p1 = new Profesor("qwe", "Oscar ancan", "adasdads@hotmail.com");
    	Profesor p2 = new Profesor("zxc", "Caviedes", "adasdads@hotmail.com");
    	Profesor p3 = new Profesor("erw", "Mansilla", "adasdads@hotmail.com");
    	
    	Tarea t1 = new Tarea("asdcx", "tarea 1", new Date(2012,03,01,20,0,0),  new Date(2012,03,01,20,0,0), false, "tarea 1");
    	Tarea t2 = new Tarea("asdcx", "tarea 2", new Date(2012,04,01,20,0,0),  new Date(2012,04,01,20,0,0), false, "tarea 2");
    	Tarea t3 = new Tarea("asdcx", "tarea 3", new Date(2012,03,04,20,0,0),  new Date(2012,05,01,20,0,0), false, "tarea 3");
    	Tarea t4 = new Tarea("asdcx", "tarea 4", new Date(2012,03,05,20,0,0),  new Date(2012,06,01,20,0,0), false, "tarea 4");
    	Tarea t5 = new Tarea("asdcx", "tarea 5", new Date(2012,03,06,20,0,0),  new Date(2012,07,01,20,0,0), false, "tarea 5");
    	Tarea t6 = new Tarea("asdcx", "tarea 6", new Date(2012,03,07,20,0,0),  new Date(2012,8,01,20,0,0), false, "tarea 6");
    	Tarea t7 = new Tarea("asdcx", "tarea 7", new Date(2012,03,8,20,0,0),  new Date(2012,03,9,20,0,0), false, "tarea 7");
    	Tarea t8 = new Tarea("asdcx", "tarea 8", new Date(2012,03,9,20,0,0),  new Date(2012,03,10,20,0,0), false, "tarea 8");
    	
    	Recurso r1 = new Recurso("asdwq 1", false, null, "descripcion", "recurso 1");
    	Recurso r2 = new Recurso("asdwq 2", false, null, "descripcion", "recurso 2");
    	Recurso r3 = new Recurso("asdwq 3", false, null, "descripcion", "recurso 3");
    	Recurso r4 = new Recurso("asdwq 4", false, null, "descripcion", "recurso 4");
    	Recurso r5 = new Recurso("asdwq 5", false, null, "descripcion", "recurso 5");
    	Recurso r6 = new Recurso("asdwq 6", false, null, "descripcion", "recurso 6");
    	Recurso r7 = new Recurso("asdwq 7", false, null, "descripcion", "recurso 7");
    	
    	Curso c1 = new Curso("123", p1, new ArrayList<Tarea>(Arrays.asList(t1,t2,t3)), new ArrayList<Recurso>(Arrays.asList(r1,r2,r3)), "Programacion 1");
    	Curso c2 = new Curso("123", p2, new ArrayList<Tarea>(Arrays.asList(t4,t6,t2)), new ArrayList<Recurso>(Arrays.asList(r2,r1,r1)), "Programacion 2");
    	Curso c3 = new Curso("123", p3, new ArrayList<Tarea>(Arrays.asList(t7,t1,t1)), new ArrayList<Recurso>(Arrays.asList(r3,r2,r4)), "Programacion  3");
    	Curso c4 = new Curso("123", p1, new ArrayList<Tarea>(Arrays.asList(t4,t1,t6)), new ArrayList<Recurso>(Arrays.asList(r4,r5,r5)), "Programacion 4");
    	Curso c5 = new Curso("123", p2, new ArrayList<Tarea>(Arrays.asList(t3,t2,t7)), new ArrayList<Recurso>(Arrays.asList(r5,r3,r6)), "Programacion 5");
    	Curso c6 = new Curso("123", p3, new ArrayList<Tarea>(Arrays.asList(t2,t5,t5)), new ArrayList<Recurso>(Arrays.asList(r6,r4,r7)), "Programacion 6");
    	Curso c7 = new Curso("123", p3, new ArrayList<Tarea>(Arrays.asList(t1,t3,t2)), new ArrayList<Recurso>(Arrays.asList(r7,r6,r1)), "Programacion 7");
    	Curso c8 = new Curso("123", p2, new ArrayList<Tarea>(Arrays.asList(t1,t6,t6,t8)), new ArrayList<Recurso>(Arrays.asList(r1,r7,r2)), "Programacion 8");
    	
    	this.cursos = new ArrayList<Curso>(Arrays.asList(c1,c2,c3,c4,c5,c6,c7,c8));
    	*/
    }

    	// conseguir info guardada en el android
    public void recuperarInfo(){
    	
    }
    	// login
    public boolean login(String nombreDeUsuario, String contraseña){
    	ConexionCampus conn = new ConexionCampus();
    	if(conn.login(nombreDeUsuario,contraseña)){
    		this.nombreDeUsuario = nombreDeUsuario;
    		this.contraseña = contraseña;
    		return true;
    	}else{
    		return false;
    	}
    }
    
    	// devuelve lista de nombres de cursos
    public String[] getNombreCursos(){
    	if(this.cursos == null){
    		ParserUfro parser = new ParserUfro();
			this.cursos = parser.getCursos();
			if(this.cursos == null){
				Log.i("Campus","cursos nulos ctm!!!!!");
				return null;
			}
    	}
      	String[] nombres = new String[this.cursos.size()];
    	for (int i = 0; i < this.cursos.size(); i++) {
			nombres[i] = this.cursos.get(i).getNombre();
		} 

		   	
    	return nombres;
    }
    
    
    public void mostrarCadenaLargaEnLog(String respuesta){
		//Log.i("Campus", "mostrarCadenaLargaEnLog");
		//Log.i("Campus","TERERE - "+ respuesta);
		 int maxLogSize = 1000;
		 for(int i = 0; i <= respuesta.length() / maxLogSize; i++) {
		    int start = i * maxLogSize;
		    int end = (i+1) * maxLogSize;
		    end = end > respuesta.length() ? respuesta.length() : end;
		    Log.v("Campus", respuesta.substring(start, end));
		 }
	}
    
    
    
    
    public DefaultHttpClient getClienteHttp() {
		return clienteHttp;
	}

	public void setClienteHttp(DefaultHttpClient clienteHttp) {
		this.clienteHttp = clienteHttp;
	}

	public Recurso getRecursoActual() {
		return recursoActual;
	}

	public void setRecursoActual(Recurso recursoActual) {
		this.recursoActual = recursoActual;
	}

	public Tarea getTareaActual() {
		return tareaActual;
	}

	public void setTareaActual(Tarea tareaActual) {
		this.tareaActual = tareaActual;
	}

	public Curso getCursoActual() {
		return cursoActual;
	}

	public void setCursoActual(Curso cursoActual) {
		this.cursoActual = cursoActual;
	}

	public File getCookie() {
		return cookie;
	}

	public void setCookie(File cookie) {
		this.cookie = cookie;
	}

	public String getNombreDeUsuario() {
		return nombreDeUsuario;
	}

	public void setNombreDeUsuario(String nombreDeUsuario) {
		this.nombreDeUsuario = nombreDeUsuario;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public ArrayList<Curso> getCursos() {
		// si no hay, conseguir
		if(this.cursos == null ){
			ParserUfro parser = new ParserUfro();
			this.cursos = parser.getCursos();			
		}
		return cursos;
	}

	public void setCursos(ArrayList<Curso> cursos) {
		this.cursos = cursos;
	}

	
	/*
     * Metodos del singleton
     */
    
	private static class CampusHolder { 
            public static final Campus instance = new Campus();
    }

    public static Campus getInstance() {
            return CampusHolder.instance;
    }
    
    

}
