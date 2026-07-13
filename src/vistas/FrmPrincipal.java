package vistas;

import modelos.Usuario;

public class FrmPrincipal extends javax.swing.JFrame {
    
    private JpPacientes panelPacientes;
    private JpMedicos panelMedicos;
    private JpHistorialesClinicos panelHistoriales; 
    private JpAgendarCita panelAgendar;
    private JpReportesClinicos panelReportesClinicos;
    private JpLogin panelLogin;
    
    
    /**
     * Creates new form Principal
     */
    public FrmPrincipal() {
        initComponents();
        conectarPaneles();
    }

    private void conectarPaneles() {
        try {
            panelPacientes = new JpPacientes();
            panelMedicos = new JpMedicos(); 
            panelHistoriales = new JpHistorialesClinicos();
            panelAgendar = new JpAgendarCita(); 
            panelReportesClinicos = new JpReportesClinicos();
            panelLogin = new JpLogin(this);

            if (jTabbedPane2 != null) {
                jTabbedPane2.removeAll();
                jTabbedPane2.setVisible(true);
                jTabbedPane2.addTab("Login", panelLogin);
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "Error: jTabbedPane2 fue borrado del diseño.");
            }
            
        } catch (Throwable t) {
            javax.swing.JOptionPane.showMessageDialog(this, 
                "Falla Crítica al cargar un panel.\nMotivo: " + t.toString(), 
                "Error de Arranque", 
                javax.swing.JOptionPane.ERROR_MESSAGE);
            
            t.printStackTrace(); 
        }
    }
    
    //llama al panel jplogin
    public void iniciarSesion(Usuario usuario) {
        jTabbedPane2.removeAll();

        if (usuario.getRol().equals("Administrador")) {
            jTabbedPane2.addTab("Dashboard", new JpAdmin());
            jTabbedPane2.addTab("Medicos", panelMedicos);
            jTabbedPane2.addTab("Pacientes", panelPacientes);
            jTabbedPane2.addTab("Historiales Clinicos", panelHistoriales);
            jTabbedPane2.addTab("Agendar Citas", panelAgendar);
        } else if (usuario.getRol().equals("Recepcionista")) {
            jTabbedPane2.addTab("Pacientes", panelPacientes);
            jTabbedPane2.addTab("Agendar Citas", panelAgendar);
        } else if (usuario.getRol().equals("Medico")) {
            jTabbedPane2.addTab("Reportes Clinicos", panelReportesClinicos);
            jTabbedPane2.addTab("Historiales Clinicos", panelHistoriales);
        }
    }

    public void cerrarSesion() {
        jTabbedPane2.removeAll();
        jTabbedPane2.addTab("Login", panelLogin);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane3 = new javax.swing.JTabbedPane();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jTabbedPane5 = new javax.swing.JTabbedPane();
        jTabbedPane6 = new javax.swing.JTabbedPane();
        jTabbedPane4 = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane2.addTab("Medicos", jTabbedPane5);
        jTabbedPane2.addTab("Historiales Clinicos", jTabbedPane6);
        jTabbedPane2.addTab("Pacientes", jTabbedPane4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 849, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 675, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTabbedPane jTabbedPane5;
    private javax.swing.JTabbedPane jTabbedPane6;
    // End of variables declaration//GEN-END:variables
}
