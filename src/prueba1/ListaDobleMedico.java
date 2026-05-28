/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prueba1;

/**
 *
 * @author Jean
 */
public class ListaDobleMedico {
    NodoMedico ini;
    NodoMedico fin;

    public ListaDobleMedico() {
        this.ini = null;
        this.fin = null;
    }

    public void insertar(Medico dato) {
        NodoMedico nuevo = new NodoMedico(dato);
        if (ini == null) {
            ini = nuevo;
            fin = nuevo;
        } else {
            fin.setSgte(nuevo);
            nuevo.setAnt(fin);
            fin = nuevo;
        }
    }

    public boolean eliminar(String dni) {
        if (ini == null) return false;
        NodoMedico actual = ini;
        while (actual != null) {
            if (actual.getDato().getDni().equals(dni)) {
                if (actual == ini && actual == fin) {
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
                return true;
            }
            actual = actual.getSgte();
        }
        return false;
    }

    public NodoMedico buscar(String dni) {
        NodoMedico actual = ini;
        while (actual != null) {
            if (actual.getDato().getDni().equals(dni)) {
                return actual;
            }
            actual = actual.getSgte();
        }
        return null;
    }

    public NodoMedico getIni() { return ini; }
}
