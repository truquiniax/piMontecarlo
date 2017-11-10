/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import model.Hilos;

/**
 * @author Eduar
 */
public class Main {
    
    public static void main(String [] args){
        Hilos hil = new Hilos(6, (int) 1e7);
        System.out.println("Aproximacion de PI Montecarlo: "+hil.pi());    
    }
}
