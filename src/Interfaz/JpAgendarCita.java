package Interfaz;

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
            fecha = txtTurno.getText();
                    
                    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                    Date fechaParsada = formato.parse(fecha);
            
            if (txtTurno.getText().isEmpty()){
        DefaultTableModel modeloTabla = (DefaultTableModel) tablaMedico.getModel();
        NodoMedico nodo = listaDobleMedico.buscar(txtDniMedico.getText());
        modeloTabla.addRow(new Object[]{
        nodo.getDato().getDni(),
        nodo.getDato().getNombres(),
        nodo.getDato().getApellidos(),
        nodo.getDato().getTurno(),
        nodo.getDato().getCelular(),
        nodo.getDato().getEspecialidad(),
            }
        );
            }else if(txtDniMedico.getText().isEmpty()){
            
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
               JOptionPane.showMessageDialog(this, "RELLENA ALGUNO PS IDIOTA");
            }
            }catch(Exception e){
                    e.printStackTrace();
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 805, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnBuscar))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDniMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(txtTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnBuscarMedico)
                                .addGap(18, 18, 18)
                                .addComponent(btnAgendar)))))
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
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgendar)
                    .addComponent(btnBuscarMedico)
                    .addComponent(jLabel2)
                    .addComponent(txtDniMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(111, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        imprimirPaciente();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnBuscarMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarMedicoActionPerformed
        imprimirMedico();
    }//GEN-LAST:event_btnBuscarMedicoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgendar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscarMedico;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaMedico;
    private javax.swing.JTable tablaPaciente;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtDniMedico;
    private javax.swing.JFormattedTextField txtTurno;
    // End of variables declaration//GEN-END:variables
}
