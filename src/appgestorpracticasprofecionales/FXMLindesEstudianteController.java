/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appgestorpracticasprofecionales;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import datos.Conexion;
import datos.StudentConnection;
import domain.StudentDTO;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author zS18019639
 */
public class FXMLindesEstudianteController implements Initializable {
    private static final String SQL_ObtenerCarrera = "SELECT * FROM tbl_carrera, tbl_estudiante WHERE tbl_estudiante.matricula= ?";

    @FXML
    private Label txtMatricula;
    @FXML
    private Label txtNombre;
    
    
    
    
    
   public void consultarInfomacion(String matricula){
        Connection connect = Conexion.getConexion();
        PreparedStatement stmt = null;
        if(connect != null){
            try{
                stmt = connect.prepareStatement(SQL_ObtenerCarrera);
                stmt.setString(1, matricula);
                ResultSet rs = stmt.executeQuery();
                if(rs.next()){
                    String nombre = rs.getString("nombre");
                    String apellidoPatreno = rs.getString("apellidoPaterno");
                    String apellidoMaterno = rs.getString("apellidoMaterno");
                    String nombrecompleto = nombre + " " +apellidoPatreno + " " +apellidoMaterno;
                    txtNombre.setText(nombrecompleto);
                    txtMatricula.setText(StudentDTO.matricula);
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        consultarInfomacion(StudentDTO.matricula);
    }    
    
}
