package hospitaljy;

import vistas.FrmPrincipal;
import java.text.SimpleDateFormat;
import java.util.Random;
import arbol.ArbolPaciente;
import estructuras.ListaDobleAdmin;
import estructuras.ListaDobleMedico;
import estructuras.ListaDobleRecepcionista;

public class main {

    public static void main(String[] args) {
        precargarDatos();
        configurarVisual();
        iniciarInterfaz();
    }

    private static void precargarDatos() {
        try {
            SimpleDateFormat formatoNac = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat formatoTurno = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            Random rand = new Random();

            Precargador[] precargadores = {
                new PrecargadorPacientes(ArbolPaciente.getInstancia(), rand, formatoNac, formatoTurno),
                new PrecargadorAdmins(ListaDobleAdmin.getInstancia(), rand, formatoNac, formatoTurno),
                new PrecargadorMedicos(ListaDobleMedico.getInstancia(), rand, formatoNac, formatoTurno),
                new PrecargadorRecepcionistas(ListaDobleRecepcionista.getInstancia(), rand, formatoNac, formatoTurno)
            };

            for (Precargador p : precargadores) {
                p.precargar();
            }

            System.out.println("Todos los datos cargados con éxito.");

        } catch (Exception e) {
            System.err.println("Error en precarga masiva: " + e.getMessage());
        }
    }

    private static void configurarVisual() {
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
    }

    private static void iniciarInterfaz() {
        java.awt.EventQueue.invokeLater(() -> {
            FrmPrincipal ventana = new FrmPrincipal();
            ventana.setLocationRelativeTo(null);
            ventana.setVisible(true);
        });
    }
}