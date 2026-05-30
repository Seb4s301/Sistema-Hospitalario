package PruebaInterfaz;

/**
 *
 * @author Jean
 */
public class FrmPrincipal extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FrmPrincipal.class.getName());
    private JpPacientes panelPacientes;
    private JpMedicos panelMedicos;
    private JpHistorialesClinicos panelHistoriales; 
    /**
     * Creates new form Principal
     */
    public FrmPrincipal() {
        initComponents();
        conectarPaneles();
    }

    private void conectarPaneles() {
        // 1. Instanciar los paneles que creaste
        panelPacientes = new JpPacientes();
        panelMedicos = new JpMedicos(); // Asegurate de que la clase se llame exactamente asi
        panelHistoriales = new JpHistorialesClinicos();
        
        // 2. Limpiar las pestañas por defecto para evitar duplicados
        jTabbedPane2.removeAll();
        
        // 3. Agregar los paneles reales asignandoles su titulo
        jTabbedPane2.addTab("Principal", new javax.swing.JPanel()); 
        jTabbedPane2.addTab("Pacientes", panelPacientes);          
        jTabbedPane2.addTab("Medicos", panelMedicos); // ¡CORREGIDO! Aqui iba tu variable, no un panel vacio
        jTabbedPane2.addTab("Historiales Clinicos", panelHistoriales); 
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane2 = new javax.swing.JTabbedPane();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jTabbedPane5 = new javax.swing.JTabbedPane();
        jTabbedPane6 = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane2.addTab("Principal", jTabbedPane3);
        jTabbedPane2.addTab("Pacientes", jTabbedPane4);
        jTabbedPane2.addTab("Medicos", jTabbedPane5);
        jTabbedPane2.addTab("Historiales Clinicos", jTabbedPane6);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 591, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        /* [cite: 27] */
        java.awt.EventQueue.invokeLater(() -> new FrmPrincipal().setVisible(true));
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTabbedPane jTabbedPane5;
    private javax.swing.JTabbedPane jTabbedPane6;
    // End of variables declaration//GEN-END:variables
}
