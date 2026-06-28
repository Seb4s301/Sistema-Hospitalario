
package Arbol;

import Clases.Medico;
import java.util.Date;
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
    
    //Método INSERTAR
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
    
    //Método para BUSCAR por DNI
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
        
        
        System.out.println("Filas en modelo: " + modelo.getRowCount());
        
        return modelo;
    }
    
    private void InordenRec(NodoArbolMedico nodo, DefaultTableModel modelo){
        if(nodo == null) return;

        InordenRec(nodo.getIzq(), modelo); 
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
    
    //Método para Eliminar
    public void eliminar(String dni){
        raiz = eliminarRec(raiz, dni);
    }
    
     private NodoArbolMedico eliminarRec(NodoArbolMedico nodo, String dni){
        if(nodo == null){
            return null;
        }        
        if (dni.compareTo(nodo.getDato().getDni()) < 0){
            nodo.setIzq(eliminarRec(nodo.getIzq(), dni));
        }
        else if (dni.compareTo(nodo.getDato().getDni()) > 0){
            nodo.setDer(eliminarRec(nodo.getDer(), dni));
        }else{
            if(nodo.getIzq() == null && nodo.getDer() == null) return null;
            
            if(nodo.getIzq() == null)return nodo.getDer();
            if(nodo.getDer() == null)return nodo.getIzq();
            
            NodoArbolMedico sucesor = minimonodo(nodo.getDer());
            nodo.setDato(sucesor.getDato());
            nodo.setDer(eliminarRec(nodo.getDer(), sucesor.getDato().getDni()));
        }
        return nodo;
    }
     
    private NodoArbolMedico minimonodo(NodoArbolMedico nodo){
        while(nodo.getIzq() != null){
            nodo = nodo.getIzq();
        }
        return null;
    }
     
    public boolean modificar(String dni, String nombres, String apellidos, Date fecha, String celular, String especialidad){
        NodoArbolMedico nodo = buscarRec(raiz, dni);
        Medico medico = nodo.getDato();
        if(!nombres.trim().isEmpty()) medico.setNombres(nombres);
        if(!apellidos.trim().isEmpty()) medico.setApellidos(apellidos);
        if(fecha != null) medico.setTurno(fecha);
        if(!celular.trim().isEmpty()) medico.setCelular(celular);
        if(!especialidad.trim().isEmpty()) medico.setEspecialidad(especialidad);
        return true;        
    }
    
    //Método para poder BUSCAR
    public Medico buscarTurno(Date turno) {
        return buscarTurnoRec(raiz, turno);
    }
    
    private Medico buscarTurnoRec(NodoArbolMedico nodo, Date turno) {
        if (nodo == null) return null;
        if (nodo.getDato().getTurno().equals(turno)) return nodo.getDato();
        Medico izq = buscarTurnoRec(nodo.getIzq(), turno);
        if (izq != null) return izq;
        return buscarTurnoRec(nodo.getDer(), turno);
    }

}  
