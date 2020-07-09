/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appgestorpracticasprofecionales;

import datos.StudentConnection;
import domain.*;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * FXML Controller class
 *
 * @author zS18019639
 */
public class FXMLExpedienteController implements Initializable {
    StudentDTO estudianteInfo = new StudentDTO();
    StudentConnection infoEstudiante = new StudentConnection();
    private static String nombreImagen;
    
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
    private ImageView imagenPerfil;
    
    @FXML
    public void regresar(ActionEvent event){
        irEstudianteIndex();
    }
    
    @FXML
    public void editarInformacion(ActionEvent event){
        String path = " ";
        JFileChooser explorador = new JFileChooser();
        explorador.setFileSelectionMode(JFileChooser.FILES_ONLY);
        explorador.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("png, jpg", "png", "jpg");
        explorador.addChoosableFileFilter(filtro);
        int valorBoton = explorador.showOpenDialog(explorador);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Copnfirmar documento");
        alert.setHeaderText("");
        alert.setContentText("");
        Optional<ButtonType> result = alert.showAndWait();
        if(result.get() == ButtonType.OK){
            path = explorador.getSelectedFile().getAbsolutePath();
            StudentDTO.setNombreImagen(explorador.getSelectedFile().getName());
            StudentConnection documentInfo = new StudentConnection();
            String file = explorador.getSelectedFile().toURI().toString();
            System.out.println(file);
            documentInfo.uploadImagen(path);
            System.out.println("Imagen subida");
            Image imagen = new Image(file);
            imagenPerfil.setImage(imagen);
        }else{
            valorBoton = explorador.showOpenDialog(explorador);
        }
        
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        infoEstudiante.consultaProfesor(StudentDTO.matricula);
        infoEstudiante.consultarEmpresa(StudentDTO.matricula);
        
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
        String nombreImagen2 = StudentDTO.getNombreImagen();
        if(nombreImagen == null){
            System.out.println("Erro");
        }else{
            try {
                infoEstudiante.obtenerImagen(nombreImagen2);
                FileInputStream nuevaImagen = new FileInputStream(nombreImagen2);
                Image imagen = new Image(nuevaImagen);
                imagenPerfil.setImage(imagen);
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        }
        
        
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
