package controladores.estrategias;

import modelos.Usuario;

public interface EstrategiaAutenticacion {
    Usuario autenticar(String username, String password);
    String getRol();
}