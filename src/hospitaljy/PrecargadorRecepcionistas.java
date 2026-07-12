package hospitaljy;

import java.text.SimpleDateFormat;
import java.util.Random;
import modelos.Recepcionista;
import estructuras.ListaDobleRecepcionista;

public class PrecargadorRecepcionistas extends Precargador {
    private ListaDobleRecepcionista lista;
    private int cantidad = 0;

    public PrecargadorRecepcionistas(ListaDobleRecepcionista lista, Random rand, SimpleDateFormat formatoNac, SimpleDateFormat formatoTurno) {
        super(rand, formatoNac, formatoTurno);
        this.lista = lista;
    }

    @Override
    protected void precargarFijo() throws Exception {
        lista.insertar(new Recepcionista("10000000", "Laura", "Mendoza",
            formatoTurno.parse("15/07/2026 08:00"), "977777777", "Mañana"));
        cantidad++;
    }

    @Override
    protected void precargarAleatorios() throws Exception {
        String[] turnos = {"Mañana", "Tarde", "Noche"};
        String[] nombres = {"Carlos", "Ana", "Luis"};
        String[] apellidos = {"Ramirez", "Torres", "Flores"};

        for (int i = 0; i < 3; i++) {
            String dni = generarDniString(70000000L);
            String cel = generarCelular();
            lista.insertar(new Recepcionista(dni, nombres[i], apellidos[i],
                formatoTurno.parse("15/07/2026 08:00"), cel, turnos[i]));
            cantidad++;
        }
    }

    @Override
    protected String getNombre() { return "Recepcionistas"; }

    @Override
    protected int getCantidad() { return cantidad; }
}