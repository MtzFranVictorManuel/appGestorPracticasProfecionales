/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import domain.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Martinez Franzoni Victor Manuel
 */


public class StudentConnection implements StudentDao{
    private Connection conexionTransaccional;
    
    private static final String SQL_INSERT = "INSERT INTO tbl_estudiante(nombre, apellidoPaterno, apellidoMaterno, correo, matricula, semestre, telefono, password) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_estudiante SET nombre=?, apellidoPaterno=?, apellidoMaterno=?, correo=?, matricula=?, semestre=?, telefono=?, password=? WHERE id_estudiante = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_estudiante WHERE id_estudiante=?";
    private static final String SQL_OPTENERINFOESTUDIANTE = "SELECT TBL_estudiante.nombre, TBL_estudiante.apellidoPaterno, TBL_estudiante.apellidoMaterno, TBL_estudiante.correo, TBL_estudiante.matricula, TBL_estudiante.semestre, TBL_estudiante.telefono, TBL_Carrera.carreraUniversitaria FROM TBL_estudiante, TBL_Carrera WHERE tbl_carrera.idtbl_carrera = (SELECT fk_id_carrera FROM tbl_estudiante WHERE matricula = ?) AND tbl_estudiante.matricula = ?";
    private static final String SQL_EMPRESAINFO = "SELECT *  FROM tbl_proyecto WHERE tbl_proyecto.id_proyecto = (SELECT FK_id_proyecto FROM STBL_FK_ProfesAlumnProyect WHERE FK_id_estudiante = (SELECT id_estudiante FROM TBL_Estudiante Where matricula = ?))";
    private static final String SQL_PROFESOR = "Select nombre, apellidoPaterno, apellidoMaterno from tbl_profesor where tbl_profesor.id_profesor = (select fk_id_profesor from stbl_fk_profesalumnproyect where fk_id_estudiante = (select id_estudiante from tbl_estudiante where matricula = ?))";

    public StudentConnection(){
        
    }
    
    public StudentConnection(Connection conexionTransaccional){
        this.conexionTransaccional = conexionTransaccional;
    }
    
    
    public int insert(StudentDTO student) throws SQLException{
        Connection connect = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try{
            connect = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConexion();
            stmt = connect.prepareStatement(SQL_INSERT);
            stmt.setString(1, student.getNombre());
            stmt.setString(2, student.getApellidoPaterno());
            stmt.setString(3, student.getApellidoMaterno());
            stmt.setString(4, student.getCorreo());
            stmt.setString(5, student.getMatricula());
            stmt.setString(6, student.getSemestre());
            stmt.setString(7, student.getTelefono());
            stmt.setString(8, student.getPassword());
            
            rows = stmt.executeUpdate();
        } finally {
            Conexion.close(stmt);
            if (this.conexionTransaccional == null) {
                Conexion.close(connect);
            }
        }
        return rows;
    }
    
    public int update(StudentDTO student) throws SQLException{
        Connection connect = null;
        PreparedStatement stmt = null;
        int rows = 0;
        
        try{
            connect = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConexion();
            stmt = connect.prepareStatement(SQL_UPDATE);
            stmt.setString(1, student.getNombre());
            stmt.setString(2, student.getApellidoPaterno());
            stmt.setString(3, student.getApellidoMaterno());
            stmt.setString(4, student.getCorreo());
            stmt.setString(5, student.getMatricula());
            stmt.setString(6, student.getSemestre());
            stmt.setString(7, student.getTelefono());
            stmt.setString(8, student.getPassword());
            stmt.setInt(9, student.getId_estudiante());
            
            rows = stmt.executeUpdate();
        }
        finally {
            Conexion.close(stmt);
            if (this.conexionTransaccional == null) {
                Conexion.close(connect);
            }
        }

        return rows;
    }
    
    public int delete(StudentDTO student) throws SQLException{
        Connection connect = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            connect = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConexion();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = connect.prepareStatement(SQL_DELETE);
            stmt.setInt(1, student.getId_estudiante());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } finally {
            Conexion.close(stmt);
            if (this.conexionTransaccional == null) {
                Conexion.close(connect);
            }
        }

        return rows;
    }
    
    
        
   public void consultarInfomacion(String matricula){
    Connection connect = Conexion.getConexion();
    PreparedStatement stmt = null;
    if(connect != null){
        try{
            stmt = connect.prepareStatement(SQL_OPTENERINFOESTUDIANTE);
            stmt.setString(1, matricula);
            stmt.setString(2, matricula);
            ResultSet rs = stmt.executeQuery();
                if(rs.next()){
                    String nombre = rs.getString("nombre");
                    String apellidoPatreno = rs.getString("apellidoPaterno");
                    String apellidoMaterno = rs.getString("apellidoMaterno");
                    String correo = rs.getString("correo");
                    String semestre = rs.getString("semestre");
                    String telefono = rs.getString("telefono");
                    String carrera = rs.getString("carreraUniversitaria");
                    
                   StudentDTO estudianteInfo = new StudentDTO();
                   estudianteInfo.setNombre(nombre);
                   estudianteInfo.setApellidoPaterno(apellidoPatreno);
                   estudianteInfo.setApellidoMaterno(apellidoMaterno);
                   estudianteInfo.setCorreo(correo);
                   estudianteInfo.setSemestre(semestre);
                   estudianteInfo.setTelefono(telefono);
                   estudianteInfo.setCarrera(carrera);
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    
   
    public void consultarEmpresa(String matricula){
    Connection connect = Conexion.getConexion();
    PreparedStatement stmt = null;
    if(connect != null){
        try{
            stmt = connect.prepareStatement(SQL_EMPRESAINFO);
            stmt.setString(1, matricula);
            ResultSet rs = stmt.executeQuery();
                if(rs.next()){
                    String nombreEmpresa = rs.getString("nombre");
                    String compania = rs.getString("company");
                    String direccion = rs.getString("direccion");
                    String jefeProyecto = rs.getString("jefeProyecto");
                    String descripcion = rs.getString("descripcion");
                    String fechaInicio = rs.getString("fechaInicio");
                    String fechaFin = rs.getString("fechaFin");
                    String periodo = rs.getString("periodo");
                    String horasTotales = rs.getString("horasTotales");
                    
                    
                    ProyectoDTO proyectoInfo = new ProyectoDTO();
                    proyectoInfo.setNombreProyecto(nombreEmpresa);
                    proyectoInfo.setCompania(compania);
                    proyectoInfo.setDireccion(direccion);
                    proyectoInfo.setJefeProyecto(jefeProyecto);
                    proyectoInfo.setDescripcion(descripcion);
                    proyectoInfo.setFechaInicio(fechaInicio);
                    proyectoInfo.setFechaFin(fechaFin);
                    proyectoInfo.setPeriodo(periodo);
                    proyectoInfo.setHorasTotales(horasTotales);
                    
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    
    
    
    public void consultaProfesor(String matricula){
        Connection connect = Conexion.getConexion();
    PreparedStatement stmt = null;
    if(connect != null){
        try{
            stmt = connect.prepareStatement(SQL_PROFESOR);
            stmt.setString(1, matricula);
            ResultSet rs = stmt.executeQuery();
                if(rs.next()){
                    String nombre = rs.getString("nombre");
                    String apellidoPaterno = rs.getString("apellidoPaterno");
                    String apellidoMaterno = rs.getString("apellidoMaterno");
                    
                    ProfesorDTO profesorInfo = new ProfesorDTO();
                    profesorInfo.setNombreProfesor(nombre);
                    profesorInfo.setApellidoPaterno(apellidoPaterno);
                    profesorInfo.setApellidoMaterno(apellidoMaterno);
                    
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
        } 
    }
    
}
