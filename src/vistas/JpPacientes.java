package vistas;

import arbol.ArbolPaciente;
import controladores.GestorTablas;
import modelos.Paciente;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Jean, Sebastian
 */
public class JpPacientes extends javax.swing.JPanel {
    private ArbolPaciente arbolPaciente = ArbolPaciente.getInstancia();
    private GestorTablas gestorTablas = new GestorTablas();
    
    private String dni,  nombres,apellidos,celular,seguro,fecha;
    
    public JpPacientes() {
        initComponents();
        listar();
    }
    
    public void listar() {
        if(arbolPaciente != null){
            tablaPaciente.setModel(gestorTablas.modeloTablaPacientes(arbolPaciente.obtenerTodos()));
        }
    }

    private void limpiarCajas() {
        txtDni.setText("");
        txtNombres.setText("");
        txtApellidos.setText("");
        txtFechaNac.setValue(null);
        txtCelular.setText("");
        txtSeguro.setText("");
        txtDni.requestFocus();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        btnInsertar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPaciente = new javax.swing.JTable();
        txtDni = new javax.swing.JTextField();
        txtNombres = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        txtCelular = new javax.swing.JTextField();
        txtSeguro = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtFechaNac = new javax.swing.JFormattedTextField();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

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

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
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
        tablaPaciente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaPacienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaPaciente);

        jLabel1.setText("DNI");

        jLabel2.setText("Nombres");

        jLabel3.setText("Apellidos");

        jLabel4.setText("Fecha Nacimiento");

        jLabel5.setText("Numero Celular");

        jLabel6.setText("Seguro");

        try {
            txtFechaNac.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtApellidos)
                            .addComponent(txtNombres)
                            .addComponent(txtDni, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCelular, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                            .addComponent(txtSeguro, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                            .addComponent(txtFechaNac))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnInsertar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 766, Short.MAX_VALUE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtCelular, txtSeguro});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnInsertar)
                            .addComponent(txtFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(btnModificar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtSeguro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnEliminar)))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(144, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtCelular, txtSeguro});

    }// </editor-fold>//GEN-END:initComponents

    private void btnInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarActionPerformed
        try {
            dni = txtDni.getText().trim();
            nombres = txtNombres.getText().trim();
            apellidos = txtApellidos.getText().trim();
            celular = txtCelular.getText().trim();
            seguro = txtSeguro.getText().trim();
            fecha = txtFechaNac.getText().trim();

            if (dni.isEmpty() || nombres.isEmpty() || apellidos.isEmpty() || celular.isEmpty() || fecha.isEmpty() || fecha.equals("  /  /    ")) {
                JOptionPane.showMessageDialog(this,"Complete los datos principales");
                return;
            }

            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            Date fechaParsada = formato.parse(fecha);

            arbolPaciente.insertar(new Paciente(dni, nombres, apellidos, fechaParsada, celular, seguro));
            
            listar();
            limpiarCajas();
            JOptionPane.showMessageDialog(this, "Paciente registrado con exito");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error de formato de fecha");
        }
    }//GEN-LAST:event_btnInsertarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
       try {
            dni = txtDni.getText().trim();
            nombres = txtNombres.getText().trim();
            apellidos = txtApellidos.getText().trim();
            celular = txtCelular.getText().trim();
            seguro = txtSeguro.getText().trim();
            fecha = txtFechaNac.getText().trim();
            
            if (dni.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ingrese el DNI a modificar");
                return;
            }

            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            Date fechaParsada = formato.parse(fecha);

            boolean modificado = arbolPaciente.modificar(new Paciente(dni, nombres, apellidos, fechaParsada, celular, seguro));

            if (modificado) {
                listar();
                limpiarCajas();
                JOptionPane.showMessageDialog(this, "Paciente modificado correctamente");
            } else {
                JOptionPane.showMessageDialog(this, "Paciente no encontrado en la memoria");
            }
        } catch(Exception e) {
            JOptionPane.showMessageDialog(this, "Verifique los datos ingresados");
        }
    }//GEN-LAST:event_btnModificarActionPerformed
    
    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        dni = txtDni.getText().trim();
        if (dni.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Seleccione un paciente");
            return;
        }

        int confirmar = JOptionPane.showConfirmDialog(this, "Esta seguro de eliminar al paciente?", "Confirmar", JOptionPane.YES_NO_OPTION);

        if (confirmar == JOptionPane.YES_OPTION) {
            boolean eliminado = arbolPaciente.eliminar(dni);
            if (eliminado) {
                listar();
                limpiarCajas();
                JOptionPane.showMessageDialog(this, "Paciente removido del sistema");
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo eliminar");
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        //Metodo erroneo
    }//GEN-LAST:event_formMouseClicked

    private void tablaPacienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaPacienteMouseClicked
       int filaSeleccionada = tablaPaciente.getSelectedRow();
        if (filaSeleccionada != -1) {
            dni = tablaPaciente.getValueAt(filaSeleccionada, 0).toString();
            Paciente p = arbolPaciente.buscar(dni);
            if (p != null) {
                txtDni.setText(p.getDni());
                txtNombres.setText(p.getNombres());
                txtApellidos.setText(p.getApellidos());
                
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                txtFechaNac.setText(formato.format(p.getFechaNacimiento()));
                
                txtCelular.setText(p.getCelular());
                txtSeguro.setText(p.getSeguro());
            }
        }
    }//GEN-LAST:event_tablaPacienteMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnInsertar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTable tablaPaciente;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JTextField txtDni;
    private javax.swing.JFormattedTextField txtFechaNac;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtSeguro;
    // End of variables declaration//GEN-END:variables
}
