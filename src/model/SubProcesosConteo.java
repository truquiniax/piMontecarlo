/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Random;

/**
 * @author Eduar
 */
public class SubProcesosConteo extends Thread {

    
    
    
    private double distancia(double x,double y){
        return Math.sqrt(x*x+y*y);
    }
    
    public long getCantidadDentro() {
        return cantidadDentro;
    }

    public void setCantidadDentro(long cantidadDentro) {
        this.cantidadDentro = cantidadDentro;
    }

    public long getCantidadTotal() {
        return cantidadTotal;
    }
    
    public SubProcesosConteo(Random aleatorio,long conteo) {
        generador = aleatorio;
        cantidadTotal = conteo;
    }
    
    @Override
    public void run() {
        for (long i = 0; i < cantidadTotal; i++) {
            double x = generador.nextDouble();
            double y = generador.nextDouble();
            if (distancia(x, y) <= 1) {
                cantidadDentro++;
            }
        }
    }
    
    private long cantidadDentro = 0;
    private long cantidadTotal = 0;
    private Random generador = null;
}
