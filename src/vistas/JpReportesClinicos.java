
package vistas;

import estructuras.ListaDobleReporte;
import facade.HospitalFacade;
import modelos.ReporteMedico;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class JpReportesClinicos extends javax.swing.JPanel {
    
    private HospitalFacade facade = HospitalFacade.getInstancia();
    private estructuras.ListaDobleReporte listaReportes = estructuras.ListaDobleReporte.getInstancia();
            
    public JpReportesClinicos() {
        initComponents();
    }
    
    private void limpiarCajas() {
        txtDNIPaciente.setText("");
        txtSintomas.setText("");
        txtAlergias.setText("");
        txtEnfermedades.setText("");
        txtTratamiento.setText("");
        txtObservaciones.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnInsertar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtSintomas = new javax.swing.JTextPane();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        txtAlergias = new javax.swing.JTextPane();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtObservaciones = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        txtTratamiento = new javax.swing.JTextPane();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        txtEnfermedades = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane10 = new javax.swing.JScrollPane();
        txtDNIPaciente = new javax.swing.JTextPane();
        jLabel9 = new javax.swing.JLabel();

        jLabel2.setText("Sintomas:");

        jLabel5.setText("Observaciones:");

        btnInsertar.setText("Insertar");
        btnInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        jLabel3.setText("Sintomas:");

        jScrollPane6.setViewportView(txtSintomas);

        jLabel4.setText("Alergias:");

        jScrollPane7.setViewportView(txtAlergias);

        jLabel6.setText("Observaciones:");

        txtObservaciones.setColumns(20);
        txtObservaciones.setRows(5);
        jScrollPane1.setViewportView(txtObservaciones);

        jLabel7.setText("Enfermedades:");

        jScrollPane8.setViewportView(txtTratamiento);

        jLabel8.setText("Tratamiento:");

        jScrollPane9.setViewportView(txtEnfermedades);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Sintomas", "Alergias", "Enfermedades", "Tratamiento", "Observaciones"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jScrollPane10.setViewportView(txtDNIPaciente);

        jLabel9.setText("DNI Paciente:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 230, Short.MAX_VALUE)
                                .addComponent(jLabel6))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel7))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(19, 19, 19)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                                            .addComponent(jScrollPane8))))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnInsertar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(37, 37, 37))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(btnInsertar)
                            .addComponent(jLabel9)
                            .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnModificar)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarActionPerformed
        try {
            String dni = txtDNIPaciente.getText().trim();
            String sintomas = txtSintomas.getText().trim();
            String alergias = txtAlergias.getText().trim();
            String enfermedades = txtEnfermedades.getText().trim();
            String tratamiento = txtTratamiento.getText().trim();
            String observaciones = txtObservaciones.getText().trim();

            if (dni.isEmpty() || sintomas.isEmpty() || alergias.isEmpty()
                || enfermedades.isEmpty() || tratamiento.isEmpty() || observaciones.isEmpty()) {
                javax.swing.JOptionPane.showMessageDialog(this, "Complete todos los campos");
                return;
            }
            
            if (!dni.matches("\\d{8}")) {
                javax.swing.JOptionPane.showMessageDialog(this, "DNI invalido");
                return;
            }
            
            if (facade.buscarPaciente(dni) == null) {
                javax.swing.JOptionPane.showMessageDialog(this, "El paciente no existe en el sistema");
                return;
            }
            
            if (listaReportes.buscar(dni) != null) {
                javax.swing.JOptionPane.showMessageDialog(this, "Este paciente ya tiene un reporte. Use Modificar.");
                return;
            }

            modelos.ReporteMedico nuevo = new modelos.ReporteMedico(
                 dni, sintomas, alergias, enfermedades, tratamiento, observaciones);
            listaReportes.insertar(nuevo);

            
            javax.swing.table.DefaultTableModel modelo = new javax.swing.table.DefaultTableModel(
                new String[]{"Sintomas", "Alergias", "Enfermedades", "Tratamiento", "Observaciones"}, 0);
            for (modelos.ReporteMedico r : listaReportes.obtenerTodos()) {
                modelo.addRow(new Object[]{
                    r.getSintomas(), r.getAlergias(), r.getEnfermedades(),
                    r.getTratamiento(), r.getObservaciones()
                });
            }
            jTable2.setModel(modelo);

            limpiarCajas();
            javax.swing.JOptionPane.showMessageDialog(this, "Reporte registrado correctamente");

            } catch (Exception e) {
                javax.swing.JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            }
    }//GEN-LAST:event_btnInsertarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        try {
            String dni = txtDNIPaciente.getText().trim();
            String sintomas = txtSintomas.getText().trim();
            String alergias = txtAlergias.getText().trim();
            String enfermedades = txtEnfermedades.getText().trim();
            String tratamiento = txtTratamiento.getText().trim();
            String observaciones = txtObservaciones.getText().trim();

            if (dni.isEmpty()) {
                javax.swing.JOptionPane.showMessageDialog(this, "Ingrese el DNI del paciente a modificar");
                return;
            }

            modelos.ReporteMedico modificado = new modelos.ReporteMedico(
                dni, sintomas, alergias, enfermedades, tratamiento, observaciones);
            boolean resultado = listaReportes.modificar(modificado);

            if (resultado) {
                
                javax.swing.table.DefaultTableModel modelo = new javax.swing.table.DefaultTableModel(
                    new String[]{"Sintomas", "Alergias", "Enfermedades", "Tratamiento", "Observaciones"}, 0);
                for (modelos.ReporteMedico r : listaReportes.obtenerTodos()) {
                    modelo.addRow(new Object[]{
                        r.getSintomas(), r.getAlergias(), r.getEnfermedades(),
                        r.getTratamiento(), r.getObservaciones()
                    });
                }
                jTable2.setModel(modelo);
                limpiarCajas();
                    javax.swing.JOptionPane.showMessageDialog(this, "Reporte modificado correctamente");
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "No se encontro el reporte");
            }

            } catch (Exception e) {
                javax.swing.JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            }
    }//GEN-LAST:event_btnModificarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInsertar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextPane txtAlergias;
    private javax.swing.JTextPane txtDNIPaciente;
    private javax.swing.JTextPane txtEnfermedades;
    private javax.swing.JTextArea txtObservaciones;
    private javax.swing.JTextPane txtSintomas;
    private javax.swing.JTextPane txtTratamiento;
    // End of variables declaration//GEN-END:variables
}
