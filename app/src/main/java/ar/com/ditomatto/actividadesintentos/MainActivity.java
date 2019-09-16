package ar.com.ditomatto.actividadesintentos;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editTextNumeroEntero;
    EditText editTextCadenaDeCaracteres;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextNumeroEntero = (EditText) findViewById(R.id.editTextNumeroEntero);
        editTextCadenaDeCaracteres = (EditText) findViewById(R.id.editTextCadenaDeCaracteres);
        Button btnLanzarContactos = (Button)findViewById(R.id.button6);
        btnLanzarContactos.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("content://contacts/people/")));
            }
        });
        Button btnIniciarLlamada = (Button)findViewById(R.id.button7);
        btnIniciarLlamada.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("tel:123456")));
            }
        });
    }

    public void invocarActividadSinDatos(View view){
        //Invocacion explicita con el nombre de la actividad
        startActivity(new Intent(this, ActividadSinDatos.class));
    }

    public void invocarActividadConDatos(View view){
        String cadena = editTextCadenaDeCaracteres.getText().toString();
        Integer numero = Integer.parseInt(editTextNumeroEntero.getText().toString());
        //Invocacion explicita creando un objeto Intent y con info Extra
        Intent intencion = new Intent("ar.com.ditomatto.actividadesintentos.ActividadConDatos");
        intencion.putExtra("ValorNumerico", numero);
        intencion.putExtra("ValorString",cadena);
        startActivity(intencion);
    }

    public void invocarActividadConDatosYResultados(View view){ ;
        Intent intencion = new Intent("ar.com.ditomatto.actividadesintentos.ActividadConDatosYResultados");
        //Uso de un objeto Bundle para pasar los datos
        Bundle extras = new Bundle();
        extras.putInt("ValorNumerico", Integer.parseInt(editTextNumeroEntero.getText().toString()));
        intencion.putExtras(extras);
        startActivityForResult(intencion,1);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data){
        //Controla si el requestCode es 1
        if (requestCode==1){
            //Verifica si el resultado fue OK
            if(resultCode==RESULT_OK){
                //Recupera los resultados
                Toast.makeText(this,Integer.toString(
                        data.getIntExtra("cuadrado",0)),
                        Toast.LENGTH_LONG).show();
            }
        }

    }

    public void invocarActividadNavegador(View view){
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.unse.edu.ar/")));
    }

    public void invocarActividadBuscador(View view){
        Intent intent= new Intent(Intent.ACTION_WEB_SEARCH );
        intent.putExtra(SearchManager.QUERY, "android intents implicitos");

        startActivity(intent);

    }
}
