package com.example.varios_controles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class Registro extends AppCompatActivity {

    private EditText etNombreM;
    private RadioButton rbPerro, rbGato;
    private Button registro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        //Comunicación o búsqueda de componentes, relación entre la parte lógica con la parte gráfica
        etNombreM = (EditText) findViewById(R.id.etNombreMascota);
        rbPerro = (RadioButton) findViewById(R.id.rbPerro);
        rbGato = (RadioButton) findViewById(R.id.rbGato);
    }
    public void total_Pago(View v){
        String nombre = etNombreM.getText().toString();
        String tipoM;
        if(rbPerro.isChecked() == true){
            tipoM="perro";
        }else{
            tipoM="gato";
        }
        Mascota m1 = new Mascota(nombre, tipoM);
        double pago = m1.pago();
        //Para pasar los parámetros lo hacemos con un objeto Intent, se coloca el activity origine u el destino
        Intent resultadoPago = new Intent(this, Pago.class);
        resultadoPago.putExtra("pago", pago);
        startActivity(resultadoPago);
    }
}