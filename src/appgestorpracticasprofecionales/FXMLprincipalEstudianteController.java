/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appgestorpracticasprofecionales;

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
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.control.*;
import domain.StudentDTO;
/**
 * FXML Controller class
 *
 * @author zS18019639
 */
public class FXMLprincipalEstudianteController implements Initializable {
    
    @FXML
    private Button btnExpediente;
    
    @FXML
    private Label txtProcentaje;
    
    @FXML
    private void iniciarExpediente(ActionEvent event){
        irExpediente();
    }
    
    private void irExpediente(){
        try {
            Stage stage = (Stage) btnExpediente.getScene().getWindow();
            
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("FXMLExpediente.fxml")));
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
