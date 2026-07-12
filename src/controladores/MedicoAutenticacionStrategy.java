package controladores;

import modelos.Usuario;
import modelos.Medico;
import estructuras.ListaDobleMedico;

public class MedicoAutenticacionStrategy implements AutenticacionStrategy {
    private ListaDobleMedico listaMedicos = ListaDobleMedico.getInstancia();

    @Override
    public Usuario autenticar(String codigo, String password) {
        Medico medico = listaMedicos.buscar(codigo.replace("M", ""));
        if (medico == null) {
            medico = listaMedicos.buscar(codigo);
        }
        
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