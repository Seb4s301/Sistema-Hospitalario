package practicandolistas;

import javax.swing.table.DefaultTableModel;

public class ListaDoble {
    NodoDoble ini;
    NodoDoble fin;
    
    public ListaDoble() {
        this.ini = null;
        this.fin = null;
    }
    
    public void mostrarEnTabla(DefaultTableModel modelo) {
        modelo.setRowCount(0); 
        
        NodoDoble actual = ini;
        int posicion = 1;
        while (actual != null) {
            modelo.addRow(new Object[]{posicion, actual.getDato()});
            actual = actual.getSgte();
            posicion++;
        }
    }
    
    public void mostrarEnTablaInverso(DefaultTableModel modelo) {
        modelo.setRowCount(0); 
        
        NodoDoble actual = fin;
        int posicion = 1;
        while (actual != null) {
            modelo.addRow(new Object[]{posicion, actual.getDato()});
            actual = actual.getAnt();
            posicion++;
        }
    }
    
    public void insertar2(int dato) {
        NodoDoble nuevo = new NodoDoble(dato);
        
        if (ini == null) {
            ini = nuevo;
            fin = nuevo;
        } else {
            fin.setSgte(nuevo);
            nuevo.setAnt(fin);
            fin = nuevo;
        }
    }
    
    public void insertarInicio(int dato) {
        NodoDoble nuevo = new NodoDoble(dato);
        
        if (ini == null) {
            ini = nuevo;
            fin = nuevo;
        } else {
            nuevo.setSgte(ini);
            ini.setAnt(nuevo);
            ini = nuevo;
        }
    }
    
    public void eliminarPrimero() { 
        if (ini == null) return;
        
        if (ini == fin) {
            ini = null;
            fin = null;
        } else {
            ini = ini.getSgte();
            ini.setAnt(null);
        }
    }
    
    public void invertirImpares() {
        if (ini == null) return;
        
        NodoDoble izq = ini;
        NodoDoble der = fin;
        
        while (izq != der && izq.getAnt() != der) {
            if (izq.getDato() % 2 == 0) {
                izq = izq.getSgte();
                continue;
            }
            if (der.getDato() % 2 == 0) {
                der = der.getAnt();
                continue;
            }
            
            int temp = izq.getDato();
            izq.setDato(der.getDato());
            der.setDato(temp);
            
            izq = izq.getSgte();
            der = der.getAnt();
        }
    }
    
    public void inversionCompleta() {
        if (ini == null) return;
        
        NodoDoble actual = ini;
        NodoDoble temp = null;
        
        while (actual != null) {
            temp = actual.getSgte();
            actual.setSgte(actual.getAnt());
            actual.setAnt(temp);
            actual = temp;
        }
        
        temp = ini;
        ini = fin;
        fin = temp;
    }
}