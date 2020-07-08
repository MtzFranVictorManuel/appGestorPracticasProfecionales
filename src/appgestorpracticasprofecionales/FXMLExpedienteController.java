/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appgestorpracticasprofecionales;

import datos.StudentConnection;
import domain.*;
import java.io.IOException;
import java.net.URL;
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
public class FXMLExpedienteController implements Initializable {
    @FXML
    private Label txtNombreEstudiante;
    @FXML
    private Label txtApellidoPEstudiante;
    @FXML
    private Label txtApellidoMEstudiante;
    @FXML
    private Label txtCorreoEstudiante;
    @FXML
    private Label txtMatricula;
    @FXML
    private Label txtTelefono;
    @FXML
    private Label txtFechaInicio;
    @FXML
    private Label txtFechaFin;
    @FXML
    private Label txtPeriodo;
    @FXML
    private Label txtProfesor;
    @FXML
    private Label txtNombreProyecto;
    @FXML
    private Label txtHoras;
    
    @FXML
    public void regresar(ActionEvent event){
        irEstudianteIndex();
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        StudentConnection infoEstudiante = new StudentConnection();
        infoEstudiante.consultaProfesor(StudentDTO.matricula);
        infoEstudiante.consultarEmpresa(StudentDTO.matricula);
        StudentDTO estudianteInfo = new StudentDTO();
        ProyectoDTO proyectoInfo = new ProyectoDTO();
        ProfesorDTO profesorInfo = new ProfesorDTO();
        txtNombreEstudiante.setText(estudianteInfo.getNombre());
        txtApellidoPEstudiante.setText(estudianteInfo.getApellidoPaterno());
        txtApellidoMEstudiante.setText(estudianteInfo.getApellidoMaterno());
        txtCorreoEstudiante.setText(estudianteInfo.getCorreo());
        txtMatricula.setText(estudianteInfo.getMatricula());
        txtTelefono.setText(estudianteInfo.getTelefono());
        if(proyectoInfo.getFechaInicio() != null){
            txtFechaInicio.setText(proyectoInfo.getFechaInicio());
        }else{
            txtFechaInicio.setText("FECHA INICIAL SIN ASIGNAR");
        }
        if(proyectoInfo.getFechaFin() != null){
            txtFechaFin.setText(proyectoInfo.getFechaFin());
        }else{
            txtFechaFin.setText("FECHA FINAL SIN ASIGNAR");
        }
        txtPeriodo.setText(proyectoInfo.getPeriodo());
        if(profesorInfo.getNombreProfesor() != null){
            txtProfesor.setText(profesorInfo.getNombreProfesor() + " " + profesorInfo.getApellidoPaterno() + " " + profesorInfo.getApellidoMaterno());
        }else{
            txtProfesor.setText("PROFESOR NO ASIGNADO");
        }
        if(proyectoInfo.getNombreProyecto() != null){
            txtNombreProyecto.setText(proyectoInfo.getNombreProyecto());
        }else{
            txtNombreProyecto.setText("PROYECTO SIN ASIGNAR");
        }
        txtHoras.setText(proyectoInfo.getHorasTotales());
    }    
    
    private void irEstudianteIndex(){
           try {
        Stage stage = (Stage) txtNombreEstudiante.getScene().getWindow();

        Scene peregil = new Scene(FXMLLoader.load(getClass().getResource("FXMLindesEstudiante.fxml")));
        stage.setScene(peregil);
        stage.show();

    }   catch (IOException ex) {
            Logger.getLogger(FXMLindexNewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
