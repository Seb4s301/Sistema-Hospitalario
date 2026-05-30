package PruebaInterfaz;
import PruebaLista.ListaDoblePaciente;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import PruebaNodo.NodoPaciente;
import PruebaClases.Paciente;

/**
 *
 * @author Jean, Sebastian
 */
public class JpPacientes extends javax.swing.JPanel {
    
    ListaDoblePaciente listaPacientes=new ListaDoblePaciente();
    
    private String dni;
    private String nombres;
    private String apellidos;
    private String celular;
    private String seguro;
    private String fecha;
    
    public JpPacientes() {
        initComponents();
        listaPacientes = new ListaDoblePaciente();
        listar();
    }
    
    private void listar() {
        tablaPaciente.setModel(listaPacientes.imprimirIDPaciente());
    }

    private void limpiarCajas() {
        txtDni.setText("");
        txtPacNombres.setText("");
        txtPacApellidos.setText("");
        txtFechaNac.setText("");
        txtPacCelular.setText("");
        txtPacSeguro.setText("");
        txtDni.requestFocus();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        btnPacInsertar = new javax.swing.JButton();
        btnPacModificar = new javax.swing.JButton();
        btnPacEliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPaciente = new javax.swing.JTable();
        txtDni = new javax.swing.JTextField();
        txtPacNombres = new javax.swing.JTextField();
        txtPacApellidos = new javax.swing.JTextField();
        txtPacCelular = new javax.swing.JTextField();
        txtPacSeguro = new javax.swing.JTextField();
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

        btnPacInsertar.setText("Insertar");
        btnPacInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPacInsertarActionPerformed(evt);
            }
        });

        btnPacModificar.setText("Modificar");
        btnPacModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPacModificarActionPerformed(evt);
            }
        });

        btnPacEliminar.setText("Eliminar");
        btnPacEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPacEliminarActionPerformed(evt);
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
                            .addComponent(txtPacApellidos)
                            .addComponent(txtPacNombres)
                            .addComponent(txtDni, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtPacCelular, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                            .addComponent(txtPacSeguro, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                            .addComponent(txtFechaNac))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnPacModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPacEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPacInsertar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 709, Short.MAX_VALUE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtPacCelular, txtPacSeguro});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPacNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPacApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnPacInsertar)
                            .addComponent(txtFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPacCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(btnPacModificar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPacSeguro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(btnPacEliminar))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtPacCelular, txtPacSeguro});

    }// </editor-fold>//GEN-END:initComponents

    private void btnPacInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPacInsertarActionPerformed
    try {
        dni = txtDni.getText();
        nombres = txtPacNombres.getText().trim();
        apellidos = txtPacApellidos.getText().trim();
        celular = txtPacCelular.getText().trim();
        seguro = txtPacSeguro.getText().trim();
        fecha = txtFechaNac.getText().trim();
        if (dni.isEmpty()
                || nombres.isEmpty()
                || apellidos.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Complete los datos principales");
            return;
        }
        if (!dni.matches("\\d{8}")) {
            JOptionPane.showMessageDialog(
                    this,
                    "DNI invalido");
            return;
        }
        if (!celular.matches("\\d{9}")) {
            JOptionPane.showMessageDialog(
                    this,
                    "Celular invalido");
            return;
        }
        Paciente nuevoPaciente =
                new Paciente(
                        dni,
                        nombres,
                        apellidos,
                        fecha,
                        celular,
                        seguro);
        listaPacientes.insertar(nuevoPaciente);
        listar();
        limpiarCajas();
        JOptionPane.showMessageDialog(
                this,
                "Paciente registrado con exito");
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(
                this,
                "Error real: " + e.getMessage());
    }
    }//GEN-LAST:event_btnPacInsertarActionPerformed

    private void btnPacModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPacModificarActionPerformed
    dni = txtDni.getText().trim();
    nombres =txtPacNombres.getText().trim();
    apellidos =txtPacApellidos.getText().trim();
    celular =txtPacCelular.getText().trim();
    seguro =txtPacSeguro.getText().trim();
    fecha =txtFechaNac.getText().trim();
    
    boolean modificado =listaPacientes.modificar(
                    dni,
                    nombres,
                    apellidos,
                    fecha,
                    celular,
                    seguro
            );
    if (modificado) {
        listar();
        limpiarCajas();
        JOptionPane.showMessageDialog(
                this,
                "Paciente modificado correctamente");
    } else {
        JOptionPane.showMessageDialog(
                this,
                "Paciente no encontrado");
    }
            
    }//GEN-LAST:event_btnPacModificarActionPerformed

    private void btnPacEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPacEliminarActionPerformed
    dni = txtDni.getText().trim();
    if (dni.isEmpty()) {
        JOptionPane.showMessageDialog(
                this,
                "Seleccione un paciente");
        return;
    }
    int confirmar = JOptionPane.showConfirmDialog(
            this,
            "Esta seguro de eliminar al paciente con DNI "
            + dni + "?",
            "Confirmar eliminacion",
            JOptionPane.YES_NO_OPTION);
    if (confirmar == JOptionPane.YES_OPTION) {
        listaPacientes.eliminarID(dni);
        listar();
        limpiarCajas();
        JOptionPane.showMessageDialog(
                this,
                "Paciente removido del sistema");
    }
    }//GEN-LAST:event_btnPacEliminarActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        int filaSeleccionada =
            tablaPaciente.getSelectedRow();
    if (filaSeleccionada != -1) {
        dni =tablaPaciente.getValueAt(
                        filaSeleccionada,
                        0).toString();
        NodoPaciente nodo =listaPacientes.buscar(dni);
        if (nodo != null) {
            Paciente p = nodo.getDato();
            txtDni.setText(p.getDni());
            txtPacNombres.setText(p.getNombres());
            txtPacApellidos.setText(p.getApellidos());
            txtFechaNac.setText(p.getFechaNacimiento());
            txtPacCelular.setText(p.getCelular());
            txtPacSeguro.setText(p.getSeguro());
        }
    }
    }//GEN-LAST:event_formMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPacEliminar;
    private javax.swing.JButton btnPacInsertar;
    private javax.swing.JButton btnPacModificar;
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
    private javax.swing.JTextField txtDni;
    private javax.swing.JFormattedTextField txtFechaNac;
    private javax.swing.JTextField txtPacApellidos;
    private javax.swing.JTextField txtPacCelular;
    private javax.swing.JTextField txtPacNombres;
    private javax.swing.JTextField txtPacSeguro;
    // End of variables declaration//GEN-END:variables
}
