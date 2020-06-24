/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import domain.StudentDTO;
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
                    String carrera = rs.getString("carreraUniversitaria");
                    
                   StudentDTO estudianteInfo = new StudentDTO();
                   estudianteInfo.setNombre(nombre);
                   estudianteInfo.setApellidoPaterno(apellidoPatreno);
                   estudianteInfo.setApellidoMaterno(apellidoMaterno);
                   estudianteInfo.setCarrera(carrera);
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    
    
    
}
