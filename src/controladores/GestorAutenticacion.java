package controladores;

import modelos.Usuario;

public class GestorAutenticacion {
    private Usuario[] usuariosPermitidos;

    public GestorAutenticacion() {
        usuariosPermitidos = new Usuario[3];
        usuariosPermitidos[0] = new Usuario("admin", "12345", "Administrador");
        usuariosPermitidos[1] = new Usuario("recepcion", "12345", "Recepcionista");
        usuariosPermitidos[2] = new Usuario("medico", "12345", "Medico");
    }
    
    public Usuario validarLogin(String username, String password) {
        for (Usuario u : usuariosPermitidos) {
            if (u != null && u.getUsername().equals(username) && u.getPassword().equals(password)) {
                return u;
            }
        }
        return null;
    }
}