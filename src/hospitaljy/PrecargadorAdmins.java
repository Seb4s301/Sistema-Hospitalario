package hospitaljy;

import java.text.SimpleDateFormat;
import java.util.Random;
import modelos.Admin;
import estructuras.ListaDobleAdmin;

public class PrecargadorAdmins extends Precargador {
    private ListaDobleAdmin lista;
    private int cantidad = 0;

    public PrecargadorAdmins(ListaDobleAdmin lista, Random rand, SimpleDateFormat formatoNac, SimpleDateFormat formatoTurno) {
        super(rand, formatoNac, formatoTurno);
        this.lista = lista;
    }

    @Override
    protected void precargarFijo() throws Exception {
        lista.insertar(new Admin("10000000", "Admin", "Principal",
            formatoTurno.parse("15/07/2026 08:00"), "999999999", "Administrador General"));
        cantidad++;
    }

    @Override
    protected void precargarAleatorios() throws Exception {
        // Admin solo tiene el fijo, no se generan aleatorios
    }

    @Override
    protected String getNombre() { return "Administradores"; }

    @Override
    protected int getCantidad() { return cantidad; }
}