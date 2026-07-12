package controladores;

import modelos.Usuario;

public interface AutenticacionStrategy {
    Usuario autenticar(String codigo, String password);
    String getRol();
}