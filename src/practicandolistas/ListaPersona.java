/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicandolistas;

import java.util.Date;

/**
 *
 * @author Jean
 */
public class ListaPersona {
    NodoPersona ini;
    NodoPersona fin;

    public ListaPersona() {
        this.ini = null;
        this.fin = null;
    }
    
    public void insertar(Persona dato){
        NodoPersona nuevo = new NodoPersona(dato);
        
        if(ini==null){
            ini=nuevo;
            fin=nuevo;
        }else{
            fin.setSgte(nuevo);
            nuevo.setAnt(fin);
            fin=nuevo;
        }
    }
    
    public void imprimir(){
        if(ini==null){System.out.println("lista vacia");return;}
        NodoPersona actual =ini;
        System.out.println("");
        while(actual!=null){
            System.out.println("["+actual.getDato()+"]->");
            
            actual= actual.getSgte();
        }
    }
    
    public double promedio(){
        if(ini == null) return 0;
        
        NodoPersona actual = ini;
        int promedio = 0;
        int cantidad = 0;
        
        // Capturamos el tiempo exacto de la RAM en este instante
        long milisegundosHoy = new java.util.Date().getTime();
        
        while(actual != null){
            long milisegundosNac = actual.getDato().getFechaNacimiento().getTime();
            
            int edad = (int) ((milisegundosHoy - milisegundosNac) / 31536000000L);
            
            
            promedio = edad +promedio ;
            cantidad++;
            actual = actual.getSgte();
        }
        return 0;
    }
    
    public double promedio2(){
        if(ini==null)return 0;
        
        NodoPersona actual=ini;
        double promedio = 0;
        int cantidad= 0;
        int total= 0;
        long timeHoy = new java.util.Date().getTime();
        
        while(actual!=null){
            long nacimiento = actual.getDato().getFechaNacimiento().getTime();
            
            int edad = (int) ((timeHoy-nacimiento)/31536000000L);
            
            total=edad+total;
            cantidad++;
            actual = actual.getSgte();
        }
        promedio=(double) total/cantidad;
        
        return promedio;
    }
    
    
    
    
}
