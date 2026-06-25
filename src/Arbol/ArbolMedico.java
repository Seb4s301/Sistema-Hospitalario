
package Arbol;

import Clases.Medico;
import javax.swing.table.DefaultTableModel;
import Nodo.NodoMedico;

public class ArbolMedico {
    private NodoArbolMedico raiz;
    private static ArbolMedico instancia;

    public ArbolMedico() {
        raiz = null;    
    }

    public NodoArbolMedico getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoArbolMedico raiz) {
        this.raiz = raiz;
    }
    
    public static ArbolMedico getInstancia(){
        if(instancia == null){
            instancia = new ArbolMedico();
        }
        return instancia;
    }
    
    public void insertar(Medico dato){
        raiz = insertarRec(raiz, dato);
    }
    
     private NodoArbolMedico insertarRec(NodoArbolMedico nodo, Medico dato){
        if(nodo == null){
            return new NodoArbolMedico(dato);
        }      
        if(dato.getDni().compareTo(nodo.getDato().getDni()) < 0){
            nodo.setIzq(insertarRec(nodo.getIzq(), dato));
        if(dato.getDni().compareTo(nodo.getDato().getDni()) > 0){
                nodo.setDer(insertarRec(nodo.getDer(), dato));
            }
        }
        return nodo;
    }
     
    public Medico buscar(String dni){
        NodoArbolMedico nodo = buscarRec(raiz, dni);
        if(nodo != null){
            return nodo.getDato();
        }else{
            return null;
        }
    }
    
    private NodoArbolMedico buscarRec(NodoArbolMedico nodo, String dni) {
        if (nodo == null) return null;
        if (dni.compareTo(nodo.getDato().getDni()) == 0) return nodo;
        if (dni.compareTo(nodo.getDato().getDni()) < 0) return buscarRec(nodo.getIzq(), dni);
        return buscarRec(nodo.getDer(), dni);
    }
    
    public DefaultTableModel ListaInorden() {
        String columnas[] = {"DNI","NOMBRES","APELLIDOS","TURNO","CELULAR","ESPECIALIDAD"};
        
        DefaultTableModel modelo = new DefaultTableModel(null, columnas);
         
        InordenRec(raiz, modelo);
        
        return modelo;
    }
    
    private void InordenRec(NodoArbolMedico nodo, DefaultTableModel modelo){
        if(nodo == null){
            InordenRec(nodo.getIzq(), modelo);
        }
        
        modelo.addRow(new Object[]{
            nodo.getDato().getDni(),
            nodo.getDato().getNombres(),
            nodo.getDato().getApellidos(),
            nodo.getDato().getTurno(),
            nodo.getDato().getCelular(),
            nodo.getDato().getEspecialidad()
        });
        InordenRec(nodo.getDer(), modelo);
    }
    
    public void reconstruir(NodoMedico ini) {
    raiz = null;
    NodoMedico tmp = ini;
    while (tmp != null) {
        insertar(tmp.getDato());
        tmp = tmp.getSgte();
    }
}
}
    
    
