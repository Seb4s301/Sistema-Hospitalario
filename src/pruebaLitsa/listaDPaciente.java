package pruebaLitsa;

import javax.swing.table.DefaultTableModel;

public class listaDPaciente {
    private nodoD ini;
    private nodoD fin;
    
    public listaDPaciente() {
        this.ini = null;
        this.fin = null;
    }
    
    // Equivale a insertar2 o add (insertar al final)
    public void insertarFinal(Paciente dato) {
        nodoD nuevo = new nodoD(dato);
        
        if (ini == null) {
            ini = nuevo;
            fin = nuevo;
        } else {
            fin.setSgte(nuevo);
            nuevo.setAnt(fin);
            fin = nuevo;
        }
    }
    
    // Equivale a pre o insertarInicio
    public void insertarInicio(Paciente dato) {
        nodoD nuevo = new nodoD(dato);
        
        if (ini == null) {
            ini = nuevo;
            fin = nuevo;
        } else {
            nuevo.setSgte(ini);
            ini.setAnt(nuevo);
            ini = nuevo;
        }
    }
    
    private String col[] = {
        "ID", "Nombre", "Telefono", "Celular", "Tipo", "Seguro", "Sucursal", "Saldo", "Fecha"
    };
    
    // Equivale a imprimir2 adaptado a JTable (Izquierda a Derecha)
    public DefaultTableModel imprimirTabla() {
        DefaultTableModel modelo = new DefaultTableModel(null, col);
        nodoD actual = ini;
        
        while (actual != null) {
            String[] fila = new String[9];
            fila[0] = actual.getDato().getID();
            fila[1] = actual.getDato().getNombre();
            fila[2] = actual.getDato().getTelefono();
            fila[3] = actual.getDato().getCelular();
            fila[4] = actual.getDato().getTipo();
            fila[5] = actual.getDato().getSeguro();
            fila[6] = actual.getDato().getSucursal();
            fila[7] = actual.getDato().getSaldo();
            fila[8] = actual.getDato().getFechaN();
            modelo.addRow(fila);
            
            actual = actual.getSgte();
        }
        return modelo;
    }
    
    // Equivale a impresionInversa2 adaptado a JTable (Derecha a Izquierda)
    public DefaultTableModel impresionInversaTabla() {
        DefaultTableModel modelo = new DefaultTableModel(null, col);
        nodoD actual = fin;
        
        while (actual != null) {
            String[] fila = new String[9];
            fila[0] = actual.getDato().getID();
            fila[1] = actual.getDato().getNombre();
            fila[2] = actual.getDato().getTelefono();
            fila[3] = actual.getDato().getCelular();
            fila[4] = actual.getDato().getTipo();
            fila[5] = actual.getDato().getSeguro();
            fila[6] = actual.getDato().getSucursal();
            fila[7] = actual.getDato().getSaldo();
            fila[8] = actual.getDato().getFechaN();
            modelo.addRow(fila);
            
            actual = actual.getAnt();
        }
        return modelo;
    }
    
    // Equivale a eliminarPrimero
    public void eliminarPrimero() { 
        if (ini == null) {
            System.out.println("Lista vacia"); 
            return;
        }
        
        if (ini == fin) {
            ini = null;
            fin = null;
        } else {
            ini = ini.getSgte();
            ini.setAnt(null);
        }
    }
    
    // Eliminar por un criterio especifico (ID) respetando la nueva estructura
    public void eliminarPorID(String ID) {
        if (ini == null) {
            System.out.println("Lista vacia");
            return;
        }
        
        nodoD actual = ini;
        while (actual != null && !actual.getDato().getID().equals(ID)) {
            actual = actual.getSgte();
        }
        
        if (actual == null) {
            System.out.println("No existe el paciente con el ID ingresado");
            return;
        }
        
        if (ini == fin) {
            ini = null;
            fin = null;
        } else if (actual == ini) {
            ini = ini.getSgte();
            ini.setAnt(null);
        } else if (actual == fin) {
            fin = fin.getAnt();
            fin.setSgte(null);
        } else {
            actual.getAnt().setSgte(actual.getSgte());
            actual.getSgte().setAnt(actual.getAnt());
        }
    }
    
    public void modificarPorID(String ID, Paciente nuevoDato) {
        if (ini == null) {
            System.out.println("Lista vacia");
            return;
        }

        nodoD actual = ini;
        while (actual != null) {
            if (actual.getDato().getID().equals(ID)) {
                actual.setDato(nuevoDato);
                System.out.println("Paciente modificado exitosamente");
                return;
            }
            actual = actual.getSgte();
        }
        System.out.println("No se encontro el paciente con el ID especificado");
    }
}