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
 *
 * @author zS18019639
 */
public class FXMLindexNewController implements Initializable {
    
    
    private static final String SQL_CONSULTAESTUDIANTE = "SELECT * FROM tbl_estudiante WHERE tbl_estudiante.matricula=? AND  tbl_estudiante.password=?";
    private static final String SQL_CONSULTAPROFESOR = "SELECT * FROM tbl_profesor WHERE tbl_profesor.nombre=? AND  tbl_profesor.password=?";
    
    @FXML
    private TextField textNameUser;
    @FXML
    private PasswordField textPassword;
    
    @FXML
    private void initializeLogin(ActionEvent event){
        String userName = textNameUser.getText();
        String password = textPassword.getText();

        if(!userName.isEmpty() && !password.isEmpty()){
            if(userName.startsWith("xd"))
            {
                consultarEstudiante(userName, password);
            }else{
                consultarProfresor(userName, password);
            }
        }
        else{
        Alert alertEmptyInfo = new Alert(Alert.AlertType.ERROR);
        alertEmptyInfo.setTitle("Error");
        alertEmptyInfo.setHeaderText(null);
        alertEmptyInfo.setContentText("Los campos de usauario y/o contraseña no han sido ingresados");
        alertEmptyInfo.showAndWait();
        
        }
    }
    
    private void consultarEstudiante(String matricula, String password){
        Connection connect = Conexion.getConexion();
        PreparedStatement stmt = null;
        if(connect != null){
            try{
                stmt = connect.prepareStatement(SQL_CONSULTAESTUDIANTE);
                stmt.setString(1, matricula);
                stmt.setString(2, password);
                ResultSet rs = stmt.executeQuery();
                if(rs.next()){
                    String nomUser = rs.getString("nombre");
                    String apellidoPaternoUser = rs.getString("apellidoPaterno");
                    
                    Alert alertExitoso = new Alert(Alert.AlertType.INFORMATION);
                    alertExitoso.setTitle("Acceso correcto");
                    alertExitoso.setHeaderText(null);
                    alertExitoso.setContentText("Bienvenido " + nomUser + " " + apellidoPaternoUser + " al sistema");
                    alertExitoso.showAndWait();
                    irprincipalEstudiante();
                }
                else{
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText("Usauario y/o contraseña incorrecto...");
                    alert.showAndWait();
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    
    public void consultarProfresor(String nombre, String password){
        Connection connect = Conexion.getConexion();
        PreparedStatement stmt = null;
        if(connect != null){
            try{
                stmt = connect.prepareStatement(SQL_CONSULTAPROFESOR);
                stmt.setString(1, nombre);
                stmt.setString(2, password);
                ResultSet rs = stmt.executeQuery();
                if(rs.next()){
                    String nomUser = rs.getString("nombre");
                    String apellidoPaternoUser = rs.getString("apellidoPaterno");
                    
                    Alert alertExitoso = new Alert(Alert.AlertType.INFORMATION);
                    alertExitoso.setTitle("Acceso correcto");
                    alertExitoso.setHeaderText(null);
                    alertExitoso.setContentText("Bienvenido " + nomUser + " " + apellidoPaternoUser + " al sistema");
                    alertExitoso.showAndWait();
                }
                else{
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText("Usauario y/o contraseña incorrecto...");
                    alert.showAndWait();
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    
    
    private void irprincipalEstudiante(){
        
        try {
            Stage stage = (Stage) textNameUser.getScene().getWindow();
            
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("FXMLprincipalEstudiante.fxml")));
            stage.setScene(scene);
            stage.show();
                    
        } catch (IOException ex) {
            Logger.getLogger(FXMLindexNewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
}
