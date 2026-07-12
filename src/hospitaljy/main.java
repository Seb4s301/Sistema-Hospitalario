package hospitaljy;

import vistas.FrmPrincipal;
import java.text.SimpleDateFormat;
import java.util.Random;
import modelos.Admin;
import modelos.Medico;
import modelos.Recepcionista;
import estructuras.ListaDobleAdmin;
import estructuras.ListaDobleMedico;
import estructuras.ListaDobleRecepcionista;

public class main {

    public static void main(String[] args) {
        
        // 1. Cargamos datos iniciales en memoria para realizar pruebas
        precargarDatos();

        // 2. Configuramos el estilo visual del sistema (Nimbus)
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            System.err.println("Error visual: " + ex.getMessage());
        }

        // 3. Arrancamos el hilo de la interfaz grafica
        java.awt.EventQueue.invokeLater(() -> {
            FrmPrincipal ventana = new FrmPrincipal();
            ventana.setLocationRelativeTo(null); // Centra la ventana en la pantalla
            ventana.setVisible(true);
        });
    }

    private static void precargarDatos() {
        try {
            SimpleDateFormat formatoNac = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat formatoTurno = new SimpleDateFormat("dd/MM/yyyy HH:mm");

            // Instancias Singleton
            ListaDobleAdmin listaAdmins = ListaDobleAdmin.getInstancia();
            ListaDobleMedico listaMedicos = ListaDobleMedico.getInstancia();
            ListaDobleRecepcionista listaRecepcionistas = ListaDobleRecepcionista.getInstancia();

            // Generador aleatorio
            Random rand = new Random();

            // ====== USUARIOS FIJOS PARA PRUEBAS ======
            // Admin fijo: admin / 12345
            listaAdmins.insertar(new Admin("10000000", "Admin", "Principal", 
                formatoTurno.parse("15/07/2026 08:00"), "999999999", "Administrador General"));

            // Medico fijo: M10000000 / 12345
            listaMedicos.insertar(new Medico("10000000", "Dr. Carlos", "Vargas", 
                                   formatoTurno.parse("15/07/2026 09:00"), "988888888", "Cardiologia"));

            // Recepcionista fijo: R10000000 / 12345
            listaRecepcionistas.insertar(new Recepcionista("10000000", "Laura", "Mendoza", 
                                        formatoTurno.parse("15/07/2026 08:00"), "977777777", "Mañana"));

            // ====== USUARIOS ALEATORIOS ======
            // Precarga Masiva de Medicos
            String[] especialidades = {"Cardiologia", "Pediatria", "Traumatologia", "Oncologia", "Dermatologia"};
            String[] nombresM = {"Juan", "Maria", "Pedro", "Ana", "Luis"};
            String[] apellidosM = {"Perez", "Gomez", "Lopez", "Diaz", "Torres"};
            
            for (int i = 0; i < 5; i++) {
                long dniMedBase = 70000000L + rand.nextInt(20000000);
                String dniMed = String.valueOf(dniMedBase);
                long celMedBase = 910000000L + rand.nextInt(90000000);
                String celMed = String.valueOf(celMedBase);
                listaMedicos.insertar(new Medico(dniMed, "Dr. " + nombresM[i], apellidosM[i], 
                                   formatoTurno.parse("15/07/2026 09:00"), celMed, especialidades[i]));
            }

            // Precarga Masiva de Recepcionistas
            String[] turnos = {"Mañana", "Tarde", "Noche"};
            String[] nombresR = {"Carlos", "Ana", "Luis"};
            String[] apellidosR = {"Ramirez", "Torres", "Flores"};
            for (int i = 0; i < 3; i++) {
                long dniRecBase = 70000000L + rand.nextInt(20000000);
                String dniRec = String.valueOf(dniRecBase);
                long celRecBase = 910000000L + rand.nextInt(90000000);
                String celRec = String.valueOf(celRecBase);
                listaRecepcionistas.insertar(new Recepcionista(dniRec, nombresR[i], apellidosR[i], 
                                        formatoTurno.parse("15/07/2026 08:00"), celRec, turnos[i]));
            }
            
            System.out.println("Datos masivos cargados con exito.");

        } catch (Exception e) {
            System.err.println("Error en precarga masiva: " + e.getMessage());
        }
    }
}