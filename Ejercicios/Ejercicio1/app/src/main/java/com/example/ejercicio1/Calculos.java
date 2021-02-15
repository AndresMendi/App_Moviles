package com.example.ejercicio1;

public class Calculos {

    double sueldo;
    double horasEx;

    public Calculos(double sueldo, double horasEx) {
        this.sueldo = sueldo;
        this.horasEx = horasEx;
    }
    double calculoSueldo(){
        double total = 0;
        total = sueldo + (horasEx*(sueldo*0.02));
        return total;
    }
}
