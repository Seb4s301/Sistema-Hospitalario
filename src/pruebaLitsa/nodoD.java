package pruebaLitsa;


public class nodoD {
    private Paciente dato;
    nodoD sgte;
    nodoD ant;

    public nodoD(Paciente dato) {
        this.dato = dato;
        this.sgte = null;
        this.ant = null;
    }

    public Paciente getDato() {
        return dato;
    }

    public void setDato(Paciente dato) {
        this.dato = dato;
    }

    public nodoD getSgte() {
        return sgte;
    }

    public void setSgte(nodoD sgte) {
        this.sgte = sgte;
    }

    public nodoD getAnt() {
        return ant;
    }

    public void setAnt(nodoD ant) {
        this.ant = ant;
    }
    
}
