package ar.com.ditomatto.actividadesintentos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ActividadConDatosYResultados extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_con_datos_yresultados);
    }

    public void retornarElCuadrado(View view){
        //Recupero el valor recibido usando un objeto Bundle
        Bundle extras = getIntent().getExtras();
        Integer numeroRecibido = extras.getInt("ValorNumerico");
        Integer cuadrado = numeroRecibido * numeroRecibido;
        //Genero el resultado
        Intent resultado = new Intent();
        resultado.putExtra("cuadrado",cuadrado);
        setResult(RESULT_OK, resultado);
        finish();
    }
}
