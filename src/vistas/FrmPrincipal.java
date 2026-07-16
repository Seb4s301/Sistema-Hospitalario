package vistas;

import modelos.Usuario;

public class FrmPrincipal extends javax.swing.JFrame {
    
    private JpPacientes panelPacientes;
    private JpMedicos panelMedicos;
    private JpHistorialesHospitalarios panelHistoriales; 
    private JpAgendarCita panelAgendar;
    private JpReportesHospitalarios panelReportesClinicos;
    private JpLogin panelLogin;
    private JpCerrarSesion panelCerrarSesion; 
    private JpCitasMedico panelCitasMedico;
    
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
            panelHistoriales = new JpHistorialesHospitalarios();
            panelAgendar = new JpAgendarCita(); 
            panelLogin = new JpLogin(this);
            panelCerrarSesion = new JpCerrarSesion(this);
            
            if (jTabbedPane2 != null) {
                jTabbedPane2.removeAll();
                jTabbedPane2.setVisible(true);
                jTabbedPane2.addTab("Login", panelLogin);
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "Error: Tabla fue borrada del diseño.");
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

        panelCerrarSesion.mostrarCredenciales(usuario.getUsername(), usuario.getRol());

        if (usuario.getRol().equals("Administrador")) {
            jTabbedPane2.addTab("Dashboard", new JpAdmin());
            jTabbedPane2.addTab("Medicos", panelMedicos);
            jTabbedPane2.addTab("Pacientes", panelPacientes);
            jTabbedPane2.addTab("Historiales Hospitalarios", panelHistoriales);
            jTabbedPane2.addTab("Agendar Citas", panelAgendar);
        } else if (usuario.getRol().equals("Recepcionista")) {
            jTabbedPane2.addTab("Pacientes", panelPacientes);
            jTabbedPane2.addTab("Agendar Citas", panelAgendar);
        } else if (usuario.getRol().equals("Medico")) {
            String dniMedico = usuario.getUsername().substring(1);
            panelReportesClinicos = new JpReportesHospitalarios(dniMedico);
            panelCitasMedico = new JpCitasMedico(usuario.getUsername());
            jTabbedPane2.addTab("Citas", panelCitasMedico);
            jTabbedPane2.addTab("Reportes Hospitalarios", panelReportesClinicos);
            jTabbedPane2.addTab("Historiales Hospitalarios", panelHistoriales);
        }
        jTabbedPane2.addTab("Sesión Actual", panelCerrarSesion);
    }
    
    public void cerrarSesion() {
        jTabbedPane2.removeAll();
        panelLogin.limpiarCampos();
        jTabbedPane2.addTab("Login", panelLogin);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane2 = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 802, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 698, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane jTabbedPane2;
    // End of variables declaration//GEN-END:variables
}
