package com.example.ejercicio3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText ax;
    private EditText bx;
    private EditText cx;
    private TextView mensaje;
    private double x0;
    private double x1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Casteo
        ax = (EditText) findViewById(R.id.etNumeroA);
        bx = (EditText) findViewById(R.id.etNumeroB);
        cx = (EditText) findViewById(R.id.etNumeroC);
        mensaje = (TextView) findViewById(R.id.tvMensaje);
    }

    public void calcular(View view){
        double a = Double.parseDouble(ax.getText().toString());
        double b = Double.parseDouble(bx.getText().toString());
        double c = Double.parseDouble(cx.getText().toString());

        double numero = (b*b) - (4*a*c);
        if (numero>0){
            x0 = (-b + Math.sqrt(numero)) / 2*a;
            x1 = (-b - Math.sqrt(numero)) / 2*a;
            mensaje.setText("La ecuacion tiene dos soluciones.\nX0: " + x0 + "\nX1: " + x1);
        }else{
            if (numero==0){
                x0 = (-b) / 2*a;
                mensaje.setText("La ecuacion tiene una solucion.\nX0" + x0);
            }else {
                mensaje.setText("La ecuacion no tiene solucion.");
            }
        }
    }
}