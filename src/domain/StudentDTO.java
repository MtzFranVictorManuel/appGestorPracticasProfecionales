/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author Martinez Franzoni Victor Manuel
 */
public class StudentDTO {
    private int id_estudiante;
    public static String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String correo;
    public static String matricula;
    private String semestre;
    private String telefono;
    private String password;
    public static String carrera;

    public StudentDTO(int id_estudiante, String nombre, String apellidoPaterno, String apellidoMaterno, String correo, String matricula, String semestre, String telefono, String password, String carrera) {
        this.id_estudiante = id_estudiante;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.correo = correo;
        this.matricula = matricula;
        this.semestre = semestre;
        this.telefono = telefono;
        this.password = password;
        this.carrera = carrera;
    }

    public StudentDTO(){
        
    }
    
    //gets
    public int getId_estudiante() {
        return id_estudiante;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public String getCorreo() {
        return correo;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getSemestre() {
        return semestre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getPassword() {
        return password;
    }
    
    public String getCarrera(){
        return carrera;
    }
    
    
    //sets
    public void setId_estudiante(int id_estudiante) {
        this.id_estudiante = id_estudiante;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public void setCarrera(String carrea){
        this.carrera = carrea;
    }
    
}
