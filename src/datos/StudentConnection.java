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
    
    private static final String SQL_SELECT = "SELECT id_estudiante, nombre, apellidoPaterno, apellidoMaterno, correo, matricula, semestre, telefono, password FROM tbl_estudiante";
    private static final String SQL_INSERT = "INSERT INTO tbl_estudiante(nombre, apellidoPaterno, apellidoMaterno, correo, matricula, semestre, telefono, password) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_estudiante SET nombre=?, apellidoPaterno=?, apellidoMaterno=?, correo=?, matricula=?, semestre=?, telefono=?, password=? WHERE id_estudiante = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_estudiante WHERE id_estudiante=?";
    
    public StudentConnection(){
        
    }
    
    public StudentConnection(Connection conexionTransaccional){
        this.conexionTransaccional = conexionTransaccional;
    }
    
    public List<StudentDTO> select() throws SQLException{
        Connection connect = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        StudentDTO estudiante = null;
        List<StudentDTO> estudiantes = new ArrayList<StudentDTO>();
        
        try{
            connect = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConexion();
            stmt = connect.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id_estudiante = rs.getInt("id_estudiante");
                String nombre = rs.getString("nombre");
                String apellidoPaterno = rs.getString("apellidoPaterno");
                String apellidoMaterno = rs.getString("apellidoMaterno");
                String correo = rs.getString("correo");
                String matricula = rs.getString("matricula");
                String semestre = rs.getString("semestre");
                String telefono = rs.getString("telefono");
                String password = rs.getString("password");
                
                estudiante = new StudentDTO();
                estudiante.setId_estudiante(id_estudiante);
                estudiante.setNombre(nombre);
                estudiante.setApellidoPaterno(apellidoPaterno);
                estudiante.setApellidoMaterno(apellidoMaterno);
                estudiante.setCorreo(correo);
                estudiante.setMatricula(matricula);
                estudiante.setSemestre(semestre);
                estudiante.setTelefono(telefono);
                estudiante.setPassword(password);
                
                estudiantes.add(estudiante);
            }
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            if(this.conexionTransaccional == null)
                Conexion.close(connect);
        }
        return estudiantes;
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
}
