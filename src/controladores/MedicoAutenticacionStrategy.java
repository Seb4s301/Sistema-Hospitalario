package controladores;

import modelos.Usuario;
import modelos.Medico;
import estructuras.ListaDobleMedico;

public class MedicoAutenticacionStrategy implements AutenticacionStrategy {
    private ListaDobleMedico listaMedicos = ListaDobleMedico.getInstancia();

    @Override
    public Usuario autenticar(String codigo, String password) {
        Medico medico = listaMedicos.buscarPorCodigo(codigo);
        if (medico == null) {
            medico = listaMedicos.buscar(codigo);
        }
        
        if (medico != null && password.equals("12345")) {
            return new Usuario(medico.getCodigo(), password, "Medico");
        }
        return null;
    }

    @Override
    public String getRol() {
        return "Medico";
    }
}