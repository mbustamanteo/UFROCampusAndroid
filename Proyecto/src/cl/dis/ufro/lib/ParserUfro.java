package cl.dis.ufro.lib;

import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import android.util.Log;

import cl.dis.ufro.lib.ConexionCampus.TipoConsulta;
import cl.dis.ufro.modelo.Curso;
import cl.dis.ufro.modelo.Profesor;
import cl.dis.ufro.modelo.Recurso;
import cl.dis.ufro.modelo.Tarea;

/*
 * 
 * 	ParserUFRO recibe el html de la pagina y rescata la informacion necesaria
 *  * 
 */



public class ParserUfro {

	private ConexionCampus conexion;
	
	
	
	public ParserUfro() {
		super();
		this.conexion = new ConexionCampus();
	}	


	
		// -- devuelve los bloques del curso ;)
	public ArrayList<String> getBloquesPorCurso(Curso curso){
		ArrayList<String> bloques = new ArrayList<String>();
		
		bloques.add("<html><body><td class=\"content\"><div class=\"summary\"><h3 style=\"font-weight: bold;\">Semana 01 (18 Oct - 21 Oct)<br /></h3> </div><ul class=\"section img-text\"><li class=\"activity label\" id=\"module-107996\"><img class=\"spacer\" height=\"12\" width=\"20\" src=\"http://campusvirtual.ufro.cl/pix/spacer.gif\" alt=\"\" /> <span style=\"font-weight: bold;\"> Clase 01: </span>Contexto y Entorno de desarrollo Android<br /> </li><li class=\"activity resource\" id=\"module-108018\"><img class=\"spacer\" height=\"12\" width=\"40\" src=\"http://campusvirtual.ufro.cl/pix/spacer.gif\" alt=\"\" /><a   href=\"http://campusvirtual.ufro.cl/mod/resource/view.php?id=108018\"><img src=\"http://campusvirtual.ufro.cl/theme/campusv/pix/f/folder.gif\" class=\"activityicon\" alt=\"\" /> <span>Lecturas<span class=\"accesshide \" > archivo</span></span></a></li><li class=\"activity label\" id=\"module-107999\"><img class=\"spacer\" height=\"12\" width=\"20\" src=\"http://campusvirtual.ufro.cl/pix/spacer.gif\" alt=\"\" /> <span style=\"font-weight: bold;\">Clase 02:</span> Estructura de proyecto y una aplicación Android sencilla </li><li class=\"activity resource\" id=\"module-108020\"><img class=\"spacer\" height=\"12\" width=\"40\" src=\"http://campusvirtual.ufro.cl/pix/spacer.gif\" alt=\"\" /><a   href=\"http://campusvirtual.ufro.cl/mod/resource/view.php?id=108020\"><img src=\"http://campusvirtual.ufro.cl/theme/campusv/pix/f/folder.gif\" class=\"activityicon\" alt=\"\" /> <span>Lecturas<span class=\"accesshide \" > archivo</span></span></a></li><li class=\"activity resource\" id=\"module-108021\"><img class=\"spacer\" height=\"12\" width=\"40\" src=\"http://campusvirtual.ufro.cl/pix/spacer.gif\" alt=\"\" /><a   href=\"http://campusvirtual.ufro.cl/mod/resource/view.php?id=108021\"><img src=\"http://campusvirtual.ufro.cl/theme/campusv/pix/f/folder.gif\" class=\"activityicon\" alt=\"\" /> <span>Ejercicios<span class=\"accesshide \" > archivo</span></span></a></li></ul></td></body></html>");
		bloques.add("<html><body><td class=\"content\"><div class=\"summary\"><h3>Semana 02 (25 Oct - 28 Oct)<br /></h3> </div><ul class=\"section img-text\"><li class=\"activity label\" id=\"module-108002\"><img class=\"spacer\" height=\"12\" width=\"20\" src=\"http://campusvirtual.ufro.cl/pix/spacer.gif\" alt=\"\" /> <span style=\"font-weight: bold;\"> Clase 01: </span>Interfaz de usuario en Android: Layouts<ul></ul> </li><li class=\"activity resource\" id=\"module-108008\"><img class=\"spacer\" height=\"12\" width=\"40\" src=\"http://campusvirtual.ufro.cl/pix/spacer.gif\" alt=\"\" /><a   href=\"http://campusvirtual.ufro.cl/mod/resource/view.php?id=108008\"><img src=\"http://campusvirtual.ufro.cl/theme/campusv/pix/f/folder.gif\" class=\"activityicon\" alt=\"\" /> <span>Ejemplos<span class=\"accesshide \" > archivo</span></span></a></li><li class=\"activity resource\" id=\"module-108010\"><img class=\"spacer\" height=\"12\" width=\"40\" src=\"http://campusvirtual.ufro.cl/pix/spacer.gif\" alt=\"\" /><a   href=\"http://campusvirtual.ufro.cl/mod/resource/view.php?id=108010\"><img src=\"http://campusvirtual.ufro.cl/theme/campusv/pix/f/folder.gif\" class=\"activityicon\" alt=\"\" /> <span>Lecturas<span class=\"accesshide \" > archivo</span></span></a></li><li class=\"activity resource\" id=\"module-108013\"><img class=\"spacer\" height=\"12\" width=\"40\" src=\"http://campusvirtual.ufro.cl/pix/spacer.gif\" alt=\"\" /><a   href=\"http://campusvirtual.ufro.cl/mod/resource/view.php?id=108013\"><img src=\"http://campusvirtual.ufro.cl/theme/campusv/pix/f/folder.gif\" class=\"activityicon\" alt=\"\" /> <span>Complementario<span class=\"accesshide \" > archivo</span></span></a></li><li class=\"activity label\" id=\"module-108009\"><img class=\"spacer\" height=\"12\" width=\"20\" src=\"http://campusvirtual.ufro.cl/pix/spacer.gif\" alt=\"\" /> <span style=\"font-weight: bold;\">Clase 02:</span> Interfaz de usuario en Android: Controles básicos (I)<ul></ul> </li><li class=\"activity resource\" id=\"module-108050\"><img class=\"spacer\" height=\"12\" width=\"40\" src=\"http://campusvirtual.ufro.cl/pix/spacer.gif\" alt=\"\" /><a   href=\"http://campusvirtual.ufro.cl/mod/resource/view.php?id=108050\"><img src=\"http://campusvirtual.ufro.cl/theme/campusv/pix/f/folder.gif\" class=\"activityicon\" alt=\"\" /> <span>Ejemplos<span class=\"accesshide \" > archivo</span></span></a></li><li class=\"activity resource\" id=\"module-108520\"><img class=\"spacer\" height=\"12\" width=\"40\" src=\"http://campusvirtual.ufro.cl/pix/spacer.gif\" alt=\"\" /><a   href=\"http://campusvirtual.ufro.cl/mod/resource/view.php?id=108520\"><img src=\"http://campusvirtual.ufro.cl/theme/campusv/pix/f/folder.gif\" class=\"activityicon\" alt=\"\" /> <span>Lecturas<span class=\"accesshide \" > archivo</span></span></a></li></ul></td></body></html>");
		
		return bloques;
	}
	
	
	public ArrayList<Curso> getCursos(){
		String html = this.conexion.consultar(TipoConsulta.PRINCIPAL, null);
		ArrayList<Curso> cursos = new ArrayList<Curso>();
		
		// error
		if(html == null){
			Log.i("Campus", "HTML llego mal");
			return null;
		}
		
		Document doc = Jsoup.parse(html);		
		Elements cursosRaw = doc.select(".coursebox");
		for (Element cursoRaw : cursosRaw) {
			String nombre = cursoRaw.select("div.name > a").eq(0).text();
			String nombreProfesor = cursoRaw.select("ul.teachers li  a").eq(0).text();
			String idCurso = this.getIdByURL(cursoRaw.select("div.name > a").eq(0).text());
			
			Curso curso = new Curso(idCurso, new Profesor(null,nombreProfesor,null), null, null, nombre);
			cursos.add(curso);
		}
		
		// si es vacio , error
		if(cursos.isEmpty()){
			Log.i("Campus", "Parseo vacio");
			cursos = null;
		}
			
		return cursos;		
	}
	
	// consigue la ID de la URL, devuelve null si la url es invalida
	private String getIdByURL(String url){
		String[] partes = url.split("&");
		if(partes.length == 0){
			return null;
		}
		for(String parte : partes){
			String[] temps = parte.split("=");
			if(temps.length == 2){
				if(temps[0] == "id"){
					return temps[1];
				}
			}
		}
		
		return null;

	}
	
	
	public ConexionCampus getConexion() {
		return conexion;
	}

	public void setConexion(ConexionCampus conexion) {
		this.conexion = conexion;
	}

	
	public Profesor getProfesor(String id){
		String html = this.conexion.consultar(ConexionCampus.TipoConsulta.PROFESOR,id);
		return new Profesor();
	}
	
	
	public Curso getCurso(String id){
		return new Curso();
	}
	
	public Tarea getTarea(String id){
		return new Tarea();
	}
	
	public Recurso getRecurso(String id){
		return new Recurso();
	}
	
	public ArrayList<Tarea> sincronizarTareas(){
		return null;
		
	}
	
	public ArrayList<Recurso> sincronizarRecursos(){
		return null;
	}
	
	public ArrayList<Curso> sincronizarCursos(){
		return null;
	}
	
	

	
}
