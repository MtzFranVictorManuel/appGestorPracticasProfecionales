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
import domain.ReporteDTO;
import domain.StudentDTO;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author zS18019639
 */
public class FXMLindesEstudianteController implements Initializable {
    public static int valorGuardado;
    //Tabla
    
    @FXML
    private TableView<ReporteDTO> tblReportes;
    @FXML
    private TableColumn colTipo;
    @FXML
    private TableColumn colEstado;
    @FXML
    private TableColumn colFechaEntrega;
    
    private ObservableList<ReporteDTO> reportes;
    
    //Labels 
    @FXML
    private Label txtMatricula;
    @FXML
    private Label txtNombre;
    
    
    //Botones
    
    @FXML
    private void irGenerarReporte(ActionEvent event){
        try{
        reportes = tblReportes.getSelectionModel().getSelectedItems();
        valorGuardado = reportes.get(0).getIdReporte();
        System.out.println(valorGuardado);
        irReporteIndex();
        }catch(Exception e){
            Alert alertEmptyInfo = new Alert(Alert.AlertType.ERROR);
            alertEmptyInfo.setTitle("Error");
            alertEmptyInfo.setHeaderText(null);
            alertEmptyInfo.setContentText("Seleccione algun reporte a subir");
            alertEmptyInfo.showAndWait();
        }
        
    }
    
    @FXML
    private void irExpediente(ActionEvent event){
        irExpedienteIndex();
    }
    
    @FXML
    private void cerrarSesion(ActionEvent event){
        salir();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            StudentConnection infoEstudiante = new StudentConnection();
            infoEstudiante.consultarInfomacion(StudentDTO.matricula);
            StudentDTO estudiante = new StudentDTO();
            txtNombre.setText(estudiante.getNombre() + " " + estudiante.getApellidoPaterno() + " " + estudiante.getApellidoMaterno());
            txtMatricula.setText(StudentDTO.matricula);
            
            reportes = FXCollections.observableArrayList();
            this.colTipo.setCellValueFactory(new PropertyValueFactory("tipo"));
            this.colEstado.setCellValueFactory(new PropertyValueFactory("estado"));
            this.colFechaEntrega.setCellValueFactory(new PropertyValueFactory("fechaEntrega"));
            cargarReportes();
    }

    private void irReporteIndex(){
    try {
        Stage stage = (Stage) txtNombre.getScene().getWindow();

        Scene peregil = new Scene(FXMLLoader.load(getClass().getResource("FXMLgenerarReporte.fxml")));
        stage.setScene(peregil);
        stage.show();

    }   catch (IOException ex) {
            Logger.getLogger(FXMLindexNewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    private void irExpedienteIndex(){
    try {
        Stage stage = (Stage) txtNombre.getScene().getWindow();

        Scene peregil = new Scene(FXMLLoader.load(getClass().getResource("FXMLExpediente.fxml")));
        stage.setScene(peregil);
        stage.show();

    }   catch (IOException ex) {
            Logger.getLogger(FXMLindexNewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    private void salir(){
    try {
        Stage stage = (Stage) txtNombre.getScene().getWindow();

        Scene peregil = new Scene(FXMLLoader.load(getClass().getResource("FXMLindexNew.fxml")));
        stage.setScene(peregil);
        stage.show();

    }   catch (IOException ex) {
            Logger.getLogger(FXMLindexNewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //metodo
    private void cargarReportes(){
    Connection connect = Conexion.getConexion();
    PreparedStatement stmt = null;
    if(connect != null){
        try{
            stmt = connect.prepareStatement("select id_reporteinfo, tipo, estado, fechaentrega, nrc, numerohoras, fecha, valoraravance from tbl_reporteinfo where tbl_estudiante_id_estudiante = (select id_estudiante from tbl_estudiante where matricula = ?)");
            stmt.setString(1, StudentDTO.matricula);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
               ReporteDTO temp = new ReporteDTO();
               temp.setIdReporte(rs.getInt("id_reporteInfo"));
               temp.setTipo(rs.getString("tipo"));
               temp.setEstado(rs.getString("estado"));
               temp.setFechaEntrega(rs.getString("fechaEntrega"));
               temp.setNrc(rs.getString("nrc"));
               temp.setNumeroHoras(rs.getString("numeroHoras"));
               temp.setFecha(rs.getString("fecha"));
               temp.setValorarAvance(rs.getString("valorarAvance"));
               reportes.add(temp);
            }
            tblReportes.setItems(reportes);
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        }
    }
}
    
