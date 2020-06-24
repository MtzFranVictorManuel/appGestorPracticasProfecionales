/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appgestorpracticasprofecionales;

import datos.Conexion;
import datos.StudentConnection;
import domain.StudentDTO;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author zS18019639
 */
public class FXMLgenerarReporteController implements Initializable {
    private static String SQL_CONSULTAEmpresa = "SELECT *  FROM tbl_proyecto WHERE tbl_proyecto.id_proyecto = (SELECT FK_id_proyecto FROM STBL_FK_ProfesAlumnProyect WHERE FK_id_estudiante = (SELECT id_estudiante FROM TBL_Estudiante Where matricula = ?));";
    
    @FXML
    private Label txtPeriodoEscolar;
    
    @FXML
    private Label txtNombreProyecto;
    @FXML
    private Label txtCarrera;
    @FXML
    private Label txtNombreCompleto;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        StudentConnection infoEstudiante = new StudentConnection();
        infoEstudiante.consultarInfomacion(StudentDTO.matricula);
        StudentDTO estudiante = new StudentDTO();
        txtNombreCompleto.setText(estudiante.getNombre() + " " + estudiante.getApellidoPaterno() + " " + estudiante.getApellidoMaterno());
        txtCarrera.setText(estudiante.getCarrera());
       // txtNombreProyecto.setText(estudiante.ge);
       // txtPeriodoEscolar.setText(periodo);
    }    
    
}
