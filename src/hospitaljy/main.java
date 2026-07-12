package hospitaljy;

import vistas.FrmPrincipal;
import java.text.SimpleDateFormat;
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

            // Precarga Masiva de Admins
            listaAdmins.insertar(new Admin("10000000", "Admin", "Principal", 
                formatoTurno.parse("15/07/2026 08:00"), "999999999", "Administrador General"));

            // Precarga Masiva de Medicos
            String[] especialidades = {"Cardiologia", "Pediatria", "Traumatologia", "Oncologia", "Dermatologia"};
            String[] nombresM = {"Juan", "Maria", "Pedro", "Ana", "Luis"};
            String[] apellidosM = {"Perez", "Gomez", "Lopez", "Diaz", "Torres"};
            
            for (int i = 0; i < 5; i++) {
                String codigo = "2000000" + i;
                listaMedicos.insertar(new Medico(codigo, "Dr. " + nombresM[i], apellidosM[i], 
                                   formatoTurno.parse("15/07/2026 09:00"), "99999999" + i, especialidades[i]));
            }

            // Precarga Masiva de Recepcionistas
            String[] turnos = {"Mañana", "Tarde", "Noche"};
            String[] nombresR = {"Carlos", "Ana", "Luis"};
            String[] apellidosR = {"Ramirez", "Torres", "Flores"};
            for (int i = 0; i < 3; i++) {
                String dni = "3000000" + i;
                listaRecepcionistas.insertar(new Recepcionista(dni, nombresR[i], apellidosR[i], 
                                        formatoTurno.parse("15/07/2026 08:00"), "98888888" + i, turnos[i]));
            }
            
            System.out.println("Datos masivos cargados con exito.");

        } catch (Exception e) {
            System.err.println("Error en precarga masiva: " + e.getMessage());
        }
    }
}