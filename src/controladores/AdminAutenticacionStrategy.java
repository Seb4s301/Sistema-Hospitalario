package controladores;

import modelos.Usuario;
import modelos.Admin;
import estructuras.ListaDobleAdmin;

public class AdminAutenticacionStrategy implements AutenticacionStrategy {
    private ListaDobleAdmin listaAdmins = ListaDobleAdmin.getInstancia();

    @Override
    public Usuario autenticar(String codigo, String password) {
        // Buscar por código (ej: A1234567) o por DNI (ej: 1234567)
        Admin admin = listaAdmins.buscarPorCodigo(codigo);
        if (admin == null) {
            // Intentar buscar por DNI sin el prefijo
            admin = listaAdmins.buscar(codigo.replace("A", ""));
        }
        
        if (admin != null && password.equals("12345")) {
            return new Usuario(admin.getCodigo(), password, "Administrador");
        }
        return null;
    }

    @Override
    public String getRol() {
        return "Administrador";
    }
}