package com.example.ejercicio2;

public class Division {
    private double numero1;
    private double numero2;

    public Division(double numero1, double numero2) {
        this.numero1 = numero1;
        this.numero2 = numero2;
    }

    double resultadoDivi(){
        double total = 0;
        total = numero1 / numero2;
        return total;
    }
}
