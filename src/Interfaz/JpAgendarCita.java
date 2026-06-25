package Interfaz;

import Arbol.ArbolMedico;
import Clases.Cita;
import Clases.Medico;
import Lista.ListaDobleAgendar;
import Lista.ListaDobleMedico;
import Lista.ListaDoblePaciente;
import Nodo.NodoMedico;
import Nodo.NodoPaciente;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sebastian Casavilca
 */
public class JpAgendarCita extends javax.swing.JPanel {
    
    
    ListaDoblePaciente listaPacientes = ListaDoblePaciente.getInstancia();
    ListaDobleMedico listaDobleMedico = ListaDobleMedico.getInstancia();
    ListaDobleAgendar listaDobleAgendar = ListaDobleAgendar.getInstancia();
    ArbolMedico arbolMedico = ArbolMedico.getInstancia();
    
    private String fecha;
    
    public JpAgendarCita() {
        initComponents();
        listar();
    }
    
    public void listar(){
        DefaultTableModel modeloPacientes = listaPacientes.imprimirIDPaciente();
        tablaPaciente.setModel(modeloPacientes);
        
        DefaultTableModel modeloMedicos = listaDobleMedico.imprimirIDMedico();
        tablaMedico.setModel(modeloMedicos);
        
        DefaultTableModel modeloCitas = listaDobleAgendar.imprimirAgenda();
        tablaCita.setModel(modeloCitas);
    }
    
    
    private void imprimirPaciente(){
        DefaultTableModel modeloTabla = (DefaultTableModel) tablaPaciente.getModel();
        NodoPaciente nodo = listaPacientes.buscar(txtDni.getText());
        modeloTabla.addRow(new Object[]{
        nodo.getDato().getDni(),
        nodo.getDato().getNombres(),
        nodo.getDato().getApellidos(),
        nodo.getDato().getFechaNacimiento(),
        nodo.getDato().getCelular(),
        nodo.getDato().getSeguro(),
            }
        );
    }
    
    private void imprimirMedico(){
          try{   
           
            
            if (txtTurno.getValue() == null || !txtTurno.isEditValid()){
        DefaultTableModel modeloTabla = (DefaultTableModel) tablaMedico.getModel();
        Medico nodo = arbolMedico.buscar(txtDniMedico.getText());
        
        if (nodo == null) {
                JOptionPane.showMessageDialog(this, "Medico no encontrado");
                return;
            }
        modeloTabla.addRow(new Object[]{
        nodo.getDni(),
        nodo.getNombres(),
        nodo.getApellidos(),
        nodo.getTurno(),
        nodo.getCelular(),
        nodo.getEspecialidad(),
            }
        );
            }else if(txtDniMedico.getText().isEmpty()){
                 fecha = txtTurno.getText();
                    
                    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                    Date fechaParsada = formato.parse(fecha);
                
                    DefaultTableModel modeloTabla = (DefaultTableModel) tablaMedico.getModel();
                    NodoMedico nodo = listaDobleMedico.buscarTurno(fechaParsada);
                    modeloTabla.addRow(new Object[]{
                        nodo.getDato().getDni(),
                        nodo.getDato().getNombres(),
                        nodo.getDato().getApellidos(),
                        nodo.getDato().getTurno(),
                        nodo.getDato().getCelular(),
                        nodo.getDato().getEspecialidad(),
                    }
                    );
                
            }else{
               JOptionPane.showMessageDialog(this, "Rellene alguno de los campos");
            }
            }catch(Exception e){
                    JOptionPane.showMessageDialog(this,"Error real: " + e.getMessage());
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
                        .addContainerGap(149, Short.MAX_VALUE))
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
        if (tablaPaciente.getSelectedRow() == -1) {
        JOptionPane.showMessageDialog(this, "Seleccione un paciente de la tabla superior.");
        return;
        }
        
        if (tablaMedico.getSelectedRow() == -1) {
        JOptionPane.showMessageDialog(this, "Seleccione un médico de la tabla inferior.");
        return;
        }
        
        try {
        String dniPaciente = tablaPaciente.getValueAt(tablaPaciente.getSelectedRow(), 0).toString();
        String dniMedico = tablaMedico.getValueAt(tablaMedico.getSelectedRow(), 0).toString();

   
        NodoPaciente nodoP = listaPacientes.buscar(dniPaciente);
        NodoMedico nodoM = listaDobleMedico.buscar(dniMedico);

        if (nodoP == null || nodoM == null) {
            JOptionPane.showMessageDialog(this, "Error de consistencia en las listas de memoria.");
            return;
        }
        String dniP = nodoP.getDato().getDni();
        String NombreP = nodoP.getDato().getNombres();
        String ApellidoP = nodoP.getDato().getApellidos();
        String dniM = nodoM.getDato().getDni();
        String nombreM = nodoM.getDato().getNombres();
        String apellidoM = nodoM.getDato().getApellidos();
        String especialidadM = nodoM.getDato().getEspecialidad();
        Date fechaM = nodoM.getDato().getTurno();

        listaDobleAgendar.insertar(new Cita(dniP, NombreP, ApellidoP, dniM, nombreM,
                                    apellidoM, especialidadM, fechaM));
        //imprime en la tabla
        tablaCita.setModel(listaDobleAgendar.imprimirAgenda());
        
        JOptionPane.showMessageDialog(this, "Cita agendada con exito");

        txtDni.setText("");
        txtDniMedico.setText("");
        txtTurno.setValue(null);
        ((DefaultTableModel) tablaPaciente.getModel()).setRowCount(0);
        ((DefaultTableModel) tablaMedico.getModel()).setRowCount(0);

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
