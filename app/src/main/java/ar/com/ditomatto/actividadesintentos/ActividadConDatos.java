package ar.com.ditomatto.actividadesintentos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class ActividadConDatos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_con_datos);
        //Recupero los valores pasados como Extras
        String cadenaRecibida = getIntent().getStringExtra("ValorString");
        Integer numeroRecibido = getIntent().getIntExtra("ValorNumerico", 0);
        //Coloco los valores recibidos en los TextViews
        TextView txtViewNumero = (TextView)findViewById(R.id.textViewNumero);
        TextView txtViewCadena = (TextView)findViewById(R.id.textViewString);
        txtViewNumero.setText(txtViewNumero.getText()+" "+numeroRecibido.toString());
        txtViewCadena.setText(txtViewCadena.getText()+" "+cadenaRecibida);
    }
}
