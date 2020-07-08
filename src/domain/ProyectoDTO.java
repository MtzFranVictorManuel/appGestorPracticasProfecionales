
package domain;

/**
 *
 * @author zS18019639
 */
public class ProyectoDTO {
    private static int idProyecto;
    private static String nombreProyecto;
    private static String compania;
    private static String direccion;
    private static String jefeProyecto;
    private static String descripcion;
    private static String fechaInicio;
    private static String fechaFin;
    private static String periodo;
    private static String horasTotales;

    public ProyectoDTO(){
        
    }
    
    public ProyectoDTO(int idProyecto, String nombreProyecto, String compania, String direccion, String jefeProyecto, String descripcion, String fechaInicio, String fechaFin, String periodo, String horasTotales) {
        this.idProyecto = idProyecto;
        this.nombreProyecto = nombreProyecto;
        this.compania = compania;
        this.direccion = direccion;
        this.jefeProyecto = jefeProyecto;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.periodo = periodo;
        this.horasTotales = horasTotales;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public void setCompania(String compania) {
        this.compania = compania;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setJefeProyecto(String jefeProyecto) {
        this.jefeProyecto = jefeProyecto;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public void setHorasTotales(String horasTotales) {
        this.horasTotales = horasTotales;
    }

    
    
    public int getIdProyecto() {
        return idProyecto;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public String getCompania() {
        return compania;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getJefeProyecto() {
        return jefeProyecto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public String getPeriodo() {
        return periodo;
    }

    public String getHorasTotales() {
        return horasTotales;
    }
    
    
    
}
