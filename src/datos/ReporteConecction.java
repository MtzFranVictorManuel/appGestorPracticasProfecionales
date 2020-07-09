/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import appgestorpracticasprofecionales.FXMLindesEstudianteController;
import java.sql.Connection;
import domain.ReporteDTO;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author zS18019639
 */
public class ReporteConecction {
    private Connection conexionTransaccional;
    
    private static final String SQL_REPORTEUPDATE = "UPDATE tbl_reporteinfo SET nrc=?, numeroHoras=?, fecha=?, valorarAvance=? WHERE id_reporteInfo = ?";
    
    public ReporteConecction(){
        
    }

    public ReporteConecction(Connection conexionTransaccional) {
        this.conexionTransaccional = conexionTransaccional;
    }
    
    public int updateReporte(String nrc, String numeroHoras, String fecha, String valorarAvance) throws SQLException{
        Connection connect = Conexion.getConexion();
        PreparedStatement stmt = null;
        int rows=0;
        try{
            stmt = connect.prepareStatement(SQL_REPORTEUPDATE);
            int index =1;
            stmt.setString(index++, nrc);
            stmt.setString(index++, numeroHoras);
            stmt.setString(index++, fecha);
            stmt.setString(index++, valorarAvance);
            stmt.setInt(index, FXMLindesEstudianteController.valorGuardado);
            
            rows = stmt.executeUpdate();
            System.out.println("Correguidos" + rows);
        }catch(Exception e){
            e.printStackTrace();
            
        }
        return rows;
    }
    
    
}
