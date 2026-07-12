package vistas;

import controladores.GestorTablas;
import arbol.ArbolPaciente;
import estructuras.ListaDobleMedico;
import estructuras.ListaDobleCita;
import modelos.Paciente;
import modelos.Medico;
import modelos.Cita;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class JpAgendarCita extends javax.swing.JPanel {
    private GestorTablas gestorTablas = new GestorTablas();
    private ArbolPaciente arbolPacientes = ArbolPaciente.getInstancia();
    private ListaDobleMedico listaMedicos = ListaDobleMedico.getInstancia();
    private ListaDobleCita listaCitas = ListaDobleCita.getInstancia();
    
    public JpAgendarCita() {
        initComponents();
        listar();
    }
    
    public void listar(){
        if(arbolPacientes != null) {
            tablaPaciente.setModel(gestorTablas.modeloTablaPacientes(arbolPacientes.obtenerTodos()));
        }
        if(listaMedicos != null) {
            tablaMedico.setModel(gestorTablas.modeloTablaMedicos(listaMedicos.obtenerTodos()));
        }
        if(listaCitas != null) {
            tablaCita.setModel(gestorTablas.modeloTablaCitas(listaCitas.obtenerTodos()));
        }
        limpiar();
    }
    
    public void limpiar(){
        txtDni.setText("");
        txtDniMedico.setText("");
        txtTurno.setValue(null);
    }
    
    private void imprimirPaciente(){
        String dniBusqueda = txtDni.getText().trim();
        if (dniBusqueda.isEmpty()) {
            listar(); 
            return;
        }
        
        Paciente p = arbolPacientes.buscar(dniBusqueda);
        if (p != null) {
            ArrayList<Paciente> listaUnica = new ArrayList<>();
            listaUnica.add(p);
            tablaPaciente.setModel(gestorTablas.modeloTablaPacientes(listaUnica));
        } else {
            JOptionPane.showMessageDialog(this, "Paciente no encontrado");
        }
    }
    
    private void imprimirMedico(){
        String dniBusqueda = txtDniMedico.getText().trim();
        if (dniBusqueda.isEmpty()) {
            listar();
            return;
        }
        
        Medico m = listaMedicos.buscar(dniBusqueda);
        if (m != null) {
            ArrayList<Medico> listaUnica = new ArrayList<>();
            listaUnica.add(m);
            tablaMedico.setModel(gestorTablas.modeloTablaMedicos(listaUnica));
        } else {
            JOptionPane.showMessageDialog(this, "Medico no encontrado");
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPaciente = new javax.swing.JTable();
        txtDni = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnAgendar = new javax.swing.JButton();
        btnBuscarMedico = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaMedico = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtDniMedico = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTurno = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaCita = new javax.swing.JTable();

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        tablaPaciente.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaPaciente);

        jLabel1.setText("DNI");

        btnAgendar.setText("Agendar");
        btnAgendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgendarActionPerformed(evt);
            }
        });

        btnBuscarMedico.setText("Buscar Doctor");
        btnBuscarMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarMedicoActionPerformed(evt);
            }
        });

        tablaMedico.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tablaMedico);

        jLabel2.setText("Codigo Doctor");

        jLabel3.setText("Horario");

        try {
            txtTurno.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/#### ##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel4.setText("Cita Agendada");

        tablaCita.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tablaCita);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 860, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnBuscar))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDniMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(txtTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnBuscarMedico))))
                    .addComponent(jScrollPane3)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(366, 366, 366))
                            .addComponent(btnAgendar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscar)
                    .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnBuscarMedico)
                            .addComponent(jLabel2)
                            .addComponent(txtDniMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(txtTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(btnAgendar)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(162, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(291, 291, 291))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        imprimirPaciente();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnBuscarMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarMedicoActionPerformed
        imprimirMedico();
    }//GEN-LAST:event_btnBuscarMedicoActionPerformed

    private void btnAgendarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgendarActionPerformed
        int filaPac = tablaPaciente.getSelectedRow();
        int filaMed = tablaMedico.getSelectedRow();

        if (filaPac == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un paciente de la tabla superior.");
            return;
        }
        
        if (filaMed == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un medico de la tabla central.");
            return;
        }
        
        try {
            String dniPaciente = tablaPaciente.getValueAt(filaPac, 0).toString();
            String dniMedico = tablaMedico.getValueAt(filaMed, 0).toString();
            Paciente p = arbolPacientes.buscar(dniPaciente);
            Medico m = listaMedicos.buscar(dniMedico);

            if (p == null || m == null) {
                JOptionPane.showMessageDialog(this, "Error: El registro seleccionado no existe en memoria.");
                return;
            }
            
            Cita nuevaCita = new Cita(
                p.getDni(), p.getNombres(), p.getApellidos(),
                m.getDni(), m.getNombres(), m.getApellidos(),
                m.getEspecialidad(), m.getTurno()
            );

            listaCitas.insertar(nuevaCita);
            
            JOptionPane.showMessageDialog(this, "Cita agendada con exito");
            listar();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al agendar: " + e.getMessage());
        }
    }//GEN-LAST:event_btnAgendarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgendar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscarMedico;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tablaCita;
    private javax.swing.JTable tablaMedico;
    private javax.swing.JTable tablaPaciente;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtDniMedico;
    private javax.swing.JFormattedTextField txtTurno;
    // End of variables declaration//GEN-END:variables
}
