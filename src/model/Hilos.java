/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author Eduar
 */
public class Hilos {
    
    public Hilos(int cantHilos,int cantI) {
        this.CantHilos = cantHilos;
        CantIteracion = cantI;
        hilos = new LinkedList();
        Pool = Executors.newFixedThreadPool(cantHilos);
        iniciarProcesos();
    }
    
    public void iniciarProcesos(){
        Random aleator = new Random();
        for(int i = 0; i < CantHilos; i++)
            hilos.add(new SubProcesosConteo(aleator,CantIteracion/CantHilos));
    }
    
    public void iniciarTodos(){
        for(SubProcesosConteo s : hilos){
            Pool.execute(s);
        }
        Pool.shutdown();    
    }
    
    public double pi(){
        iniciarTodos();
        long totalDentro = 0;long totalTotal = 0;
            while (!Pool.isTerminated());
            for (SubProcesosConteo t : hilos) {
                totalDentro += t.getCantidadDentro();
                totalTotal += t.getCantidadTotal();
            }
            return 4.0 * totalDentro / totalTotal;
    }
    private ExecutorService Pool; 
    private int CantHilos = 0;
    private int CantIteracion = 0;
    private LinkedList<SubProcesosConteo> hilos;    
}
