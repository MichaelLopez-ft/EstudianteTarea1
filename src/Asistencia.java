import java.time.LocalDate;
import java.time.LocalTime;

public class Asistencia {
    private Estudiante estudiante;
    private LocalDate fecha;
    private LocalTime horaEntrada;
    private LocalTime horaSalida;
    private String estado; // "Presente", "Ausente", "Retardo"

    public Asistencia(Estudiante estudiante, LocalDate fecha, LocalTime horaEntrada, String estado) {
        this.estudiante = estudiante;
        this.fecha = fecha;
        this.horaEntrada = horaEntrada;
        this.estado = estado;
        this.horaSalida = null;
    }

    public void registrarSalida(LocalTime horaSalida) {
        this.horaSalida = horaSalida;
    }

    // Metodo
    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(LocalTime horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public LocalTime getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(LocalTime horaSalida) {
        this.horaSalida = horaSalida;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return estudiante + " - Fecha: " + fecha + ", Entrada: " + horaEntrada + ", Salida: " + (horaSalida != null ? horaSalida : "No registrada") + ", Estado: " + estado;
    }
}

