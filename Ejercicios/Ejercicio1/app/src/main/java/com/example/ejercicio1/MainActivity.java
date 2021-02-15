package com.example.ejercicio1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.app.DatePickerDialog;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public class MainActivity extends AppCompatActivity {

    Date fechaAct = new Date();
    private int annioAct = 0;
    private int mesAct = 0;
    private int annio = 0;
    private int mes = 0;
    private int dia = 0;

    Calendar myCalendar = Calendar.getInstance();
    private EditText nombres;
    private EditText apellidos;
    private EditText fechaNac;
    private EditText fechaIng;
    private EditText horasExtra;
    private EditText salario;
    private Button mostrar;
    private double resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Casteo
        nombres = (EditText)findViewById(R.id.etNombre);
        apellidos = (EditText)findViewById(R.id.etApellido);
        fechaNac = (EditText)findViewById(R.id.etFechaNac);
        fechaIng = (EditText)findViewById(R.id.etFechaIng);
        horasExtra = (EditText)findViewById(R.id.etHorasExtra);
        salario = (EditText)findViewById(R.id.etSueldo);
        mostrar = (Button)findViewById(R.id.btMostrar);

        fechaNac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(MainActivity.this,fechaN,myCalendar.get(Calendar.YEAR),
                        myCalendar.get(Calendar.MONTH),myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        fechaIng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(MainActivity.this,fechaI,myCalendar.get(Calendar.YEAR),
                        myCalendar.get(Calendar.MONTH),myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }

    DatePickerDialog.OnDateSetListener fechaN = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int mes, int dia) {
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH,mes);
            myCalendar.set(Calendar.DAY_OF_MONTH,dia);
            fechaNacimiento();
        }
    };

    DatePickerDialog.OnDateSetListener fechaI = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int mes, int dia) {
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH,mes);
            myCalendar.set(Calendar.DAY_OF_MONTH,dia);
            fechaIngreso();
        }
    };


    private void fechaNacimiento() {
        String formatoDeFecha = "dd/MM/yy";
        SimpleDateFormat formato = new SimpleDateFormat(formatoDeFecha, Locale.US);
        fechaNac.setText(formato.format(myCalendar.getTime()));
    }

    private void fechaIngreso() {
        String formatoDeFecha = "dd/MM/yy";
        SimpleDateFormat formato = new SimpleDateFormat(formatoDeFecha, Locale.US);
        fechaIng.setText(formato.format(myCalendar.getTime()));
    }

    public void calcular(View view){
        double horas2 = Double.parseDouble(horasExtra.getText().toString());
        double salario2 = Double.parseDouble(salario.getText().toString());
        //objeto
        Calculos calculos = new Calculos(salario2,horas2);
        resultado = calculos.calculoSueldo();
    }

    public void pantalla(View view){
        Intent mostrar = new Intent(this, Mostrar.class);
        mostrar.putExtra("Nombre", nombres.getText().toString());
        mostrar.putExtra("Apellido", apellidos.getText().toString());
        mostrar.putExtra("FechaNac", fechaNac.getText().toString());
        mostrar.putExtra("FechaIng", fechaIng.getText().toString());
        mostrar.putExtra("ExtraHora", horasExtra.getText().toString());
        mostrar.putExtra("SueldoBase", salario.getText().toString());
        mostrar.putExtra("SalarioTotal", resultado);
        startActivity(mostrar);
    }
}