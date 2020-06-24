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
import java.util.List;
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
 
    @FXML
    private Label txtMatricula;
    @FXML
    private Label txtNombre;
    
    @FXML
    private void irGenerarReporte(ActionEvent event){
        irReporteIndex();
    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            StudentConnection infoEstudiante = new StudentConnection();
            infoEstudiante.consultarInfomacion(StudentDTO.matricula);
            StudentDTO estudiante = new StudentDTO();
            txtNombre.setText(estudiante.getNombre() + " " + estudiante.getApellidoPaterno() + " " + estudiante.getApellidoMaterno());
            txtMatricula.setText(StudentDTO.matricula);
    }

   private void irReporteIndex(){
    try {
        Stage stage = (Stage) txtNombre.getScene().getWindow();

        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("FXMLgenerarReporte.fxml")));
        stage.setScene(scene);
        stage.show();

    }   catch (IOException ex) {
            Logger.getLogger(FXMLindexNewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
