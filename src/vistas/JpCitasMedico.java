package vistas;

import facade.HospitalFacade;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import javax.swing.table.DefaultTableModel;
import modelos.Cita;

public class JpCitasMedico extends javax.swing.JPanel {
    
    private final String codigoMedico;
    private final HospitalFacade facade;
    private final DefaultTableModel modeloTabla;
    
    public JpCitasMedico(String codigoMedico) {
        this.codigoMedico = codigoMedico;
        this.facade = HospitalFacade.getInstancia();
        this.modeloTabla = new DefaultTableModel(null, new String[]{
            "DNI Paciente", "Paciente", "Especialidad", "Fecha"
        }) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        initComponents();
        tblCitasMedico.setModel(modeloTabla);
        cargarCitasMedico();
    }
    
    private void cargarCitasMedico() {
        ArrayList<Cita> todas = facade.obtenerCitas();
        ArrayList<Cita> filtradas = new ArrayList<>();
        for (Cita c : todas) {
            if (c.getDniMedico().equals(codigoMedico)) {
                filtradas.add(c);
            }
        }
        mostrarCitas(filtradas);
    }
    
    private void mostrarCitas(ArrayList<Cita> citas) {
        modeloTabla.setRowCount(0);
        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy", new Locale("es", "PE"));
        for (Cita c : citas) {
            modeloTabla.addRow(new Object[]{
                c.getDniPaciente(),
                c.getNombrePaciente() + " " + c.getApellidoPaciente(),
                c.getEspecialidad(),
                c.getFecha() != null ? fmt.format(c.getFecha()) : ""
            });
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblCitasMedico = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JFormattedTextField();
        txtDNI = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        BtnBuscarDNI = new javax.swing.JButton();
        btnBuscarFecha = new javax.swing.JButton();

        tblCitasMedico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Paciente", "DNI", "Teléfono", "Seguro", "Fecha y Hora "
            }
        ));
        jScrollPane1.setViewportView(tblCitasMedico);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Citas Programadas");

        try {
            txtFecha.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/#### ##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel2.setText("DNI Paciente");

        jLabel3.setText("Fecha");

        BtnBuscarDNI.setText("Buscar Por DNI");
        BtnBuscarDNI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBuscarDNIActionPerformed(evt);
            }
        });

        btnBuscarFecha.setText("Buscar Por Fecha");
        btnBuscarFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarFechaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 779, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(253, 253, 253)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(BtnBuscarDNI, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnBuscarFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(BtnBuscarDNI))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(btnBuscarFecha))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(70, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BtnBuscarDNIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBuscarDNIActionPerformed
        String dni = txtDNI.getText().trim();
        if (dni.isEmpty()) {
            cargarCitasMedico();
            return;
        }
        ArrayList<Cita> todas = facade.obtenerCitas();
        ArrayList<Cita> filtradas = new ArrayList<>();
        for (Cita c : todas) {
            if (c.getDniMedico().equals(codigoMedico) && c.getDniPaciente().equals(dni)) {
                filtradas.add(c);
            }
        }
        mostrarCitas(filtradas);
    }//GEN-LAST:event_BtnBuscarDNIActionPerformed

    private void btnBuscarFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarFechaActionPerformed
        String fechaTexto = txtFecha.getText().trim();
        if (fechaTexto.equals("  /  /    ") || fechaTexto.trim().isEmpty()) {
            cargarCitasMedico();
            return;
        }
        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy", new Locale("es", "PE"));
        try {
            Date fechaBusqueda = fmt.parse(fechaTexto);
            ArrayList<Cita> todas = facade.obtenerCitas();
            ArrayList<Cita> filtradas = new ArrayList<>();
            for (Cita c : todas) {
                if (c.getDniMedico().equals(codigoMedico) && c.getFecha() != null
                        && fmt.format(c.getFecha()).equals(fmt.format(fechaBusqueda))) {
                    filtradas.add(c);
                }
            }
            mostrarCitas(filtradas);
        } catch (ParseException ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "Fecha inválida. Use formato dd/MM/yyyy");
        }
    }//GEN-LAST:event_btnBuscarFechaActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnBuscarDNI;
    private javax.swing.JButton btnBuscarFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCitasMedico;
    private javax.swing.JTextField txtDNI;
    private javax.swing.JFormattedTextField txtFecha;
    // End of variables declaration//GEN-END:variables
}
