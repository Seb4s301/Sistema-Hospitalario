package vistas;

import facade.HospitalFacade;
import java.awt.BorderLayout;
import java.util.HashMap;
import java.util.Map;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public class JpAdmin extends javax.swing.JPanel {
    private HospitalFacade facade = HospitalFacade.getInstancia();

    public JpAdmin() {
        initComponents();
        actualizarDashboard();
    }

    // 2. Método orquestador para cargar o recargar ambos gráficos
    public void actualizarDashboard() {
        try {
            // Limpiamos los paneles antes de dibujar
            panelGraficoEspecialidades.removeAll();
            panelGraficoSeguros.removeAll();
            
            // Generamos la data fresca
            generarGraficoEspecialidades();
            generarGraficoSeguros();
            
            // Forzamos el redibujado de toda la interfaz del panel
            this.revalidate();
            this.repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelGraficoEspecialidades = new javax.swing.JPanel();
        panelGraficoSeguros = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnRefrescarActionPerformed = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setMaximumSize(new java.awt.Dimension(32767, 280));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 280));
        jPanel1.setLayout(new java.awt.GridLayout(1, 2));

        panelGraficoEspecialidades.setLayout(new java.awt.BorderLayout());
        jPanel1.add(panelGraficoEspecialidades);

        panelGraficoSeguros.setOpaque(false);
        panelGraficoSeguros.setPreferredSize(new java.awt.Dimension(350, 250));
        panelGraficoSeguros.setLayout(new java.awt.BorderLayout());
        jPanel1.add(panelGraficoSeguros);

        add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(85, 80));

        btnRefrescarActionPerformed.setBackground(new java.awt.Color(204, 204, 204));
        btnRefrescarActionPerformed.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnRefrescarActionPerformed.setForeground(new java.awt.Color(84, 110, 122));
        btnRefrescarActionPerformed.setText("Refrescar");
        btnRefrescarActionPerformed.setPreferredSize(new java.awt.Dimension(110, 25));
        btnRefrescarActionPerformed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarDashboard();
            }
        });
        jPanel2.add(btnRefrescarActionPerformed);

        add(jPanel2, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents
    private void generarGraficoEspecialidades() {
        HashMap<String, Integer> datosEspecialidad = facade.obtenerDemandaPorEspecialidad();
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (Map.Entry<String, Integer> entry : datosEspecialidad.entrySet()) {
            dataset.addValue(entry.getValue(), "Citas", entry.getKey());
        }

        JFreeChart graficoBarras = ChartFactory.createBarChart(
                "Demanda por Especialidad Médica",
                "Especialidad",
                "Cantidad de Citas",
                dataset
        );

        ChartPanel chartPanel = new ChartPanel(graficoBarras);
        panelGraficoEspecialidades.removeAll();
        panelGraficoEspecialidades.add(chartPanel, BorderLayout.CENTER);
        panelGraficoEspecialidades.validate();
    }
    
    private void generarGraficoSeguros() {
        HashMap<String, Integer> datosSeguro = facade.obtenerPacientesPorSeguro();
        DefaultPieDataset dataset = new DefaultPieDataset();
        for (Map.Entry<String, Integer> entry : datosSeguro.entrySet()) {
            dataset.setValue(entry.getKey(), entry.getValue());
        }

        JFreeChart graficoCircular = ChartFactory.createPieChart(
                "Distribucion de Pacientes por Seguro",
                dataset,
                true,
                true,
                false
        );

        ChartPanel chartPanel = new ChartPanel(graficoCircular);
        panelGraficoSeguros.removeAll();
        panelGraficoSeguros.add(chartPanel, BorderLayout.CENTER);
        panelGraficoSeguros.validate();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRefrescarActionPerformed;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel panelGraficoEspecialidades;
    private javax.swing.JPanel panelGraficoSeguros;
    // End of variables declaration//GEN-END:variables
}
