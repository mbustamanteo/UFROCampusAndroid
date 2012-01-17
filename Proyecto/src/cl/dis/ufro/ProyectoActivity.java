package cl.dis.ufro;

import java.util.ArrayList;

import cl.dis.ufro.lib.ConexionCampus;
import cl.dis.ufro.modelo.Campus;
import cl.dis.ufro.modelo.Curso;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.CookieSyncManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class ProyectoActivity extends Activity {
   	
	// - login
	private EditText usuario;
	private EditText contraseña;
	
	// - mostrar cursos
	private ListView listaCursos;
	
	
	 /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        
        // -- Recuperar cookies!
        CookieSyncManager.createInstance(getApplicationContext());
        
        // wena ctm!!!!
    }
    
    
    /*
     * 	Conectarse al campus
     */
    public void login(View v){
    	this.usuario = (EditText) findViewById(R.id.editText1);
    	this.contraseña = (EditText) findViewById(R.id.editText2);
    	
    	String nombreUsuario = "175832548"; //this.usuario.getText().toString();
    	String pass = "1825"; //this.contraseña.getText().toString();
    	
    	if(Campus.getInstance().login(nombreUsuario, pass)){
    		// login
        	this.mostrarCursos();
    	}else{
    		this.errorLogin();
    	}    	    	
    }
    
    /*
     * 
     * Muestra los cursos disponibles para el usuario
     */
    
    public void mostrarCursos(){
    	setContentView(R.layout.seleccion_cursos);
    	this.listaCursos = (ListView)findViewById(R.id.listView1);
    	    	
    	String[] cursos = Campus.getInstance().getNombreCursos();    	
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, cursos);
    	
    	this.listaCursos.setAdapter(adapter);
    	
    	this.listaCursos.setOnItemClickListener(new OnItemClickListener() {
    	    public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
    	          // ir a ver el curso
    	    	
    	    	  Curso cursoElegido = Campus.getInstance().getCursos().get(position);
    	    	  Campus.getInstance().setCursoActual(cursoElegido);
    	    	
    	    	  Intent i = new Intent(getApplicationContext(), VerCursoActivity.class);
    	    	  ProyectoActivity.this.startActivity(i);
    	    }
    	});
    
    }
    
    	// ups error en el ingreso - muestra un dialogo
    public void errorLogin(){
    	AlertDialog.Builder dialogo1 = new AlertDialog.Builder(this);
    	dialogo1.setTitle("Error");
    	dialogo1.setMessage("El nombre de usuario o contraseña es invalido");
    	dialogo1.setCancelable(false);
    	
    	dialogo1.setPositiveButton("OK", new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				dialog.cancel();
		
			}
		});
    	dialogo1.show();
    }
    
    	// sincroniza toda la informacion del campus - sin contar con los archivos 
    public void sincronizarTodo(View v){
    	
    }
    
}