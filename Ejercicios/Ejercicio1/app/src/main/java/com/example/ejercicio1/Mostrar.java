package com.example.ejercicio1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Mostrar extends AppCompatActivity {

    private TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);
        texto = (TextView)findViewById(R.id.tvTexto);
        imprimir();
    }

    public void imprimir(){
        Bundle recogeDatos = getIntent().getExtras();
        String nombres = recogeDatos.getString("Nombre");
        String apellidos = recogeDatos.getString("Apellido");
        String fechaNac = recogeDatos.getString("FechaNac");
        String fechaIng = recogeDatos.getString("FechaIng");
        String horasEx = recogeDatos.getString("ExtraHora");
        String sueldoBase = recogeDatos.getString("SueldoBase");
        double salario = recogeDatos.getDouble("SalarioTotal");
        texto.setText("Nombre: "+nombres+" "+apellidos+"\nFecha de Nacimiento: "+fechaNac+"\nFecha de ingreso a la empresa: "+fechaIng+
                      "\nHoras extras trabajadas: "+horasEx+"\nSueldo Base: "+sueldoBase+"\nSueldo a pagar: "+salario);
    }
}