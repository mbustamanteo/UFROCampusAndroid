package cl.dis.ufro.lib;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;

import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;

import cl.dis.ufro.modelo.Campus;

/*
 * 
 * Clase que maneja la conexion con el sitio web http://campusvirtual.ufro.cl
 * 
 * 
 */

public class ConexionCampus {

	public enum TipoConsulta{
		PROFESOR,
		CURSO,
		RECURSO,
		LISTARECURSOS,
		TAREA,
		LISTATAREAS,
		PRINCIPAL
	}
	
	/*
	 * URL's --- Reemplazamos las URLS con los id's correspondientes
	 */
	private final String urlMain 			= "http://campusvirtual.ufro.cl/";
	private final String urlLogin			= "http://campusvirtual.ufro.cl/login/index.php";
	private final String urlProfesor 		= "http://campusvirtual.ufro.cl/user/view.php?id=XXXXXX";
	private final String urlCurso 			= "http://campusvirtual.ufro.cl/course/view.php?id=XXXXXX";
	private final String urlRecurso 		= "http://campusvirtual.ufro.cl/mod/resource/view.php?id=XXXXXX";
	private final String urlListaRecursos 	= "http://campusvirtual.ufro.cl/mod/resource/index.php?id=XXXXXX";
	private final String urlTarea 			= "http://campusvirtual.ufro.cl/mod/assignment/view.php?id=XXXXXX";
	private final String urlListaTareas 	= "http://campusvirtual.ufro.cl/mod/assignment/index.php?id=XXXXXX";
	// ----
	private String cookie;
	
	
	public ConexionCampus(String cookie) {
		this.cookie = cookie;
	}
		
	public ConexionCampus() {
		super();
	}
	
		// se conecta al campusvirtual
	public boolean login(String nombreDeUsuario, String contraseña){
		boolean exito = false;
		
		DefaultHttpClient httpclient = Campus.getInstance().getClienteHttp();
		BufferedReader in = null;
		try {

			HttpGet httpget = new HttpGet("http://campusvirtual.ufro.cl/login/index.php");
			HttpResponse response = httpclient.execute(httpget);
			HttpEntity entity = response.getEntity();

			// conseguir cookies para loguearse
			//Log.i("Campus", "Login form get: " + response.getStatusLine());
			List<Cookie> cookies = httpclient.getCookieStore().getCookies();
			if (cookies.isEmpty()) {
				Log.i("Campus", "no hay cookies");
			}

			//teniendo las cookies, loguearse via POST
			HttpPost httpost = new HttpPost(this.urlLogin);

			// crear url
			List<BasicNameValuePair> nvps = new ArrayList<BasicNameValuePair>();
			nvps.add(new BasicNameValuePair("username", "175832548"));
			nvps.add(new BasicNameValuePair("password", "1825"));
			nvps.add(new BasicNameValuePair("submit", "Login"));			
			httpost.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));
			
			//enviar
			response = httpclient.execute(httpost);
			entity = response.getEntity();

			//Log.i("Campus", "Login form get: " + response.getStatusLine());
			if (entity != null) {
				//entity.consumeContent();
			}
		
			// buscar si estamos aun en el login, sino estamos logueados!!!!
			in = new BufferedReader (new InputStreamReader(response.getEntity().getContent()));
	        String line = "";
	        while ((line = in.readLine()) != null) {
	        	//estamos logueados
	        	if(line.contains("http://campusvirtual.ufro.cl/login/logout.php?")){
	        		exito = true;
	        		break;
	        	}
	        	       	
	        	// llegamos al final de head, terminar
	        	if(line.contains("<!-- END OF HEADER -->")){ 
	        		break;
	        	}
	        }
	        // cerrar
	        in.close();
	        HttpEntity enty = response.getEntity();
	        if (enty != null){
	            enty.consumeContent();
	        }
	        // si tuvimos exito
			if(exito){
				Log.i("Campus","Login exitoso!!!!!");
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			exito = false;
			e.printStackTrace();
		}finally {
			// cerrar conexiones para liberar memoria
			
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
         }

		return exito;
	}

	// consulta a la web y devuelve el resultado
	public String consultar(TipoConsulta tipo, String id){
		String respuesta;
		switch (tipo) {
			case PROFESOR:
				respuesta = this.conn(this.urlProfesor.replace("XXXXXX", id));				
				break;
			case CURSO:
				respuesta = this.conn(this.urlCurso.replace("XXXXXX", id));
				break;
			case PRINCIPAL:
				respuesta = this.conn(this.urlMain);
				Campus.getInstance().mostrarCadenaLargaEnLog(respuesta);						
				
				break;
			case TAREA:
				respuesta = this.conn(this.urlTarea.replace("XXXXXX", id));
				break;
			case LISTATAREAS:
				respuesta = this.conn(this.urlListaTareas.replace("XXXXXX", id));
				break;
			case LISTARECURSOS:
				respuesta = this.conn(this.urlListaRecursos.replace("XXXXXX", id));
				break;
			case RECURSO:
				respuesta = this.conn(this.urlRecurso.replace("XXXXXX", id));
				break;	
			default:
				respuesta = null;
				break;
		}
		return respuesta;
	}
	
	
	
	
	private String conn(String url){
		Log.i("Campus", "Consultar URL:" + url);
		
		DefaultHttpClient httpclient = Campus.getInstance().getClienteHttp();
		BufferedReader in = null;
		StringBuilder total = new StringBuilder();
		try{
			
			// hacer consulta
			HttpGet httpget = new HttpGet(url);
			HttpResponse response = httpclient.execute(httpget);
			HttpEntity entity = response.getEntity();	
			
			// obtener respuesta
			String line = "";
			in = new BufferedReader(new InputStreamReader(entity.getContent()));
			while ((line = in.readLine()) != null) { 
			        total.append(line); 
			}
			    
			
		}catch (Exception e) {
			// TODO: handle exception
		}finally{
			// liberar recursos
		}
		
		return total.toString();
		
	}
	

	/**
	 * setters y getters
	 * 
	 */
		

	public String getCookie() {
		return cookie;
	}


	public void setCookie(String cookie) {
		this.cookie = cookie;
	}


	public String getUrlMain() {
		return urlMain;
	}


	public String getUrlLogin() {
		return urlLogin;
	}


	public String getUrlProfesor() {
		return urlProfesor;
	}


	public String getUrlCurso() {
		return urlCurso;
	}


	public String getUrlRecurso() {
		return urlRecurso;
	}


	public String getUrlTarea() {
		return urlTarea;
	}
	
	
	
	

}
