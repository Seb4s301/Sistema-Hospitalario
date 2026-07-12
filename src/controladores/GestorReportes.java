package controladores;

import modelos.Cita;
import modelos.Paciente;
import java.util.ArrayList;
import java.util.HashMap;

public class GestorReportes {

    public HashMap<String, Integer> obtenerDemandaPorEspecialidad(ArrayList<Cita> listaCitas) {
        HashMap<String, Integer> reporte = new HashMap<>();
        
        if (listaCitas == null || listaCitas.isEmpty()) {
            return reporte;
        }

        for (Cita actual : listaCitas) {
            String especialidad = actual.getEspecialidad();
            if (especialidad != null && !especialidad.trim().isEmpty()) {
                int cantidad = reporte.getOrDefault(especialidad, 0) + 1;
                reporte.put(especialidad, cantidad);
            }
        }
        return reporte;
    }

    public HashMap<String, Integer> obtenerPacientesPorSeguro(ArrayList<Paciente> listaPacientes) {
        HashMap<String, Integer> reporte = new HashMap<>();
        
        if (listaPacientes == null || listaPacientes.isEmpty()) {
            return reporte;
        }

        for (Paciente actual : listaPacientes) {
            String seguro = actual.getSeguro();
            if (seguro != null && !seguro.trim().isEmpty()) {
                int cantidad = reporte.getOrDefault(seguro, 0) + 1;
                reporte.put(seguro, cantidad);
            }
        }
        return reporte;
    }
}