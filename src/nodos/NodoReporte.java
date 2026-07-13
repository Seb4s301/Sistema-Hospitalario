
package nodos;

import modelos.ReporteMedico;

public class NodoReporte {
    private ReporteMedico dato;
    private NodoReporte sgte;
    private NodoReporte ant;

    public NodoReporte(ReporteMedico dato) {
        this.dato = dato;
        this.sgte = null;
        this.ant = null;
    }

    public ReporteMedico getDato() {
        return dato;
    }

    public void setDato(ReporteMedico dato) {
        this.dato = dato;
    }

    public NodoReporte getSgte() {
        return sgte;
    }

    public void setSgte(NodoReporte sgte) {
        this.sgte = sgte;
    }

    public NodoReporte getAnt() {
        return ant;
    }

    public void setAnt(NodoReporte ant) {
        this.ant = ant;
    }

    
}
