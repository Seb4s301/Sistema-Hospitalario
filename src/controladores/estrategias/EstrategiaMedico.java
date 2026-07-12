package controladores.estrategias;

import estructuras.ListaDobleMedico;
import modelos.Medico;
import modelos.Usuario;

public class EstrategiaMedico implements EstrategiaAutenticacion {
    private ListaDobleMedico listaMedicos = ListaDobleMedico.getInstancia();

    @Override
    public Usuario autenticar(String dni, String password) {
        Medico medico = listaMedicos.buscar("M" + dni);
        if (medico != null && password.equals("12345")) {
            return new Usuario(medico.getDni(), password, "Medico");
        }
        return null;
    }

    @Override
    public String getRol() {
        return "Medico";
    }
}