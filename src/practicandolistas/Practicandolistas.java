/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practicandolistas;

/**
 *
 * @author Jean
 */
public class Practicandolistas {
    public static void main(String[] args) {
        
        ListaSimple prueba= new ListaSimple();
        
        prueba.insertar(500);
        prueba.insertar(15);
        prueba.insertar(20);
        prueba.insertar(200);
        
        prueba.imprimir();
        
        prueba.promedio();
        prueba.sumar();
        
        prueba.eliminar(20);
        prueba.imprimir();
        
        prueba.MayorMenor();
        
        prueba.cantidadMayorMenorPromedio();
        
        prueba.insertar(20);
        prueba.insertar(50);
        prueba.insertar(2);
        prueba.ordenamiento();
        
        prueba.insertarInicio(1);
        
        prueba.imprimir();
        
        prueba.InsertarEnPocision(24, 20);
        prueba.InsertarEnPocision(4, 128);
        prueba.imprimir();
        
        ListaDoble prueba2 = new ListaDoble();
        
        System.out.println("");
        prueba2.insertar2(10);
        prueba2.insertar2(424);
        prueba2.insertar2(51);
        prueba2.insertar2(50);
        prueba2.insertar2(20);
        prueba2.insertar2(65);
        prueba2.insertar2(33);
        prueba2.insertar2(5);
        
        prueba2.imprimir2();
        
        System.out.println("");
        prueba2.insertarInicio(0);
        
        System.out.println("");
        prueba2.eliminarPrimero();
        
        System.out.println("");
        prueba2.invertirImpares();
        
        System.out.println("");
        prueba2.inversionCompleta();
        
        
    }
}
