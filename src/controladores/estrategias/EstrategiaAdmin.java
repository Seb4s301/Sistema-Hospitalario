package controladores.estrategias;

import modelos.Usuario;

public class EstrategiaAdmin implements EstrategiaAutenticacion {
    private static final String ADMIN_USER = "admin";
    private static final String ADMIN_PASS = "12345";

    @Override
    public Usuario autenticar(String username, String password) {
        if (ADMIN_USER.equals(username) && ADMIN_PASS.equals(password)) {
            return new Usuario(username, password, "Administrador");
        }
        return null;
    }

    @Override
    public String getRol() {
        return "Administrador";
    }
}