package hospitaljy;

import java.text.SimpleDateFormat;
import java.util.Random;

public abstract class Precargador {
    protected Random rand;
    protected SimpleDateFormat formatoNac;
    protected SimpleDateFormat formatoTurno;

    public Precargador(Random rand, SimpleDateFormat formatoNac, SimpleDateFormat formatoTurno) {
        this.rand = rand;
        this.formatoNac = formatoNac;
        this.formatoTurno = formatoTurno;
    }

    // Template Method
    public final void precargar() throws Exception {
        System.out.println("Precargando " + getNombre() + "...");
        precargarFijo();
        precargarAleatorios();
        System.out.println("  -> " + getCantidad() + " registros cargados.");
    }

    protected abstract void precargarFijo() throws Exception;
    protected abstract void precargarAleatorios() throws Exception;
    protected abstract String getNombre();
    protected abstract int getCantidad();

    // Métodos comunes
    protected long generarDni(long base) {
        return base + rand.nextInt(20000000);
    }

    protected String generarCelular() {
        long cel = 910000000L + rand.nextInt(90000000);
        return String.valueOf(cel);
    }

    protected String generarDniString(long base) {
        return String.valueOf(generarDni(base));
    }

    protected String[] getNombres() {
        return new String[]{"Maria", "Juan", "Ana", "Luis", "Carmen", "Jose", "Rosa", "Miguel", "Teresa", "Jorge"};
    }

    protected String[] getApellidos() {
        return new String[]{"Lopez", "Garcia", "Martinez", "Rodriguez", "Fernandez", "Hernandez", "Gonzalez", "Perez", "Sanchez", "Ramirez"};
    }
}