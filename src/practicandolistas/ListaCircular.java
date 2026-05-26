/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicandolistas;

public class ListaCircular {
   private NodoDoble ini;
   private NodoDoble fin;
   
   public void insertarFinalCircular(int dato){
       NodoDoble nuevo = new NodoDoble(dato);
       
       if(ini==null){
           ini=nuevo;
           fin=nuevo;
           
           nuevo.setSgte(ini);
           nuevo.setAnt(fin);
       }else{
           nuevo.setAnt(fin);
           fin.setSgte(nuevo);
           fin=nuevo;
           fin.setSgte(ini);
           ini.setAnt(fin);
       }
       
   }
   
   public void eliminarInicioCirculo(){
       if(ini==null){System.out.println("");return;}
       
       
       if(ini==fin){
        ini=null;
        fin=null;
       }else{
        fin.setSgte(ini.getSgte());
        ini.getSgte().setAnt(fin);
       
       ini=ini.getSgte();
       }
       
       
       
   }
   
   
   
   
   
   
   
   
}
