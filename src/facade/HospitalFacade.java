package facade;

import arbol.ArbolPaciente;
import controladores.GestorAutenticacion;
import controladores.GestorReportes;
import controladores.GestorTablas;
import estructuras.ListaDobleAdmin;
import estructuras.ListaDobleCita;
import estructuras.ListaDobleHistorial;
import estructuras.ListaDobleMedico;
import estructuras.ListaDobleRecepcionista;
import estructuras.ListaDobleReporte;
import modelos.*;
import java.text.SimpleDateFormat;
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

    // ======================== AUTENTICACIÓN ========================

    public Usuario login(String codigo, String password) {
        return gestorAuth.validarLogin(codigo, password);
    }

    // ======================== PACIENTES ========================

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

    // ======================== MÉDICOS ========================

    public boolean insertarMedico(Medico m) {
        listaMedicos.insertar(m);
        return true;
    }

    public Medico buscarMedico(String dni) {
        return listaMedicos.buscar(dni);
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

    // ======================== RECEPCIONISTAS ========================

    public boolean insertarRecepcionista(Recepcionista r) {
        listaRecepcionistas.insertar(r);
        return true;
    }

    public Recepcionista buscarRecepcionista(String dni) {
        return listaRecepcionistas.buscar(dni);
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

    // ======================== ADMINISTRADORES ========================

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

    // ======================== CITAS ========================

    public boolean insertarCita(Cita c) {
        listaCitas.insertar(c);
        return true;
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

    // ======================== HISTORIALES ========================

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

    // ======================== REPORTES MÉDICOS (ReporteMedico) ========================

    public boolean insertarReporte(ReporteMedico r) {
        if (listaReportes.buscar(r.getDniPaciente()) != null) {
            return false;
        }
        listaReportes.insertar(r);
        return true;
    }

    public ReporteMedico buscarReporte(String dniPaciente) {
        return listaReportes.buscar(dniPaciente);
    }

    public boolean modificarReporte(ReporteMedico r) {
        return listaReportes.modificar(r);
    }

    public ArrayList<ReporteMedico> obtenerReportes() {
        return listaReportes.obtenerTodos();
    }

    public DefaultTableModel modeloTablaReportes(ArrayList<ReporteMedico> lista) {
        return gestorTablas.modeloTablaReportes(lista);
    }

    // ======================== REPORTES (gráficos) ========================

    public HashMap<String, Integer> obtenerDemandaPorEspecialidad() {
        return gestorReportes.obtenerDemandaPorEspecialidad(listaCitas.obtenerTodos());
    }

    public HashMap<String, Integer> obtenerPacientesPorSeguro() {
        return gestorReportes.obtenerPacientesPorSeguro(arbolPacientes.obtenerTodos());
    }
}
