package cl.dis.ufro;

import java.util.ArrayList;

import cl.dis.ufro.lib.ParserUfro;
import cl.dis.ufro.modelo.Campus;
import cl.dis.ufro.modelo.Curso;
import cl.dis.ufro.modelo.Recurso;
import cl.dis.ufro.modelo.Tarea;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

public class VerCursoActivity extends Activity {
	
	 private Curso curso;
	 private ListView lista;
	 
	
	 @Override
	 public void onCreate(Bundle savedInstanceState) {
	     super.onCreate(savedInstanceState);
	     setContentView(R.layout.ver_curso);
	     
	     this.curso = Campus.getInstance().getCursoActual();
	         
	     
	     this.cargarInfo();
	 }
	 
	 
	 
	 // -- carga la informacion a la pantalla
	 public void cargarInfo(){
		 // obtener informacion
		 ParserUfro parser = new ParserUfro();
		 ArrayList<String> bloques = parser.getBloquesPorCurso(this.curso);
		 
		 WebView vista = (WebView)findViewById(R.id.webview1);
		 Log.i("campus", bloques.get(0));
		 vista.loadData(bloques.get(0), null, "UTF-8");
	 
		 
		 
	 }
	 
	 
	 // metodos del menu
	 public boolean onCreateOptionsMenu(Menu menu){
	    	MenuInflater inflater = getMenuInflater();
	    	inflater.inflate(R.menu.menu_principal, menu);
	    	return true;
	 }
	 
	 public boolean onOptionsItemSelected(MenuItem item){
	    	switch (item.getItemId()) {
				case R.id.itemRecursos:		
					this.setupSeleccionRecursos();
					break;
				
				case R.id.itemTareas:
					this.setupSeleccionTareas();
					break;					
			}
	    	return true;
	    }
	 
	 public void setupSeleccionRecursos(){
		 setContentView(R.layout.seleccion_recursos);
		 
		 this.lista = (ListView) findViewById(R.id.listViewRecursos);
		 
		 String[] cursos = this.curso.getNombreRecursos();   	
		 ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, cursos);
	    	
	     this.lista.setAdapter(adapter);
	     this.lista.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				Recurso rec = VerCursoActivity.this.curso.getRecursos().get(arg2);
				Campus.getInstance().setRecursoActual(rec);
				
  	    	  	Intent i = new Intent(getApplicationContext(), VerRecursoActivity.class);
  	    	  	VerCursoActivity.this.startActivity(i);
			}
	    	 
		});
		 
		 
	 }
	 
	 public void setupSeleccionTareas(){
		 setContentView(R.layout.seleccion_tareas);

		 this.lista = (ListView) findViewById(R.id.listViewTareas);
		 
		 String[] tareas = this.curso.getNombreTareas();   	
		 ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, tareas);
	    	
	     this.lista.setAdapter(adapter);
	     this.lista.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
						long arg3) {
					// TODO Auto-generated method stub
					Tarea tar = VerCursoActivity.this.curso.getTareas().get(arg2);
					Campus.getInstance().setTareaActual(tar);
					
	  	    	  	Intent i = new Intent(getApplicationContext(), VerTareaActivity.class);
	  	    	  	VerCursoActivity.this.startActivity(i);
				}
		    	 
		});
		 
	 }

}
