/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appgestorpracticasprofecionales;

import datos.Conexion;
import datos.StudentConnection;
import domain.*;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author zS18019639
 */
public class FXMLgenerarReporteController implements Initializable {    
    @FXML
    private Label txtPeriodoEscolar;
    @FXML
    private Label txtNombreProyecto;
    @FXML
    private Label txtCarrera;
    @FXML
    private Label txtNombreCompleto;
    @FXML
    private Label txtNombreProfesor;
    
    @FXML
    public void regresar(ActionEvent event){
        irEstudianteIndex();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        StudentConnection infoEstudiante = new StudentConnection();
        infoEstudiante.consultarInfomacion(StudentDTO.matricula);
        infoEstudiante.consultarEmpresa(StudentDTO.matricula);
        infoEstudiante.consultaProfesor(StudentDTO.matricula);
        StudentDTO estudiante = new StudentDTO();
        ProyectoDTO proyectoInfo = new ProyectoDTO();
        ProfesorDTO profesorInfo = new ProfesorDTO();
        txtNombreCompleto.setText(estudiante.getNombre() + " " + estudiante.getApellidoPaterno() + " " + estudiante.getApellidoMaterno());
        txtCarrera.setText(estudiante.getCarrera());
        txtPeriodoEscolar.setText(proyectoInfo.getPeriodo());
        txtNombreProyecto.setText(proyectoInfo.getNombreProyecto());
        txtNombreProfesor.setText(profesorInfo.getNombreProfesor() + " " + profesorInfo.getApellidoPaterno() + " " + profesorInfo.getApellidoMaterno());
    }    
    
    
        private void irEstudianteIndex(){
           try {
        Stage stage = (Stage) txtNombreCompleto.getScene().getWindow();

        Scene peregil = new Scene(FXMLLoader.load(getClass().getResource("FXMLindesEstudiante.fxml")));
        stage.setScene(peregil);
        stage.show();

    }   catch (IOException ex) {
            Logger.getLogger(FXMLindexNewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
