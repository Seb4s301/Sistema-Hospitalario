package vistas;

import facade.HospitalFacade;
import modelos.HistorialClinico;
import modelos.Paciente;
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class JpHistorialesClinicos extends javax.swing.JPanel {
    private HospitalFacade facade = HospitalFacade.getInstancia();

    public JpHistorialesClinicos() {
        initComponents();
    }

    private void limpiarCajas() {
        txtTipoSangre.setText("");
        txtAlergias.setText("");
        txtEnfermedades.setText("");
        txtObservaciones.setText("");
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTextPane5 = new javax.swing.JTextPane();
        jSpinner1 = new javax.swing.JSpinner();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jRadioButton1 = new javax.swing.JRadioButton();
        btnBuscar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtBuscarDNI = new javax.swing.JTextPane();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane4.setViewportView(jTextArea1);

        jFormattedTextField1.setText("jFormattedTextField1");

        jScrollPane9.setViewportView(jTextPane5);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane10.setViewportView(jTextArea2);

        jRadioButton1.setText("jRadioButton1");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Buscar DNI", "Tipo de Sangre ", "Alergias", "Enfermedades", "Observaciones"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jLabel1.setText(" Buscar DNI:");

        jScrollPane5.setViewportView(txtBuscarDNI);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 733, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(36, 36, 36)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBuscar)))
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(btnBuscar)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(152, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String dniBusqueda = txtBuscarDNI.getText().trim();

        if (dniBusqueda.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese un DNI para buscar");
            return;
        }

        Paciente paciente = facade.buscarPaciente(dniBusqueda);
        if (paciente == null) {
            JOptionPane.showMessageDialog(this, "Error: El paciente no existe en el sistema.");
            limpiarCajas();
            return;
        }

        HistorialClinico historial = facade.buscarHistorial(dniBusqueda);

        if (historial != null) {
            txtTipoSangre.setText(historial.getTipoSangre());
            txtAlergias.setText(historial.getAlergias());
            txtEnfermedades.setText(historial.getEnfermedadesCronicas());
            txtObservaciones.setText(historial.getObservacionesMedicas());

            ArrayList<HistorialClinico> listaUnica = new ArrayList<>();
            listaUnica.add(historial);
            jTable2.setModel(facade.modeloTablaHistoriales(listaUnica));
            
            JOptionPane.showMessageDialog(this, "Historial recuperado exitosamente.");
        } else {
            limpiarCajas();
            jTable2.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {},
                new String [] {"Buscar DNI", "Tipo de Sangre", "Alergias", "Enfermedades", "Observaciones"}
            ));
            JOptionPane.showMessageDialog(this, "Paciente encontrado, pero no tiene historial registrado.");
        }
    }//GEN-LAST:event_btnBuscarActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextPane jTextPane5;
    private javax.swing.JTextPane txtBuscarDNI;
    // End of variables declaration//GEN-END:variables
}
