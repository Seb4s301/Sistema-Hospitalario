package hospitaljy;

import java.text.SimpleDateFormat;
import java.util.Random;
import modelos.Medico;
import estructuras.ListaDobleMedico;

public class PrecargadorMedicos extends Precargador {
    private ListaDobleMedico lista;
    private int cantidad = 0;

    public PrecargadorMedicos(ListaDobleMedico lista, Random rand, SimpleDateFormat formatoNac, SimpleDateFormat formatoTurno) {
        super(rand, formatoNac, formatoTurno);
        this.lista = lista;
    }

    @Override
    protected void precargarFijo() throws Exception {
        lista.insertar(new Medico("10000000", "Dr. Carlos", "Vargas",
            formatoTurno.parse("15/07/2026 09:00"), "988888888", "Cardiologia"));
        cantidad++;
    }

    @Override
    protected void precargarAleatorios() throws Exception {
        String[] especialidades = {"Cardiologia", "Pediatria", "Traumatologia", "Oncologia", "Dermatologia"};
        String[] nombres = {"Dr. Juan", "Dr. Maria", "Dr. Pedro", "Dr. Ana", "Dr. Luis"};
        String[] apellidos = getApellidos();

        for (int i = 0; i < 5; i++) {
            String dni = generarDniString(70000000L);
            String cel = generarCelular();
            lista.insertar(new Medico(dni, nombres[i], apellidos[i],
                formatoTurno.parse("15/07/2026 09:00"), cel, especialidades[i]));
            cantidad++;
        }
    }

    @Override
    protected String getNombre() { return "Médicos"; }

    @Override
    protected int getCantidad() { return cantidad; }
}