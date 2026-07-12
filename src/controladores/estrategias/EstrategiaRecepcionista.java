package controladores.estrategias;

import estructuras.ListaDobleRecepcionista;
import modelos.Recepcionista;
import modelos.Usuario;

public class EstrategiaRecepcionista implements EstrategiaAutenticacion {
    private ListaDobleRecepcionista listaRecepcionistas = ListaDobleRecepcionista.getInstancia();

    @Override
    public Usuario autenticar(String dni, String password) {
        Recepcionista recepcionista = listaRecepcionistas.buscar("R" + dni);
        if (recepcionista != null && password.equals("12345")) {
            return new Usuario(recepcionista.getDni(), password, "Recepcionista");
        }
        return null;
    }

    @Override
    public String getRol() {
        return "Recepcionista";
    }
}