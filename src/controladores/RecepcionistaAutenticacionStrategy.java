package controladores;

import modelos.Usuario;
import modelos.Recepcionista;
import estructuras.ListaDobleRecepcionista;

public class RecepcionistaAutenticacionStrategy implements AutenticacionStrategy {
    private ListaDobleRecepcionista listaRecepcionistas = ListaDobleRecepcionista.getInstancia();

    @Override
    public Usuario autenticar(String codigo, String password) {
        Recepcionista recep = listaRecepcionistas.buscarPorCodigo(codigo);
        if (recep == null) {
            recep = listaRecepcionistas.buscar(codigo);
        }
        
        if (recep != null && password.equals("12345")) {
            return new Usuario(recep.getCodigo(), password, "Recepcionista");
        }
        return null;
    }

    @Override
    public String getRol() {
        return "Recepcionista";
    }
}