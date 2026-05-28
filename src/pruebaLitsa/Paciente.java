
package pruebaLitsa;
import java.util.Date;

public class Paciente {
    private String ID, nombre, telefono, celular, tipo, seguro, sucursal, saldo, fechaN;

    public Paciente() {
        ID="";
        nombre="";
        telefono="";
        celular="";
        tipo="";
        seguro="";
        sucursal="";
        saldo="";
        fechaN="";
    }

    public Paciente(String ID, String nombre, String telefono, String celular, String tipo, String seguro, String sucursal, String saldo, String fechaN) {
        this.ID = ID;
        this.nombre = nombre;
        this.telefono = telefono;
        this.celular = celular;
        this.tipo = tipo;
        this.seguro = seguro;
        this.sucursal = sucursal;
        this.saldo = saldo;
        this.fechaN = fechaN;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSeguro() {
        return seguro;
    }

    public void setSeguro(String seguro) {
        this.seguro = seguro;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public String getSaldo() {
        return saldo;
    }

    public void setSaldo(String saldo) {
        this.saldo = saldo;
    }

    public String getFechaN() {
        return fechaN;
    }

    public void setFechaN(String fechaN) {
        this.fechaN = fechaN;
    }

    @Override
    public String toString() {
        return "Paciente{" + "ID=" + ID + ", nombre=" + nombre + ", telefono=" + telefono + ", celular=" + celular + ", tipo=" + tipo + ", seguro=" + seguro + ", sucursal=" + sucursal + ", saldo=" + saldo + ", fechaN=" + fechaN + '}';
    }
    
}
