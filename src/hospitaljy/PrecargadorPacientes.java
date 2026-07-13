package hospitaljy;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import modelos.Paciente;
import arbol.ArbolPaciente;

public class PrecargadorPacientes extends Precargador {
    private ArbolPaciente arbol;
    private int cantidad = 0;

    public PrecargadorPacientes(ArbolPaciente arbol, Random rand, SimpleDateFormat formatoNac, SimpleDateFormat formatoTurno) {
        super(rand, formatoNac, formatoTurno);
        this.arbol = arbol;
    }

    @Override
    protected void precargarFijo() throws Exception {
        arbol.insertar(new Paciente("10000000", "Pedro", "Garcia",
            formatoNac.parse("15/03/1985"), "966666666", "Seguro-0"));
        cantidad++;
    }

    @Override
    protected void precargarAleatorios() throws Exception {
        String[] seguros = {"Essalud", "Rimac", "La Positiva", "Sanitas", "Pacifico"};
        String[] nombres = getNombres();
        String[] apellidos = getApellidos();

        for (int i = 0; i < 10; i++) {
            String dni = generarDniString(40000000L);
            String cel = generarCelular();
            String seguro = seguros[rand.nextInt(seguros.length)];
            Date fechaNac = generarFechaNacimientoAleatoria();
            arbol.insertar(new Paciente(dni, nombres[i], apellidos[i],
                fechaNac, cel, seguro));
            cantidad++;
        }
    }
    
    private Date generarFechaNacimientoAleatoria() {
        Calendar cal = Calendar.getInstance();
        int anio = 1950 + rand.nextInt(56);   // 1950 - 2005
        int mes = rand.nextInt(12);              // 0 - 11
        int dia = 1 + rand.nextInt(28);          // 1 - 28 (evita problemas con febrero)
        cal.set(anio, mes, dia, 0, 0, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    @Override
    protected String getNombre() { return "Pacientes"; }

    @Override
    protected int getCantidad() { return cantidad; }
}