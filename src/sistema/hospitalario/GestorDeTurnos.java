package sistema.hospitalario;

/**
 *
 * @author Sebas301
 */
public class GestorDeTurnos {
    private static GestorDeTurnos instancia;
    
    // Aquí puedes guardar todos los turnos globales del hospital
    private List<Turno> todosLosTurnosDelHospital;

    private GestorDeTurnos() {
        todosLosTurnosDelHospital = new ArrayList<>();
    }

    public static GestorDeTurnos getInstancia() {
        if (instancia == null) {
            instancia = new GestorDeTurnos();
        }
        return instancia;
    }

    // Método para validar que dos médicos no usen el mismo consultorio a la misma hora
    public boolean validarCruce(Turno nuevoTurno) {
        // Lógica de validación
        return true; 
    }
}