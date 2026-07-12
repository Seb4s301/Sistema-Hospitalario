package hospitaljy;

import vistas.FrmPrincipal;
import arbol.ArbolPaciente;
import estructuras.ListaDobleMedico;
import modelos.Paciente;
import modelos.Medico;
import java.text.SimpleDateFormat;
import java.util.Date;

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
            arbol.ArbolPaciente arbolPacientes = arbol.ArbolPaciente.getInstancia();
            estructuras.ListaDobleMedico listaMedicos = estructuras.ListaDobleMedico.getInstancia();

            // Precarga Masiva de Pacientes
            String[] nombresP = {"Juan", "Maria", "Pedro", "Ana", "Luis", "Elena", "Carlos", "Sofia", "Jorge", "Lucia"};
            String[] apellidosP = {"Perez", "Gomez", "Lopez", "Diaz", "Torres", "Ruiz", "Flores", "Soto", "Vega", "Ortiz"};
            
            for (int i = 0; i < 10; i++) {
                String dni = "1000000" + i;
                arbolPacientes.insertar(new modelos.Paciente(dni, nombresP[i], apellidosP[i], 
                                        formatoNac.parse("01/01/1990"), "90000000" + i, "Seguro-" + (i % 3)));
            }

            // Precarga Masiva de Medicos
            String[] especialidades = {"Cardiologia", "Pediatria", "Traumatologia", "Oncologia", "Dermatologia"};
            for (int i = 0; i < 5; i++) {
                String dni = "2000000" + i;
                listaMedicos.insertar(new modelos.Medico(dni, "Dr. " + nombresP[i], apellidosP[i], 
                                       formatoTurno.parse("15/07/2026 09:00"), "99999999" + i, especialidades[i]));
            }
            
            System.out.println("Datos masivos cargados con exito.");

        } catch (Exception e) {
            System.err.println("Error en precarga masiva: " + e.getMessage());
        }
    }
}