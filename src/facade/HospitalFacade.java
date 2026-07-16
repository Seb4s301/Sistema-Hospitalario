package facade;

import arbol.ArbolPaciente;
import controladores.*;
import estructuras.*;
import modelos.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;

public class HospitalFacade {
    private static HospitalFacade instancia;
   
    private final ArbolPaciente arbolPacientes;
    private final ListaDobleAdmin listaAdmins;
    private final ListaDobleMedico listaMedicos;
    private final ListaDobleRecepcionista listaRecepcionistas;
    private final ListaDobleCita listaCitas;
    private final ListaDobleHistorial listaHistoriales;
    private final ListaDobleReporte listaReportes;
    private final GestorAutenticacion gestorAuth;
    private final GestorTablas gestorTablas;
    private final GestorReportes gestorReportes;

    private HospitalFacade() {
        arbolPacientes = ArbolPaciente.getInstancia();
        listaAdmins = ListaDobleAdmin.getInstancia();
        listaMedicos = ListaDobleMedico.getInstancia();
        listaRecepcionistas = ListaDobleRecepcionista.getInstancia();
        listaCitas = ListaDobleCita.getInstancia();
        listaHistoriales = ListaDobleHistorial.getInstancia();
        listaReportes = ListaDobleReporte.getInstancia();
        gestorAuth = new GestorAutenticacion();
        gestorTablas = new GestorTablas();
        gestorReportes = new GestorReportes();
    }

    public static HospitalFacade getInstancia() {
        if (instancia == null) {
            instancia = new HospitalFacade();
        }
        return instancia;
    }
    //autenticación
    public Usuario login(String codigo, String password) {
        return gestorAuth.validarLogin(codigo, password);
    }
    
    //pacientes
    public boolean insertarPaciente(Paciente p) {
        arbolPacientes.insertar(p);
        return true;
    }

    public Paciente buscarPaciente(String dni) {
        return arbolPacientes.buscar(dni);
    }

    public boolean modificarPaciente(Paciente p) {
        return arbolPacientes.modificar(p);
    }

    public boolean eliminarPaciente(String dni) {
        return arbolPacientes.eliminar(dni);
    }

    public ArrayList<Paciente> obtenerPacientes() {
        return arbolPacientes.obtenerTodos();
    }

    public DefaultTableModel modeloTablaPacientes() {
        return gestorTablas.modeloTablaPacientes(arbolPacientes.obtenerTodos());
    }

    public DefaultTableModel modeloTablaPacientes(ArrayList<Paciente> lista) {
        return gestorTablas.modeloTablaPacientes(lista);
    }
    
    //medicos
    public boolean insertarMedico(Medico m) {
        listaMedicos.insertar(m);
        return true;
    }

    public Medico buscarMedico(String dni) {
        return listaMedicos.buscar(dni);
    }

    public Medico buscarMedicoPorCodigo(String codigo) {
        return listaMedicos.buscarPorCodigo(codigo);
    }

    public Medico buscarMedicoTurno(Date turno){
        return listaMedicos.buscarPorTurno(turno);
    }
        
    public boolean modificarMedico(Medico m) {
        return listaMedicos.modificar(m);
    }

    public boolean eliminarMedico(String dni) {
        return listaMedicos.eliminar(dni);
    }

    public ArrayList<Medico> obtenerMedicos() {
        return listaMedicos.obtenerTodos();
    }

    public DefaultTableModel modeloTablaMedicos() {
        return gestorTablas.modeloTablaMedicos(listaMedicos.obtenerTodos());
    }

    public DefaultTableModel modeloTablaMedicos(ArrayList<Medico> lista) {
        return gestorTablas.modeloTablaMedicos(lista);
    }

    //recepcionista
    public boolean insertarRecepcionista(Recepcionista r) {
        listaRecepcionistas.insertar(r);
        return true;
    }

    public Recepcionista buscarRecepcionista(String dni) {
        return listaRecepcionistas.buscarPorDni(dni);
    }

    public boolean modificarRecepcionista(Recepcionista r) {
        return listaRecepcionistas.modificar(r);
    }

    public boolean eliminarRecepcionista(String dni) {
        return listaRecepcionistas.eliminar(dni);
    }

    public ArrayList<Recepcionista> obtenerRecepcionistas() {
        return listaRecepcionistas.obtenerTodos();
    }

    //administradores
    public boolean insertarAdmin(Admin a) {
        listaAdmins.insertar(a);
        return true;
    }

    public Admin buscarAdmin(String dni) {
        return listaAdmins.buscar(dni);
    }

    public ArrayList<Admin> obtenerAdmins() {
        return listaAdmins.obtenerTodos();
    }

    //citas
    public boolean insertarCita(Cita c) {
        if (!listaCitas.validarSeparacion15Minutos(c.getDniMedico(), c.getFecha())) {
            return false;
        }
        listaCitas.insertar(c);
        return true;
    }
    
    public boolean validarSeparacionCita(String dniMedico, Date fecha) {
        return listaCitas.validarSeparacion15Minutos(dniMedico, fecha);
    }

    public boolean modificarCita(Cita c) {
        return listaCitas.modificar(c);
    }

    public boolean eliminarCita(String dniPaciente, String especialidad) {
        return listaCitas.eliminar(dniPaciente, especialidad);
    }

    public ArrayList<Cita> obtenerCitas() {
        return listaCitas.obtenerTodos();
    }

    public DefaultTableModel modeloTablaCitas() {
        return gestorTablas.modeloTablaCitas(listaCitas.obtenerTodos());
    }

    //historiales
    public boolean insertarHistorial(HistorialClinico h) {
        listaHistoriales.insertar(h);
        return true;
    }

    public HistorialClinico buscarHistorial(String dniPaciente) {
        return listaHistoriales.buscar(dniPaciente);
    }

    public boolean modificarHistorial(HistorialClinico h) {
        return listaHistoriales.modificar(h);
    }

    public boolean eliminarHistorial(String dniPaciente) {
        return listaHistoriales.eliminar(dniPaciente);
    }

    public ArrayList<HistorialClinico> obtenerHistoriales() {
        return listaHistoriales.obtenerTodos();
    }

    public DefaultTableModel modeloTablaHistoriales(ArrayList<HistorialClinico> lista) {
        return gestorTablas.modeloTablaHistoriales(lista);
    }

    //reportes medicos
    public boolean insertarReporte(ReporteMedico r) {
        listaReportes.insertar(r);
        return true;
    }

    public ReporteMedico buscarReporte(String dniPaciente, Date fecha) {
        return listaReportes.buscar(dniPaciente, fecha);
    }

    public boolean modificarReporte(ReporteMedico r) {
        return listaReportes.modificar(r);
    }

    public ArrayList<ReporteMedico> obtenerReportes() {
        return listaReportes.obtenerTodos();
    }

    public ArrayList<ReporteMedico> obtenerReportesPorMedico(String dniMedico) {
        return listaReportes.buscarPorMedico(dniMedico);
    }

    public ArrayList<ReporteMedico> obtenerReportesPorPaciente(String dniPaciente) {
        return listaReportes.buscarPorPaciente(dniPaciente);
    }

    public DefaultTableModel modeloTablaReportes(ArrayList<ReporteMedico> lista) {
        return gestorTablas.modeloTablaReportes(lista);
    }

    public DefaultTableModel modeloTablaHistorialCompleto(String dniPaciente) {
        ArrayList<Cita> todasCitas = listaCitas.obtenerTodos();
        ArrayList<Cita> citasPaciente = new ArrayList<>();
        for (Cita c : todasCitas) {
            if (c.getDniPaciente().equals(dniPaciente)) {
                citasPaciente.add(c);
            }
        }
        ArrayList<ReporteMedico> reportes = listaReportes.buscarPorPaciente(dniPaciente);
        return gestorTablas.modeloTablaHistorialCompleto(citasPaciente, reportes);
    }

    //gráficos
    public HashMap<String, Integer> obtenerDemandaPorEspecialidad() {
        return gestorReportes.obtenerDemandaPorEspecialidad(listaCitas.obtenerTodos());
    }

    public HashMap<String, Integer> obtenerPacientesPorSeguro() {
        return gestorReportes.obtenerPacientesPorSeguro(arbolPacientes.obtenerTodos());
    }
}
