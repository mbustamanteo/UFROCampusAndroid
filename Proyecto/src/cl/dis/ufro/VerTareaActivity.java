package cl.dis.ufro;

import java.text.SimpleDateFormat;

import cl.dis.ufro.modelo.Campus;
import cl.dis.ufro.modelo.Tarea;
import android.app.Activity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.TextView;

public class VerTareaActivity extends Activity {

	private Tarea tarea;
	
	 @Override
	 public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.ver_tarea);
	        
	        this.tarea = Campus.getInstance().getTareaActual();
	        
	        SimpleDateFormat curFormater = new SimpleDateFormat("dd/MM/yyyy hh:mm"); 
	              
        
	       TextView fechaInicio = (TextView) findViewById(R.id.textView2);
	       TextView fechaTermino = (TextView) findViewById(R.id.textView4);
	       
	       
	     
	       fechaInicio.setText(curFormater.format(this.tarea.getFechaInicio()));
	       fechaTermino.setText(curFormater.format(this.tarea.getFechaTermino()));
	       
	       TextView enviado = (TextView) findViewById(R.id.textView6);
	       if(this.tarea.getEnviado()){
	    	   enviado.setText("Sí");
	       }else{
	    	   enviado.setText("No");
	       }
	       
	 }
}
