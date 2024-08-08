import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        GestionAsistencia gestionAsistencia = new GestionAsistencia();

        // Crear estudiantes
        Estudiante estudiante1 = new Estudiante("Ana", "Pérez", "001", "Ingeniería", 3);
        Estudiante estudiante2 = new Estudiante("Luis", "García", "002", "Admin empresas", 2);

        // Agregar estudiantes a la gestión
        gestionAsistencia.agregarEstudiante(estudiante1);
        gestionAsistencia.agregarEstudiante(estudiante2);

        // Registrar asistencia
        gestionAsistencia.registrarAsistencia(estudiante1, LocalDate.of(2024, 7, 29), LocalTime.of(9, 0), "Presente");
        gestionAsistencia.registrarAsistencia(estudiante2, LocalDate.of(2024, 7, 29), LocalTime.of(9, 15), "Retardo");

        // Registrar salidas
        gestionAsistencia.registrarSalida(estudiante1, LocalDate.of(2024, 7, 29), LocalTime.of(11, 0));
        gestionAsistencia.registrarSalida(estudiante2, LocalDate.of(2024, 7, 29), LocalTime.of(11, 30));

        // Consultar asistencias
        System.out.println("Asistencias de Ana Pérez:");
        for (Asistencia asistencia : gestionAsistencia.consultarAsistenciasEstudiante("001")) {
            System.out.println(asistencia);
        }

        // Generar reportes
        System.out.println("Porcentaje de asistencia de Ana Pérez: " + gestionAsistencia.porcentajeAsistencia(estudiante1) + "%");
        System.out.println("Estudiantes con más ausencias:");
        for (Estudiante estudiante : gestionAsistencia.estudiantesConMasAusencias()) {
            System.out.println(estudiante);
        }
    }
}

