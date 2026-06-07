package PruebaInterfaz;
import PruebaLista.ListaDobleMedico;
import PruebaClases.Medico;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Usuario
 */

public class JpMedicos extends javax.swing.JPanel {

       ListaDobleMedico listaDobleMedico = ListaDobleMedico.getInstancia();
    
       private String dni;
       private String nombres;
       private String apellidos;
       private String especialidad;
       private String celular;
       private String fechaNac;
        
    public JpMedicos() {
        initComponents();
        listar();
    }
    //Creacion del metodo imprimirIDPaciente para la tabla
    private void listar() {
        tablaMedicos.setModel(listaDobleMedico.imprimirIDMedico());
    }

    private void limpiarCajas() {
        txtDni.setText("");
        txtNombres.setText("");
        txtApellidos.setText("");
        txtFechaNac.setText("");
        txtCelular.setText("");
        txtEspecialidad.setSelectedIndex(0);
        txtDni.requestFocus();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jButton1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        txtCelular = new javax.swing.JTextPane();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDni = new javax.swing.JTextPane();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtNombres = new javax.swing.JTextPane();
        txtFechaNac = new javax.swing.JFormattedTextField();
        btnInsertar = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtApellidos = new javax.swing.JTextPane();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        tablaMedicos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtEspecialidad = new javax.swing.JComboBox<>();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jButton1.setText("jButton1");

        jLabel9.setText("Celular:");

        jLabel3.setText("Apellidos:");

        jScrollPane12.setViewportView(txtCelular);

        jLabel4.setText("Especialidad:");

        jScrollPane2.setViewportView(txtDni);

        jLabel11.setText("Fecha de Nacimiento:");

        jScrollPane3.setViewportView(txtNombres);

        try {
            txtFechaNac.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        btnInsertar.setText("Insertar");
        btnInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarActionPerformed(evt);
            }
        });

        jScrollPane4.setViewportView(txtApellidos);

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

        tablaMedicos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "DNI", "Nombres", "Apellidos", "Especialidad", "Celular", "Fecha de Nacimiento", "Seguro"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(tablaMedicos);

        jLabel1.setText("DNI:");

        jLabel2.setText("Nombres:");

        txtEspecialidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Seleccione--", "Traumatología", "Pediatria", "Oftalmología", "Neurología", "Endocrinología", "Oncología", "Dermatología", "Cardiología", "Gastroenterología" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                    .addComponent(jScrollPane3)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel11)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFechaNac, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtEspecialidad, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(94, 94, 94)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnInsertar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel4)))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEspecialidad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel9)
                            .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11)
                                    .addComponent(txtFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(3, 3, 3))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnInsertar)
                        .addGap(18, 18, 18)
                        .addComponent(btnModificar)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarActionPerformed
    try {    
        dni = txtDni.getText().trim();
        nombres = txtNombres.getText().trim();
        apellidos = txtApellidos.getText().trim();
        especialidad = txtEspecialidad.getSelectedItem().toString();
        celular = txtCelular.getText().trim();
        fechaNac = txtFechaNac.getText().trim();

        //Inicio validacion de restricciones
        if (dni.isEmpty() 
                || nombres.isEmpty() 
                || apellidos.isEmpty()
                || especialidad.isEmpty()
                || celular.isEmpty()
                || fechaNac.isEmpty()) {
            JOptionPane.showMessageDialog(
                    null,
                    "Complete todos los campos");
            return;
        }
        if (!dni.matches("\\d{8}")) {
            JOptionPane.showMessageDialog(
                    null,
                    "DNI invalido");
            return;
        }
        if (!celular.matches("\\d{9}")) {
            JOptionPane.showMessageDialog(
                    null,
                    "Celular invalido");
            return;
        }
        
    } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(
                    this,
                    "Error real: " + e.getMessage());
    }
    
    try {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            Date fechaParsada = formato.parse(fechaNac);
            
            //Uso de metodo insertar nuevo Medico
            listaDobleMedico.insertar(new Medico(
                        dni,
                        nombres,
                        apellidos,
                        fechaParsada,
                        celular,
                        especialidad)
        );
        
        //Listar y validar insercion exitosa
        listar();
        limpiarCajas();
        JOptionPane.showMessageDialog(null,"Medico registrado correctamente");
            
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: "+e.getMessage());
        }
    
    }//GEN-LAST:event_btnInsertarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        dni = txtDni.getText().trim();
        nombres = txtNombres.getText().trim();
        apellidos = txtApellidos.getText().trim();
        especialidad =txtEspecialidad.getSelectedItem().toString();
        celular =txtCelular.getText().trim();
        fechaNac =txtFechaNac.getText().trim();
        try{
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            Date fechaParsada = formato.parse(fechaNac);
            
            //Uso de metodo modificar Medico
        boolean modificado =listaDobleMedico.modificar(
                        dni,
                        nombres,
                        apellidos,
                        fechaParsada,
                        celular,
                        especialidad
                );
        
        //Si es true
        if (modificado) {
            listar();
            limpiarCajas();
            JOptionPane.showMessageDialog(
                    null,
                    "Medico modificado correctamente");
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "No se encontro el medico");
        }
            
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error real: " +e.getMessage());
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        dni = txtDni.getText().trim();

        if (dni.isEmpty()) {
            JOptionPane.showMessageDialog(
                    null,
                    "Ingrese un DNI");
            return;
        }

        int confirmar = JOptionPane.showConfirmDialog(
                    this,
                    "Esta seguro de eliminar al medico con DNI "
                    + dni + "?",
                    "Confirmar eliminacion",
                    JOptionPane.YES_NO_OPTION);

            if (confirmar == JOptionPane.YES_OPTION) {
                //Uso del metodo Eliminar Medico
                listaDobleMedico.eliminarID(dni);
                listar();
                limpiarCajas();
                JOptionPane.showMessageDialog(
                        this,
                        "Medico removido del sistema");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnInsertar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable tablaMedicos;
    private javax.swing.JTextPane txtApellidos;
    private javax.swing.JTextPane txtCelular;
    private javax.swing.JTextPane txtDni;
    private javax.swing.JComboBox<String> txtEspecialidad;
    private javax.swing.JFormattedTextField txtFechaNac;
    private javax.swing.JTextPane txtNombres;
    // End of variables declaration//GEN-END:variables
}
