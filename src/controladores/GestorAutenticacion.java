package controladores;

import modelos.Usuario;

public class GestorAutenticacion {
    private AutenticacionStrategy[] estrategias;

    public GestorAutenticacion() {
        estrategias = new AutenticacionStrategy[3];
        estrategias[0] = new AdminAutenticacionStrategy();
        estrategias[1] = new RecepcionistaAutenticacionStrategy();
        estrategias[2] = new MedicoAutenticacionStrategy();
    }

    public Usuario validarLogin(String codigo, String password) {
        for (AutenticacionStrategy estrategia : estrategias) {
            Usuario usuario = estrategia.autenticar(codigo, password);
            if (usuario != null) {
                return usuario;
            }
        }
        return null;
    }

    public AutenticacionStrategy getEstrategia(String rol) {
        for (AutenticacionStrategy estrategia : estrategias) {
            if (estrategia.getRol().equalsIgnoreCase(rol)) {
                return estrategia;
            }
        }
        return null;
    }
}