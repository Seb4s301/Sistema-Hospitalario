package controladores;

import modelos.Usuario;
import modelos.Admin;
import estructuras.ListaDobleAdmin;

public class AdminAutenticacionStrategy implements AutenticacionStrategy {
    private ListaDobleAdmin listaAdmins = ListaDobleAdmin.getInstancia();

    @Override
    public Usuario autenticar(String codigo, String password) {
        Admin admin = listaAdmins.buscarPorCodigo(codigo);
        if (admin == null) {
            admin = listaAdmins.buscar(codigo);
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