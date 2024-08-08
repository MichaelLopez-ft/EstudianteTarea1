import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class GestionAsistencia {
    private Map<String, Estudiante> estudiantes;
    private List<Asistencia> asistencias;

    public GestionAsistencia() {
        estudiantes = new HashMap<>();
        asistencias = new ArrayList<>();
    }

    // Métodos para gestionar estudiantes
    public void agregarEstudiante(Estudiante estudiante) {
        estudiantes.put(estudiante.getNumeroIdentificacion(), estudiante);
    }

    public void actualizarEstudiante(String numeroIdentificacion, Estudiante estudianteActualizado) {
        estudiantes.put(numeroIdentificacion, estudianteActualizado);
    }

    public Estudiante consultarEstudiante(String numeroIdentificacion) {
        return estudiantes.get(numeroIdentificacion);
    }

    // Métodos para gestionar asistencia
    public void registrarAsistencia(Estudiante estudiante, LocalDate fecha, LocalTime horaEntrada, String estado) {
        Asistencia asistencia = new Asistencia(estudiante, fecha, horaEntrada, estado);
        asistencias.add(asistencia);
    }

    public void registrarSalida(Estudiante estudiante, LocalDate fecha, LocalTime horaSalida) {
        for (Asistencia asistencia : asistencias) {
            if (asistencia.getEstudiante().equals(estudiante) && asistencia.getFecha().equals(fecha) && asistencia.getHoraSalida() == null) {
                asistencia.registrarSalida(horaSalida);
                break;
            }
        }
    }

    public List<Asistencia> consultarAsistenciasEstudiante(String numeroIdentificacion) {
        List<Asistencia> resultado = new ArrayList<>();
        for (Asistencia asistencia : asistencias) {
            if (asistencia.getEstudiante().getNumeroIdentificacion().equals(numeroIdentificacion)) {
                resultado.add(asistencia);
            }
        }
        return resultado;
    }

    // Métodos para generar reportes
    public double porcentajeAsistencia(Estudiante estudiante) {
        List<Asistencia> asistenciasEstudiante = consultarAsistenciasEstudiante(estudiante.getNumeroIdentificacion());
        long totalClases = asistenciasEstudiante.size();
        long clasesPresentes = asistenciasEstudiante.stream().filter(a -> a.getEstado().equals("Presente")).count();
        return totalClases == 0 ? 0 : (double) clasesPresentes / totalClases * 100;
    }

    public List<Estudiante> estudiantesConMasAusencias() {
        Map<Estudiante, Long> ausenciasPorEstudiante = new HashMap<>();
        for (Asistencia asistencia : asistencias) {
            if (asistencia.getEstado().equals("Ausente")) {
                ausenciasPorEstudiante.put(asistencia.getEstudiante(), ausenciasPorEstudiante.getOrDefault(asistencia.getEstudiante(), 0L) + 1);
            }
        }
        List<Estudiante> resultado = new ArrayList<>(ausenciasPorEstudiante.keySet());
        resultado.sort((e1, e2) -> Long.compare(ausenciasPorEstudiante.get(e2), ausenciasPorEstudiante.get(e1)));
        return resultado;
    }
}

