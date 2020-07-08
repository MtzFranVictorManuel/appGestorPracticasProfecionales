
package domain;

/**
 *
 * @author zS18019639
 */
public class ProfesorDTO {
    private static int idProfesor;
    private static String nombreProfesor;
    private static String apellidoPaterno;
    private static String apellidoMaterno;
    private static int numeroPersonal;
    
    public ProfesorDTO(){
        
    }

    public ProfesorDTO(int idProfesor, String nombreProfesor, String apellidoPaterno, String apellidoMaterno, int numeroPersonal) {
        this.idProfesor = idProfesor;
        this.nombreProfesor = nombreProfesor;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.numeroPersonal = numeroPersonal;
    }

    public int getIdProfesor() {
        return idProfesor;
    }

    public String getNombreProfesor() {
        return nombreProfesor;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public int getNumeroPersonal() {
        return numeroPersonal;
    }

    public void setIdProfesor(int idProfesor) {
        this.idProfesor = idProfesor;
    }

    public void setNombreProfesor(String nombreProfesor) {
        this.nombreProfesor = nombreProfesor;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public void setNumeroPersonal(int numeroPersonal) {
        this.numeroPersonal = numeroPersonal;
    }
    
    
    
    
}
