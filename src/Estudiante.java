public class Estudiante {
    private String nombre;
    private String apellido;
    private String numeroIdentificacion;
    private String carrera;
    private int semestre;

    public Estudiante(String nombre, String apellido, String numeroIdentificacion, String carrera, int semestre) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroIdentificacion = numeroIdentificacion;
        this.carrera = carrera;
        this.semestre = semestre;
    }

    // Metodo
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    @Override
    public String toString() {
        return nombre + " " + apellido + " (" + numeroIdentificacion + ")";
    }

}
