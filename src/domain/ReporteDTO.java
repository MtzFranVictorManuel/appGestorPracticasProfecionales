
package domain;

/**
 *
 * @author zS18019639
 */
public class ReporteDTO {
    private int idReporte;
    private String tipo;
    private String estado;
    private String fechaEntrega;
    private String nrc;
    private String numeroHoras;
    private String fecha;
    private String valorarAvance;
    
    public ReporteDTO(){
        
    }

    public ReporteDTO(int idReporte, String tipo, String estado, String fechaEntrega, String nrc, String numeroHoras, String fecha, String valorarAvance) {
        this.idReporte = idReporte;
        this.tipo = tipo;
        this.estado = estado;
        this.fechaEntrega = fechaEntrega;
        this.nrc = nrc;
        this.numeroHoras = numeroHoras;
        this.fecha = fecha;
        this.valorarAvance = valorarAvance;
    }

    public int getIdReporte() {
        return idReporte;
    }

    public String getTipo() {
        return tipo;
    }

    public String getEstado() {
        return estado;
    }

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public String getNrc() {
        return nrc;
    }

    public String getNumeroHoras() {
        return numeroHoras;
    }

    public String getFecha() {
        return fecha;
    }

    public String getValorarAvance() {
        return valorarAvance;
    }

    public void setIdReporte(int idReporte) {
        this.idReporte = idReporte;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public void setNrc(String nrc) {
        this.nrc = nrc;
    }

    public void setNumeroHoras(String numeroHoras) {
        this.numeroHoras = numeroHoras;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setValorarAvance(String valorarAvance) {
        this.valorarAvance = valorarAvance;
    }
    
    
}
