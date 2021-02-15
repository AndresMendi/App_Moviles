package com.example.ejercicio2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText numero1;
    private EditText numero2;
    private TextView resultado;
    private double total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //casteo
        numero1 = (EditText) findViewById(R.id.etNumero1);
        numero2 = (EditText) findViewById(R.id.etNumero2);
        resultado = (TextView) findViewById(R.id.tvResultadoOpera);
    }

    public void suma(View view){
        double numero_1 = Double.parseDouble(numero1.getText().toString());
        double numero_2 = Double.parseDouble(numero2.getText().toString());
        //crear objeto
        Suma suma = new Suma(numero_1, numero_2);
        total = suma.resultadoSumatoria();
        resultado.setText("El resultado es: " + total);
    }

    public void resta(View view){
        double numero_1 = Double.parseDouble(numero1.getText().toString());
        double numero_2 = Double.parseDouble(numero2.getText().toString());
        //crear objeto
        Resta resta = new Resta(numero_1, numero_2);
        total = resta.resultadoResta();
        resultado.setText("El resultado es: " + total);
    }

    public void multiplicacion(View view){
        double numero_1 = Double.parseDouble(numero1.getText().toString());
        double numero_2 = Double.parseDouble(numero2.getText().toString());
        //crear objeto
        Multipliacion multipliacion = new Multipliacion(numero_1, numero_2);
        total = multipliacion.resultadoMulti();
        resultado.setText("El resultado es: " + total);
    }

    public void division(View view){
        double numero_1 = Double.parseDouble(numero1.getText().toString());
        double numero_2 = Double.parseDouble(numero2.getText().toString());
        //crear objeto
        Division division = new Division(numero_1, numero_2);
        total = division.resultadoDivi();
        resultado.setText("El resultado es: " + total);
    }

    public void borrar(View view){
        numero1.setText("");
        numero2.setText("");
        resultado.setText("");
    }
}