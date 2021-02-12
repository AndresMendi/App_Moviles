package com.example.varios_controles;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Pago extends AppCompatActivity {

    private TextView pagoResultado;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pago);
        impresion_pantalla();
    }
    public void impresion_pantalla(){
        Bundle recogeDatos = getIntent().getExtras();
        double pago = recogeDatos.getDouble("pago");
        pagoResultado = (TextView) findViewById(R.id.tvPago);
        pagoResultado.setText(pago+"");
    }
}