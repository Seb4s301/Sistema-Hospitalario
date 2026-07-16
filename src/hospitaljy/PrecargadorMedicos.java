package hospitaljy;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
        String[] especialidades = {"Cardiología", "Pediatria", "Traumatología", "Oncología", "Dermatología"};
        String[] nombres = {"Dr. Juan", "Dr. Maria", "Dr. Pedro", "Dr. Ana", "Dr. Luis"};
        String[] apellidos = getApellidos();

        for (int i = 0; i < 5; i++) {
            String dni = generarDniString(70000000L);
            String cel = generarCelular();
            Date turno = generarTurnoAleatorio();
            lista.insertar(new Medico(dni, nombres[i], apellidos[i],
                turno, cel, especialidades[i]));
            cantidad++;
        }
    }
    
    private Date generarTurnoAleatorio() {
        Calendar cal = Calendar.getInstance();
        cal.set(2026, Calendar.JULY, 1 + rand.nextInt(92), 0, 0, 0); // jul - sep 2026
        cal.set(Calendar.MILLISECOND, 0);
        int hora = 8 + rand.nextInt(10);  // 08:00 - 17:00
        int minuto = (rand.nextInt(4)) * 15; // 00, 15, 30, 45
        cal.set(Calendar.HOUR_OF_DAY, hora);
        cal.set(Calendar.MINUTE, minuto);
        return cal.getTime();
    }

    @Override
    protected String getNombre() { return "Medicos"; }

    @Override
    protected int getCantidad() { return cantidad; }
}