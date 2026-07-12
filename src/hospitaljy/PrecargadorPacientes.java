package hospitaljy;

import java.text.SimpleDateFormat;
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
        String[] seguros = {"Essalud", "Rimac", "La Positiva", "Sanitas", "Pacífico"};
        String[] nombres = getNombres();
        String[] apellidos = getApellidos();

        for (int i = 0; i < 10; i++) {
            String dni = generarDniString(40000000L);
            String cel = generarCelular();
            String seguro = seguros[rand.nextInt(seguros.length)];
            arbol.insertar(new Paciente(dni, nombres[i], apellidos[i],
                formatoNac.parse("01/01/1990"), cel, seguro));
            cantidad++;
        }
    }

    @Override
    protected String getNombre() { return "Pacientes"; }

    @Override
    protected int getCantidad() { return cantidad; }
}